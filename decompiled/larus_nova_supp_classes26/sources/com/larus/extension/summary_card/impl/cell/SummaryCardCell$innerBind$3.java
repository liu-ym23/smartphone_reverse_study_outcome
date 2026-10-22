package com.larus.extension.summary_card.impl.cell;

import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class SummaryCardCell$innerBind$3 extends FunctionReferenceImpl implements Function2<String, Boolean, Unit> {
    public SummaryCardCell$innerBind$3(Object r8) {
        super(2, r8, SummaryCardCell.class, "onVideoSummaryClick", "onVideoSummaryClick(Ljava/lang/String;Z)V", 0);
    }

    public final void invoke(String r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "p0");
        SummaryCardCell r0 = (SummaryCardCell) ((CallableReference) this).receiver;
        int r1 = SummaryCardCell.k;
        r0.getClass();
        JSONObject r2 = new JSONObject();
        r2.put("button_type", r6);     // Catch: JSONException -> L41
        z r8 = (z) ((BaseMessageListCell) r0).d;     // Catch: JSONException -> L41
        String r3 = null;
        if (r8 == null) goto L10;
        Message r9 = r8.e;     // Catch: JSONException -> L41
        if (r9 == null) goto L10;
        String r10 = m99.a.c(r9);     // Catch: JSONException -> L41
        if (r10 == null) goto L10;
        Integer r11 = StringsKt.toIntOrNull(r10);     // Catch: JSONException -> L41
    L11:
        int r4 = 0;
        if (r11 == null) goto L14;
        int r12 = r11.intValue();     // Catch: JSONException -> L41
    L15:
        r2.put("model_source", r12);     // Catch: JSONException -> L41
        z r13 = (z) ((BaseMessageListCell) r0).d;     // Catch: JSONException -> L41
        if (r13 == null) goto L20;
        Message r14 = r13.e;     // Catch: JSONException -> L41
        if (r14 == null) goto L20;
        String r15 = r14.getMessageId();     // Catch: JSONException -> L41
    L22:
        if (r15 != null) goto L24;
    L27:
        boolean r16 = true;
    L28:
        if (r16 == false) goto L39;
        z r17 = (z) ((BaseMessageListCell) r0).d;     // Catch: JSONException -> L41
        if (r17 == null) goto L37;
        Message r18 = r17.e;     // Catch: JSONException -> L41
        if (r18 == null) goto L37;
        Map r19 = r18.getBusinessExt();     // Catch: JSONException -> L41
        if (r19 == null) goto L37;
        r3 = (String) r19.get("feed_is_place_holder");     // Catch: JSONException -> L41
    L37:
        if (Intrinsics.areEqual(r3, "1") == false) goto L39;
        r4 = 1;
    L39:
        r2.put("is_placeholder", r4);     // Catch: JSONException -> L41
    L43:
        TrackParams r20 = new TrackParams().merge(r2);
        by7.a r5 = new by7.a("flow_click_video_summary_button");
        if (lf8.a.d(r0) != null) goto L46;
    L48:
        r5.a.merge(r20);
        r5.b();
        if (r7 == false) goto L58;
        z r21 = (z) ((BaseMessageListCell) r0).d;
        if (r21 == null) goto L59;
        Message r22 = ((xc8.b) r21).a;
        if (r22 == null) goto L60;
        r0.r(r22);
        return;
    L60:
        return;
    L59:
        return;
    L58:
        return;
    L46:
        if ((lf8.a.d(r0) instanceof by7.e) == false) goto L48;
        by7.e r23 = lf8.a.d(r0);
        Intrinsics.checkNotNull(r23, "null cannot be cast to non-null type com.ixigua.lib.track.ITrackNode");
        r5.b = r23;
        goto L48
    L24:
        if (r15.length() == 0) goto L27;
        r16 = false;
    L20:
        r15 = null;
        goto L22
    L14:
        r12 = 0;
    L10:
        r11 = null;
    L41:
        e = move-exception;
        FLogger.a.e("SummaryCardCell", "onVideoSummaryClick error in  " + e.getLocalizedMessage());
        goto L43
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((String) r1, ((Boolean) r2).booleanValue());
        return Unit.INSTANCE;
    }
}
