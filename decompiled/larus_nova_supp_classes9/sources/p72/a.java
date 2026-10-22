package p72;

import com.bytedance.android.live.base.model.data.activityemoji.ActivityEmojiGroup;
import com.bytedance.android.live.base.model.data.activityemoji.EffectiveActivityEmojiGroup;
import com.bytedance.android.live.base.model.message.m;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.interactivity.api.comment.event.OpenInputSource;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements com.bytedance.android.livesdk.interactivity.api.emoji.d, l {
    public com.bytedance.android.live.base.model.message.l a;
    public com.bytedance.android.live.base.model.data.activityemoji.b b;
    public final vlc.d c;

    @Override // com.bytedance.android.livesdk.interactivity.api.emoji.d
    public final EffectiveActivityEmojiGroup a() {
        com.bytedance.android.live.base.model.message.l r0 = this.a;
        List r1 = null;
        if (r0 != null) goto L8;
        vlc.d r2 = this.c;
        if (r2 == null) goto L7;
        r0 = (com.bytedance.android.live.base.model.message.l) bc2.d.a(r2, "WebcastActivityEmojiGroupsMessage");
        goto L8
    L7:
        r0 = null;
    L8:
        if (r0 == null) goto L53;
        List r3 = r0.getActivityEmojiGroups();
        int r4 = 0;
        if (r3 != null) goto L12;
        EffectiveActivityEmojiGroup r5 = null;
    L27:
        if (r5 == null) goto L44;
        ActivityEmojiGroup r6 = r5.getEmojiGroup();
        if (r6 == null) goto L44;
        List r7 = r6.getActivityEmojiList();
        if (r7 == null) goto L44;
        if ((true ^ r7.isEmpty()) == false) goto L35;
        r1 = r7;
    L35:
        if (r1 == null) goto L44;
        int r8 = r1.size();
    L37:
        if (r4 >= r8) goto L44;
        com.bytedance.android.live.base.model.data.activityemoji.b r9 = (com.bytedance.android.live.base.model.data.activityemoji.b) ListProtector.get(r1, r4);
        ActivityEmojiGroup r10 = r5.getEmojiGroup();
        if (r10 == null) goto L41;
        long r11 = r10.getId();
    L42:
        r9.setActivityEmojiGroupId(r11);
        r4 = r4 + 1;
        goto L37
    L41:
        r11 = 0;
    L44:
        return r5;
    L12:
        long r13 = p6.b() / 1000;
        ArrayList r14 = new ArrayList();
        Iterator r15 = r3.iterator();
    L14:
        if (r15.hasNext() == false) goto L26;
        Object r16 = r15.next();
        EffectiveActivityEmojiGroup r17 = (EffectiveActivityEmojiGroup) r16;
        if (r17 == null) goto L23;
        long r18 = r17.getStartTime();
        long r19 = r17.getEndTime();
        if (r18 > r13) goto L23;
        if (r19 <= r13) goto L23;
        boolean r20 = true;
    L24:
        if (r20 == false) goto L14;
        r14.add(r16);
    L23:
        r20 = false;
        goto L24
    L26:
        r5 = (EffectiveActivityEmojiGroup) CollectionsKt.maxWithOrNull(r14, m.a);
        goto L27
    L53:
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.emoji.d
    public final com.bytedance.android.live.base.model.data.activityemoji.b b() {
        com.bytedance.android.live.base.model.data.activityemoji.b r0 = this.b;
        this.b = null;
        return r0;
    }

    public a(vlc.d r3) {
        this.c = r3;
        if (r3 == null) goto L5;
        com.bytedance.android.live.base.model.message.l r1 = (com.bytedance.android.live.base.model.message.l) bc2.d.a(r3, "WebcastActivityEmojiGroupsMessage");
    L6:
        this.a = r1;
        if (r3 == null) goto L10;
        r3.addMessageListener("WebcastActivityEmojiGroupsMessage", this);
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void onMessage(tlc.d r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if ((r2 instanceof com.bytedance.android.live.base.model.message.l) == false) goto L8;
        this.a = (com.bytedance.android.live.base.model.message.l) r2;
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.emoji.d
    public final void inputActivityEmoji(long r7, String r9, Map<String, String> r10) {
        EffectiveActivityEmojiGroup r11 = a();
        com.bytedance.android.live.base.model.data.activityemoji.b r1 = null;
        Object r2 = null;
        r1 = null;
        r1 = null;
        if (r11 == null) goto L18;
        ActivityEmojiGroup r13 = r11.getEmojiGroup();
        if (r13 == null) goto L18;
        List r14 = r13.getActivityEmojiList();
        if (r14 == null) goto L18;
        Iterator r15 = r14.iterator();
    L10:
        if (r15.hasNext() == false) goto L17;
        Object r3 = r15.next();
        if (((com.bytedance.android.live.base.model.data.activityemoji.b) r3).getId() != r7) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == false) goto L10;
        r2 = r3;
        goto L17
    L14:
        r4 = false;
    L17:
        r1 = (com.bytedance.android.live.base.model.data.activityemoji.b) r2;
    L18:
        if (r1 != null) goto L21;
        f2.c("活动已结束，该表情不可用", 0);
        return;
    L21:
        this.b = r1;
        xs2.b r8 = xs2.b.a();
        u22.m r16 = new u22.m();
        r16.l = OpenInputSource.InputActivityEmojiEvent;
        if (r9 == null) goto L24;
        r16.f = r9;
    L24:
        Unit r17 = Unit.INSTANCE;
        r8.post(r16);
    }
}
