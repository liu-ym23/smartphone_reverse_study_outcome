package hf;

import com.bytedance.android.anniex.scene.core.i;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.n;
import com.bytedance.iesgurd.meta.PrepareMeta;
import com.bytedance.iesgurd.meta.h;
import com.bytedance.iesgurd.update.ErrorCode;
import com.bytedance.iesgurd.update.UpdateException;
import com.lynx.tasm.ui.image.v;
import java.io.File;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PrepareMeta f17319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f17320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public File f17321c;
    public pa.a d;
    public long e;
    public final n f;

    public g(n r5) {
        this.f = r5;
    }

    public final void a() {
        PrepareMeta r5 = this.f17319a;     // Catch: Throwable -> L6 UpdateException -> L8
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("meta");     // Catch: Throwable -> L6 UpdateException -> L8
    L10:
        new c(r5, this.f).d();     // Catch: Throwable -> L6 UpdateException -> L8
        PrepareMeta r10 = this.f17319a;
        if (r10 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L14:
        la.a r11 = r10.getUpdateBuffer();
        if (r11 == null) goto L17;
        r11.release();
    L17:
        StringBuilder r12 = new StringBuilder("[");
        PrepareMeta r13 = this.f17319a;
        if (r13 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L20:
        r12.append(r13);
        r12.append("]update success");
        GeckoLogger.a(r12.toString());
        long r14 = System.currentTimeMillis();
        h r15 = this.f17320b;
        if (r15 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("model");
    L23:
        r15.f6656a = true;
        h r16 = this.f17320b;
        if (r16 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("model");
    L26:
        r16.f6657b = r14 - this.e;
        h r17 = this.f17320b;
        if (r17 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("model");
    L29:
        PrepareMeta r18 = this.f17319a;
        if (r18 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L32:
        com.bytedance.iesgurd.meta.g r19 = r17.a(r18.getUpdateWithPatch());
        r19.f6653a = true;
        h r20 = this.f17320b;
        if (r20 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("model");
    L35:
        r20.f6658c = r14 - r19.f;
        PrepareMeta r21 = this.f17319a;
        if (r21 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L38:
        r21.upload();
        PrepareMeta r22 = this.f17319a;
        if (r22 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L41:
        ((Executor) com.bytedance.geckox.utils.c.e.getValue()).execute(new v(9, this, false, r22));
        return;
    L50:
        th = move-exception;
        PrepareMeta r23 = this.f17319a;
        if (r23 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L63:
        la.a r24 = r23.getUpdateBuffer();
        if (r24 == null) goto L66;
        r24.release();
    L66:
        throw th;
    L8:
        e = move-exception;
        c(e);     // Catch: Throwable -> L50
        PrepareMeta r25 = this.f17319a;
        if (r25 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L56:
        la.a r26 = r25.getUpdateBuffer();
        if (r26 == null) goto L70;
    L58:
        r26.release();
        return;
    L70:
        return;
    L6:
        th = move-exception;
        c(new UpdateException(ErrorCode.f6701b, "unexpected exception: " + th.getStackTrace()));     // Catch: Throwable -> L50
        PrepareMeta r27 = this.f17319a;
        if (r27 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L47:
        r26 = r27.getUpdateBuffer();
        if (r26 != null) goto L58;
    }

    public final void b(PrepareMeta r5, String r10) {
        GeckoLogger.b("[" + r5 + "]update failed: " + r10);
        ((Executor) com.bytedance.geckox.utils.c.e.getValue()).execute(new i(this, 20, r10, r5));
    }

    public final void c(UpdateException r10) {
        h r5 = this.f17320b;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("model");
    L5:
        PrepareMeta r11 = this.f17319a;
        if (r11 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L8:
        com.bytedance.iesgurd.meta.g r12 = r5.a(r11.getUpdateWithPatch());
        r12.f6653a = false;
        r12.f6654b = r10.f6712a;
        r12.f6655c = r10.getMessage();
        PrepareMeta r13 = this.f17319a;
        if (r13 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L12:
        if (r13.getUpdateWithPatch() == false) goto L21;
        StringBuilder r14 = new StringBuilder("[");
        PrepareMeta r15 = this.f17319a;
        if (r15 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L16:
        r14.append(r15);
        r14.append("]update failed, fallback to full: ");
        r14.append(r10.getMessage());
        GeckoLogger.a(r14.toString());
        PrepareMeta r16 = this.f17319a;
        if (r16 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L19:
        r16.setUpdateWithPatch(false);
        a();
        return;
    L21:
        h r17 = this.f17320b;
        if (r17 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("model");
    L24:
        r17.d = 0;
        r17.f = 0;
        r17.g = 0;
        r17.f6659h = 0;
        r17.f6660i = 0;
        r17.f6661j = 0;
        h r18 = this.f17320b;
        if (r18 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("model");
    L27:
        r18.f6656a = false;
        PrepareMeta r19 = this.f17319a;
        if (r19 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L30:
        r19.upload();
        PrepareMeta r20 = this.f17319a;
        if (r20 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("meta");
    L33:
        String r21 = r10.getMessage();
        if (r21 != null) goto L36;
        Intrinsics.throwNpe();
    L36:
        b(r20, r21);
    }
}
