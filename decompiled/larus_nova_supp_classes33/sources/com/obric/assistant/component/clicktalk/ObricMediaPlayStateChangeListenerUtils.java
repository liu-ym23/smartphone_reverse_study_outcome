package com.obric.assistant.component.clicktalk;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.mediaplay.IMediaPlayStateChangeListener;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001e\u0010\f\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/component/clicktalk/ObricMediaPlayStateChangeListenerUtils;", "Lcom/obric/assistant/spi/mediaplay/IMediaPlayStateChangeListener;", "<init>", "()V", "onMusicPlayStart", "", "hasHandledInterrupt", "Ljava/util/concurrent/atomic/AtomicBoolean;", "shouldInterruptTutor", "", "applicant", "Lcom/larus/media/audiofocus/AudioSessionScene;", "handleInterruptedTutor", "action", "Lkotlin/Function0;", "isReset", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricMediaPlayStateChangeListenerUtils implements IMediaPlayStateChangeListener {
    public final AtomicBoolean a;

    @Override // com.obric.assistant.spi.mediaplay.IMediaPlayStateChangeListener
    public final void b() {
        int r0 = com.obric.assistant.utils.e.a;
        Object r1 = com.obric.assistant.utils.e.a(Activity.class);
        if ((r1 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r2 = (FragmentActivity) r1;
    L6:
        if (r2 != null) goto L9;
        return;
    L9:
        if (com.obric.assistant.chat.p.e(r2) == false) goto L22;
        t1a.b r3 = com.obric.assistant.chat.p.a(r2);
        if (r3 == null) goto L13;
        maa.e r4 = (maa.e) r3.getAbility(maa.e.class);
    L14:
        FLogger r5 = FLogger.a;
        StringBuilder r6 = new StringBuilder("music start: host=");
        r6.append(r2.getClass().getSimpleName());
        r6.append(", hasClickTalk=");
        if (r4 == null) goto L17;
        boolean r7 = true;
    L18:
        r6.append(r7);
        r5.i("ObricMediaPlayStateChangeListener", r6.toString());
        if (r4 == null) goto L23;
        maa.e.a.a(r4, null, null, false, 7);
        return;
    L23:
        return;
    L17:
        r7 = false;
        goto L18
    L13:
        r4 = null;
        goto L14
    L22:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public ObricMediaPlayStateChangeListenerUtils() {
        this.a = new AtomicBoolean(false);
    }

    @Override // com.obric.assistant.spi.mediaplay.IMediaPlayStateChangeListener
    public final boolean a(lk9.g r3) {
        Intrinsics.checkNotNullParameter(r3, "applicant");
        if (Intrinsics.areEqual(r3.getScene(), "O_CALL") == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r3.getScene(), "o_asr") == true) goto L8;
        return false;
    }

    @Override // com.obric.assistant.spi.mediaplay.IMediaPlayStateChangeListener
    public final void c(Function0<Unit> r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "action");
        if (r4 == false) goto L7;
        this.a.set(false);
        return;
    L7:
        if (this.a.compareAndSet(false, true) == true) goto L9;
        return;
    L9:
        r3.invoke();
    }
}
