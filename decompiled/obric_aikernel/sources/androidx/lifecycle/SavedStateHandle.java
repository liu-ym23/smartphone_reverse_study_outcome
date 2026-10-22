package androidx.lifecycle;

import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import androidx.core.os.BundleKt;
import androidx.savedstate.SavedStateRegistry;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.p1;
import kotlinx.coroutines.flow.q1;

/* JADX INFO: loaded from: classes.dex */
@SourceDebugExtension({"SMAP\nSavedStateHandle.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SavedStateHandle.kt\nandroidx/lifecycle/SavedStateHandle\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,450:1\n361#2,3:451\n364#2,4:455\n1#3:454\n*S KotlinDebug\n*F\n+ 1 SavedStateHandle.kt\nandroidx/lifecycle/SavedStateHandle\n*L\n198#1:451,3\n198#1:455,4\n*E\n"})
public final class SavedStateHandle {
    private static final Class<? extends Object>[] ACCEPTABLE_CLASSES = null;
    public static final Companion Companion = null;
    private static final String KEYS = "keys";
    private static final String VALUES = "values";
    private final Map<String, g1<Object>> flows;
    private final Map<String, SavingStateLiveData<?>> liveDatas;
    private final Map<String, Object> regular;
    private final SavedStateRegistry.SavedStateProvider savedStateProvider;
    private final Map<String, SavedStateRegistry.SavedStateProvider> savedStateProviders;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final SavedStateHandle createHandle(Bundle r10, Bundle r11) {
            if (r10 != null) goto L11;
            if (r11 == null) goto L28;
            HashMap r12 = new HashMap();
            Iterator<String> r13 = r11.keySet().iterator();
        L7:
            if (r13.hasNext() == false) goto L10;
            String r14 = r13.next();
            Intrinsics.checkNotNullExpressionValue(r14, "key");
            r12.put(r14, r11.get(r14));
            goto L7
        L10:
            return new SavedStateHandle(r12);
        L28:
            return new SavedStateHandle();
        L11:
            ArrayList r15 = r10.getParcelableArrayList(SavedStateHandle.KEYS);
            ArrayList r16 = r10.getParcelableArrayList(SavedStateHandle.VALUES);
            int r17 = 0;
            if (r15 == null) goto L17;
            if (r16 == null) goto L17;
            if (r15.size() != r16.size()) goto L17;
            boolean r18 = true;
        L18:
            if (r18 == false) goto L25;
            LinkedHashMap r19 = new LinkedHashMap();
            int r20 = r15.size();
        L20:
            if (r17 >= r20) goto L23;
            Object r21 = r15.get(r17);
            Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type kotlin.String");
            r19.put((String) r21, r16.get(r17));
            r17 = r17 + 1;
            goto L20
        L23:
            return new SavedStateHandle(r19);
        L25:
            throw new IllegalStateException("Invalid bundle passed as restored state".toString());
        L17:
            r18 = false;
            goto L18
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final boolean validateValue(Object r10) {
            if (r10 != null) goto L5;
            return true;
        L5:
            Class[] r11 = SavedStateHandle.access$getACCEPTABLE_CLASSES$cp();
            int r12 = r11.length;
            int r13 = 0;
        L6:
            if (r13 >= r12) goto L11;
            Class r14 = r11[r13];
            Intrinsics.checkNotNull(r14);
            if (r14.isInstance(r10) == true) goto L9;
            r13 = r13 + 1;
            goto L6
        L9:
            return true;
        L11:
            return false;
        }
    }

    public static final class SavingStateLiveData<T> extends MutableLiveData<T> {
        private SavedStateHandle handle;
        private String key;

        public SavingStateLiveData(SavedStateHandle r10, String r11) {
            Intrinsics.checkNotNullParameter(r11, "key");
            this.key = r11;
            this.handle = r10;
        }

        public SavingStateLiveData(SavedStateHandle r10, String r11, T r12) {
            Intrinsics.checkNotNullParameter(r11, "key");
            super(r12);
            this.key = r11;
            this.handle = r10;
        }

        public final void detach() {
            this.handle = null;
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void setValue(T r10) {
            SavedStateHandle r11 = this.handle;
            if (r11 == null) goto L8;
            SavedStateHandle.access$getRegular$p(r11).put(this.key, r10);
            g1 r12 = (g1) SavedStateHandle.access$getFlows$p(r11).get(this.key);
            if (r12 == null) goto L8;
            r12.setValue(r10);
        L8:
            super.setValue(r10);
        }
    }

    static {
        Companion = new Companion(null);
        Class<? extends Object>[] r10 = new Class[29];
        r10[0] = Boolean.TYPE;
        r10[1] = boolean[].class;
        r10[2] = Double.TYPE;
        r10[3] = double[].class;
        Class<SizeF> r11 = Integer.TYPE;
        r10[4] = r11;
        r10[5] = int[].class;
        r10[6] = Long.TYPE;
        r10[7] = long[].class;
        r10[8] = String.class;
        r10[9] = String[].class;
        r10[10] = Binder.class;
        r10[11] = Bundle.class;
        r10[12] = Byte.TYPE;
        r10[13] = byte[].class;
        r10[14] = Character.TYPE;
        r10[15] = char[].class;
        r10[16] = CharSequence.class;
        r10[17] = CharSequence[].class;
        r10[18] = ArrayList.class;
        r10[19] = Float.TYPE;
        r10[20] = float[].class;
        r10[21] = Parcelable.class;
        r10[22] = Parcelable[].class;
        r10[23] = Serializable.class;
        r10[24] = Short.TYPE;
        r10[25] = short[].class;
        r10[26] = SparseArray.class;
        int r12 = Build.VERSION.SDK_INT;
        if (r12 < 21) goto L5;
        Class<? extends Object> r13 = Size.class;
    L6:
        r10[27] = r13;
        if (r12 < 21) goto L9;
        r11 = SizeF.class;
    L9:
        r10[28] = r11;
        ACCEPTABLE_CLASSES = r10;
        return;
    L5:
        r13 = r11;
        goto L6
    }

    public SavedStateHandle() {
        this.regular = new LinkedHashMap();
        this.savedStateProviders = new LinkedHashMap();
        this.liveDatas = new LinkedHashMap();
        this.flows = new LinkedHashMap();
        this.savedStateProvider = new f(this);
    }

    public SavedStateHandle(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "initialState");
        LinkedHashMap r11 = new LinkedHashMap();
        this.regular = r11;
        this.savedStateProviders = new LinkedHashMap();
        this.liveDatas = new LinkedHashMap();
        this.flows = new LinkedHashMap();
        this.savedStateProvider = new f(this);
        r11.putAll(r10);
    }

    public static /* synthetic */ Bundle a(SavedStateHandle r10) {
        return savedStateProvider$lambda$0(r10);
    }

    public static final /* synthetic */ Class[] access$getACCEPTABLE_CLASSES$cp() {
        return ACCEPTABLE_CLASSES;
    }

    public static final /* synthetic */ Map access$getFlows$p(SavedStateHandle r10) {
        return r10.flows;
    }

    public static final /* synthetic */ Map access$getRegular$p(SavedStateHandle r10) {
        return r10.regular;
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final SavedStateHandle createHandle(Bundle r10, Bundle r11) {
        return Companion.createHandle(r10, r11);
    }

    private final <T> MutableLiveData<T> getLiveDataInternal(String r10, boolean r11, T r12) {
        SavingStateLiveData<?> r13 = this.liveDatas.get(r10);
        if ((r13 instanceof MutableLiveData) == false) goto L5;
        SavingStateLiveData<?> r14 = r13;
    L6:
        if (r14 == null) goto L9;
        return r14;
    L9:
        if (this.regular.containsKey(r10) == false) goto L11;
        SavingStateLiveData<?> r15 = new SavingStateLiveData(this, r10, this.regular.get(r10));
    L14:
        this.liveDatas.put(r10, r15);
        return r15;
    L11:
        if (r11 == false) goto L13;
        this.regular.put(r10, r12);
        r15 = new SavingStateLiveData(this, r10, r12);
        goto L14
    L13:
        r15 = new SavingStateLiveData(this, r10);
        goto L14
    L5:
        r14 = null;
        goto L6
    }

    private static final Bundle savedStateProvider$lambda$0(SavedStateHandle r10) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        Iterator r11 = MapsKt.toMap(r10.savedStateProviders).entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry r12 = (Map.Entry) r11.next();
        r10.set((String) r12.getKey(), ((SavedStateRegistry.SavedStateProvider) r12.getValue()).saveState());
        goto L4
    L6:
        Set<String> r13 = r10.regular.keySet();
        ArrayList r14 = new ArrayList(r13.size());
        ArrayList r15 = new ArrayList(r14.size());
        Iterator<String> r16 = r13.iterator();
    L8:
        if (r16.hasNext() == false) goto L11;
        String r17 = r16.next();
        r14.add(r17);
        r15.add(r10.regular.get(r17));
        goto L8
    L11:
        return BundleKt.bundleOf(new Pair[]{TuplesKt.to(KEYS, r14), TuplesKt.to(VALUES, r15)});
    }

    @MainThread
    public final void clearSavedStateProvider(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        this.savedStateProviders.remove(r10);
    }

    @MainThread
    public final boolean contains(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        return this.regular.containsKey(r10);
    }

    @MainThread
    public final <T> T get(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        return (T) this.regular.get(r10);
    L5:
        remove(r10);
        return null;
    }

    @MainThread
    public final <T> MutableLiveData<T> getLiveData(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        MutableLiveData<T> r11 = getLiveDataInternal(r10, false, null);
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<T of androidx.lifecycle.SavedStateHandle.getLiveData>");
        return r11;
    }

    @MainThread
    public final <T> MutableLiveData<T> getLiveData(String r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        return getLiveDataInternal(r10, true, r11);
    }

    @MainThread
    public final <T> p1<T> getStateFlow(String r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Map<String, g1<Object>> r12 = this.flows;
        g1<Object> r13 = r12.get(r10);
        if (r13 == null) goto L5;
    L8:
        p1<T> r14 = kotlinx.coroutines.flow.e.a(r13);
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type kotlinx.coroutines.flow.StateFlow<T of androidx.lifecycle.SavedStateHandle.getStateFlow>");
        return r14;
    L5:
        if (this.regular.containsKey(r10) == true) goto L7;
        this.regular.put(r10, r11);
    L7:
        r13 = q1.a(this.regular.get(r10));
        this.flows.put(r10, r13);
        r12.put(r10, r13);
        goto L8
    }

    @MainThread
    public final Set<String> keys() {
        return SetsKt.plus(SetsKt.plus(this.regular.keySet(), this.savedStateProviders.keySet()), this.liveDatas.keySet());
    }

    @MainThread
    public final <T> T remove(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        T r11 = (T) this.regular.remove(r10);
        SavingStateLiveData<?> r12 = this.liveDatas.remove(r10);
        if (r12 == null) goto L5;
        r12.detach();
    L5:
        this.flows.remove(r10);
        return r11;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final SavedStateRegistry.SavedStateProvider savedStateProvider() {
        return this.savedStateProvider;
    }

    @MainThread
    public final <T> void set(String r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        if (Companion.validateValue(r11) == false) goto L16;
        SavingStateLiveData<?> r12 = this.liveDatas.get(r10);
        if ((r12 instanceof MutableLiveData) == false) goto L7;
        SavingStateLiveData<?> r13 = r12;
    L8:
        if (r13 == null) goto L10;
        r13.setValue(r11);
    L11:
        g1<Object> r14 = this.flows.get(r10);
        if (r14 == null) goto L18;
        r14.setValue(r11);
        return;
    L18:
        return;
    L10:
        this.regular.put(r10, r11);
        goto L11
    L7:
        r13 = null;
        goto L8
    L16:
        StringBuilder r15 = new StringBuilder();
        r15.append("Can't put value with type ");
        Intrinsics.checkNotNull(r11);
        r15.append(r11.getClass());
        r15.append(" into saved state");
        throw new IllegalArgumentException(r15.toString());
    }

    @MainThread
    public final void setSavedStateProvider(String r10, SavedStateRegistry.SavedStateProvider r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, "provider");
        this.savedStateProviders.put(r10, r11);
    }
}
