package com.obric.memorydata.memory.ui.detail;

import android.content.Context;
import android.view.View;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/CustomLinkSetup;", "", "<init>", "()V", "TAG", "", "hasSetup", "Ljava/util/concurrent/atomic/AtomicBoolean;", "setup", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f10853a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f10854b = null;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u000b"}, d2 = {"com/obric/memorydata/memory/ui/detail/CustomLinkSetup$setup$1", "Lcom/larus/business/markdown/api/depend/LinkResolverWithStyle;", "needUnderline", "", "link", "", "enableLinkStyle", "resolve", "", "view", "Landroid/view/View;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements com.larus.business.markdown.api.depend.i {
        a() {
        }

        @Override // com.larus.business.markdown.api.depend.i
        public void a(View r1, String r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r1, "view");
            Intrinsics.checkNotNullParameter(r2, "link");
            resolve(r1, r2);
        }

        @Override // com.larus.business.markdown.api.depend.i
        public boolean a(String r1) {
            Intrinsics.checkNotNullParameter(r1, "link");
            return false;
        }

        @Override // com.larus.business.markdown.api.depend.i
        public boolean b(String r1) {
            Intrinsics.checkNotNullParameter(r1, "link");
            return false;
        }

        @Override // com.larus.business.markdown.api.depend.i, io.noties.markwon.d
        public void resolve(View r5, String r6) {
            Intrinsics.checkNotNullParameter(r5, "view");
            Intrinsics.checkNotNullParameter(r6, "link");
            String r7 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).toString();
            RunLog.INSTANCE.debug("CustomLinkSetup", "resolve link=" + r7);
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L16;
            return;
        L16:
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L10
            a r4 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            q r8 = q.f10871a;     // Catch: Throwable -> L10
            Context r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            Intrinsics.checkNotNullExpressionValue(r9, "getContext(...)");     // Catch: Throwable -> L10
            r8.a(r9, r7);     // Catch: Throwable -> L10
            Object r10 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
        L12:
            Throwable r11 = Result.m1424exceptionOrNullimpl(r10);
            if (r11 == null) goto L18;
            RunLog.INSTANCE.warn("CustomLinkSetup", "open failed link=" + r7, r11);
            return;
        L18:
            return;
        L10:
            th = move-exception;
            Result.Companion r12 = Result.Companion;
            r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L12
        L5:
            r0 = false;
            goto L6
        }
    }

    static {
        f10853a = new e();
        f10854b = new AtomicBoolean(false);
    }

    private e() {
    }

    public final void a() {
        com.larus.business.markdown.api.a r6 = com.larus.business.markdown.api.a.f5138a.d();
        if (r6 != null) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CustomLinkSetup", "setup skipped, MarkdownService is null", null, 4, null);
        return;
    L7:
        if (f10854b.compareAndSet(false, true) == true) goto L10;
        RunLog.INSTANCE.debug("CustomLinkSetup", "setup skipped, link resolver already registered");
        return;
    L10:
        r6.registerLinkResolver((com.larus.business.markdown.api.depend.i) ZeusTransformUtils.preCheckCast(new a(), com.larus.business.markdown.api.depend.i.class, "com.obric.memorydata.plugin"));
        RunLog.INSTANCE.debug("CustomLinkSetup", "setup success, link resolver registered");
    }
}
