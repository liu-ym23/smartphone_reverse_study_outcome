package com.bytedance.forest.postprocessor;

import androidx.annotation.Keep;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.anniex.scene.core.i;
import com.bytedance.forest.model.w;
import com.bytedance.forest.utils.q;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b'\u0018\u0000  *\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0001!B\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\n\u0010\u000bJ1\u0010\u0014\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0018\u0010\u0011\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0010\u0012\u0004\u0012\u00020\t0\u000fH\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\u0006\u0010\u0016\u001a\u00020\u0015H$¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0015H\u0010¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\b\u001a\u00020\u00078\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\f\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001f¨\u0006\""}, d2 = {"Lcom/bytedance/forest/postprocessor/ForestPostProcessor;", "", ExifInterface.GPS_DIRECTION_TRUE, "", "allowOnMainThread", "<init>", "(Z)V", "Lcom/bytedance/forest/utils/e;", "context", "", "setContext$forest_release", "(Lcom/bytedance/forest/utils/e;)V", "setContext", "Lcom/bytedance/forest/model/w;", "response", "Lkotlin/Function1;", "Lcom/bytedance/forest/postprocessor/ProcessedData;", "callback", "process$forest_release", "(Lcom/bytedance/forest/model/w;Lkotlin/jvm/functions/Function1;)V", "process", "Lcom/bytedance/forest/postprocessor/f;", "data", "onProcess", "(Lcom/bytedance/forest/postprocessor/f;)Lcom/bytedance/forest/postprocessor/ProcessedData;", "onPostProcess$forest_release", "(Lcom/bytedance/forest/postprocessor/f;)V", "onPostProcess", "Lcom/bytedance/forest/utils/e;", "getContext", "()Lcom/bytedance/forest/utils/e;", "Z", "Companion", "com/bytedance/forest/postprocessor/c", "forest_release"}, k = 1, mv = {1, 4, 0})
public abstract class ForestPostProcessor<T> {
    public static final c Companion = null;
    private final boolean allowOnMainThread;
    protected com.bytedance.forest.utils.e context;

    static {
        Companion = new c();
    }

    public ForestPostProcessor() {
        boolean r5 = false;
        this(r5, 1, null);
    }

    public final com.bytedance.forest.utils.e getContext() {
        com.bytedance.forest.utils.e r5 = this.context;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("context");
    L5:
        return r5;
    }

    public void onPostProcess$forest_release(final f r10) {
        if (r10.g == false) goto L17;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L6
        ((InputStream) r10.f4551h.getValue()).close();     // Catch: Throwable -> L6
        Object r11 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L8:
        final Throwable r12 = Result.m127exceptionOrNullimpl(r11);
        if (r12 == null) goto L18;
        com.bytedance.forest.utils.e r13 = this.context;
        if (r13 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("context");
    L13:
        com.bytedance.forest.utils.d.c(r13.g, 6, "PostProcessor", null, null, new ForestPostProcessor$onPostProcess$$inlined$onFailure$lambda$1(r12, r10), 24);
        return;
    L18:
        return;
    L6:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r11 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public abstract ProcessedData<T> onProcess(f r5);

    public final void process$forest_release(w r5, Function1<? super ProcessedData<T>, Unit> r10) {
        int r11 = 5;
        i r12 = new i(this, r11, new f(r5), r10);
        if (this.allowOnMainThread == true) goto L6;
        q.a(r12);
        return;
    L6:
        r12.run();
    }

    public final void setContext(com.bytedance.forest.utils.e r5) {
        this.context = r5;
    }

    public final void setContext$forest_release(com.bytedance.forest.utils.e r5) {
        this.context = r5;
    }

    public ForestPostProcessor(boolean r5) {
        this.allowOnMainThread = r5;
    }

    public /* synthetic */ ForestPostProcessor(boolean r5, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        r5 = true;
    L5:
        this(r5);
    }
}
