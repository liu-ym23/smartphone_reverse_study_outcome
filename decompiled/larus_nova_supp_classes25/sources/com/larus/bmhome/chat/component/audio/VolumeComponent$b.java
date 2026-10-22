package com.larus.bmhome.chat.component.audio;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.audio.AudioServiceDelegate;
import com.larus.bmhome.audio.VolumeChangedObserver;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.layout.holder.helper.s;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.a;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class VolumeComponent$b implements VolumeChangedObserver.b {
    public final /* synthetic */ VolumeComponent a;

    public VolumeComponent$b(VolumeComponent r1) {
        this.a = r1;
    }

    @Override // com.larus.bmhome.audio.VolumeChangedObserver.b
    public final void onVolumeChanged(int r12, int r13) {
        u7 r0 = (u7) this.a.i.getValue();
        if (r0 == null) goto L73;
        List r1 = r0.zj();
        if (r1 == null) goto L74;
        Iterator r2 = r1.iterator();
    L7:
        boolean r3 = true;
        if (r2.hasNext() == false) goto L18;
        Object r4 = r2.next();
        Integer r5 = b0.c((Message) r4);
        if (r5 != null) goto L13;
    L14:
        boolean r6 = true;
    L16:
        if (r6 == false) goto L7;
    L19:
        Message r7 = (Message) r4;
        if (r7 != null) goto L22;
        return;
    L22:
        if (a.E0(r7) == false) goto L44;
        List r8 = s.a(r7);
        if (r8 == null) goto L43;
        Message r9 = (Message) CollectionsKt.firstOrNull(r8);
        if (r9 == null) goto L71;
        String r10 = r9.getMessageId();
        if (r10 != null) goto L30;
    L32:
        boolean r11 = false;
    L33:
        if (r11 == false) goto L35;
    L37:
        boolean r14 = false;
    L38:
        if (r14 == true) goto L41;
        r9 = null;
    L41:
        if (r9 != null) goto L46;
        return;
    L46:
        if (com.larus.bmhome.chat.bean.d.Q0(r7) == false) goto L76;
        if (r13 != 0) goto L77;
        if (r12 <= 0) goto L78;
        RepoDispatcher.a.getClass();
        if (Intrinsics.areEqual(RepoDispatcher.d.d.d.o6(), r9.getMessageId()) == false) goto L52;
        return;
    L52:
        if (AudioServiceDelegate.a.i0().a() == true) goto L80;
        y r15 = (y) this.a.j.getValue();
        if (r15 == null) goto L60;
        wc9.e r16 = r15.h();
        if (r16 == null) goto L60;
        if (r16.i != true) goto L60;
    L61:
        if (r3 == true) goto L63;
        return;
    L63:
        if (com.larus.bmhome.chat.bean.d.w0(r9) == false) goto L82;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(s1a.a.c(this.a)), null, null, new VolumeComponent$volumeListener$2$1$onVolumeChanged$1(r9, null), 3, null);
        return;
    L82:
        return;
    L60:
        r3 = false;
        goto L61
    L80:
        return;
    L78:
        return;
    L77:
        return;
    L76:
        return;
    L35:
        if (a.r0(r9) == true) goto L37;
        r14 = true;
        goto L38
    L30:
        if (StringsKt.contains$default(r10, "#", false, 2, null) != true) goto L32;
        r11 = true;
        goto L33
    L71:
        return;
    L43:
        return;
    L44:
        r9 = r7;
        goto L46
    L13:
        if (r5.intValue() != 14) goto L14;
        r6 = false;
        goto L16
    L18:
        r4 = null;
        goto L19
    L74:
        return;
    }
}
