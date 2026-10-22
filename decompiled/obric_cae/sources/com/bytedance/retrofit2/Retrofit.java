package com.bytedance.retrofit2;

import com.bytedance.retrofit2.cache.ICacheServer;
import com.bytedance.retrofit2.client.Client;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class Retrofit {
    private static volatile CopyOnWriteArrayList<Interceptor> sCommonInterceptors;
    private final List<CallAdapter.Factory> adapterFactories;
    private final ICacheServer cacheServer;
    private final Executor callbackExecutor;
    private final Client.Provider clientProvider;
    private final List<Converter.Factory> converterFactories;
    private final Executor httpExecutor;
    private final List<Interceptor> interceptors;
    private final Endpoint server;
    private final Map<Method, ServiceMethod> serviceMethodCache;
    private final boolean validateEagerly;

    public static final class Builder {
        private List<CallAdapter.Factory> adapterFactories;
        private ICacheServer cacheServer;
        private Executor callbackExecutor;
        private Client.Provider clientProvider;
        private List<Converter.Factory> converterFactories;
        private Endpoint endpoint;
        private Executor httpExecutor;
        private List<Interceptor> interceptors;
        private Platform platform;
        private boolean validateEagerly;

        public Builder() {
            this(Platform.get());
        }

        public Builder addCallAdapterFactory(CallAdapter.Factory r8) {
            this.adapterFactories.add((CallAdapter.Factory) Utils.checkNotNull(r8, "factory == null"));
            return this;
        }

        public Builder addConverterFactory(Converter.Factory r8) {
            this.converterFactories.add((Converter.Factory) Utils.checkNotNull(r8, "factory == null"));
            return this;
        }

        public Builder addInterceptor(Interceptor r8) {
            Interceptor r10 = (Interceptor) Utils.checkNotNull(r8, "interceptor == null");
            this.interceptors.add(r10);
            return this;
        }

        public Retrofit build() {
            if (this.endpoint == null) goto L26;
            if (this.clientProvider == null) goto L24;
            if (this.httpExecutor == null) goto L22;
            Executor r8 = this.callbackExecutor;
            if (r8 != null) goto L11;
            r8 = this.platform.defaultCallbackExecutor();
        L11:
            Executor r10 = r8;
            ArrayList r11 = new ArrayList(this.adapterFactories);
            r11.add(this.platform.defaultCallAdapterFactory(r10));
            ArrayList r12 = new ArrayList(this.converterFactories);
            if (Retrofit.access$000() == null) goto L20;
            Iterator r13 = Retrofit.access$000().iterator();
        L15:
            if (r13.hasNext() == false) goto L20;
            Interceptor r14 = (Interceptor) r13.next();
            if (this.interceptors.contains(r14) == true) goto L15;
            this.interceptors.add(r14);
        L20:
            return new Retrofit(this.endpoint, this.clientProvider, this.interceptors, r12, r11, this.httpExecutor, r10, this.validateEagerly);
        L22:
            throw new IllegalStateException("HttpExecutor may not be null.");
        L24:
            throw new IllegalStateException("ClientProvider may not be null.");
        L26:
            throw new IllegalStateException("Endpoint may not be null.");
        }

        public Builder cacheServer(ICacheServer r8) {
            this.cacheServer = r8;
            return this;
        }

        public Builder callbackExecutor(Executor r8) {
            this.callbackExecutor = (Executor) Utils.checkNotNull(r8, "callbackExecutor == null");
            return this;
        }

        public Builder client(Client.Provider r8) {
            return provider((Client.Provider) Utils.checkNotNull(r8, "provider == null"));
        }

        public Builder httpExecutor(Executor r8) {
            this.httpExecutor = (Executor) Utils.checkNotNull(r8, "httpExecutor == null");
            return this;
        }

        public Builder provider(Client.Provider r8) {
            this.clientProvider = (Client.Provider) Utils.checkNotNull(r8, "provider == null");
            return this;
        }

        public Builder removeInterceptor(Interceptor r8) {
            Interceptor r10 = (Interceptor) Utils.checkNotNull(r8, "interceptor == null");
            this.interceptors.remove(r10);
            return this;
        }

        public Builder setEndpoint(Endpoint r8) {
            if (r8 == null) goto L6;
            this.endpoint = r8;
            return this;
        L6:
            throw new NullPointerException("Endpoint may not be null.");
        }

        public Builder validateEagerly(boolean r8) {
            this.validateEagerly = r8;
            return this;
        }

        public Builder(Platform r8) {
            this.interceptors = new CopyOnWriteArrayList();
            this.converterFactories = new ArrayList();
            this.adapterFactories = new ArrayList();
            this.platform = r8;
            this.converterFactories.add(new BuiltInConverters());
        }

        public Builder setEndpoint(String r8) {
            if (r8 == null) goto L8;
            if (r8.trim().length() == 0) goto L8;
            this.endpoint = Endpoints.newFixedEndpoint(r8);
            return this;
        L8:
            throw new NullPointerException("Endpoint may not be blank.");
        }
    }

    public Retrofit(Endpoint r11, Client.Provider r12, List<Interceptor> r13, List<Converter.Factory> r14, List<CallAdapter.Factory> r15, Executor r16, Executor r17, boolean r18) {
        this(r11, r12, r13, r14, r15, r16, r17, r18, null);
    }

    public static /* synthetic */ CopyOnWriteArrayList access$000() {
        return sCommonInterceptors;
    }

    private void eagerlyValidateMethods(Class<?> r8) {
        Platform r10 = Platform.get();
        Method[] r11 = r8.getDeclaredMethods();
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        Method r14 = r11[r13];
        if (r10.isDefaultMethod(r14) == true) goto L7;
        loadServiceMethod(r14);
    L7:
        r13 = r13 + 1;
        goto L3
    }

    public static void setCommonInterceptor(CopyOnWriteArrayList<Interceptor> r8) {
        sCommonInterceptors = r8;
    }

    public ICacheServer cacheServer() {
        return this.cacheServer;
    }

    public CallAdapter<?> callAdapter(Type r8, Annotation[] r10) {
        return nextCallAdapter(null, r8, r10);
    }

    public List<CallAdapter.Factory> callAdapterFactories() {
        return this.adapterFactories;
    }

    public Executor callbackExecutor() {
        return this.callbackExecutor;
    }

    public Client.Provider clientProvider() {
        return this.clientProvider;
    }

    public List<Converter.Factory> converterFactories() {
        return this.converterFactories;
    }

    public <T> T create(final Class<T> r8) {
        Utils.validateServiceInterface(r8);
        if (this.validateEagerly == false) goto L6;
        eagerlyValidateMethods(r8);
    L6:
        return (T) Proxy.newProxyInstance(r8.getClassLoader(), new Class[]{r8}, new AnonymousClass1(this, r8));
    }

    public <T> Converter<T, Header> headerConverter(Type r8, Annotation[] r10) {
        Utils.checkNotNull(r8, "type == null");
        Utils.checkNotNull(r10, "annotations == null");
        int r11 = this.converterFactories.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        Converter<T, Header> r13 = (Converter<T, Header>) this.converterFactories.get(r12).headerConverter(r8, r10, this);
        if (r13 != null) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return r13;
    L9:
        throw new IllegalArgumentException("Could not locate header converter");
    }

    public Executor httpExecutor() {
        return this.httpExecutor;
    }

    public List<Interceptor> interceptors() {
        return this.interceptors;
    }

    public ServiceMethod loadServiceMethod(Method r8) {
        ServiceMethod r10 = this.serviceMethodCache.get(r8);
        if (r10 == null) goto L5;
        return r10;
    L5:
        Map<Method, ServiceMethod> r11 = this.serviceMethodCache;
        monitor-enter(r11);
        ServiceMethod r12 = this.serviceMethodCache.get(r8);     // Catch: Throwable -> L12
        if (r12 != null) goto L10;
        r12 = new ServiceMethod.Builder(this, r8).build();     // Catch: Throwable -> L12
        this.serviceMethodCache.put(r8, r12);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r11);     // Catch: Throwable -> L12
        return r12;
    L12:
        th = move-exception;
        throw th;
    }

    public CallAdapter<?> nextCallAdapter(CallAdapter.Factory r8, Type r10, Annotation[] r11) {
        Utils.checkNotNull(r10, "returnType == null");
        Utils.checkNotNull(r11, "annotations == null");
        int r12 = this.adapterFactories.indexOf(r8) + 1;
        int r13 = this.adapterFactories.size();
        int r14 = r12;
    L3:
        if (r14 >= r13) goto L8;
        CallAdapter<?> r15 = this.adapterFactories.get(r14).get(r10, r11, this);
        if (r15 != null) goto L6;
        r14 = r14 + 1;
        goto L3
    L6:
        return r15;
    L8:
        StringBuilder r16 = new StringBuilder("Could not locate call adapter for ");
        r16.append(r10);
        r16.append(".\n");
        if (r8 == null) goto L14;
        r16.append("  Skipped:");
        int r17 = 0;
    L11:
        if (r17 >= r12) goto L13;
        r16.append("\n   * ");
        r16.append(this.adapterFactories.get(r17).getClass().getName());
        r17 = r17 + 1;
        goto L11
    L13:
        r16.append('\n');
    L14:
        r16.append("  Tried:");
        int r18 = this.adapterFactories.size();
    L15:
        if (r12 >= r18) goto L18;
        r16.append("\n   * ");
        r16.append(this.adapterFactories.get(r12).getClass().getName());
        r12 = r12 + 1;
        goto L15
    L18:
        throw new IllegalArgumentException(r16.toString());
    }

    public <T> Converter<T, TypedOutput> nextRequestBodyConverter(Converter.Factory r8, Type r10, Annotation[] r11, Annotation[] r12) {
        Utils.checkNotNull(r10, "type == null");
        Utils.checkNotNull(r11, "parameterAnnotations == null");
        Utils.checkNotNull(r12, "methodAnnotations == null");
        int r13 = this.converterFactories.indexOf(r8) + 1;
        int r14 = this.converterFactories.size();
        int r15 = r13;
    L3:
        if (r15 >= r14) goto L8;
        Converter<T, TypedOutput> r16 = (Converter<T, TypedOutput>) this.converterFactories.get(r15).requestBodyConverter(r10, r11, r12, this);
        if (r16 != null) goto L6;
        r15 = r15 + 1;
        goto L3
    L6:
        return r16;
    L8:
        StringBuilder r17 = new StringBuilder("Could not locate RequestBody converter for ");
        r17.append(r10);
        r17.append(".\n");
        if (r8 == null) goto L14;
        r17.append("  Skipped:");
        int r18 = 0;
    L11:
        if (r18 >= r13) goto L13;
        r17.append("\n   * ");
        r17.append(this.converterFactories.get(r18).getClass().getName());
        r18 = r18 + 1;
        goto L11
    L13:
        r17.append('\n');
    L14:
        r17.append("  Tried:");
        int r19 = this.converterFactories.size();
    L15:
        if (r13 >= r19) goto L18;
        r17.append("\n   * ");
        r17.append(this.converterFactories.get(r13).getClass().getName());
        r13 = r13 + 1;
        goto L15
    L18:
        throw new IllegalArgumentException(r17.toString());
    }

    public <T> Converter<TypedInput, T> nextResponseBodyConverter(Converter.Factory r8, Type r10, Annotation[] r11) {
        Utils.checkNotNull(r10, "type == null");
        Utils.checkNotNull(r11, "annotations == null");
        int r12 = this.converterFactories.indexOf(r8) + 1;
        int r13 = this.converterFactories.size();
        int r14 = r12;
    L3:
        if (r14 >= r13) goto L8;
        Converter<TypedInput, T> r15 = (Converter<TypedInput, T>) this.converterFactories.get(r14).responseBodyConverter(r10, r11, this);
        if (r15 != null) goto L6;
        r14 = r14 + 1;
        goto L3
    L6:
        return r15;
    L8:
        StringBuilder r16 = new StringBuilder("Could not locate TypeInput converter for ");
        r16.append(r10);
        r16.append(".\n");
        if (r8 == null) goto L14;
        r16.append("  Skipped:");
        int r17 = 0;
    L11:
        if (r17 >= r12) goto L13;
        r16.append("\n   * ");
        r16.append(this.converterFactories.get(r17).getClass().getName());
        r17 = r17 + 1;
        goto L11
    L13:
        r16.append('\n');
    L14:
        r16.append("  Tried:");
        int r18 = this.converterFactories.size();
    L15:
        if (r12 >= r18) goto L18;
        r16.append("\n   * ");
        r16.append(this.converterFactories.get(r12).getClass().getName());
        r12 = r12 + 1;
        goto L15
    L18:
        throw new IllegalArgumentException(r16.toString());
    }

    public <T> Converter<T, Object> objectConverter(Type r8, Annotation[] r10) {
        Utils.checkNotNull(r8, "type == null");
        Utils.checkNotNull(r10, "annotations == null");
        int r11 = this.converterFactories.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        Converter<T, Object> r13 = (Converter<T, Object>) this.converterFactories.get(r12).objectConverter(r8, r10, this);
        if (r13 != null) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return r13;
    L9:
        throw new IllegalArgumentException("Could not locate object converter");
    }

    public <T> Converter<T, TypedOutput> requestBodyConverter(Type r8, Annotation[] r10, Annotation[] r11) {
        return nextRequestBodyConverter(null, r8, r10, r11);
    }

    public <T> Converter<TypedInput, T> responseBodyConverter(Type r8, Annotation[] r10) {
        return nextResponseBodyConverter(null, r8, r10);
    }

    public Endpoint server() {
        return this.server;
    }

    public <T> Converter<T, String> stringConverter(Type r8, Annotation[] r10) {
        Utils.checkNotNull(r8, "type == null");
        Utils.checkNotNull(r10, "annotations == null");
        int r11 = this.converterFactories.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        Converter<T, String> r13 = (Converter<T, String>) this.converterFactories.get(r12).stringConverter(r8, r10, this);
        if (r13 != null) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return r13;
    L9:
        return BuiltInConverters.ToStringConverter.INSTANCE;
    }

    public Retrofit(Endpoint r8, Client.Provider r10, List<Interceptor> r11, List<Converter.Factory> r12, List<CallAdapter.Factory> r13, Executor r14, Executor r15, boolean r16, ICacheServer r17) {
        this.serviceMethodCache = new ConcurrentHashMap();
        this.server = r8;
        this.clientProvider = r10;
        this.interceptors = r11;
        this.converterFactories = Collections.unmodifiableList(r12);
        this.adapterFactories = Collections.unmodifiableList(r13);
        this.httpExecutor = r14;
        this.callbackExecutor = r15;
        this.validateEagerly = r16;
        this.cacheServer = r17;
    }
}
