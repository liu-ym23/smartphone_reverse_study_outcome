package com.obric.aikernel.res.a;

import android.content.Context;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/aikernel/res/debug/DebugInfo;", "", "()V", "DEBUG_INFO_FILE", "", "cleanDebugInfo", "", "context", "Landroid/content/Context;", "getDebugInfo", "Lcom/obric/aikernel/res/debug/DebugInfo$DebugInfo;", "DebugInfo", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6001a = null;

    /* JADX INFO: renamed from: com.obric.aikernel.res.a.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/obric/aikernel/res/debug/DebugInfo$DebugInfo;", "", "targetPackage", "", "(Ljava/lang/String;)V", "getTargetPackage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class C0256a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("target_package")
        private final String f6002a;

        public final String a() {
            return this.f6002a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0256a.class) == true) goto L8;
            return false;
        L8:
            C0256a r6 = (C0256a) ZeusTransformUtils.preCheckCast(r5, C0256a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f6002a, r6.f6002a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f6002a.hashCode();
        }

        public String toString() {
            return "DebugInfo(targetPackage=" + this.f6002a + ')';
        }
    }

    static {
        f6001a = new a();
    }

    private a() {
    }

    public final C0256a a(Context r3) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "context");
        File r4 = new File(r2.getFilesDir(), "aee_debug_info.json");
        if (r4.canRead() == true) goto L7;
        return null;
    L7:
        return (C0256a) ZeusTransformUtils.preCheckCast(com.obric.aikernel.res.utils.a.f6155a.a(r4, C0256a.class), C0256a.class, "com.obric.memorydata.plugin");
    }

    public final void b(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        new File(r1.getFilesDir(), "aee_debug_info.json").delete();
    }
}
