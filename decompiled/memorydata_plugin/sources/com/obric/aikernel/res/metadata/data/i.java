package com.obric.aikernel.res.metadata.data;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.res.metadata.NativeLibVersionPolicy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\r\u001a\u00020\nJ\b\u0010\u000e\u001a\u00020\u0003H\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0014J\b\u0010\u0013\u001a\u00020\nH\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/obric/aikernel/res/metadata/data/PythonLibrary;", "Lcom/obric/aikernel/res/metadata/data/BaseMetadata;", ActivityLifecycle.NAME, "", "version", "config", "Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig;", "(Ljava/lang/String;Ljava/lang/String;Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig;)V", WsConstants.KEY_EXTRA, "useNative", "", "getUseNative", "()Z", "checkNativeLibVersionPolicy", "getExtra", "getType", "getTypeRootPath", "onInstallSucceed", "", "resourceIsAvailable", "Companion", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class i extends d {
    public static final a d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f6096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile String f6097b;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u0006*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/aikernel/res/metadata/data/PythonLibrary$Companion;", "", "()V", "TYPE", "", "libVersionLargerThan", "", TypedValues.AttributesType.S_TARGET, "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final boolean a(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            Intrinsics.checkNotNullParameter(r11, TypedValues.AttributesType.S_TARGET);
            Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"."}, false, 0, 6, null), Iterable.class, "com.obric.memorydata.plugin");
            Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r13 = r12.iterator();
        L4:
            if (r13.hasNext() == false) goto L6;
            r1.add(StringsKt.toIntOrNull((String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.memorydata.plugin")));
            goto L4
        L6:
            List r14 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
            Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"."}, false, 0, 6, null), Iterable.class, "com.obric.memorydata.plugin");
            Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r16 = r9.iterator();
        L8:
            if (r16.hasNext() == false) goto L10;
            r15.add(StringsKt.toIntOrNull((String) ZeusTransformUtils.preCheckCast(r16.next(), String.class, "com.obric.memorydata.plugin")));
            goto L8
        L10:
            List r17 = (List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin");
            Iterator r18 = ((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin")).iterator();
            int r2 = 0;
        L12:
            if (r18.hasNext() == false) goto L30;
            Object r3 = r18.next();
            int r4 = r2 + 1;
            if (r2 >= 0) goto L16;
            CollectionsKt.throwIndexOverflow();
        L16:
            Integer r5 = (Integer) ZeusTransformUtils.preCheckCast(r3, Integer.class, "com.obric.memorydata.plugin");
            if (r5 == null) goto L19;
            int r6 = r5.intValue();
        L20:
            Integer r7 = (Integer) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r17, r2), Integer.class, "com.obric.memorydata.plugin");
            if (r7 == null) goto L23;
            int r8 = r7.intValue();
        L24:
            if (r6 > r8) goto L25;
            if (r6 < r8) goto L28;
            r2 = r4;
            goto L12
        L28:
            return false;
        L25:
            return true;
        L23:
            r8 = 0;
            goto L24
        L19:
            r6 = 0;
            goto L20
        L30:
            return false;
        }
    }

    static {
        d = new a(null);
    }

    public i(String r3, String r4, PackageResourceManager.PresmConfig r5) {
        Intrinsics.checkNotNullParameter(r3, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r4, "version");
        Intrinsics.checkNotNullParameter(r5, "config");
        super(r3, r4, r5);
        this.f6096a = StringsKt.startsWith$default(r3, "native_", false, 2, null);
    }

    @Override // com.obric.aikernel.res.metadata.data.d
    public void a() {
        super.a();
        l();
        if (this.f6096a == false) goto L6;
        NativeLibVersionPolicy.INSTANCE.onNativeLibInstalled$resource_manager_release(this);
        return;
    }

    @Override // com.obric.aikernel.res.metadata.data.d
    public boolean e() {
        if (super.e() == true) goto L5;
    L9:
        return false;
    L5:
        if (this.f6096a == true) goto L7;
    L8:
        return true;
    L7:
        if (j() == false) goto L9;
        goto L8
    }

    public final boolean g() {
        return this.f6096a;
    }

    @Override // com.obric.aikernel.res.metadata.data.d
    public String getType() {
        return "lib";
    }

    @Override // com.obric.aikernel.res.metadata.data.d
    public String h() {
        return "libs";
    }

    public final boolean j() {
        String r0 = NativeLibVersionPolicy.INSTANCE.getVersion(s());
        boolean r1 = false;
        if (r0 == null) goto L8;
        if ((!d.a(t(), r0)) == true) goto L8;
        r1 = true;
    L8:
        return !r1;
    }

    @Override // com.obric.aikernel.res.metadata.data.d
    public String l() {
        if (this.f6097b != null) goto L33;
        monitor-enter(this);
    L30:
        th = move-exception;
        throw th;
    L6:
        if (this.f6097b != null) goto L27;
        com.obric.aikernel.res.metadata.config.a r0 = J();     // Catch: Throwable -> L30
        String r1 = null;
        if (r0 == null) goto L10;
        JsonObject r2 = r0.b();     // Catch: Throwable -> L30
    L11:
        if (r2 == null) goto L26;
        JsonElement r3 = r2.get(WsConstants.KEY_EXTRA);     // Catch: Throwable -> L30
        boolean r4 = true;
        if (r3 != null) goto L15;
    L17:
        r4 = false;
    L19:
        if (Boolean.valueOf(r4).booleanValue() == true) goto L22;
        r2 = null;
    L22:
        if (r2 == null) goto L26;
        JsonElement r5 = r2.get(WsConstants.KEY_EXTRA);     // Catch: Throwable -> L30
        if (r5 == null) goto L26;
        r1 = r5.getAsString();     // Catch: Throwable -> L30
        goto L26
    L15:
        if (r3.isJsonPrimitive() != true) goto L17;
    L26:
        this.f6097b = r1;     // Catch: Throwable -> L30
        goto L27
    L10:
        r2 = null;
    L27:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L30
        monitor-exit(this);
    L33:
        String r7 = this.f6097b;
        if (r7 != null) goto L39;
        return "{}";
    L39:
        return r7;
    }
}
