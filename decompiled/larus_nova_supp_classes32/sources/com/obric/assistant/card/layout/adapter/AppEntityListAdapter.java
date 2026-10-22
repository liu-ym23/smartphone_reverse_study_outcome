package com.obric.assistant.card.layout.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.AppIntentCardData;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.layout.bean.MessageExtraForViewHolder;
import com.obric.assistant.card.layout.viewholder.MusicViewHolder;
import com.obric.assistant.card.layout.viewholder.abs.AbsCardItemViewHolder;
import com.obric.assistant.card.layout.viewholder.style.AbsCardItemClockStyle;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.MessageEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kca.d;
import kca.e;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import nca.p0;
import pca.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 E2\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0006\b\u0001\u0012\u00020\u00030\u00020\u0001:\u0004BCDEB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\u0018\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u001a2\b\b\u0002\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0012J\u0010\u0010\u001e\u001a\u00020\u00192\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0014\u0010\u001f\u001a\u00020\u00192\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00170\u0016J\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00140\u001a2\u0006\u0010\"\u001a\u00020#J\u0010\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010\"\u001a\u00020#J\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u001a2\u0006\u0010\"\u001a\u00020#H\u0002J!\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010\"\u001a\u00020#2\b\u0010)\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0002\u0010*J\u0018\u0010+\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00120,J$\u0010-\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\b\u0001\u0012\u00020\u00030\u00022\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0010H\u0016J\u0010\u00101\u001a\u00020\u00102\u0006\u00102\u001a\u00020\u0010H\u0016J\b\u00103\u001a\u00020\u0010H\u0016J$\u00104\u001a\u00020\u00192\u0012\u00105\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\b\u0001\u0012\u00020\u00030\u00022\u0006\u00102\u001a\u00020\u0010H\u0016J\u001c\u00106\u001a\u00020\u00192\u0012\u00105\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016J\u001c\u00107\u001a\u00020\u00192\u0012\u00105\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010:\u001a\u00020\u00192\b\u0010;\u001a\u0004\u0018\u000109J\u0010\u0010>\u001a\u00020\u00192\b\u0010;\u001a\u0004\u0018\u00010=J\u0018\u0010?\u001a\b\u0012\u0004\u0012\u00020\f0\u001a*\b\u0012\u0004\u0012\u00020\f0\u001aH\u0002J\u0018\u0010@\u001a\b\u0012\u0004\u0012\u00020\f0\u001a*\b\u0012\u0004\u0012\u00020\f0\u001aH\u0002J\u0018\u0010A\u001a\b\u0012\u0004\u0012\u00020\f0\u001a*\b\u0012\u0004\u0012\u00020\f0\u001aH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lcom/obric/assistant/card/layout/adapter/AppEntityListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/obric/assistant/card/layout/viewholder/abs/AbsCardItemViewHolder;", "Landroidx/viewbinding/ViewBinding;", "pageType", "Lcom/obric/assistant/card/layout/adapter/AppEntityListAdapter$PageType;", "<init>", "(Lcom/obric/assistant/card/layout/adapter/AppEntityListAdapter$PageType;)V", "messageExtra", "Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;", "dataList", "Ljava/util/ArrayList;", NameKeys.UnloadStrategy_No_Strategy, "Lkotlin/collections/ArrayList;", "dataListOriginal", "maxCount", NameKeys.UnloadStrategy_No_Strategy, "isLatestMessage", NameKeys.UnloadStrategy_No_Strategy, "messageId", NameKeys.UnloadStrategy_No_Strategy, "traceInfoFetcher", "Lkotlin/Function0;", "Landroid/os/Bundle;", "updateData", NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, "updateMaxCount", "setIsLatestMessage", "isLatest", "setMessageId", "setTraceInfoFetcher", "traceInfo", "getTypeNames", "context", "Landroid/content/Context;", "getPrimaryHeaderType", "Lcom/obric/assistant/card/layout/adapter/AppEntityListAdapter$HeaderType;", "buildTypeInfos", "Lcom/obric/assistant/card/layout/adapter/AppEntityListAdapter$TypeInfo;", "buildTypeInfoByRes", "resId", "(Landroid/content/Context;Ljava/lang/Integer;)Lcom/obric/assistant/card/layout/adapter/AppEntityListAdapter$TypeInfo;", "getLayoutInfo", "Lkotlin/Triple;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemViewType", "position", "getItemCount", "onBindViewHolder", "holder", "onViewDetachedFromWindow", "onViewAttachedToWindow", "itemClickListener", "Lcom/obric/assistant/card/layout/listener/OnItemClickListener;", "setOnItemClickListener", "listener", "itemLongClickListener", "Lcom/obric/assistant/card/layout/listener/OnItemLongClickListener;", "setOnLongClickListener", "filterSupportedType", "mergePhotoEntity", "mergeVirtualContactsEntity", "HeaderType", "TypeInfo", "PageType", "Companion", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppEntityListAdapter extends RecyclerView.Adapter<AbsCardItemViewHolder<?, ? extends ViewBinding>> {
    public static final Lazy<Map<Class<?>, Integer>> k = null;
    public final PageType a;
    public MessageExtraForViewHolder b;
    public final ArrayList<Object> c;
    public final ArrayList<Object> d;
    public int e;
    public boolean f;
    public String g;
    public Function0<Bundle> h;
    public pca.b i;
    public c j;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/card/layout/adapter/AppEntityListAdapter$HeaderType;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "LARK", "INSTRUCTION_MANAGEMENT", "CLOCK", "CONTACTS", "SMS", "NOTE", "MEMORY", "RECORDING", "NETEASE_MUSIC", "ALBUM", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum HeaderType extends Enum<HeaderType> {
        public static final HeaderType ALBUM = null;
        public static final HeaderType CLOCK = null;
        public static final HeaderType CONTACTS = null;
        public static final HeaderType INSTRUCTION_MANAGEMENT = null;
        public static final HeaderType LARK = null;
        public static final HeaderType MEMORY = null;
        public static final HeaderType NETEASE_MUSIC = null;
        public static final HeaderType NOTE = null;
        public static final HeaderType RECORDING = null;
        public static final HeaderType SMS = null;
        public static final /* synthetic */ HeaderType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<HeaderType> getEntries() {
            return b;
        }

        static {
            HeaderType r0 = new HeaderType("LARK", 0);
            LARK = r0;
            HeaderType r1 = new HeaderType("INSTRUCTION_MANAGEMENT", 1);
            INSTRUCTION_MANAGEMENT = r1;
            HeaderType r3 = new HeaderType("CLOCK", 2);
            CLOCK = r3;
            HeaderType r5 = new HeaderType("CONTACTS", 3);
            CONTACTS = r5;
            HeaderType r7 = new HeaderType("SMS", 4);
            SMS = r7;
            HeaderType r9 = new HeaderType("NOTE", 5);
            NOTE = r9;
            HeaderType r11 = new HeaderType("MEMORY", 6);
            MEMORY = r11;
            HeaderType r13 = new HeaderType("RECORDING", 7);
            RECORDING = r13;
            HeaderType r15 = new HeaderType("NETEASE_MUSIC", 8);
            NETEASE_MUSIC = r15;
            HeaderType r14 = new HeaderType("ALBUM", 9);
            ALBUM = r14;
            HeaderType[] r12 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
            a = r12;
            b = EnumEntriesKt.enumEntries(r12);
        }

        public static HeaderType[] values() {
            return (HeaderType[]) a.clone();
        }

        public static HeaderType valueOf(String r1) {
            return (HeaderType) r27.a.a(HeaderType.class, r1);
        }

        public HeaderType(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/card/layout/adapter/AppEntityListAdapter$PageType;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "ChatPage", "ShowAllPage", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum PageType extends Enum<PageType> {
        public static final PageType ChatPage = null;
        public static final PageType ShowAllPage = null;
        public static final /* synthetic */ PageType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<PageType> getEntries() {
            return b;
        }

        static {
            PageType r0 = new PageType("ChatPage", 0);
            ChatPage = r0;
            PageType r1 = new PageType("ShowAllPage", 1);
            ShowAllPage = r1;
            PageType[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static PageType[] values() {
            return (PageType[]) a.clone();
        }

        public static PageType valueOf(String r1) {
            return (PageType) r27.a.a(PageType.class, r1);
        }

        public PageType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b {
        public final String a;
        public final HeaderType b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            HeaderType r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "TypeInfo(displayName=" + this.a + ", headerType=" + this.b + ')';
        }

        public b(String r2, HeaderType r3) {
            Intrinsics.checkNotNullParameter(r2, "displayName");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
        new a();
        k = LazyKt.lazy(new kca.a());
    }

    public final int getItemCount() {
        return RangesKt.coerceAtMost(this.c.size(), this.e);
    }

    public AppEntityListAdapter(PageType r11) {
        Intrinsics.checkNotNullParameter(r11, "pageType");
        this.a = r11;
        this.b = new MessageExtraForViewHolder(false, false, null, null, null, null, null, 127);
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = 5;
        this.f = true;
    }

    public final int getItemViewType(int r4) {
        Object r5 = ListProtector.get(this.c, r4);
        Lazy r0 = p0.c;
        Integer r1 = (Integer) ((Map) r0.getValue()).get(r5.getClass());
        if (r1 == null) goto L13;
        int r2 = r1.intValue();
        if ((r5 instanceof MessageEntity) == true) goto L7;
        return r2;
    L7:
        if (Intrinsics.areEqual(((MessageEntity) r5).getPackageName(), "com.ss.android.lark") == false) goto L15;
        Integer r6 = (Integer) ((Map) r0.getValue()).get(com.obric.assistant.card.a.class);
        if (r6 != null) goto L11;
        return r2;
    L11:
        return r6.intValue();
    L15:
        return r2;
    L13:
        throw new IllegalArgumentException("not support entity: " + r5.getClass());
    }

    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r2) {
        AbsCardItemViewHolder r3 = (AbsCardItemViewHolder) r2;
        Intrinsics.checkNotNullParameter(r3, "holder");
        super.onViewAttachedToWindow(r3);
        r3.U3();
    }

    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r2) {
        AbsCardItemViewHolder r3 = (AbsCardItemViewHolder) r2;
        Intrinsics.checkNotNullParameter(r3, "holder");
        super.onViewDetachedFromWindow(r3);
        r3.V3();
    }

    public final List<b> z2(final Context r3) {
        return SequencesKt.toList(SequencesKt.filter(SequencesKt.distinctBy(SequencesKt.mapNotNull(SequencesKt.filterNotNull(SequencesKt.flatMapIterable(CollectionsKt.asSequence(this.c), new kca.b())), new kca.c(r3, this)), new d()), new e()));
    }

    public static b y2(Context r2, Integer r3) {
        if (r3 != null) goto L5;
    L6:
        if (r3 != null) goto L9;
    L11:
        if (r3 != null) goto L14;
    L16:
        if (r3 != null) goto L19;
    L21:
        if (r3 != null) goto L24;
    L26:
        if (r3 != null) goto L29;
    L31:
        if (r3 != null) goto L34;
    L36:
        if (r3 == null) goto L42;
        if (r3.intValue() != 2131912009) goto L42;
        return new b(r2.getString(r3.intValue()), HeaderType.NETEASE_MUSIC);
    L42:
        if (r3 != null) goto L53;
        return null;
    L53:
        return new b(r2.getString(r3.intValue()), null);
    L34:
        if (r3.intValue() != 2131912001) goto L36;
        return new b(r2.getString(r3.intValue()), HeaderType.INSTRUCTION_MANAGEMENT);
    L29:
        if (r3.intValue() != 2131911991) goto L31;
        return new b(r2.getString(r3.intValue()), HeaderType.ALBUM);
    L24:
        if (r3.intValue() != 2131912016) goto L26;
        return new b(r2.getString(r3.intValue()), HeaderType.RECORDING);
    L19:
        if (r3.intValue() != 2131912188) goto L21;
        return new b(r2.getString(r3.intValue()), HeaderType.NOTE);
    L14:
        if (r3.intValue() != 2131912190) goto L16;
        return new b(r2.getString(r3.intValue()), HeaderType.SMS);
    L9:
        if (r3.intValue() != 2131912013) goto L11;
    L46:
        return new b(r2.getString(r3.intValue()), HeaderType.CONTACTS);
    L5:
        if (r3.intValue() == 2131912192) goto L46;
        goto L6
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r10, int r11) {
        AbsCardItemViewHolder r12 = (AbsCardItemViewHolder) r10;
        Intrinsics.checkNotNullParameter(r12, "holder");
        Object r2 = ListProtector.get(this.c, r11);
        r12.g = this.i;
        r12.h = this.j;
        boolean r6 = false;
        if (r11 < this.d.size()) goto L5;
    L7:
        boolean r7 = false;
        boolean r8 = false;
    L9:
        if ((r12 instanceof MusicViewHolder) == false) goto L13;
        Function0<Bundle> r0 = this.h;
        if (r0 == null) goto L13;
        Intrinsics.checkNotNullParameter(r0, "traceInfo");
        ((MusicViewHolder) r12).m = r0;
    L13:
        MessageExtraForViewHolder r1 = this.b;
        ArrayList<Object> r3 = this.c;
        Intrinsics.checkNotNullParameter(r1, "messageExtra");
        Intrinsics.checkNotNullParameter(r3, "entityGroup");
        Intrinsics.checkNotNullParameter(r2, "entity");
        r12.d = r3;
        View r4 = ((RecyclerView.ViewHolder) r12).itemView;
        if (r11 != (r3.size() - 1)) goto L16;
        int r5 = 2131244528;
    L17:
        r4.setBackgroundResource(r5);
        if (r12.b == false) goto L20;
        r12.W3(r12.a.getRoot(), r3, r2, r11);
    L20:
        r12.T3(r1, r2, r11, r7, r8);
        if ((r12 instanceof AbsCardItemClockStyle) == false) goto L29;
        boolean r13 = this.f;
        if (r13 == false) goto L27;
        if (r7 == true) goto L27;
        if (r8 == true) goto L27;
        r6 = true;
    L27:
        ((AbsCardItemClockStyle) r12).Y3(r6, this.g, r13);
        return;
    L29:
        return;
    L16:
        r5 = 2131244527;
        goto L17
    L5:
        if ((ListProtector.get(this.d, r11) instanceof AppIntentCardData) == false) goto L7;
        Object r9 = ListProtector.get(this.d, r11);
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type com.obric.aiagent.assistant.idl.bean.AppIntentCardData");
        boolean r14 = ((AppIntentCardData) r9).isDeleted();
        Object r15 = ListProtector.get(this.d, r11);
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type com.obric.aiagent.assistant.idl.bean.AppIntentCardData");
        r7 = r14;
        r8 = ((AppIntentCardData) r15).isRefreshed();
        goto L9
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        Function1 r0 = (Function1) ((Map) p0.d.getValue()).get(Integer.valueOf(r4));
        if (r0 == null) goto L7;
        AbsCardItemViewHolder r5 = (AbsCardItemViewHolder) r0.invoke(r3);
        PageType r6 = this.a;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r5.f = r6;
        return r5;
    L7:
        throw new IllegalArgumentException("not support viewType: " + r4);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void A2(MessageExtraForViewHolder r9, List<? extends Object> r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "messageExtra");
        Intrinsics.checkNotNullParameter(r10, "dataList");
        this.e = r11;
        this.b = r9;
        this.c.clear();
        this.d.clear();
        ArrayList<Object> r12 = this.d;
        List<? extends Object> r13 = r10;
        ArrayList r14 = new ArrayList();
        Iterator<T> r0 = r13.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        Object r1 = r0.next();
        if ((r1 instanceof AppIntentCardData) == false) goto L8;
        r1 = com.obric.assistant.card.utils.c.b((AppIntentCardData) r1);
    L8:
        if (r1 == null) goto L4;
        r14.add(r1);
        goto L4
    L10:
        r12.addAll(r14);
        ArrayList<Object> r15 = this.c;
        ArrayList r16 = new ArrayList();
        Iterator<T> r17 = r13.iterator();
    L12:
        if (r17.hasNext() == false) goto L18;
        Object r2 = r17.next();
        if ((r2 instanceof AppIntentCardData) == false) goto L16;
        r2 = com.obric.assistant.card.utils.c.c((AppIntentCardData) r2);
    L16:
        if (r2 == null) goto L12;
        r16.add(r2);
        goto L12
    L18:
        ArrayList r18 = new ArrayList();
        Iterator r19 = r16.iterator();
    L20:
        if (r19.hasNext() == false) goto L26;
        Object r3 = r19.next();
        boolean r4 = ((Set) p0.b.getValue()).contains(r3.getClass());
        if (r4 == true) goto L24;
        FLogger.a.w("AppEntityListAdapter", "not support entity: " + r3.getClass());
    L24:
        if (r4 == false) goto L20;
        r18.add(r3);
        goto L20
    L26:
        int r5 = 0;
        Object r6 = null;
        if (r18.isEmpty() == false) goto L29;
    L91:
        Iterator r110 = r18.iterator();
    L93:
        if (r110.hasNext() == false) goto L97;
        Object r7 = r110.next();
        if ((r7 instanceof PhotoEntity) == false) goto L93;
        r6 = r7;
    L97:
        if (r6 == null) goto L124;
        ArrayList r111 = new ArrayList();
        ArrayList r8 = new ArrayList();
        Iterator r112 = r18.iterator();
        int r20 = Integer.MAX_VALUE;
    L101:
        if (r112.hasNext() == false) goto L111;
        Object r21 = r112.next();
        int r22 = r5 + 1;
        if (r5 >= 0) goto L106;
        CollectionsKt.throwIndexOverflow();
    L106:
        if ((r21 instanceof PhotoEntity) == false) goto L108;
        int r23 = RangesKt.coerceAtMost(r20, r5);
        r8.add(r21);
        r20 = r23;
    L109:
        r5 = r22;
        goto L101
    L108:
        r111.add(r21);
        goto L109
    L111:
        if ((!r8.isEmpty()) == true) goto L113;
    L123:
        r18 = r111;
        goto L124
    L113:
        if (r111.isEmpty() == false) goto L115;
        Object r113 = new mca.c(r8);
    L117:
        if (r20 < 5) goto L120;
        r111.add(r113);
        goto L123
    L120:
        if (r111.size() >= 5) goto L122;
        r111.add(r113);
        goto L123
    L122:
        ListProtector.add(r111, 4, r113);
        goto L123
    L115:
        r113 = new mca.d(r8);
    L124:
        r15.addAll(r18);
        return;
    L29:
        if (r18.isEmpty() == true) goto L37;
        Iterator r114 = r18.iterator();
    L33:
        if (r114.hasNext() == false) goto L37;
        if ((r114.next() instanceof ContactEntity) == true) goto L33;
        boolean r115 = false;
    L38:
        if (r115 == false) goto L91;
        LinkedHashSet r116 = new LinkedHashSet();
        Iterator r24 = r18.iterator();
    L42:
        if (r24.hasNext() == false) goto L51;
        Object r25 = r24.next();
        if ((r25 instanceof ContactEntity) == true) goto L46;
    L48:
        boolean r26 = false;
    L49:
        if (r26 == false) goto L42;
    L52:
        if (r25 == null) goto L54;
        boolean r117 = true;
    L55:
        if (r117 == false) goto L91;
        ArrayList r118 = new ArrayList();
        ArrayList r27 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));
        Iterator r119 = r18.iterator();
    L59:
        if (r119.hasNext() == false) goto L61;
        Object r28 = r119.next();
        Intrinsics.checkNotNull(r28, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.ContactEntity");
        r27.add((ContactEntity) r28);
        goto L59
    L61:
        Iterator r120 = r27.iterator();
    L63:
        if (r120.hasNext() == false) goto L82;
        ContactEntity r29 = (ContactEntity) r120.next();
        Iterator r30 = r118.iterator();
    L66:
        if (r30.hasNext() == false) goto L70;
        Object r31 = r30.next();
        if (Intrinsics.areEqual(((ContactEntity) ((mca.e) r31).a).getId(), r29.getId()) == false) goto L66;
    L71:
        mca.e r32 = (mca.e) r31;
        if (r32 != null) goto L73;
        r118.add(new mca.e(r29));
        goto L63
    L73:
        ContactEntity r33 = (ContactEntity) r32.a;
        List r34 = r33.getTelephones();
        if (r34 != null) goto L76;
        r34 = CollectionsKt.emptyList();
    L76:
        List r35 = r34;
        List r36 = r29.getTelephones();
        if (r36 != null) goto L80;
        r36 = CollectionsKt.emptyList();
    L80:
        r33.setTelephones(CollectionsKt.plus(r35, r36));
        goto L63
    L70:
        r31 = null;
        goto L71
    L82:
        Iterator r121 = r118.iterator();
        int r37 = 0;
    L84:
        if (r121.hasNext() == false) goto L90;
        mca.e r38 = (mca.e) r121.next();
        r38.b = r37;
        List r39 = ((ContactEntity) r38.a).getTelephones();
        if (r39 == null) goto L88;
        int r40 = r39.size();
    L89:
        r37 = r37 + r40;
        goto L84
    L88:
        r40 = 0;
        goto L89
    L90:
        r18 = r118;
        goto L91
    L54:
        r117 = false;
        goto L55
    L46:
        if (r116.add(((ContactEntity) r25).getId()) == true) goto L48;
        r26 = true;
        goto L49
    L51:
        r25 = null;
    L37:
        r115 = true;
        goto L38
    }
}
