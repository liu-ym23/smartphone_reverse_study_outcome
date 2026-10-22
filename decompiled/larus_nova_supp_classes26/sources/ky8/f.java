package ky8;

import com.larus.canvas.feature.component.logic.bean.ImageSaveStatus;
import com.larus.canvas.service.bean.AIBeautify;
import com.larus.canvas.service.bean.CanvasBlock;
import com.larus.canvas.service.bean.CanvasImageBlock;
import com.larus.canvas.service.bean.CanvasInfo;
import com.larus.canvas.service.bean.CanvasMsgInfo;
import com.larus.im.bean.message.ImageData;
import com.larus.im.bean.message.ImageObj;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.platform.service.z2;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f implements h {
    public static final Lazy<Boolean> j = null;
    public final String a;
    public final List<CanvasBlock> b;
    public final h c;
    public final h d;
    public final i e;
    public final boolean f;
    public final int g;
    public final boolean h;
    public long i;

    public static final class a {
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof f) == true) goto L8;
        return false;
    L8:
        f r9 = (f) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L33;
        return false;
    L33:
        if (this.i == r9.i) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        List<CanvasBlock> r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.c.hashCode()) * 31;
        h r5 = this.d;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        int r6 = (((r4 + r2) * 31) + this.e.hashCode()) * 31;
        int r7 = 1231;
        if (this.f == false) goto L13;
        int r8 = 1231;
    L14:
        int r9 = (((r6 + r8) * 31) + this.g) * 31;
        if (this.h == true) goto L18;
        r7 = 1237;
    L18:
        long r10 = this.i;
        return ((r9 + r7) * 31) + ((int) (r10 ^ (r10 >>> 32)));
    L13:
        r8 = 1237;
        goto L14
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final boolean k() {
        return !CollectionsKt.contains(CollectionsKt.listOf(new Integer[]{10, 11}), n());
    }

    public final String toString() {
        return "GenImageTaskItem(localId=" + this.a + ", canvasBlockList=" + this.b + ", previousTaskItem=" + this.c + ", rootTaskItem=" + this.d + ", inputDataSnapShot=" + this.e + ", isLoaded=" + this.f + ", saveStatus=" + this.g + ", willBeRemove=" + this.h + ", startTime=" + this.i + ')';
    }

    static {
        j = LazyKt.lazy(new e());
    }

    public final CanvasInfo a() {
        List<CanvasBlock> r0 = this.b;
        if (r0 == null) goto L9;
        CanvasBlock r1 = (CanvasBlock) CollectionsKt.firstOrNull(r0);
        if (r1 == null) goto L9;
        CanvasImageBlock r2 = r1.content;
        if (r2 == null) goto L9;
        return r2.canvasInfo;
    L9:
        return null;
    }

    public final AIBeautify c() {
        List<CanvasBlock> r0 = this.b;
        if (r0 == null) goto L11;
        CanvasBlock r1 = (CanvasBlock) CollectionsKt.firstOrNull(r0);
        if (r1 == null) goto L11;
        CanvasImageBlock r2 = r1.content;
        if (r2 == null) goto L11;
        CanvasInfo r3 = r2.canvasInfo;
        if (r3 == null) goto L11;
        return r3.aiBeautify;
    L11:
        return null;
    }

    public final Long d() {
        List<CanvasBlock> r0 = this.b;
        if (r0 == null) goto L11;
        CanvasBlock r1 = (CanvasBlock) CollectionsKt.firstOrNull(r0);
        if (r1 == null) goto L11;
        CanvasImageBlock r2 = r1.content;
        if (r2 == null) goto L11;
        CanvasInfo r3 = r2.canvasInfo;
        if (r3 == null) goto L11;
        return r3.canvasId;
    L11:
        return null;
    }

    public final String e() {
        List<CanvasBlock> r0 = this.b;
        if (r0 == null) goto L11;
        CanvasBlock r1 = (CanvasBlock) CollectionsKt.firstOrNull(r0);
        if (r1 == null) goto L11;
        CanvasImageBlock r2 = r1.content;
        if (r2 == null) goto L11;
        CanvasInfo r3 = r2.canvasInfo;
        if (r3 == null) goto L11;
        return r3.replySubId;
    L11:
        return null;
    }

    public final UserCreationFromIM f() {
        List<CanvasBlock> r0 = this.b;
        if (r0 == null) goto L9;
        CanvasBlock r1 = (CanvasBlock) CollectionsKt.firstOrNull(r0);
        if (r1 == null) goto L9;
        CanvasImageBlock r2 = r1.content;
        if (r2 == null) goto L9;
        return r2.creation;
    L9:
        return null;
    }

    public final ImageData h() {
        List<CanvasBlock> r0 = this.b;
        if (r0 == null) goto L23;
        CanvasBlock r1 = (CanvasBlock) CollectionsKt.firstOrNull(r0);
        if (r1 == null) goto L23;
        CanvasImageBlock r2 = r1.content;
        if (r2 == null) goto L23;
        ImageData r3 = r2.image;
        if (r3 == null) goto L23;
        String r4 = r3.imageUri;
        if (r4 != null) goto L13;
    L16:
        boolean r5 = true;
    L17:
        if (r5 == true) goto L26;
        CreationNoWatermarkManager r6 = CreationNoWatermarkManager.a;
        r6.getClass();
        ImageData r7 = (ImageData) r6.W(CreationNoWatermarkManager.z(r3), r3).a;
        if (r7 != null) goto L25;
        return r3;
    L25:
        return r7;
    L26:
        return r3;
    L13:
        if (r4.length() == 0) goto L16;
        r5 = false;
    L23:
        return null;
    }

    public final CanvasMsgInfo m() {
        List<CanvasBlock> r0 = this.b;
        if (r0 == null) goto L9;
        CanvasBlock r1 = (CanvasBlock) CollectionsKt.firstOrNull(r0);
        if (r1 == null) goto L9;
        CanvasImageBlock r2 = r1.content;
        if (r2 == null) goto L9;
        return r2.msgInfo;
    L9:
        return null;
    }

    public final Integer n() {
        List<CanvasBlock> r0 = this.b;
        if (r0 == null) goto L11;
        CanvasBlock r1 = (CanvasBlock) CollectionsKt.firstOrNull(r0);
        if (r1 == null) goto L11;
        CanvasImageBlock r2 = r1.content;
        if (r2 == null) goto L11;
        CanvasInfo r3 = r2.canvasInfo;
        if (r3 == null) goto L11;
        return r3.canvasStatus;
    L11:
        return null;
    }

    public final String g() {
        ImageData r0 = h();
        if (r0 == null) goto L7;
        ImageObj r1 = r0.imageOrigin;
        if (r1 == null) goto L7;
        return r1.url;
    L7:
        return null;
    }

    public final String i() {
        ImageData r0 = h();
        String r1 = null;
        if (r0 == null) goto L64;
        boolean r3 = true;
        String r5 = "";
        if (z2.a.enableBlockImagePreviewResize() == false) goto L46;
        ImageObj r2 = r0.imagePreviewResize;
        if (r2 == null) goto L9;
        String r4 = r2.getHeicUrl();
    L10:
        if (r4 != null) goto L13;
        r4 = "";
    L13:
        if (r4.length() != 0) goto L15;
        boolean r6 = true;
    L16:
        if (r6 == false) goto L65;
        ImageObj r7 = r0.imagePreviewResize;
        if (r7 == null) goto L20;
        r4 = r7.url;
    L21:
        if (r4 != null) goto L24;
        r4 = "";
    L24:
        if (r4.length() != 0) goto L26;
        boolean r8 = true;
    L27:
        if (r8 == false) goto L65;
        ImageObj r9 = r0.imagePreview;
        if (r9 == null) goto L31;
        String r10 = r9.getHeicUrl();
    L32:
        if (r10 == null) goto L36;
        r5 = r10;
    L36:
        if (r5.length() == 0) goto L39;
        r3 = false;
    L39:
        if (r3 == false) goto L44;
        ImageObj r11 = r0.imagePreview;
        if (r11 == null) goto L43;
        r1 = r11.url;
    L43:
        r5 = r1;
    L44:
        r4 = r5;
        goto L65
    L31:
        r10 = null;
        goto L32
    L26:
        r8 = false;
        goto L27
    L20:
        r4 = null;
    L65:
        return r4;
    L15:
        r6 = false;
        goto L16
    L9:
        r4 = null;
        goto L10
    L46:
        ImageObj r12 = r0.imagePreview;
        if (r12 == null) goto L49;
        String r13 = r12.getHeicUrl();
    L50:
        if (r13 == null) goto L54;
        r5 = r13;
    L54:
        if (r5.length() == 0) goto L57;
        r3 = false;
    L57:
        if (r3 == false) goto L63;
        ImageObj r14 = r0.imagePreview;
        if (r14 == null) goto L61;
        r1 = r14.url;
    L61:
        r5 = r1;
    L63:
        return r5;
    L49:
        r13 = null;
        goto L50
    L64:
        return null;
    }

    public final String j() {
        CanvasMsgInfo r0 = m();
        if (r0 == null) goto L6;
        String r1 = r0.taskId;
        if (r1 == null) goto L6;
        return r1;
    L6:
        List<CanvasBlock> r2 = this.b;
        if (r2 == null) goto L15;
        CanvasBlock r3 = (CanvasBlock) CollectionsKt.firstOrNull(r2);
        if (r3 == null) goto L15;
        CanvasImageBlock r4 = r3.content;
        if (r4 == null) goto L15;
        ImageData r5 = r4.image;
        if (r5 == null) goto L15;
        return r5.taskId;
    L15:
        return null;
    }

    public final boolean l() {
        Integer r0 = n();
        if (r0 != null) goto L6;
    L8:
        return false;
    L6:
        if (r0.intValue() != 10) goto L8;
        return true;
    }

    public static f b(f r15, List r16, boolean r17, int r18, boolean r19, int r20) {
        i r3 = null;
        if ((r20 & 1) == 0) goto L5;
        String r5 = r15.a;
    L7:
        if ((r20 & 2) == 0) goto L9;
        List r6 = r15.b;
    L11:
        if ((r20 & 4) == 0) goto L13;
        h r7 = r15.c;
    L15:
        if ((r20 & 8) == 0) goto L17;
        h r8 = r15.d;
    L19:
        if ((r20 & 16) == 0) goto L21;
        r3 = r15.e;
    L21:
        i r9 = r3;
        if ((r20 & 32) == 0) goto L24;
        boolean r10 = r15.f;
    L26:
        if ((r20 & 64) == 0) goto L28;
        int r11 = r15.g;
    L30:
        if ((r20 & 128) == 0) goto L32;
        boolean r12 = r15.h;
    L34:
        if ((r20 & 256) == 0) goto L36;
        long r1 = r15.i;
    L37:
        r15.getClass();
        Intrinsics.checkNotNullParameter(r5, "localId");
        Intrinsics.checkNotNullParameter(r7, "previousTaskItem");
        Intrinsics.checkNotNullParameter(r9, "inputDataSnapShot");
        return new f(r5, r6, r7, r8, r9, r10, r11, r12, r1);
    L36:
        r1 = 0;
        goto L37
    L32:
        r12 = r19;
        goto L34
    L28:
        r11 = r18;
        goto L30
    L24:
        r10 = r17;
        goto L26
    L17:
        r8 = null;
        goto L19
    L13:
        r7 = null;
        goto L15
    L9:
        r6 = r16;
        goto L11
    L5:
        r5 = null;
        goto L7
    }

    public f(String r2, List<CanvasBlock> r3, h r4, h r5, i r6, boolean r7, @ImageSaveStatus int r8, boolean r9, long r10) {
        Intrinsics.checkNotNullParameter(r2, "localId");
        Intrinsics.checkNotNullParameter(r4, "previousTaskItem");
        Intrinsics.checkNotNullParameter(r6, "inputDataSnapShot");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }
}
