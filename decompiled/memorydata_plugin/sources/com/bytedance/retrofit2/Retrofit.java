package com.bytedance.retrofit2;

import com.bytedance.retrofit2.cache.ICacheServer;
import com.bytedance.retrofit2.client.Client;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class Retrofit {
    private static volatile CopyOnWriteArrayList<Interceptor> sCommonInterceptors;
    private final ICacheServer cacheServer;
    private final List<CallAdapter.Factory> callAdapterFactories;
    private final Executor callbackExecutor;
    private final Client.Provider clientProvider;
    private final List<Converter.Factory> converterFactories;
    private final Executor httpExecutor;
    private final List<Interceptor> interceptors;
    private final Endpoint server;
    private final Map<Method, ServiceMethod<?>> serviceMethodCache;
    private final ConcurrentHashMap<Method, Object> serviceMethodCacheNew;
    private final boolean validateEagerly;

    public static final class Builder {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private ICacheServer cacheServer;
        private final List<CallAdapter.Factory> callAdapterFactories;
        private Executor callbackExecutor;
        private Client.Provider clientProvider;
        private final List<Converter.Factory> converterFactories;
        private Endpoint endpoint;
        private Executor httpExecutor;
        private final List<Interceptor> interceptors;
        private final Platform platform;
        private boolean validateEagerly;

        static {
        }

        public Builder() {
            this(Platform.get());
        }

        Builder(Platform r2) {
            this.interceptors = new CopyOnWriteArrayList();
            this.converterFactories = new ArrayList();
            this.callAdapterFactories = new ArrayList();
            this.platform = r2;
        }

        Builder(Retrofit r7) {
            this.interceptors = new CopyOnWriteArrayList();
            this.converterFactories = new ArrayList();
            this.callAdapterFactories = new ArrayList();
            this.platform = Platform.get();
            this.clientProvider = Retrofit.access$000(r7);
            this.endpoint = Retrofit.access$100(r7);
            int r0 = 1;
            int r1 = 1;
        L4:
            if (r1 >= (Retrofit.access$200(r7).size() - this.platform.defaultConverterFactoriesSize())) goto L6;
            this.interceptors.add((Interceptor) ZeusTransformUtils.preCheckCast(Retrofit.access$200(r7).get(r1), Interceptor.class, "com.obric.memorydata.plugin"));
            r1 = r1 + 1;
            goto L4
        L6:
            int r2 = Retrofit.access$300(r7).size() - this.platform.defaultConverterFactoriesSize();
        L7:
            if (r0 >= r2) goto L9;
            this.converterFactories.add((Converter.Factory) ZeusTransformUtils.preCheckCast(Retrofit.access$300(r7).get(r0), Converter.Factory.class, "com.obric.memorydata.plugin"));
            r0 = r0 + 1;
            goto L7
        L9:
            int r3 = 0;
            int r4 = Retrofit.access$400(r7).size() - this.platform.defaultCallAdapterFactoriesSize();
        L10:
            if (r3 >= r4) goto L12;
            this.callAdapterFactories.add((CallAdapter.Factory) ZeusTransformUtils.preCheckCast(Retrofit.access$400(r7).get(r3), CallAdapter.Factory.class, "com.obric.memorydata.plugin"));
            r3 = r3 + 1;
            goto L10
        L12:
            this.httpExecutor = Retrofit.access$500(r7);
            this.callbackExecutor = Retrofit.access$600(r7);
            this.validateEagerly = Retrofit.access$700(r7);
            this.cacheServer = Retrofit.access$800(r7);
        }

        public Builder addCallAdapterFactory(CallAdapter.Factory r4) {
            this.callAdapterFactories.add((CallAdapter.Factory) ZeusTransformUtils.preCheckCast(Utils.checkNotNull(r4, "factory == null"), CallAdapter.Factory.class, "com.obric.memorydata.plugin"));
            return this;
        }

        public Builder addConverterFactory(Converter.Factory r4) {
            this.converterFactories.add((Converter.Factory) ZeusTransformUtils.preCheckCast(Utils.checkNotNull(r4, "factory == null"), Converter.Factory.class, "com.obric.memorydata.plugin"));
            return this;
        }

        public Builder addInterceptor(Interceptor r3) {
            Interceptor r4 = (Interceptor) ZeusTransformUtils.preCheckCast(Utils.checkNotNull((Interceptor) ZeusTransformUtils.wrapperContextForParams(r3, Interceptor.class, "com.obric.memorydata.plugin"), "interceptor == null"), Interceptor.class, "com.obric.memorydata.plugin");
            this.interceptors.add(r4);
            return this;
        }

        public Retrofit build() {
            if (this.endpoint == null) goto L26;
            if (this.clientProvider == null) goto L24;
            if (this.httpExecutor == null) goto L22;
            Executor r0 = this.callbackExecutor;
            if (r0 != null) goto L11;
            r0 = this.platform.defaultCallbackExecutor();
        L11:
            Executor r8 = r0;
            ArrayList r6 = new ArrayList(this.callAdapterFactories);
            r6.addAll(this.platform.defaultCallAdapterFactories(r8));
            ArrayList r5 = new ArrayList((this.converterFactories.size() + 1) + this.platform.defaultConverterFactoriesSize());
            r5.add(new BuiltInConverters());
            r5.addAll(this.converterFactories);
            r5.addAll(this.platform.defaultConverterFactories());
            if (Retrofit.access$900() == null) goto L20;
            Iterator r1 = Retrofit.access$900().iterator();
        L15:
            if (r1.hasNext() == false) goto L20;
            Interceptor r2 = (Interceptor) ZeusTransformUtils.preCheckCast(r1.next(), Interceptor.class, "com.obric.memorydata.plugin");
            if (this.interceptors.contains(r2) == true) goto L15;
            this.interceptors.add(r2);
        L20:
            return new Retrofit(this.endpoint, this.clientProvider, this.interceptors, r5, r6, this.httpExecutor, r8, this.validateEagerly, this.cacheServer);
        L22:
            throw new IllegalStateException("HttpExecutor may not be null.");
        L24:
            throw new IllegalStateException("ClientProvider may not be null.");
        L26:
            throw new IllegalStateException("Endpoint may not be null.");
        }

        public Builder cacheServer(ICacheServer r3) {
            this.cacheServer = (ICacheServer) ZeusTransformUtils.wrapperContextForParams(r3, ICacheServer.class, "com.obric.memorydata.plugin");
            return this;
        }

        public List<CallAdapter.Factory> callAdapterFactories() {
            return this.callAdapterFactories;
        }

        public Builder callbackExecutor(Executor r3) {
            this.callbackExecutor = (Executor) ZeusTransformUtils.preCheckCast(Utils.checkNotNull((Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.memorydata.plugin"), "executor == null"), Executor.class, "com.obric.memorydata.plugin");
            return this;
        }

        public Builder client(Client.Provider r3) {
            return provider((Client.Provider) ZeusTransformUtils.preCheckCast(Utils.checkNotNull((Client.Provider) ZeusTransformUtils.wrapperContextForParams(r3, Client.Provider.class, "com.obric.memorydata.plugin"), "provider == null"), Client.Provider.class, "com.obric.memorydata.plugin"));
        }

        public List<Converter.Factory> converterFactories() {
            return this.converterFactories;
        }

        public Builder httpExecutor(Executor r3) {
            this.httpExecutor = (Executor) ZeusTransformUtils.preCheckCast(Utils.checkNotNull((Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.memorydata.plugin"), "httpExecutor == null"), Executor.class, "com.obric.memorydata.plugin");
            return this;
        }

        public Builder provider(Client.Provider r3) {
            this.clientProvider = (Client.Provider) ZeusTransformUtils.preCheckCast(Utils.checkNotNull((Client.Provider) ZeusTransformUtils.wrapperContextForParams(r3, Client.Provider.class, "com.obric.memorydata.plugin"), "provider == null"), Client.Provider.class, "com.obric.memorydata.plugin");
            return this;
        }

        public Builder removeInterceptor(Interceptor r3) {
            Interceptor r4 = (Interceptor) ZeusTransformUtils.preCheckCast(Utils.checkNotNull((Interceptor) ZeusTransformUtils.wrapperContextForParams(r3, Interceptor.class, "com.obric.memorydata.plugin"), "interceptor == null"), Interceptor.class, "com.obric.memorydata.plugin");
            this.interceptors.remove(r4);
            return this;
        }

        public Builder setEndpoint(Endpoint r3) {
            Endpoint r4 = (Endpoint) ZeusTransformUtils.wrapperContextForParams(r3, Endpoint.class, "com.obric.memorydata.plugin");
            Objects.requireNonNull(r4, "Endpoint may not be null.");
            this.endpoint = r4;
            return this;
        }

        public Builder setEndpoint(String r2) {
            if (r2 == null) goto L8;
            if (r2.trim().length() == 0) goto L8;
            this.endpoint = Endpoints.newFixedEndpoint(r2);
            return this;
        L8:
            throw new NullPointerException("Endpoint may not be blank.");
        }

        public Builder validateEagerly(boolean r1) {
            this.validateEagerly = r1;
            return this;
        }
    }

    Retrofit(Endpoint r13, Client.Provider r14, List<Interceptor> r15, List<Converter.Factory> r16, List<CallAdapter.Factory> r17, Executor r18, Executor r19, boolean r20) {
        this((Endpoint) ZeusTransformUtils.wrapperContextForParams(r13, Endpoint.class, "com.obric.memorydata.plugin"), (Client.Provider) ZeusTransformUtils.wrapperContextForParams(r14, Client.Provider.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.memorydata.plugin"), (Executor) ZeusTransformUtils.wrapperContextForParams(r18, Executor.class, "com.obric.memorydata.plugin"), (Executor) ZeusTransformUtils.wrapperContextForParams(r19, Executor.class, "com.obric.memorydata.plugin"), r20, null);
    }

    Retrofit(Endpoint r3, Client.Provider r4, List<Interceptor> r5, List<Converter.Factory> r6, List<CallAdapter.Factory> r7, Executor r8, Executor r9, boolean r10, ICacheServer r11) {
        Endpoint r12 = (Endpoint) ZeusTransformUtils.wrapperContextForParams(r3, Endpoint.class, "com.obric.memorydata.plugin");
        Client.Provider r13 = (Client.Provider) ZeusTransformUtils.wrapperContextForParams(r4, Client.Provider.class, "com.obric.memorydata.plugin");
        List<Interceptor> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Executor r17 = (Executor) ZeusTransformUtils.wrapperContextForParams(r8, Executor.class, "com.obric.memorydata.plugin");
        Executor r18 = (Executor) ZeusTransformUtils.wrapperContextForParams(r9, Executor.class, "com.obric.memorydata.plugin");
        ICacheServer r19 = (ICacheServer) ZeusTransformUtils.wrapperContextForParams(r11, ICacheServer.class, "com.obric.memorydata.plugin");
        this.serviceMethodCache = new ConcurrentHashMap();
        this.serviceMethodCacheNew = new ConcurrentHashMap();
        this.server = r12;
        this.clientProvider = r13;
        this.interceptors = r14;
        this.converterFactories = Collections.unmodifiableList(r15);
        this.callAdapterFactories = Collections.unmodifiableList(r16);
        this.httpExecutor = r17;
        this.callbackExecutor = r18;
        this.validateEagerly = r10;
        this.cacheServer = r19;
    }

    static /* synthetic */ Client.Provider access$000(Retrofit r0) {
        return r0.clientProvider;
    }

    static /* synthetic */ Endpoint access$100(Retrofit r0) {
        return r0.server;
    }

    static /* synthetic */ List access$200(Retrofit r0) {
        return r0.interceptors;
    }

    static /* synthetic */ List access$300(Retrofit r0) {
        return r0.converterFactories;
    }

    static /* synthetic */ List access$400(Retrofit r0) {
        return r0.callAdapterFactories;
    }

    static /* synthetic */ Executor access$500(Retrofit r0) {
        return r0.httpExecutor;
    }

    static /* synthetic */ Executor access$600(Retrofit r0) {
        return r0.callbackExecutor;
    }

    static /* synthetic */ boolean access$700(Retrofit r0) {
        return r0.validateEagerly;
    }

    static /* synthetic */ ICacheServer access$800(Retrofit r0) {
        return r0.cacheServer;
    }

    static /* synthetic */ CopyOnWriteArrayList access$900() {
        return sCommonInterceptors;
    }

    private void eagerlyValidateMethods(Class<?> r6) {
        Platform r0 = Platform.get();
        Method[] r7 = r6.getDeclaredMethods();
        int r1 = r7.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L10;
        Method r3 = r7[r2];
        if (r0.isDefaultMethod(r3) == true) goto L9;
        if (Modifier.isStatic(r3.getModifiers()) == true) goto L9;
        loadServiceMethod(r3);
    L9:
        r2 = r2 + 1;
        goto L3
    }

    public static void setCommonInterceptor(CopyOnWriteArrayList<Interceptor> r0) {
        sCommonInterceptors = r0;
    }

    public ICacheServer cacheServer() {
        return this.cacheServer;
    }

    public CallAdapter<?, ?> callAdapter(Type r3, Annotation[] r4) {
        return nextCallAdapter(null, (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.memorydata.plugin"), r4);
    }

    public List<CallAdapter.Factory> callAdapterFactories() {
        return this.callAdapterFactories;
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

    public <T> T create(final Class<T> r4) {
        Utils.validateServiceInterface(r4);
        if (this.validateEagerly == false) goto L6;
        eagerlyValidateMethods(r4);
    L6:
        return (T) Proxy.newProxyInstance(r4.getClassLoader(), new Class[]{r4}, new AnonymousClass1(this, r4));
    }

    public <T> Converter<T, Header> headerConverter(Type r6, Annotation[] r7) {
        Type r8 = (Type) ZeusTransformUtils.wrapperContextForParams(r6, Type.class, "com.obric.memorydata.plugin");
        Utils.checkNotNull(r8, "type == null");
        Utils.checkNotNull(r7, "annotations == null");
        int r0 = this.converterFactories.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        Converter<T, Header> r3 = (Converter<T, Header>) ((Converter.Factory) ZeusTransformUtils.preCheckCast(this.converterFactories.get(r2), Converter.Factory.class, "com.obric.memorydata.plugin")).headerConverter(r8, r7, this);
        if (r3 != null) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L9:
        throw new IllegalArgumentException("Could not locate header converter");
    }

    public Executor httpExecutor() {
        return this.httpExecutor;
    }

    public List<Interceptor> interceptors() {
        return this.interceptors;
    }

    ServiceMethod<?> loadServiceMethod(Method r5) {
        if (RetrofitConfig.isLoadServiceMethodOptOpen() == true) goto L5;
        ServiceMethod<?> r0 = (ServiceMethod) ZeusTransformUtils.preCheckCast(this.serviceMethodCache.get(r5), ServiceMethod.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L9;
        Map<Method, ServiceMethod<?>> r1 = this.serviceMethodCache;
        monitor-enter(r1);
        ServiceMethod<?> r2 = (ServiceMethod) ZeusTransformUtils.preCheckCast(this.serviceMethodCache.get(r5), ServiceMethod.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        if (r2 != null) goto L17;
        RetrofitMetrics r3 = new RetrofitMetrics();     // Catch: Throwable -> L19
        r3.bizInvokeRetrofitRequestInterfaceStart(false);     // Catch: Throwable -> L19
        r2 = ServiceMethod.parseAnnotations(this, r5, r3);     // Catch: Throwable -> L19
        this.serviceMethodCache.put(r5, r2);     // Catch: Throwable -> L19
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L19
        return r2;
    L19:
        th = move-exception;
        throw th;
    L9:
        if (ZeusTransformUtils.instanceOf(r0, HttpServiceMethod.class) == false) goto L11;
        RetrofitMetrics r4 = new RetrofitMetrics();
        r4.bizInvokeRetrofitRequestInterfaceStart(true);
        ((HttpServiceMethod) ZeusTransformUtils.preCheckCast(r0, HttpServiceMethod.class, "com.obric.memorydata.plugin")).requestFactory.setRetrofitMetrics(r4);
    L11:
        return r0;
    L5:
        return loadServiceMethodNew(r5);
    }

    ServiceMethod<?> loadServiceMethodNew(Method r4) {
        Object r0 = this.serviceMethodCacheNew.get(r4);
        if (ZeusTransformUtils.instanceOf(r0, ServiceMethod.class) == true) goto L5;
        if (r0 != null) goto L22;
        Object r1 = new Object();
        monitor-enter(r1);
        r0 = this.serviceMethodCacheNew.putIfAbsent(r4, r1);     // Catch: Throwable -> L19
        if (r0 != null) goto L17;
        RetrofitMetrics r2 = new RetrofitMetrics();     // Catch: Throwable -> L19
        r2.bizInvokeRetrofitRequestInterfaceStart(false);     // Catch: Throwable -> L19
        ServiceMethod<?> r3 = ServiceMethod.parseAnnotations(this, r4, r2);     // Catch: Throwable -> L19
        this.serviceMethodCacheNew.put(r4, r3);     // Catch: Throwable -> L19
        monitor-exit(r1);     // Catch: Throwable -> L19
        return r3;
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    L22:
        monitor-enter(r0);
        ServiceMethod<?> r5 = (ServiceMethod) ZeusTransformUtils.preCheckCast(this.serviceMethodCacheNew.get(r4), ServiceMethod.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
        monitor-exit(r0);     // Catch: Throwable -> L26
        return r5;
    L26:
        th = move-exception;
        throw th;
    L5:
        if (ZeusTransformUtils.instanceOf(r0, HttpServiceMethod.class) == false) goto L8;
        RetrofitMetrics r6 = new RetrofitMetrics();
        r6.bizInvokeRetrofitRequestInterfaceStart(true);
        ((HttpServiceMethod) ZeusTransformUtils.preCheckCast(r0, HttpServiceMethod.class, "com.obric.memorydata.plugin")).requestFactory.setRetrofitMetrics(r6);
    L8:
        return (ServiceMethod) ZeusTransformUtils.preCheckCast(r0, ServiceMethod.class, "com.obric.memorydata.plugin");
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public CallAdapter<?, ?> nextCallAdapter(CallAdapter.Factory r7, Type r8, Annotation[] r9) {
        Type r10 = (Type) ZeusTransformUtils.wrapperContextForParams(r8, Type.class, "com.obric.memorydata.plugin");
        Utils.checkNotNull(r10, "returnType == null");
        Utils.checkNotNull(r9, "annotations == null");
        int r0 = this.callAdapterFactories.indexOf(r7) + 1;
        int r2 = this.callAdapterFactories.size();
        int r3 = r0;
    L3:
        if (r3 >= r2) goto L8;
        CallAdapter<?, ?> r4 = ((CallAdapter.Factory) ZeusTransformUtils.preCheckCast(this.callAdapterFactories.get(r3), CallAdapter.Factory.class, "com.obric.memorydata.plugin")).get(r10, r9, this);
        if (r4 != null) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return r4;
    L8:
        StringBuilder r11 = new StringBuilder("Could not locate call adapter for ").append(r10).append(".\n");
        if (r7 == null) goto L14;
        r11.append("  Skipped:");
        int r12 = 0;
    L11:
        if (r12 >= r0) goto L13;
        r11.append("\n   * ").append(((CallAdapter.Factory) ZeusTransformUtils.preCheckCast(this.callAdapterFactories.get(r12), CallAdapter.Factory.class, "com.obric.memorydata.plugin")).getClass().getName());
        r12 = r12 + 1;
        goto L11
    L13:
        r11.append('\n');
    L14:
        r11.append("  Tried:");
        int r13 = this.callAdapterFactories.size();
    L15:
        if (r0 >= r13) goto L18;
        r11.append("\n   * ").append(((CallAdapter.Factory) ZeusTransformUtils.preCheckCast(this.callAdapterFactories.get(r0), CallAdapter.Factory.class, "com.obric.memorydata.plugin")).getClass().getName());
        r0 = r0 + 1;
        goto L15
    L18:
        throw new IllegalArgumentException(r11.toString());
    }

    public <T> Converter<T, TypedOutput> nextRequestBodyConverter(Converter.Factory r7, Type r8, Annotation[] r9, Annotation[] r10) {
        Type r11 = (Type) ZeusTransformUtils.wrapperContextForParams(r8, Type.class, "com.obric.memorydata.plugin");
        Utils.checkNotNull(r11, "type == null");
        Utils.checkNotNull(r9, "parameterAnnotations == null");
        Utils.checkNotNull(r10, "methodAnnotations == null");
        int r0 = this.converterFactories.indexOf(r7) + 1;
        int r2 = this.converterFactories.size();
        int r3 = r0;
    L3:
        if (r3 >= r2) goto L8;
        Converter<T, TypedOutput> r4 = (Converter<T, TypedOutput>) ((Converter.Factory) ZeusTransformUtils.preCheckCast(this.converterFactories.get(r3), Converter.Factory.class, "com.obric.memorydata.plugin")).requestBodyConverter(r11, r9, r10, this);
        if (r4 != null) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return r4;
    L8:
        StringBuilder r12 = new StringBuilder("Could not locate RequestBody converter for ").append(r11).append(".\n");
        if (r7 == null) goto L14;
        r12.append("  Skipped:");
        int r13 = 0;
    L11:
        if (r13 >= r0) goto L13;
        r12.append("\n   * ").append(((Converter.Factory) ZeusTransformUtils.preCheckCast(this.converterFactories.get(r13), Converter.Factory.class, "com.obric.memorydata.plugin")).getClass().getName());
        r13 = r13 + 1;
        goto L11
    L13:
        r12.append('\n');
    L14:
        r12.append("  Tried:");
        int r14 = this.converterFactories.size();
    L15:
        if (r0 >= r14) goto L18;
        r12.append("\n   * ").append(((Converter.Factory) ZeusTransformUtils.preCheckCast(this.converterFactories.get(r0), Converter.Factory.class, "com.obric.memorydata.plugin")).getClass().getName());
        r0 = r0 + 1;
        goto L15
    L18:
        throw new IllegalArgumentException(r12.toString());
    }

    public <T> Converter<TypedInput, T> nextResponseBodyConverter(Converter.Factory r7, Type r8, Annotation[] r9) {
        Type r10 = (Type) ZeusTransformUtils.wrapperContextForParams(r8, Type.class, "com.obric.memorydata.plugin");
        Utils.checkNotNull(r10, "type == null");
        Utils.checkNotNull(r9, "annotations == null");
        int r0 = this.converterFactories.indexOf(r7) + 1;
        int r2 = this.converterFactories.size();
        int r3 = r0;
    L3:
        if (r3 >= r2) goto L8;
        Converter<TypedInput, T> r4 = (Converter<TypedInput, T>) ((Converter.Factory) ZeusTransformUtils.preCheckCast(this.converterFactories.get(r3), Converter.Factory.class, "com.obric.memorydata.plugin")).responseBodyConverter(r10, r9, this);
        if (r4 != null) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return r4;
    L8:
        StringBuilder r11 = new StringBuilder("Could not locate TypedInput converter for ").append(r10).append(".\n");
        if (r7 == null) goto L14;
        r11.append("  Skipped:");
        int r12 = 0;
    L11:
        if (r12 >= r0) goto L13;
        r11.append("\n   * ").append(((Converter.Factory) ZeusTransformUtils.preCheckCast(this.converterFactories.get(r12), Converter.Factory.class, "com.obric.memorydata.plugin")).getClass().getName());
        r12 = r12 + 1;
        goto L11
    L13:
        r11.append('\n');
    L14:
        r11.append("  Tried:");
        int r13 = this.converterFactories.size();
    L15:
        if (r0 >= r13) goto L18;
        r11.append("\n   * ").append(((Converter.Factory) ZeusTransformUtils.preCheckCast(this.converterFactories.get(r0), Converter.Factory.class, "com.obric.memorydata.plugin")).getClass().getName());
        r0 = r0 + 1;
        goto L15
    L18:
        throw new IllegalArgumentException(r11.toString());
    }

    public <T> Converter<T, Object> objectConverter(Type r6, Annotation[] r7) {
        Type r8 = (Type) ZeusTransformUtils.wrapperContextForParams(r6, Type.class, "com.obric.memorydata.plugin");
        Utils.checkNotNull(r8, "type == null");
        Utils.checkNotNull(r7, "annotations == null");
        int r0 = this.converterFactories.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        Converter<T, Object> r3 = (Converter<T, Object>) ((Converter.Factory) ZeusTransformUtils.preCheckCast(this.converterFactories.get(r2), Converter.Factory.class, "com.obric.memorydata.plugin")).objectConverter(r8, r7, this);
        if (r3 != null) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L9:
        throw new IllegalArgumentException("Could not locate object converter");
    }

    public <T> Converter<T, TypedOutput> requestBodyConverter(Type r3, Annotation[] r4, Annotation[] r5) {
        return nextRequestBodyConverter(null, (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    public <T> Converter<TypedInput, T> responseBodyConverter(Type r3, Annotation[] r4) {
        return nextResponseBodyConverter(null, (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.memorydata.plugin"), r4);
    }

    public Endpoint server() {
        return this.server;
    }

    public <T> Converter<T, String> stringConverter(Type r6, Annotation[] r7) {
        Type r8 = (Type) ZeusTransformUtils.wrapperContextForParams(r6, Type.class, "com.obric.memorydata.plugin");
        Utils.checkNotNull(r8, "type == null");
        Utils.checkNotNull(r7, "annotations == null");
        int r0 = this.converterFactories.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        Converter<T, String> r3 = (Converter<T, String>) ((Converter.Factory) ZeusTransformUtils.preCheckCast(this.converterFactories.get(r2), Converter.Factory.class, "com.obric.memorydata.plugin")).stringConverter(r8, r7, this);
        if (r3 != null) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L9:
        return BuiltInConverters.ToStringConverter.INSTANCE;
    }
}
