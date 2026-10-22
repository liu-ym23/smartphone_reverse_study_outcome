package androidx.lifecycle;

import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.core.os.BundleKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.savedstate.SavedStateRegistry;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;
import kotlinx.coroutines.flow.k;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\t\u0018\u0000 *2\u00020\u0001:\u0002*+B\u001d\b\u0016\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0002\u0010\u0005B\u0007\b\u0016¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0007J\u0011\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u0004H\u0087\u0002J\u001e\u0010\u0015\u001a\u0004\u0018\u0001H\u0016\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0012\u001a\u00020\u0004H\u0087\u0002¢\u0006\u0002\u0010\u0017J\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0019\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0012\u001a\u00020\u0004H\u0007J)\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0019\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u0002H\u0016H\u0007¢\u0006\u0002\u0010\u001bJ1\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0019\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u0002H\u0016H\u0002¢\u0006\u0002\u0010\u001eJ)\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00160 \"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u0002H\u0016H\u0007¢\u0006\u0002\u0010!J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040#H\u0007J\u001d\u0010$\u001a\u0004\u0018\u0001H\u0016\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0012\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0017J\b\u0010\r\u001a\u00020\u000eH\u0007J&\u0010%\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0012\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u0001H\u0016H\u0087\u0002¢\u0006\u0002\u0010'J\u0018\u0010(\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u000eH\u0007R\"\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Landroidx/lifecycle/SavedStateHandle;", "", "initialState", "", "", "(Ljava/util/Map;)V", "()V", "flows", "", "Lkotlinx/coroutines/flow/MutableStateFlow;", "liveDatas", "Landroidx/lifecycle/SavedStateHandle$SavingStateLiveData;", "regular", "savedStateProvider", "Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "savedStateProviders", "clearSavedStateProvider", "", "key", "contains", "", "get", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/String;)Ljava/lang/Object;", "getLiveData", "Landroidx/lifecycle/MutableLiveData;", "initialValue", "(Ljava/lang/String;Ljava/lang/Object;)Landroidx/lifecycle/MutableLiveData;", "getLiveDataInternal", "hasInitialValue", "(Ljava/lang/String;ZLjava/lang/Object;)Landroidx/lifecycle/MutableLiveData;", "getStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "(Ljava/lang/String;Ljava/lang/Object;)Lkotlinx/coroutines/flow/StateFlow;", SavedStateHandle.KEYS, "", "remove", "set", EventBody.KEY_VALUE, "(Ljava/lang/String;Ljava/lang/Object;)V", "setSavedStateProvider", "provider", "Companion", "SavingStateLiveData", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SavedStateHandle {
    private static final Class<? extends Object>[] ACCEPTABLE_CLASSES = null;
    public static final Companion Companion = null;
    private static final String KEYS = "keys";
    private static final String VALUES = "values";
    private final Map<String, ae<Object>> flows;
    private final Map<String, SavingStateLiveData<?>> liveDatas;
    private final Map<String, Object> regular;
    private final SavedStateRegistry.SavedStateProvider savedStateProvider;
    private final Map<String, SavedStateRegistry.SavedStateProvider> savedStateProviders;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0007J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0007R \u0010\u0003\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\b\u0001\u0012\u00020\u0001\u0018\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/lifecycle/SavedStateHandle$Companion;", "", "()V", "ACCEPTABLE_CLASSES", "", "Ljava/lang/Class;", "[Ljava/lang/Class;", "KEYS", "", "VALUES", "createHandle", "Landroidx/lifecycle/SavedStateHandle;", "restoredState", "Landroid/os/Bundle;", "defaultState", "validateValue", "", EventBody.KEY_VALUE, "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final SavedStateHandle createHandle(Bundle r6, Bundle r7) {
            if (r6 != null) goto L12;
            if (r7 == null) goto L29;
            Map r8 = (Map) ZeusTransformUtils.preCheckCast(new HashMap(), Map.class, "com.obric.memorydata.plugin");
            Iterator<String> r0 = r7.keySet().iterator();
        L8:
            if (r0.hasNext() == false) goto L11;
            String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullExpressionValue(r1, "key");
            r8.put(r1, r7.get(r1));
            goto L8
        L11:
            return new SavedStateHandle(r8);
        L29:
            return new SavedStateHandle();
        L12:
            ArrayList r9 = r6.getParcelableArrayList(SavedStateHandle.KEYS);
            ArrayList r10 = r6.getParcelableArrayList(SavedStateHandle.VALUES);
            int r2 = 0;
            if (r9 == null) goto L18;
            if (r10 == null) goto L18;
            if (r9.size() != r10.size()) goto L18;
            boolean r3 = true;
        L19:
            if (r3 == false) goto L26;
            Map r4 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
            int r5 = r9.size();
        L21:
            if (r2 >= r5) goto L24;
            Object r11 = r9.get(r2);
            Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.String");
            r4.put((String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.memorydata.plugin"), r10.get(r2));
            r2 = r2 + 1;
            goto L21
        L24:
            return new SavedStateHandle(r4);
        L26:
            throw new IllegalStateException("Invalid bundle passed as restored state".toString());
        L18:
            r3 = false;
            goto L19
        }

        public final boolean validateValue(Object r6) {
            if (r6 != null) goto L5;
            return true;
        L5:
            Class[] r0 = SavedStateHandle.access$getACCEPTABLE_CLASSES$cp();
            int r1 = r0.length;
            int r3 = 0;
        L6:
            if (r3 >= r1) goto L11;
            Class r4 = r0[r3];
            Intrinsics.checkNotNull(r4);
            if (ZeusTransformUtils.instanceOf(r4, r6) == true) goto L9;
            r3 = r3 + 1;
            goto L6
        L9:
            return true;
        L11:
            return false;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B!\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0002\u0010\bB\u0019\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\u0006\u0010\n\u001a\u00020\u000bJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\rR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/lifecycle/SavedStateHandle$SavingStateLiveData;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/MutableLiveData;", "handle", "Landroidx/lifecycle/SavedStateHandle;", "key", "", EventBody.KEY_VALUE, "(Landroidx/lifecycle/SavedStateHandle;Ljava/lang/String;Ljava/lang/Object;)V", "(Landroidx/lifecycle/SavedStateHandle;Ljava/lang/String;)V", "detach", "", "setValue", "(Ljava/lang/Object;)V", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class SavingStateLiveData<T> extends MutableLiveData<T> {
        private SavedStateHandle handle;
        private String key;

        public SavingStateLiveData(SavedStateHandle r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "key");
            this.key = r3;
            this.handle = r2;
        }

        public SavingStateLiveData(SavedStateHandle r2, String r3, T r4) {
            Intrinsics.checkNotNullParameter(r3, "key");
            super(r4);
            this.key = r3;
            this.handle = r2;
        }

        public final void detach() {
            this.handle = null;
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void setValue(T r4) {
            SavedStateHandle r0 = this.handle;
            if (r0 == null) goto L8;
            SavedStateHandle.access$getRegular$p(r0).put(this.key, r4);
            ae r1 = (ae) ZeusTransformUtils.preCheckCast(SavedStateHandle.access$getFlows$p(r0).get(this.key), ae.class, "com.obric.memorydata.plugin");
            if (r1 == null) goto L8;
            r1.b(r4);
        L8:
            super.setValue(r4);
        }
    }

    static {
        Companion = new Companion(null);
        Class<? extends Object>[] r0 = new Class[29];
        r0[0] = Boolean.TYPE;
        r0[1] = boolean[].class;
        r0[2] = Double.TYPE;
        r0[3] = double[].class;
        r0[4] = Integer.TYPE;
        r0[5] = int[].class;
        r0[6] = Long.TYPE;
        r0[7] = long[].class;
        r0[8] = String.class;
        r0[9] = String[].class;
        r0[10] = Binder.class;
        r0[11] = Bundle.class;
        r0[12] = Byte.TYPE;
        r0[13] = byte[].class;
        r0[14] = Character.TYPE;
        r0[15] = char[].class;
        r0[16] = CharSequence.class;
        r0[17] = CharSequence[].class;
        r0[18] = ArrayList.class;
        r0[19] = Float.TYPE;
        r0[20] = float[].class;
        r0[21] = Parcelable.class;
        r0[22] = Parcelable[].class;
        r0[23] = Serializable.class;
        r0[24] = Short.TYPE;
        r0[25] = short[].class;
        r0[26] = SparseArray.class;
        if (Build.VERSION.SDK_INT < 21) goto L5;
        Class<Size> r1 = Size.class;
    L6:
        r0[27] = r1;
        if (Build.VERSION.SDK_INT < 21) goto L9;
        Class<SizeF> r2 = SizeF.class;
    L10:
        r0[28] = r2;
        ACCEPTABLE_CLASSES = r0;
        return;
    L9:
        r2 = Integer.TYPE;
        goto L10
    L5:
        r1 = Integer.TYPE;
        goto L6
    }

    public SavedStateHandle() {
        this.regular = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.savedStateProviders = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.liveDatas = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.flows = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.savedStateProvider = new $$Lambda$SavedStateHandle$aMir0GWwzPQviKVGE0DPm0kayew(this);
    }

    public SavedStateHandle(Map<String, ? extends Object> r5) {
        Map<? extends String, ? extends Object> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "initialState");
        Map<String, Object> r0 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.regular = r0;
        this.savedStateProviders = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.liveDatas = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.flows = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.savedStateProvider = new $$Lambda$SavedStateHandle$aMir0GWwzPQviKVGE0DPm0kayew(this);
        r0.putAll(r6);
    }

    public static final /* synthetic */ Class[] access$getACCEPTABLE_CLASSES$cp() {
        return ACCEPTABLE_CLASSES;
    }

    public static final /* synthetic */ Map access$getFlows$p(SavedStateHandle r0) {
        return r0.flows;
    }

    public static final /* synthetic */ Map access$getRegular$p(SavedStateHandle r0) {
        return r0.regular;
    }

    @JvmStatic
    public static final SavedStateHandle createHandle(Bundle r1, Bundle r2) {
        return Companion.createHandle(r1, r2);
    }

    private final <T> MutableLiveData<T> getLiveDataInternal(String r4, boolean r5, T r6) {
        SavingStateLiveData<?> r0 = this.liveDatas.get(r4);
        if (ZeusTransformUtils.instanceOf(r0, MutableLiveData.class) == false) goto L5;
        MutableLiveData<T> r1 = (MutableLiveData) ZeusTransformUtils.preCheckCast(r0, MutableLiveData.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 == null) goto L9;
        return r1;
    L9:
        if (this.regular.containsKey(r4) == false) goto L11;
        SavingStateLiveData<?> r7 = new SavingStateLiveData(this, r4, this.regular.get(r4));
    L14:
        this.liveDatas.put(r4, r7);
        return (MutableLiveData) ZeusTransformUtils.preCheckCast(r7, MutableLiveData.class, "com.obric.memorydata.plugin");
    L11:
        if (r5 == false) goto L13;
        this.regular.put(r4, r6);
        r7 = new SavingStateLiveData(this, r4, r6);
        goto L14
    L13:
        r7 = new SavingStateLiveData(this, r4);
        goto L14
    L5:
        r1 = null;
        goto L6
    }

    public static /* synthetic */ Bundle lambda$aMir0GWwzPQviKVGE0DPm0kayew(SavedStateHandle r0) {
        return savedStateProvider$lambda$0(r0);
    }

    private static final Bundle savedStateProvider$lambda$0(SavedStateHandle r6) {
        Intrinsics.checkNotNullParameter(r6, "this$0");
        Iterator r0 = MapsKt.toMap(r6.savedStateProviders).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r6.set((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin"), ((SavedStateRegistry.SavedStateProvider) ZeusTransformUtils.preCheckCast(r1.getValue(), SavedStateRegistry.SavedStateProvider.class, "com.obric.memorydata.plugin")).saveState());
        goto L4
    L6:
        Set<String> r2 = r6.regular.keySet();
        ArrayList r3 = new ArrayList(r2.size());
        ArrayList r4 = new ArrayList(r3.size());
        Iterator<String> r5 = r2.iterator();
    L8:
        if (r5.hasNext() == false) goto L11;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin");
        r3.add(r7);
        r4.add(r6.regular.get(r7));
        goto L8
    L11:
        return BundleKt.bundleOf(new Pair[]{TuplesKt.to(KEYS, r3), TuplesKt.to(VALUES, r4)});
    }

    public final void clearSavedStateProvider(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.savedStateProviders.remove(r2);
    }

    public final boolean contains(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return this.regular.containsKey(r2);
    }

    public final <T> T get(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return (T) this.regular.get(r2);
    L5:
        remove(r2);
        return null;
    }

    public final <T> MutableLiveData<T> getLiveData(String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        MutableLiveData<T> r2 = getLiveDataInternal(r3, false, null);
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<T of androidx.lifecycle.SavedStateHandle.getLiveData>");
        return r2;
    }

    public final <T> MutableLiveData<T> getLiveData(String r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return getLiveDataInternal(r2, true, r3);
    }

    public final <T> ar<T> getStateFlow(String r3, T r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Map<String, ae<Object>> r0 = this.flows;
        ae<Object> r1 = r0.get(r3);
        if (r1 == null) goto L5;
    L8:
        ar<T> r2 = k.a((ae) ZeusTransformUtils.preCheckCast(r1, ae.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlinx.coroutines.flow.StateFlow<T of androidx.lifecycle.SavedStateHandle.getStateFlow>");
        return r2;
    L5:
        if (this.regular.containsKey(r3) == true) goto L7;
        this.regular.put(r3, r4);
    L7:
        r1 = at.a(this.regular.get(r3));
        this.flows.put(r3, r1);
        r0.put(r3, r1);
        goto L8
    }

    public final Set<String> keys() {
        return SetsKt.plus(SetsKt.plus(this.regular.keySet(), (Iterable) ZeusTransformUtils.preCheckCast(this.savedStateProviders.keySet(), Iterable.class, "com.obric.memorydata.plugin")), (Iterable) ZeusTransformUtils.preCheckCast(this.liveDatas.keySet(), Iterable.class, "com.obric.memorydata.plugin"));
    }

    public final <T> T remove(String r5) {
        Intrinsics.checkNotNullParameter(r5, "key");
        T r0 = (T) this.regular.remove(r5);
        SavingStateLiveData r1 = (SavingStateLiveData) ZeusTransformUtils.preCheckCast(this.liveDatas.remove(r5), SavingStateLiveData.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L5;
        r1.detach();
    L5:
        this.flows.remove(r5);
        return r0;
    }

    public final SavedStateRegistry.SavedStateProvider savedStateProvider() {
        return this.savedStateProvider;
    }

    public final <T> void set(String r4, T r5) {
        Intrinsics.checkNotNullParameter(r4, "key");
        if (Companion.validateValue(r5) == false) goto L16;
        SavingStateLiveData<?> r0 = this.liveDatas.get(r4);
        if (ZeusTransformUtils.instanceOf(r0, MutableLiveData.class) == false) goto L7;
        MutableLiveData r1 = (MutableLiveData) ZeusTransformUtils.preCheckCast(r0, MutableLiveData.class, "com.obric.memorydata.plugin");
    L8:
        if (r1 == null) goto L10;
        r1.setValue(r5);
    L11:
        ae r3 = (ae) ZeusTransformUtils.preCheckCast(this.flows.get(r4), ae.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L18;
        r3.b(r5);
        return;
    L18:
        return;
    L10:
        this.regular.put(r4, r5);
        goto L11
    L7:
        r1 = null;
        goto L8
    L16:
        StringBuilder r6 = new StringBuilder().append("Can't put value with type ");
        Intrinsics.checkNotNull(r5);
        throw new IllegalArgumentException(r6.append(r5.getClass()).append(" into saved state").toString());
    }

    public final void setSavedStateProvider(String r3, SavedStateRegistry.SavedStateProvider r4) {
        SavedStateRegistry.SavedStateProvider r5 = (SavedStateRegistry.SavedStateProvider) ZeusTransformUtils.wrapperContextForParams(r4, SavedStateRegistry.SavedStateProvider.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r5, "provider");
        this.savedStateProviders.put(r3, r5);
    }
}
