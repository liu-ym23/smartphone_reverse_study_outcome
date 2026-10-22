package com.obric.assistant.card.layout.viewholder;

import android.view.ViewGroup;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.layout.bean.MessageExtraForViewHolder;
import com.obric.assistant.card.layout.viewholder.style.AbsCardItemClockStyle;
import com.obric.capabilitykit.entity.app.AlarmEntity;
import com.obric.capabilitykit.entity.app.AppEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0011H\u0002¨\u0006\u0014"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/AlarmClockViewHolder;", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemClockStyle;", "Lcom/obric/capabilitykit/entity/app/AlarmEntity;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemClockStyle$StyleData;", "messageExtra", "Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;", "entity", "position", NameKeys.UnloadStrategy_No_Strategy, "formatDate", NameKeys.UnloadStrategy_No_Strategy, "repeatDayOfWeek", NameKeys.UnloadStrategy_No_Strategy, "generateRepeatDesc", "Companion", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AlarmClockViewHolder extends AbsCardItemClockStyle<AlarmEntity> {

    public static final class a {
    }

    static {
    }

    public AlarmClockViewHolder(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        super(r2);
    }

    @Override // com.obric.assistant.card.layout.viewholder.style.AbsCardItemClockStyle
    public final AbsCardItemClockStyle.a a4(MessageExtraForViewHolder r21, AppEntity r22) {
        AlarmEntity r1 = (AlarmEntity) r22;
        Intrinsics.checkNotNullParameter(r21, "messageExtra");
        Intrinsics.checkNotNullParameter(r1, "entity");
        FLogger r2 = FLogger.a;
        r2.i("AlarmClockViewHolder", "startTime = " + r1.getStartTime() + ", date = " + r1.getDate() + ", repeatType = " + r1.getRepeatType() + ", repeatDayOfWeek = " + r1.getRepeatDayOfWeek() + ", intentName = " + r21.d);
        String r0 = r1.getName();
        boolean r5 = false;
        if (r0.length() != 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L8;
        r0 = getContext().getString(2131911953);
    L8:
        String r10 = r0;
        Integer r3 = r1.getRepeatType();
        if (r3 != null) goto L12;
    L14:
        if (r3 != null) goto L17;
    L19:
        if (r3 != null) goto L22;
    L24:
        if (r3 != null) goto L27;
    L29:
        List r6 = r1.getRepeatDayOfWeek();
        if (r6 != null) goto L32;
    L34:
        boolean r7 = false;
    L35:
        if (r7 == false) goto L37;
        r2.w("AlarmClockViewHolder", "formatDate failed: dateString is empty");
    L43:
        String r8 = NameKeys.UnloadStrategy_No_Strategy;
    L44:
        String r11 = r8;
        int r9 = lca.a.d;
        return new AbsCardItemClockStyle.a(lca.a.C0099a.a(2131244438), r1.getStartTime(), r10, r11, r1.isEnabled());
    L37:
        List r12 = r6;
        if (r12 != null) goto L40;
    L41:
        r5 = true;
    L42:
        if (r5 == true) goto L43;
        String[] r13 = getContext().getResources().getStringArray(2130903072);
        List r14 = CollectionsKt.sorted(r6);
        ArrayList r15 = new ArrayList();
        Iterator r16 = r14.iterator();
    L47:
        if (r16.hasNext() == false) goto L51;
        String r17 = (String) ArraysKt.getOrNull(r13, ((Number) r16.next()).intValue() - 1);
        if (r17 == null) goto L47;
        r15.add(r17);
        goto L47
    L51:
        r8 = CollectionsKt.joinToString$default(r15, ", ", null, null, 0, null, null, 62, null);
        goto L44
    L40:
        if (r12.isEmpty() == false) goto L42;
    L32:
        if (r6.isEmpty() != true) goto L34;
        r7 = true;
        goto L35
    L27:
        if (r3.intValue() != 3) goto L29;
        r8 = getContext().getString(2131912380);
        goto L44
    L22:
        if (r3.intValue() != 2) goto L24;
        r8 = getContext().getString(2131912200);
        goto L44
    L17:
        if (r3.intValue() != 1) goto L19;
        r8 = getContext().getString(2131912106);
        goto L44
    L12:
        if (r3.intValue() != 0) goto L14;
    L5:
        r4 = false;
        goto L6
    }
}
