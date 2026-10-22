package androidx.lifecycle;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import androidx.core.os.BundleKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.f;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import androidx.savedstate.SavedStateRegistry;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.d2;
import kotlinx.coroutines.flow.e2;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.p2;
import kotlinx.coroutines.flow.q2;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 32\u00020\u0001:\u000234B\u001f\b\u0016\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006B\t\b\u0016¢\u0006\u0004\b\u0005\u0010\u0007J3\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0003H\u0087\u0002¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J+\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\f\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u0015\u0010\u0017J+\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\f\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001bH\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ \u0010\u001e\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u00020\u0003H\u0087\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ(\u0010\"\u001a\u00020!\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00018\u0000H\u0087\u0002¢\u0006\u0004\b\"\u0010#J\u001f\u0010$\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u00020\u0003H\u0007¢\u0006\u0004\b$\u0010\u001fJ\u001f\u0010&\u001a\u00020!2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0010H\u0007¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020!2\u0006\u0010\t\u001a\u00020\u0003H\u0007¢\u0006\u0004\b(\u0010)R\"\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R \u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00100*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010,R$\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030.0*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010,R(\u00101\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u0001000*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010,R\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u00102¨\u00065"}, d2 = {"Landroidx/lifecycle/SavedStateHandle;", "", "", "", "initialState", "<init>", "(Ljava/util/Map;)V", "()V", ExifInterface.GPS_DIRECTION_TRUE, STGroup.DICT_KEY, "", "hasInitialValue", "initialValue", "Landroidx/lifecycle/MutableLiveData;", "getLiveDataInternal", "(Ljava/lang/String;ZLjava/lang/Object;)Landroidx/lifecycle/MutableLiveData;", "Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "savedStateProvider", "()Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "contains", "(Ljava/lang/String;)Z", "getLiveData", "(Ljava/lang/String;)Landroidx/lifecycle/MutableLiveData;", "(Ljava/lang/String;Ljava/lang/Object;)Landroidx/lifecycle/MutableLiveData;", "Lkotlinx/coroutines/flow/p2;", "getStateFlow", "(Ljava/lang/String;Ljava/lang/Object;)Lkotlinx/coroutines/flow/p2;", "", SavedStateHandle.KEYS, "()Ljava/util/Set;", "get", "(Ljava/lang/String;)Ljava/lang/Object;", "value", "", "set", "(Ljava/lang/String;Ljava/lang/Object;)V", "remove", "provider", "setSavedStateProvider", "(Ljava/lang/String;Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;)V", "clearSavedStateProvider", "(Ljava/lang/String;)V", "", "regular", "Ljava/util/Map;", "savedStateProviders", "Landroidx/lifecycle/SavedStateHandle$SavingStateLiveData;", "liveDatas", "Lkotlinx/coroutines/flow/d2;", "flows", "Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "Companion", "SavingStateLiveData", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSavedStateHandle.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SavedStateHandle.kt\nandroidx/lifecycle/SavedStateHandle\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,450:1\n361#2,3:451\n364#2,4:455\n1#3:454\n*S KotlinDebug\n*F\n+ 1 SavedStateHandle.kt\nandroidx/lifecycle/SavedStateHandle\n*L\n198#1:451,3\n198#1:455,4\n*E\n"})
public final class SavedStateHandle {
    private static final Class<? extends Object>[] ACCEPTABLE_CLASSES = null;
    public static final Companion Companion = null;
    private static final String KEYS = "keys";
    private static final String VALUES = "values";
    private final Map<String, d2> flows;
    private final Map<String, SavingStateLiveData<?>> liveDatas;
    private final Map<String, Object> regular;
    private final SavedStateRegistry.SavedStateProvider savedStateProvider;
    private final Map<String, SavedStateRegistry.SavedStateProvider> savedStateProviders;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0007J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0007R \u0010\u0003\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\b\u0001\u0012\u00020\u0001\u0018\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/lifecycle/SavedStateHandle$Companion;", "", "()V", "ACCEPTABLE_CLASSES", "", "Ljava/lang/Class;", "[Ljava/lang/Class;", "KEYS", "", "VALUES", "createHandle", "Landroidx/lifecycle/SavedStateHandle;", "restoredState", "Landroid/os/Bundle;", "defaultState", "validateValue", "", "value", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final SavedStateHandle createHandle(Bundle r5, Bundle r10) {
            if (r5 != null) goto L11;
            if (r10 == null) goto L25;
            HashMap r11 = new HashMap();
            Iterator<String> r12 = r10.keySet().iterator();
        L7:
            if (r12.hasNext() == false) goto L10;
            String r13 = r12.next();
            r11.put(r13, r10.get(r13));
            goto L7
        L10:
            return new SavedStateHandle(r11);
        L25:
            return new SavedStateHandle();
        L11:
            ArrayList r14 = r5.getParcelableArrayList(SavedStateHandle.KEYS);
            ArrayList r15 = r5.getParcelableArrayList(SavedStateHandle.VALUES);
            if (r14 == null) goto L22;
            if (r15 == null) goto L22;
            if (r14.size() != r15.size()) goto L22;
            LinkedHashMap r16 = new LinkedHashMap();
            int r17 = r14.size();
            int r18 = 0;
        L17:
            if (r18 >= r17) goto L20;
            Object r19 = r14.get(r18);
            Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type kotlin.String");
            r16.put((String) r19, r15.get(r18));
            r18 = r18 + 1;
            goto L17
        L20:
            return new SavedStateHandle(r16);
        L22:
            throw new IllegalStateException("Invalid bundle passed as restored state");
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final boolean validateValue(Object r10) {
            if (r10 != null) goto L5;
            return true;
        L5:
            Class[] r5 = SavedStateHandle.access$getACCEPTABLE_CLASSES$cp();
            int r11 = r5.length;
            int r12 = 0;
        L6:
            if (r12 >= r11) goto L11;
            Class r13 = r5[r12];
            Intrinsics.checkNotNull(r13);
            if (r13.isInstance(r10) == true) goto L9;
            r12 = r12 + 1;
            goto L6
        L9:
            return true;
        L11:
            return false;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B!\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0002\u0010\bB\u0019\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\u0006\u0010\n\u001a\u00020\u000bJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\rR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/lifecycle/SavedStateHandle$SavingStateLiveData;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/MutableLiveData;", "handle", "Landroidx/lifecycle/SavedStateHandle;", STGroup.DICT_KEY, "", "value", "(Landroidx/lifecycle/SavedStateHandle;Ljava/lang/String;Ljava/lang/Object;)V", "(Landroidx/lifecycle/SavedStateHandle;Ljava/lang/String;)V", "detach", "", "setValue", "(Ljava/lang/Object;)V", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class SavingStateLiveData<T> extends MutableLiveData<T> {
        private SavedStateHandle handle;
        private String key;

        public SavingStateLiveData(SavedStateHandle r5, String r10, T r11) {
            Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
            super(r11);
            this.key = r10;
            this.handle = r5;
        }

        public final void detach() {
            this.handle = null;
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void setValue(T r5) {
            SavedStateHandle r10 = this.handle;
            if (r10 == null) goto L8;
            SavedStateHandle.access$getRegular$p(r10).put(this.key, r5);
            d2 r11 = (d2) SavedStateHandle.access$getFlows$p(r10).get(this.key);
            if (r11 == null) goto L8;
            ((q2) r11).i(r5);
        L8:
            super.setValue(r5);
        }

        public SavingStateLiveData(SavedStateHandle r5, String r10) {
            Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
            this.key = r10;
            this.handle = r5;
        }
    }

    static {
        Companion = new Companion(null);
        ACCEPTABLE_CLASSES = new Class[]{Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};
    }

    public SavedStateHandle(Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "initialState");
        LinkedHashMap r10 = new LinkedHashMap();
        this.regular = r10;
        this.savedStateProviders = new LinkedHashMap();
        this.liveDatas = new LinkedHashMap();
        this.flows = new LinkedHashMap();
        this.savedStateProvider = new f(this, 2);
        r10.putAll(r5);
    }

    public static /* synthetic */ Bundle a(SavedStateHandle r5) {
        return savedStateProvider$lambda$0(r5);
    }

    public static final /* synthetic */ Class[] access$getACCEPTABLE_CLASSES$cp() {
        return ACCEPTABLE_CLASSES;
    }

    public static final /* synthetic */ Map access$getFlows$p(SavedStateHandle r5) {
        return r5.flows;
    }

    public static final /* synthetic */ Map access$getRegular$p(SavedStateHandle r5) {
        return r5.regular;
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final SavedStateHandle createHandle(Bundle r5, Bundle r10) {
        return Companion.createHandle(r5, r10);
    }

    private final <T> MutableLiveData<T> getLiveDataInternal(String r5, boolean r10, T r11) {
        SavingStateLiveData<?> r12 = this.liveDatas.get(r5);
        if ((r12 instanceof MutableLiveData) == false) goto L5;
        SavingStateLiveData<?> r13 = r12;
    L6:
        if (r13 == null) goto L9;
        return r13;
    L9:
        if (this.regular.containsKey(r5) == false) goto L11;
        SavingStateLiveData<?> r14 = new SavingStateLiveData(this, r5, this.regular.get(r5));
    L14:
        this.liveDatas.put(r5, r14);
        return r14;
    L11:
        if (r10 == false) goto L13;
        this.regular.put(r5, r11);
        r14 = new SavingStateLiveData(this, r5, r11);
        goto L14
    L13:
        r14 = new SavingStateLiveData(this, r5);
        goto L14
    L5:
        r13 = null;
        goto L6
    }

    private static final Bundle savedStateProvider$lambda$0(SavedStateHandle r5) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        Iterator r10 = MapsKt.toMap(r5.savedStateProviders).entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        Map.Entry r11 = (Map.Entry) r10.next();
        r5.set((String) r11.getKey(), ((SavedStateRegistry.SavedStateProvider) r11.getValue()).saveState());
        goto L4
    L6:
        Set<String> r12 = r5.regular.keySet();
        ArrayList r13 = new ArrayList(r12.size());
        ArrayList r14 = new ArrayList(r13.size());
        Iterator<String> r15 = r12.iterator();
    L8:
        if (r15.hasNext() == false) goto L11;
        String r16 = r15.next();
        r13.add(r16);
        r14.add(r5.regular.get(r16));
        goto L8
    L11:
        return BundleKt.bundleOf(new Pair[]{TuplesKt.to(KEYS, r13), TuplesKt.to(VALUES, r14)});
    }

    @MainThread
    public final void clearSavedStateProvider(String r5) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        this.savedStateProviders.remove(r5);
    }

    @MainThread
    public final boolean contains(String r5) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        return this.regular.containsKey(r5);
    }

    @MainThread
    public final <T> T get(String r5) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        return (T) this.regular.get(r5);
    L5:
        remove(r5);
        return null;
    }

    @MainThread
    public final <T> MutableLiveData<T> getLiveData(String r5) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        MutableLiveData<T> r10 = getLiveDataInternal(r5, false, null);
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<T of androidx.lifecycle.SavedStateHandle.getLiveData>");
        return r10;
    }

    @MainThread
    public final <T> p2 getStateFlow(String r5, T r10) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        Map<String, d2> r11 = this.flows;
        d2 r12 = r11.get(r5);
        if (r12 == null) goto L5;
    L8:
        e2 r13 = new e2(r12, null);
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlinx.coroutines.flow.StateFlow<T of androidx.lifecycle.SavedStateHandle.getStateFlow>");
        return r13;
    L5:
        if (this.regular.containsKey(r5) == true) goto L7;
        this.regular.put(r5, r10);
    L7:
        r12 = i.b(this.regular.get(r5));
        this.flows.put(r5, r12);
        r11.put(r5, r12);
        goto L8
    }

    @MainThread
    public final Set<String> keys() {
        return SetsKt.plus(SetsKt.plus(this.regular.keySet(), this.savedStateProviders.keySet()), this.liveDatas.keySet());
    }

    @MainThread
    public final <T> T remove(String r5) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        T r10 = (T) this.regular.remove(r5);
        SavingStateLiveData<?> r11 = this.liveDatas.remove(r5);
        if (r11 == null) goto L5;
        r11.detach();
    L5:
        this.flows.remove(r5);
        return r10;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final SavedStateRegistry.SavedStateProvider savedStateProvider() {
        return this.savedStateProvider;
    }

    @MainThread
    public final <T> void set(String r5, T r10) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        if (Companion.validateValue(r10) == false) goto L16;
        SavingStateLiveData<?> r11 = this.liveDatas.get(r5);
        if ((r11 instanceof MutableLiveData) == false) goto L7;
        SavingStateLiveData<?> r12 = r11;
    L8:
        if (r12 == null) goto L10;
        r12.setValue(r10);
    L11:
        d2 r13 = this.flows.get(r5);
        if (r13 == null) goto L18;
        ((q2) r13).i(r10);
        return;
    L18:
        return;
    L10:
        this.regular.put(r5, r10);
        goto L11
    L7:
        r12 = null;
        goto L8
    L16:
        StringBuilder r14 = new StringBuilder("Can't put value with type ");
        Intrinsics.checkNotNull(r10);
        r14.append(r10.getClass());
        r14.append(" into saved state");
        throw new IllegalArgumentException(r14.toString());
    }

    @MainThread
    public final void setSavedStateProvider(String r5, SavedStateRegistry.SavedStateProvider r10) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        Intrinsics.checkNotNullParameter(r10, "provider");
        this.savedStateProviders.put(r5, r10);
    }

    @MainThread
    public final <T> MutableLiveData<T> getLiveData(String r5, T r10) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        return getLiveDataInternal(r5, true, r10);
    }

    public SavedStateHandle() {
        this.regular = new LinkedHashMap();
        this.savedStateProviders = new LinkedHashMap();
        this.liveDatas = new LinkedHashMap();
        this.flows = new LinkedHashMap();
        this.savedStateProvider = new f(this, 2);
    }
}
