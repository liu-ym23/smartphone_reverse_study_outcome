package com.obric.memorydata.memory.ui.list;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.core.content.ContextCompat;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/CalendarAppIconLoader;", "", "<init>", "()V", "SOURCE_PACKAGE_NAME", "", "APPLET_ID", "ICON_URI", "TAG", "load", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f11304a = null;

    static {
        f11304a = new e();
    }

    private e() {
    }

    public final Drawable a(Context r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "context");
        Object r1 = null;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L17
        e r10 = (e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        InputStream r13 = r12.getContentResolver().openInputStream(Uri.parse("content://com.obric.appletapp.SystemAppletProvider/applet_icon?packageName=com.flow.calendar"));     // Catch: Throwable -> L17
        if (r13 == null) goto L14;
        Closeable r14 = (Closeable) ZeusTransformUtils.preCheckCast(r13, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        Drawable r0 = Drawable.createFromStream((InputStream) ZeusTransformUtils.preCheckCast(r14, InputStream.class, "com.obric.memorydata.plugin"), "content://com.obric.appletapp.SystemAppletProvider/applet_icon?packageName=com.flow.calendar");     // Catch: Throwable -> L9
        CloseableKt.closeFinally(r14, null);     // Catch: Throwable -> L17
    L15:
        Object r15 = Result.m1421constructorimpl(r0);     // Catch: Throwable -> L17
    L19:
        Throwable r2 = Result.m1424exceptionOrNullimpl(r15);
        if (r2 == null) goto L23;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CalendarAppIconLoader", "load calendar icon uri failed: " + r2.getMessage(), null, 4, null);
    L23:
        if (Result.m1427isFailureimpl(r15) == true) goto L26;
        r1 = r15;
    L26:
        Drawable r16 = (Drawable) ZeusTransformUtils.preCheckCast(r1, Drawable.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L29;
        return r16;
    L29:
        return ContextCompat.getDrawable(r12, ZeusTransformUtils.mapRes(R.drawable.ic_island_calendar, "drawable", "ic_island_calendar"));
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        CloseableKt.closeFinally(r14, th);     // Catch: Throwable -> L17
        throw th;     // Catch: Throwable -> L17
    L14:
        r0 = null;
    L17:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r15 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L19
    }
}
