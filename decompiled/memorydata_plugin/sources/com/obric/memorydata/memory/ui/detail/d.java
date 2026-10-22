package com.obric.memorydata.memory.ui.detail;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.larus.business.markdown.impl.markwon.MarkdownTextView;
import com.obric.capabilitykit.entity.memory.CollectContentMemoryEntity;
import com.obric.capabilitykit.entity.memory.CollectStoreMemoryEntity;
import com.obric.capabilitykit.entity.memory.CommonTextMemoryEntity;
import com.obric.capabilitykit.entity.memory.EventScheduleMemoryEntity;
import com.obric.capabilitykit.entity.memory.EventTodoMemoryEntity;
import com.obric.capabilitykit.entity.memory.InfoAddressMemoryEntity;
import com.obric.capabilitykit.entity.memory.InfoAnniversaryMemoryEntity;
import com.obric.capabilitykit.entity.memory.InfoCommonMemoryEntity;
import com.obric.capabilitykit.entity.memory.InfoDocumentsMemoryEntity;
import com.obric.capabilitykit.entity.memory.InfoRelationshipMemoryEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderCommonMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderFlightMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderHotelMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderMovieTicketMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderTicketMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderTrainMemoryEntity;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.memory.databinding.ItemMemoryDetailBinding;
import com.obric.memorydata.memory.ui.list.FlowLayout;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.utils.at;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0011H\u0002¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/CommonDetailCardViewHolder;", "Lcom/obric/memorydata/memory/ui/detail/MemoryDetailSourceViewHolder;", "binding", "Lcom/obric/memorydata/memory/databinding/ItemMemoryDetailBinding;", "<init>", "(Lcom/obric/memorydata/memory/databinding/ItemMemoryDetailBinding;)V", "bind", "", "memoryItem", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "bindMemoryObservationEntity", "Lcom/obric/memorydata/memory/ui/data/MemoryItem$ObservationEntity;", "getTitle", "", "entity", "Lcom/obric/memorydata/database/entity/EpisodicMemoryEntity;", "bindMemoryDetailEntity", "Lcom/obric/memorydata/memory/ui/data/MemoryItem$DetailEntity;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d extends w {
    public d(ItemMemoryDetailBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        super(r2);
    }

    private final String a(EpisodicMemoryEntity r8) {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r8.getTitle(), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r7 = true;
    L6:
        if (r7 == true) goto L8;
        if (r8 == null) goto L12;
        String r9 = r8.getContent();
        if (r9 == null) goto L12;
    L13:
        int r10 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), "\n- ", 0, false, 6, null);
        if (r10 == (-1)) goto L17;
        String r11 = r9.substring(0, r10);
        Intrinsics.checkNotNullExpressionValue(r11, "substring(...)");
        return r11;
    L17:
        return r9;
    L12:
        r9 = "";
        goto L13
    L8:
        return r8.getTitle();
    L5:
        r7 = false;
        goto L6
    }

    private final void a(com.obric.memorydata.memory.ui.data.a.e r58) {
        MemoryEntity r0 = r58.b();
        com.obric.memorydata.memory.ui.h r1 = com.obric.memorydata.memory.ui.i.f10968a.a(r0.getProductType());
        String r2 = com.obric.memorydata.memory.ui.f.f10920a.a(r0);
        StringBuilder r3 = new StringBuilder();
        StringBuilder r4 = new StringBuilder();
        com.obric.memorydata.memory.utils.f r5 = com.obric.memorydata.memory.utils.f.f11537a;
        LocalDate r6 = Instant.ofEpochMilli(r0.getLastModifiedTime()).atZone(ZoneId.systemDefault()).toLocalDate();
        Intrinsics.checkNotNullExpressionValue(r6, "toLocalDate(...)");
        r4.append(r5.a(r6, true));
        r4.append(" ");
        r4.append(com.obric.memorydata.memory.utils.f.f11537a.a(r0.getLastModifiedTime(), false));
        String r7 = r4.toString();
        Intrinsics.checkNotNullExpressionValue(r7, "toString(...)");
        if (ZeusTransformUtils.instanceOf(r0, OrderFlightMemoryEntity.class) == false) goto L51;
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(((OrderFlightMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderFlightMemoryEntity.class, "com.obric.memorydata.plugin")).getDepartureAirport(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L7;
    L10:
        boolean r9 = true;
    L11:
        if (r9 == true) goto L21;
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(((OrderFlightMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderFlightMemoryEntity.class, "com.obric.memorydata.plugin")).getLandingAirport(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L15;
    L18:
        boolean r11 = true;
    L19:
        if (r11 == true) goto L21;
        r3.append(((OrderFlightMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderFlightMemoryEntity.class, "com.obric.memorydata.plugin")).getDepartureAirport() + " - " + ((OrderFlightMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderFlightMemoryEntity.class, "com.obric.memorydata.plugin")).getLandingAirport() + '\n');
        goto L21
    L15:
        if (r10.length() == 0) goto L18;
        r11 = false;
    L21:
        String r12 = v.f10881a.a((OrderFlightMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderFlightMemoryEntity.class, "com.obric.memorydata.plugin"));
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L24;
        boolean r13 = true;
    L25:
        if (r13 == false) goto L27;
        r3.append(r12).append("\n");
    L27:
        Unit r14 = Unit.INSTANCE;
        List r15 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(((OrderFlightMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderFlightMemoryEntity.class, "com.obric.memorydata.plugin")).getFlightNumber(), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L30;
        boolean r16 = true;
    L31:
        if (r16 == false) goto L33;
        r15.add(((OrderFlightMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderFlightMemoryEntity.class, "com.obric.memorydata.plugin")).getFlightNumber());
    L33:
        String r17 = ((OrderFlightMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderFlightMemoryEntity.class, "com.obric.memorydata.plugin")).getBoardingGate();
        if (r17 == null) goto L36;
        r15.add(r17);
    L36:
        List<String> r18 = ((OrderFlightMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderFlightMemoryEntity.class, "com.obric.memorydata.plugin")).getSeatNumber();
        if (r18 == null) goto L48;
        Iterator<String> r19 = r18.iterator();
    L40:
        if (r19.hasNext() == false) goto L48;
        String r20 = (String) ZeusTransformUtils.preCheckCast(r19.next(), String.class, "com.obric.memorydata.plugin");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r20, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L44;
        boolean r110 = true;
    L45:
        if (r110 == false) goto L40;
        r15.add(r20);
        goto L40
    L44:
        r110 = false;
    L48:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L297;
    L49:
        String r21 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" · ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
    L217:
        r3.append(r21);
    L297:
        RunLog.INSTANCE.debug("MemoryDetailItemViewHolder", "title " + r2 + " summary: " + r3);
        TextView r22 = ((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).memoryContent.titleText;
        Intrinsics.checkNotNull(r22);
        com.larus.business.markdown.api.model.h r23 = null;
        com.obric.memorydata.memory.ui.m.a(r22, null, 1, null);
        r22.setText((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"));
        String r24 = r3.toString();
        Intrinsics.checkNotNullExpressionValue(r24, "toString(...)");
        String r25 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r24, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        ((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).memoryContent.summaryText.setLineHeight(2, 22.0f);
        com.larus.business.markdown.api.a r111 = com.obric.memorydata.markdown.a.f9973a.b();
        if (r111 == null) goto L300;
        Context r26 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).getRoot().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r26, "getContext(...)");
        r23 = com.larus.business.markdown.api.a.b.a(r111, r26, 0, r25, true, new com.larus.business.markdown.api.model.c(0, null, null, null, false, false, null, 0, 0, null, 0.0f, null, 0, 0, null, Integer.valueOf(MathKt.roundToInt(TypedValue.applyDimension(2, 12, Resources.getSystem().getDisplayMetrics()))), Integer.valueOf(MathKt.roundToInt(TypedValue.applyDimension(2, 4, Resources.getSystem().getDisplayMetrics()))), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -98305, null), null, null, null, 224, null);
    L300:
        ((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).memoryContent.summaryText.setMarkdown(r23);
        MarkdownTextView r27 = ((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).memoryContent.summaryText;
        Intrinsics.checkNotNullExpressionValue(r27, "summaryText");
        y.a((TextView) ZeusTransformUtils.preCheckCast(r27, TextView.class, "com.obric.memorydata.plugin"));
        ((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).memoryContent.summaryTextTip.setVisibility(8);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r25, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L303;
        boolean r28 = true;
    L304:
        if (r28 == false) goto L306;
        MarkdownTextView r29 = ((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).memoryContent.summaryText;
        Intrinsics.checkNotNullExpressionValue(r29, "summaryText");
        View r30 = (View) ZeusTransformUtils.preCheckCast(r29, View.class, "com.obric.memorydata.plugin");
        boolean r31 = true;
    L307:
        com.obric.oui.common.util.o.a(r30, r31);
        LinearLayout r32 = ((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).memoryContent.bottomSourceContainer;
        Intrinsics.checkNotNullExpressionValue(r32, "bottomSourceContainer");
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(r32, View.class, "com.obric.memorydata.plugin"), true);
        AppCompatImageView r33 = ((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).memoryContent.memorySourceIcon;
        Intrinsics.checkNotNullExpressionValue(r33, "memorySourceIcon");
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(r33, View.class, "com.obric.memorydata.plugin"), true);
        ((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).memoryContent.memorySourceIcon.setImageResource(r1.b());
        TextView r34 = ((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).memoryContent.memoryTimeTv;
        Intrinsics.checkNotNullExpressionValue(r34, "memoryTimeTv");
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(r34, View.class, "com.obric.memorydata.plugin"), false);
        TextView r35 = ((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).memoryContent.memorySourceTv;
        String r36 = at.a(r1.a()) + " · " + r7;
        Intrinsics.checkNotNullExpressionValue(r36, "toString(...)");
        r35.setText((CharSequence) ZeusTransformUtils.preCheckCast(r36, CharSequence.class, "com.obric.memorydata.plugin"));
        Unit r37 = Unit.INSTANCE;
        return;
    L306:
        MarkdownTextView r38 = ((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).memoryContent.summaryText;
        Intrinsics.checkNotNullExpressionValue(r38, "summaryText");
        r30 = (View) ZeusTransformUtils.preCheckCast(r38, View.class, "com.obric.memorydata.plugin");
        r31 = false;
        goto L307
    L303:
        r28 = false;
        goto L304
    L30:
        r16 = false;
        goto L31
    L24:
        r13 = false;
        goto L25
    L7:
        if (r8.length() == 0) goto L10;
        r9 = false;
        goto L11
    L51:
        if (ZeusTransformUtils.instanceOf(r0, OrderTrainMemoryEntity.class) == false) goto L112;
        CharSequence r39 = (CharSequence) ZeusTransformUtils.preCheckCast(((OrderTrainMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderTrainMemoryEntity.class, "com.obric.memorydata.plugin")).getDepartureStation(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r39 != null) goto L55;
    L58:
        boolean r40 = true;
    L59:
        if (r40 == true) goto L69;
        CharSequence r41 = (CharSequence) ZeusTransformUtils.preCheckCast(((OrderTrainMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderTrainMemoryEntity.class, "com.obric.memorydata.plugin")).getArrivalStation(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r41 != null) goto L63;
    L66:
        boolean r42 = true;
    L67:
        if (r42 == true) goto L69;
        r3.append(((OrderTrainMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderTrainMemoryEntity.class, "com.obric.memorydata.plugin")).getDepartureStation() + " - " + ((OrderTrainMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderTrainMemoryEntity.class, "com.obric.memorydata.plugin")).getArrivalStation() + '\n');
        goto L69
    L63:
        if (r41.length() == 0) goto L66;
        r42 = false;
    L69:
        String r43 = v.f10881a.a((OrderTrainMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderTrainMemoryEntity.class, "com.obric.memorydata.plugin"));
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r43, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L72;
        boolean r44 = true;
    L73:
        if (r44 == false) goto L75;
        r3.append(r43).append("\n");
    L75:
        Unit r45 = Unit.INSTANCE;
        r15 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(((OrderTrainMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderTrainMemoryEntity.class, "com.obric.memorydata.plugin")).getTrainNumber(), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L78;
        boolean r46 = true;
    L79:
        if (r46 == false) goto L81;
        r15.add(((OrderTrainMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderTrainMemoryEntity.class, "com.obric.memorydata.plugin")).getTrainNumber());
    L81:
        List<String> r47 = ((OrderTrainMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderTrainMemoryEntity.class, "com.obric.memorydata.plugin")).getSeatNumber();
        if (r47 != null) goto L84;
        r47 = CollectionsKt.emptyList();
    L84:
        List<String> r48 = ((OrderTrainMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderTrainMemoryEntity.class, "com.obric.memorydata.plugin")).getPassengerName();
        if (r48 != null) goto L87;
        r48 = CollectionsKt.emptyList();
    L87:
        int r112 = Math.max(r47.size(), r48.size());
        int r113 = 0;
    L88:
        if (r113 >= r112) goto L109;
        String r114 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r47, r113), String.class, "com.obric.memorydata.plugin");
        String r49 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r48, r113), String.class, "com.obric.memorydata.plugin");
        CharSequence r115 = (CharSequence) ZeusTransformUtils.preCheckCast(r114, CharSequence.class, "com.obric.memorydata.plugin");
        if (r115 != null) goto L92;
    L95:
        boolean r116 = true;
    L96:
        if (r116 == true) goto L98;
        r15.add(r114);
    L98:
        CharSequence r117 = (CharSequence) ZeusTransformUtils.preCheckCast(r49, CharSequence.class, "com.obric.memorydata.plugin");
        if (r117 != null) goto L101;
    L104:
        boolean r118 = true;
    L105:
        if (r118 == true) goto L107;
        r15.add(r49);
    L107:
        r113 = r113 + 1;
        goto L88
    L101:
        if (r117.length() == 0) goto L104;
        r118 = false;
        goto L105
    L92:
        if (r115.length() == 0) goto L95;
        r116 = false;
        goto L96
    L109:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L297;
    L78:
        r46 = false;
        goto L79
    L72:
        r44 = false;
        goto L73
    L55:
        if (r39.length() == 0) goto L58;
        r40 = false;
        goto L59
    L112:
        if (ZeusTransformUtils.instanceOf(r0, OrderHotelMemoryEntity.class) == false) goto L129;
        String r50 = v.f10881a.a((OrderHotelMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderHotelMemoryEntity.class, "com.obric.memorydata.plugin"));
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r50, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L116;
        boolean r51 = true;
    L117:
        if (r51 == false) goto L119;
        r3.append(r50).append("\n");
    L119:
        Unit r52 = Unit.INSTANCE;
        CharSequence r53 = (CharSequence) ZeusTransformUtils.preCheckCast(((OrderHotelMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderHotelMemoryEntity.class, "com.obric.memorydata.plugin")).getHotelAddress(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r53 != null) goto L122;
    L125:
        boolean r54 = true;
    L126:
        if (r54 == true) goto L297;
        r21 = ((OrderHotelMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderHotelMemoryEntity.class, "com.obric.memorydata.plugin")).getHotelAddress();
        goto L217
    L122:
        if (r53.length() == 0) goto L125;
        r54 = false;
        goto L126
    L116:
        r51 = false;
        goto L117
    L129:
        if (ZeusTransformUtils.instanceOf(r0, OrderMovieTicketMemoryEntity.class) == false) goto L172;
        List r55 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        String r56 = ((OrderMovieTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderMovieTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getMovieHallNumber();
        if (r56 == null) goto L133;
        r55.add(r56);
    L133:
        List<String> r57 = ((OrderMovieTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderMovieTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getSeatNumber();
        if (r57 == null) goto L145;
        Iterator<String> r59 = r57.iterator();
    L137:
        if (r59.hasNext() == false) goto L145;
        String r60 = (String) ZeusTransformUtils.preCheckCast(r59.next(), String.class, "com.obric.memorydata.plugin");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r60, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L141;
        boolean r119 = true;
    L142:
        if (r119 == false) goto L137;
        r55.add(r60);
        goto L137
    L141:
        r119 = false;
    L145:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r55, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L147;
        r3.append(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r55, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" · ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null)).append("\n");
    L147:
        String r61 = v.f10881a.a((OrderMovieTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderMovieTicketMemoryEntity.class, "com.obric.memorydata.plugin"));
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r61, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L150;
        boolean r62 = true;
    L151:
        if (r62 == false) goto L153;
        r3.append(r61).append("\n");
    L153:
        CharSequence r63 = (CharSequence) ZeusTransformUtils.preCheckCast(((OrderMovieTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderMovieTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getMovieTheaterName(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r63 != null) goto L156;
    L159:
        boolean r64 = true;
    L160:
        if (r64 == true) goto L162;
        r3.append(((OrderMovieTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderMovieTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getMovieTheaterName()).append("\n");
    L162:
        CharSequence r65 = (CharSequence) ZeusTransformUtils.preCheckCast(((OrderMovieTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderMovieTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getMovieTheaterAddress(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r65 != null) goto L165;
    L168:
        boolean r66 = true;
    L169:
        if (r66 == true) goto L297;
        r21 = ((OrderMovieTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderMovieTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getMovieTheaterAddress();
        goto L217
    L165:
        if (r65.length() == 0) goto L168;
        r66 = false;
        goto L169
    L156:
        if (r63.length() == 0) goto L159;
        r64 = false;
        goto L160
    L150:
        r62 = false;
        goto L151
    L172:
        if (ZeusTransformUtils.instanceOf(r0, OrderTicketMemoryEntity.class) == false) goto L215;
        List r67 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        String r68 = ((OrderTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getHallNumber();
        if (r68 == null) goto L176;
        r67.add(r68);
    L176:
        List<String> r69 = ((OrderTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getSeatNumber();
        if (r69 == null) goto L188;
        Iterator<String> r70 = r69.iterator();
    L180:
        if (r70.hasNext() == false) goto L188;
        String r71 = (String) ZeusTransformUtils.preCheckCast(r70.next(), String.class, "com.obric.memorydata.plugin");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r71, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L184;
        boolean r120 = true;
    L185:
        if (r120 == false) goto L180;
        r67.add(r71);
        goto L180
    L184:
        r120 = false;
    L188:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r67, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L190;
        r3.append(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r67, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" · ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null)).append("\n");
    L190:
        String r72 = v.f10881a.a((OrderTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderTicketMemoryEntity.class, "com.obric.memorydata.plugin"));
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r72, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L193;
        boolean r73 = true;
    L194:
        if (r73 == false) goto L196;
        r3.append(r72).append("\n");
    L196:
        CharSequence r74 = (CharSequence) ZeusTransformUtils.preCheckCast(((OrderTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getAuditoriumName(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r74 != null) goto L199;
    L202:
        boolean r75 = true;
    L203:
        if (r75 == true) goto L205;
        r3.append(((OrderTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getAuditoriumName()).append("\n");
    L205:
        CharSequence r76 = (CharSequence) ZeusTransformUtils.preCheckCast(((OrderTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getAuditoriumAddress(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r76 != null) goto L208;
    L211:
        boolean r77 = true;
    L212:
        if (r77 == true) goto L297;
        r21 = ((OrderTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getAuditoriumAddress();
        goto L217
    L208:
        if (r76.length() == 0) goto L211;
        r77 = false;
        goto L212
    L199:
        if (r74.length() == 0) goto L202;
        r75 = false;
        goto L203
    L193:
        r73 = false;
        goto L194
    L215:
        if (ZeusTransformUtils.instanceOf(r0, OrderCommonMemoryEntity.class) == false) goto L219;
        r21 = ((OrderCommonMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderCommonMemoryEntity.class, "com.obric.memorydata.plugin")).getOrderDesc();
        goto L217
    L219:
        if (ZeusTransformUtils.instanceOf(r0, CollectStoreMemoryEntity.class) == false) goto L230;
        CharSequence r78 = (CharSequence) ZeusTransformUtils.preCheckCast(((CollectStoreMemoryEntity) ZeusTransformUtils.preCheckCast(r0, CollectStoreMemoryEntity.class, "com.obric.memorydata.plugin")).getAddress(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r78 != null) goto L223;
    L226:
        boolean r79 = true;
    L227:
        if (r79 == true) goto L297;
        r21 = ((CollectStoreMemoryEntity) ZeusTransformUtils.preCheckCast(r0, CollectStoreMemoryEntity.class, "com.obric.memorydata.plugin")).getAddress();
        goto L217
    L223:
        if (r78.length() == 0) goto L226;
        r79 = false;
        goto L227
    L230:
        if (ZeusTransformUtils.instanceOf(r0, EventScheduleMemoryEntity.class) == false) goto L247;
        String r80 = v.f10881a.a((EventScheduleMemoryEntity) ZeusTransformUtils.preCheckCast(r0, EventScheduleMemoryEntity.class, "com.obric.memorydata.plugin"));
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r80, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L234;
        boolean r81 = true;
    L235:
        if (r81 == false) goto L237;
        r3.append(r80).append("\n");
    L237:
        CharSequence r82 = (CharSequence) ZeusTransformUtils.preCheckCast(((EventScheduleMemoryEntity) ZeusTransformUtils.preCheckCast(r0, EventScheduleMemoryEntity.class, "com.obric.memorydata.plugin")).getAddress(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r82 != null) goto L240;
    L243:
        boolean r83 = true;
    L244:
        if (r83 == true) goto L297;
        r21 = ((EventScheduleMemoryEntity) ZeusTransformUtils.preCheckCast(r0, EventScheduleMemoryEntity.class, "com.obric.memorydata.plugin")).getAddress();
        goto L217
    L240:
        if (r82.length() == 0) goto L243;
        r83 = false;
        goto L244
    L234:
        r81 = false;
        goto L235
    L247:
        if (ZeusTransformUtils.instanceOf(r0, EventTodoMemoryEntity.class) == false) goto L255;
        String r84 = v.f10881a.a((EventTodoMemoryEntity) ZeusTransformUtils.preCheckCast(r0, EventTodoMemoryEntity.class, "com.obric.memorydata.plugin"));
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r84, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L251;
        boolean r85 = true;
    L252:
        if (r85 == false) goto L297;
        r3.append(r84).append("\n");
        goto L297
    L251:
        r85 = false;
        goto L252
    L255:
        if (ZeusTransformUtils.instanceOf(r0, CollectContentMemoryEntity.class) == false) goto L273;
        r3.append(((CollectContentMemoryEntity) ZeusTransformUtils.preCheckCast(r0, CollectContentMemoryEntity.class, "com.obric.memorydata.plugin")).getSummary());
        Collection r86 = (Collection) ZeusTransformUtils.preCheckCast(((CollectContentMemoryEntity) ZeusTransformUtils.preCheckCast(r0, CollectContentMemoryEntity.class, "com.obric.memorydata.plugin")).getTags(), Collection.class, "com.obric.memorydata.plugin");
        if (r86 != null) goto L259;
    L262:
        boolean r87 = true;
    L263:
        if (r87 == true) goto L270;
        ((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).memoryContent.tagsLinearLayout.removeAllViews();
        FlowLayout r88 = ((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).memoryContent.tagsLinearLayout;
        Intrinsics.checkNotNullExpressionValue(r88, "tagsLinearLayout");
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(r88, View.class, "com.obric.memorydata.plugin"), true);
        List<String> r89 = ((CollectContentMemoryEntity) ZeusTransformUtils.preCheckCast(r0, CollectContentMemoryEntity.class, "com.obric.memorydata.plugin")).getTags();
        if (r89 == null) goto L297;
        Iterator r90 = ((Iterable) ZeusTransformUtils.preCheckCast(r89, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L268:
        if (r90.hasNext() == false) goto L271;
        String r91 = (String) ZeusTransformUtils.preCheckCast(r90.next(), String.class, "com.obric.memorydata.plugin");
        Iterator r121 = r90;
        View r92 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).getRoot().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.layout.article_tag_layout, "layout", "article_tag_layout"), (ViewGroup) ZeusTransformUtils.preCheckCast(((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).memoryContent.tagsLinearLayout, ViewGroup.class, "com.obric.memorydata.plugin"), false, "com.obric.memorydata.plugin");
        ((TextView) ZeusTransformUtils.preCheckCast(r92.findViewById(ZeusTransformUtils.mapRes(R.id.tag_text, OaidModel.KEY_ID, "tag_text")), TextView.class, "com.obric.memorydata.plugin")).setText((CharSequence) ZeusTransformUtils.preCheckCast(r91, CharSequence.class, "com.obric.memorydata.plugin"));
        ((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).memoryContent.tagsLinearLayout.addView(r92);
        r90 = r121;
    L271:
        Unit r93 = Unit.INSTANCE;
    L270:
        FlowLayout r94 = ((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).memoryContent.tagsLinearLayout;
        Intrinsics.checkNotNullExpressionValue(r94, "tagsLinearLayout");
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(r94, View.class, "com.obric.memorydata.plugin"), false);
        goto L271
    L259:
        if (r86.isEmpty() == true) goto L262;
        r87 = false;
        goto L263
    L273:
        if (ZeusTransformUtils.instanceOf(r0, CommonTextMemoryEntity.class) == false) goto L289;
        r3.append(((CommonTextMemoryEntity) ZeusTransformUtils.preCheckCast(r0, CommonTextMemoryEntity.class, "com.obric.memorydata.plugin")).getSummary());
        Collection r95 = (Collection) ZeusTransformUtils.preCheckCast(((CommonTextMemoryEntity) ZeusTransformUtils.preCheckCast(r0, CommonTextMemoryEntity.class, "com.obric.memorydata.plugin")).getTagList(), Collection.class, "com.obric.memorydata.plugin");
        if (r95 != null) goto L277;
    L280:
        boolean r96 = true;
    L281:
        if (r96 == true) goto L270;
        ((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).memoryContent.tagsLinearLayout.removeAllViews();
        FlowLayout r97 = ((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).memoryContent.tagsLinearLayout;
        Intrinsics.checkNotNullExpressionValue(r97, "tagsLinearLayout");
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(r97, View.class, "com.obric.memorydata.plugin"), true);
        List<String> r98 = ((CommonTextMemoryEntity) ZeusTransformUtils.preCheckCast(r0, CommonTextMemoryEntity.class, "com.obric.memorydata.plugin")).getTagList();
        if (r98 == null) goto L297;
        Iterator r99 = ((Iterable) ZeusTransformUtils.preCheckCast(r98, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L286:
        if (r99.hasNext() == false) goto L271;
        String r100 = (String) ZeusTransformUtils.preCheckCast(r99.next(), String.class, "com.obric.memorydata.plugin");
        Iterator r122 = r99;
        View r101 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).getRoot().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.layout.article_tag_layout, "layout", "article_tag_layout"), (ViewGroup) ZeusTransformUtils.preCheckCast(((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).memoryContent.tagsLinearLayout, ViewGroup.class, "com.obric.memorydata.plugin"), false, "com.obric.memorydata.plugin");
        ((TextView) ZeusTransformUtils.preCheckCast(r101.findViewById(ZeusTransformUtils.mapRes(R.id.tag_text, OaidModel.KEY_ID, "tag_text")), TextView.class, "com.obric.memorydata.plugin")).setText((CharSequence) ZeusTransformUtils.preCheckCast(r100, CharSequence.class, "com.obric.memorydata.plugin"));
        ((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).memoryContent.tagsLinearLayout.addView(r101);
        r99 = r122;
        goto L286
    L277:
        if (r95.isEmpty() == true) goto L280;
        r96 = false;
        goto L281
    L289:
        if (ZeusTransformUtils.instanceOf(r0, InfoDocumentsMemoryEntity.class) == true) goto L297;
        if (ZeusTransformUtils.instanceOf(r0, InfoAddressMemoryEntity.class) == true) goto L297;
        if (ZeusTransformUtils.instanceOf(r0, InfoAnniversaryMemoryEntity.class) == true) goto L297;
        if (ZeusTransformUtils.instanceOf(r0, InfoRelationshipMemoryEntity.class) == true) goto L297;
        ZeusTransformUtils.instanceOf(r0, InfoCommonMemoryEntity.class);
        goto L297
    }

    private final void a(com.obric.memorydata.memory.ui.data.a.i r48) {
        TextView r0 = ((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).memoryContent.titleText;
        Intrinsics.checkNotNull(r0);
        com.obric.memorydata.memory.ui.m.a(r0, null, 1, null);
        r0.setText((CharSequence) ZeusTransformUtils.preCheckCast(a(r48.b()), CharSequence.class, "com.obric.memorydata.plugin"));
        ((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).memoryContent.summaryText.setLineHeight(2, 22.0f);
        String r1 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r48.b().getContent(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        com.larus.business.markdown.api.a r6 = com.obric.memorydata.markdown.a.f9973a.b();
        if (r6 == null) goto L5;
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).getRoot().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r7, "getContext(...)");
        com.larus.business.markdown.api.model.h r2 = com.larus.business.markdown.api.a.b.a(r6, r7, 0, r1, true, new com.larus.business.markdown.api.model.c(0, null, null, null, false, false, null, 0, 0, null, 0.0f, null, 0, 0, null, Integer.valueOf(MathKt.roundToInt(TypedValue.applyDimension(2, 12, Resources.getSystem().getDisplayMetrics()))), Integer.valueOf(MathKt.roundToInt(TypedValue.applyDimension(2, 4, Resources.getSystem().getDisplayMetrics()))), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -98305, null), null, null, null, 224, null);
    L6:
        ((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).memoryContent.summaryText.setMarkdown(r2);
        MarkdownTextView r3 = ((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).memoryContent.summaryText;
        Intrinsics.checkNotNullExpressionValue(r3, "summaryText");
        y.a((TextView) ZeusTransformUtils.preCheckCast(r3, TextView.class, "com.obric.memorydata.plugin"));
        ((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).memoryContent.summaryTextTip.setVisibility(8);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == false) goto L12;
        MarkdownTextView r5 = ((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).memoryContent.summaryText;
        Intrinsics.checkNotNullExpressionValue(r5, "summaryText");
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.memorydata.plugin"), true);
    L13:
        String r8 = r48.b().getLocation();
        com.obric.memorydata.memory.ui.h r9 = com.obric.memorydata.memory.ui.i.f10968a.a(r48.b().getProductType());
        ((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).memoryContent.tagsLinearLayout.removeAllViews();
        LinearLayout r10 = ((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).memoryContent.bottomSourceContainer;
        Intrinsics.checkNotNullExpressionValue(r10, "bottomSourceContainer");
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.memorydata.plugin"), true);
        ((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).memoryContent.memorySourceIcon.setImageResource(r9.b());
        String r11 = com.obric.memorydata.memory.utils.f.f11537a.a(r48.b().getStartTimestamp(), r48.b().getEndTimestamp(), true);
        TextView r12 = ((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).memoryContent.memoryTimeTv;
        Intrinsics.checkNotNullExpressionValue(r12, "memoryTimeTv");
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(r12, View.class, "com.obric.memorydata.plugin"), false);
        TextView r13 = ((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).memoryContent.memorySourceTv;
        String r14 = at.a(r9.a()) + " · " + r11;
        Intrinsics.checkNotNullExpressionValue(r14, "toString(...)");
        r13.setText((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin"));
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L16;
        boolean r15 = true;
    L18:
        if (r15 == true) goto L20;
    L22:
        FlowLayout r16 = ((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).memoryContent.tagsLinearLayout;
        Intrinsics.checkNotNullExpressionValue(r16, "tagsLinearLayout");
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(r16, View.class, "com.obric.memorydata.plugin"), false);
        return;
    L20:
        if (Intrinsics.areEqual(r48.b().getUseLocation(), true) == false) goto L22;
        FlowLayout r17 = ((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).memoryContent.tagsLinearLayout;
        Intrinsics.checkNotNullExpressionValue(r17, "tagsLinearLayout");
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(r17, View.class, "com.obric.memorydata.plugin"), true);
        View r18 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).getRoot().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.layout.screen_location_tag_layout, "layout", "screen_location_tag_layout"), (ViewGroup) ZeusTransformUtils.preCheckCast(((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).memoryContent.tagsLinearLayout, ViewGroup.class, "com.obric.memorydata.plugin"), false, "com.obric.memorydata.plugin");
        TextView r19 = (TextView) ZeusTransformUtils.preCheckCast(r18.findViewById(ZeusTransformUtils.mapRes(R.id.tag_text, OaidModel.KEY_ID, "tag_text")), TextView.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r19);
        com.obric.memorydata.memory.ui.m.a(r19, null, 1, null);
        StringCompanionObject r20 = StringCompanionObject.INSTANCE;
        String r21 = String.format(at.a(ZeusTransformUtils.mapRes(R.string.screen_memory_location_tag, TypedValues.Custom.S_STRING, "screen_memory_location_tag")), Arrays.copyOf(new Object[]{r8}, 1));
        Intrinsics.checkNotNullExpressionValue(r21, "format(...)");
        r19.setText((CharSequence) ZeusTransformUtils.preCheckCast(r21, CharSequence.class, "com.obric.memorydata.plugin"));
        ((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).memoryContent.tagsLinearLayout.addView(r18);
        return;
    L16:
        r15 = false;
        goto L18
    L12:
        MarkdownTextView r22 = ((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).memoryContent.summaryText;
        Intrinsics.checkNotNullExpressionValue(r22, "summaryText");
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(r22, View.class, "com.obric.memorydata.plugin"), false);
        goto L13
    L9:
        r4 = false;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.obric.memorydata.memory.ui.detail.w, com.obric.memorydata.memory.ui.data.c
    public void b(com.obric.memorydata.memory.ui.data.a r3) {
        Intrinsics.checkNotNullParameter(r3, "memoryItem");
        super.b(r3);
        if (ZeusTransformUtils.instanceOf(r3, com.obric.memorydata.memory.ui.data.a.e.class) == false) goto L6;
        a((com.obric.memorydata.memory.ui.data.a.e) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.memory.ui.data.a.e.class, "com.obric.memorydata.plugin"));
    L8:
        LinearLayout r2 = ((ItemMemoryDetailBinding) ZeusTransformUtils.preCheckCast(c(), ItemMemoryDetailBinding.class, "com.obric.memorydata.plugin")).llMemorySource;
        Intrinsics.checkNotNullExpressionValue(r2, "llMemorySource");
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin"), false);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.memorydata.memory.ui.data.a.i.class) == false) goto L8;
        a((com.obric.memorydata.memory.ui.data.a.i) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.memory.ui.data.a.i.class, "com.obric.memorydata.plugin"));
        goto L8
    }
}
