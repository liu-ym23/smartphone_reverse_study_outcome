package com.obric.assistant.block.search.local.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.im.bean.message.TextCard;
import com.larus.im.bean.message.VideoCard;
import com.larus.im.bean.message.block.OQueryText;
import com.larus.im.bean.message.block.OSearchEntityCollection;
import com.larus.im.bean.message.block.OSearchEntityText;
import com.larus.im.bean.message.block.OSearchReference;
import com.larus.im.bean.message.block.OSearchReferenceInCollection;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.lynx.tasm.a0;
import com.mammon.speechaudiosdk.session.type.SpeechEvent;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.databinding.ObricBlockLocalSearchItemQueryBinding;
import com.obric.assistant.card.databinding.ObricBlockLocalSearchItemTextBinding;
import com.obric.assistant.card.databinding.ObricBlockLocalSearchItemWithRowBinding;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u001c\u001d\u001e\u001fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0007H\u0002J\b\u0010\u0016\u001a\u00020\u000eH\u0016J\u001e\u0010\u0017\u001a\u00020\u00102\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u0007H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/assistant/block/search/local/adapter/SearchLocalItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "()V", "items", NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, "isSubBlock", NameKeys.UnloadStrategy_No_Strategy, "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", NameKeys.UnloadStrategy_No_Strategy, "onBindViewHolder", NameKeys.UnloadStrategy_No_Strategy, "holder", "position", "getItemViewType", "getRefViewType", "ref", "getItemCount", "setData", NameKeys.UnloadStrategy_No_Strategy, "Lcom/larus/im/bean/message/block/OSearchReference;", "isImageOrVideoItem", "item", "Companion", "TextViewHolder", "TextRowViewHolder", "QueryTextViewHolder", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchLocalItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final Set<Integer> c = null;
    public final List<Object> a;
    public boolean b;

    public static final class a {
    }

    public static final class b extends RecyclerView.ViewHolder {
        public final ObricBlockLocalSearchItemQueryBinding a;

        public b(ObricBlockLocalSearchItemQueryBinding r2) {
            Intrinsics.checkNotNullParameter(r2, "binding");
            super(r2.a);
            this.a = r2;
        }
    }

    public static final class c extends RecyclerView.ViewHolder {
        public final ObricBlockLocalSearchItemWithRowBinding a;

        public c(ObricBlockLocalSearchItemWithRowBinding r5) {
            Intrinsics.checkNotNullParameter(r5, "binding");
            super(r5.a);
            this.a = r5;
            r5.b.setHasFixedSize(true);
            r5.b.setLayoutManager(new LinearLayoutManager(r5.a.getContext(), 0, false));
            r5.b.setAdapter(new SearchLocalRowAdapter());
        }
    }

    public static final class d extends RecyclerView.ViewHolder {
        public final ObricBlockLocalSearchItemTextBinding a;

        public d(ObricBlockLocalSearchItemTextBinding r2) {
            Intrinsics.checkNotNullParameter(r2, "binding");
            super(r2.a);
            this.a = r2;
        }
    }

    public static final class e<T> implements Comparator {
        public final /* synthetic */ SearchLocalItemAdapter a;

        public e(SearchLocalItemAdapter r1) {
            this.a = r1;
        }

        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            SearchLocalItemAdapter r0 = this.a;
            Set<Integer> r1 = SearchLocalItemAdapter.c;
            r0.getClass();
            Integer r5 = Integer.valueOf(r3 instanceof OSearchEntityCollection ? 1 : 0);
            this.a.getClass();
            return ComparisonsKt.compareValues(r5, Integer.valueOf(r4 instanceof OSearchEntityCollection ? 1 : 0));
        }
    }

    static {
        c = SetsKt.setOf(new Integer[]{701, Integer.valueOf(SpeechEvent.SERVER_DOWNLINK_EVENT_TASK_FINISHED), 201, 702, Integer.valueOf(a0.LYNX_ERROR_CODE_LAYOUT), Integer.valueOf(SpeechEvent.LOCAL_EVENT_SET_WAKEUP_PARAM), 301, 801, 501, 101, Integer.valueOf(a0.LYNX_ERROR_CODE_UPDATE), 502, 20001, 10001, 10002, 10003, 10004, 10005, 10006, 10101, 10102, 10103, 10104, 10105, 10201, 10202, 10301, 10302, 10401});
    }

    public final int getItemCount() {
        return ((ArrayList) this.a).size();
    }

    public SearchLocalItemAdapter() {
        this.a = new ArrayList();
    }

    public final int getItemViewType(int r4) {
        Object r5 = ListProtector.get(this.a, r4);
        if ((r5 instanceof TextCard) == false) goto L5;
    L17:
        return 0;
    L5:
        if ((r5 instanceof VideoCard) == true) goto L17;
        if ((r5 instanceof OSearchEntityText) == true) goto L17;
        if ((r5 instanceof OSearchEntityCollection) == false) goto L13;
        return 1;
    L13:
        if ((r5 instanceof OQueryText) == false) goto L16;
        return 2;
    L16:
        throw new IllegalArgumentException("invalid type " + r5);
    }

    public final void onBindViewHolder(final RecyclerView.ViewHolder r18, int r19) {
        Intrinsics.checkNotNullParameter(r18, "holder");
        Object r1 = ListProtector.get(this.a, r19);
        if (this.b == false) goto L5;
        int r2 = i5.h();
    L6:
        boolean r4 = r18 instanceof d;
        String r8 = NameKeys.UnloadStrategy_No_Strategy;
        if (r4 == false) goto L61;
        d r5 = (d) r18;
        TextView r9 = r5.a.b;
        r9.setPadding(r2, r9.getPaddingTop(), r2, r9.getPaddingBottom());
        we8.a.b(r5.a.b, i5.o(), false, null, null, 12);
        final Ref.ObjectRef r10 = new Ref.ObjectRef();
        r10.element = NameKeys.UnloadStrategy_No_Strategy;
        final Ref.BooleanRef r3 = new Ref.BooleanRef();
        final Ref.ObjectRef r11 = new Ref.ObjectRef();
        r11.element = NameKeys.UnloadStrategy_No_Strategy;
        final Ref.ObjectRef r12 = new Ref.ObjectRef();
        r12.element = NameKeys.UnloadStrategy_No_Strategy;
        final Ref.ObjectRef r13 = new Ref.ObjectRef();
        r13.element = NameKeys.UnloadStrategy_No_Strategy;
        boolean r14 = true;
        if ((r1 instanceof TextCard) == false) goto L25;
        TextCard r6 = (TextCard) r1;
        String r15 = r6.getTitle();
        if (r15 != null) goto L13;
        r15 = NameKeys.UnloadStrategy_No_Strategy;
    L13:
        Integer r16 = r6.getIndex();
        if (r16 == null) goto L17;
        String r17 = r16.toString();
        if (r17 == null) goto L17;
    L18:
        String r7 = r6.getUrl();
        if (r7 == null) goto L22;
        r8 = r7;
    L22:
        r10.element = r8;
    L23:
        r8 = r17;
    L48:
        if (o0.d(r8) == false) goto L50;
        r5.a.b.setText(r8 + ". " + r15);
    L51:
        TextView r20 = r5.a.b;
        if (r3.element == false) goto L60;
        String r21 = (String) r12.element;
        if (r21 == null) goto L58;
        Integer r22 = StringsKt.toIntOrNull(r21);
        if (r22 == null) goto L58;
        boolean r23 = c.contains(Integer.valueOf(r22.intValue()));
    L59:
        FLogger.a.i("SearchLocalItemAdapter", "type = " + ((String) r12.element) + ", isJumpAbleType = " + r23);
        r14 = r23;
    L58:
        r23 = false;
    L60:
        r20.setEnabled(r14);
        e1.d(r5.a.b, new com.obric.assistant.block.search.local.adapter.a(r3, r11, r12, r13, r10, r18));
        return;
    L50:
        r5.a.b.setText(r15);
    L17:
        r17 = NameKeys.UnloadStrategy_No_Strategy;
        goto L18
    L25:
        if ((r1 instanceof OSearchEntityText) == false) goto L46;
        OSearchEntityText r24 = (OSearchEntityText) r1;
        r15 = r24.getTitle();
        if (r15 != null) goto L29;
        r15 = NameKeys.UnloadStrategy_No_Strategy;
    L29:
        r10.element = NameKeys.UnloadStrategy_No_Strategy;
        Integer r110 = r24.getIndex();
        if (r110 == null) goto L33;
        r17 = r110.toString();
        if (r17 == null) goto L33;
    L34:
        r3.element = true;
        String r111 = r24.getEntityPackageName();
        if (r111 != null) goto L37;
        String r25 = NameKeys.UnloadStrategy_No_Strategy;
    L38:
        r11.element = r25;
        String r26 = r24.getEntityType();
        if (r26 != null) goto L41;
        r26 = NameKeys.UnloadStrategy_No_Strategy;
    L41:
        r12.element = r26;
        String r27 = r24.getEntityId();
        if (r27 == null) goto L45;
        r8 = r27;
    L45:
        r13.element = r8;
        goto L23
    L37:
        r25 = r111;
    L33:
        r17 = NameKeys.UnloadStrategy_No_Strategy;
        goto L34
    L46:
        FLogger.a.w("SearchLocalItemAdapter", "error type " + r1);
        r15 = NameKeys.UnloadStrategy_No_Strategy;
        goto L48
    L61:
        String r28 = null;
        SearchLocalRowAdapter r29 = null;
        if ((r18 instanceof c) == false) goto L96;
        if ((r1 instanceof OSearchEntityCollection) == false) goto L94;
        OSearchEntityCollection r30 = (OSearchEntityCollection) r1;
        if (o0.d(r30.getIndex()) == false) goto L75;
        TextView r31 = ((c) r18).a.c;
        StringBuilder r32 = new StringBuilder();
        String r33 = r30.getIndex();
        if (r33 != null) goto L70;
        r33 = NameKeys.UnloadStrategy_No_Strategy;
    L70:
        r32.append(r33);
        r32.append(". ");
        String r34 = r30.getTitle();
        if (r34 == null) goto L74;
        r8 = r34;
    L74:
        r32.append(r8);
        r31.setText(r32.toString());
    L80:
        c r35 = (c) r18;
        List r36 = r30.getItems();
        if (r36 == null) goto L83;
        List<OSearchReferenceInCollection> r37 = CollectionsKt.filterNotNull(r36);
    L84:
        boolean r38 = this.b;
        RecyclerView.Adapter r39 = r35.a.b.getAdapter();
        if ((r39 instanceof SearchLocalRowAdapter) == false) goto L87;
        r29 = (SearchLocalRowAdapter) r39;
    L87:
        if (r29 == null) goto L93;
        r29.y2(r37, r38);
        RecyclerView r40 = r35.a.b;
        if (r29.getItemCount() <= 0) goto L91;
        int r41 = 0;
    L92:
        r40.setVisibility(r41);
        goto L93
    L91:
        r41 = 8;
    L93:
        e1.d(r35.a.c, new com.obric.assistant.block.search.local.adapter.b(r18));
        TextView r42 = r35.a.c;
        r42.setPadding(r2, r42.getPaddingTop(), r2, r42.getPaddingBottom());
        we8.a.b(r35.a.c, i5.o(), false, null, null, 12);
        return;
    L83:
        r37 = null;
        goto L84
    L75:
        TextView r43 = ((c) r18).a.c;
        String r44 = r30.getTitle();
        if (r44 == null) goto L79;
        r8 = r44;
    L79:
        r43.setText(r8);
        goto L80
    L94:
        FLogger.a.w("SearchLocalItemAdapter", "error type: " + r1);
        return;
    L96:
        if ((r18 instanceof b) == false) goto L109;
        b r45 = (b) r18;
        TextView r46 = r45.a.b;
        if ((r1 instanceof OQueryText) == false) goto L100;
        OQueryText r47 = (OQueryText) r1;
    L101:
        if (r47 == null) goto L103;
        r28 = r47.getTitle();
    L103:
        if (r28 == null) goto L106;
        r8 = r28;
    L106:
        r46.setText(r8);
        we8.a.b(r45.a.b, i5.o(), false, null, null, 12);
        TextView r48 = r45.a.b;
        r48.setPadding(r2, r48.getPaddingTop(), r2, r48.getPaddingBottom());
        return;
    L100:
        r47 = null;
        goto L101
    L109:
        throw new IllegalArgumentException("view holder type not support: ".concat(r18.getClass().getName()));
    L5:
        r2 = 0;
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        if (r6 != 0) goto L5;
        View r7 = LayoutInflater.from(r5.getContext()).inflate(2131563941, r5, false);
        if (r7 == null) goto L27;
        TextView r8 = (TextView) r7;
        RecyclerView.ViewHolder r9 = new d(new ObricBlockLocalSearchItemTextBinding(r8, r8));
    L25:
        return r9;
    L27:
        throw new NullPointerException("rootView");
    L5:
        if (r6 != 1) goto L7;
        View r10 = LayoutInflater.from(r5.getContext()).inflate(2131563942, r5, false);
        int r0 = 2131384866;
        RecyclerView r1 = ViewBindings.findChildViewById(r10, 2131384866);
        if (r1 == null) goto L21;
        r0 = 2131388772;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r10, 2131388772);
        if (r2 == null) goto L21;
        r9 = new c(new ObricBlockLocalSearchItemWithRowBinding((LinearLayout) r10, r1, r2));
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    L7:
        if (r6 != 2) goto L14;
        View r11 = LayoutInflater.from(r5.getContext()).inflate(2131563940, r5, false);
        if (r11 == null) goto L12;
        TextView r12 = (TextView) r11;
        r9 = new b(new ObricBlockLocalSearchItemQueryBinding(r12, r12));
        goto L25
    L12:
        throw new NullPointerException("rootView");
    L14:
        throw new IllegalArgumentException("view type not support: " + r6);
    }

    public final void y2(List<OSearchReference> r5, boolean r6) {
        ((ArrayList) this.a).clear();
        this.b = r6;
        if (r5 == null) goto L23;
        ArrayList r7 = new ArrayList();
        Iterator<T> r8 = r5.iterator();
    L6:
        if (r8.hasNext() == false) goto L22;
        OSearchReference r0 = (OSearchReference) r8.next();
        if (r0.getTextCard() == null) goto L11;
        TextCard r1 = r0.getTextCard();
    L20:
        if (r1 == null) goto L6;
        r7.add(r1);
        goto L6
    L11:
        if (r0.getOEntityText() == null) goto L14;
        r1 = r0.getOEntityText();
        goto L20
    L14:
        if (r0.getOEntityCollection() == null) goto L17;
        r1 = r0.getOEntityCollection();
        goto L20
    L17:
        if (r0.getOQueryText() == null) goto L19;
        r1 = r0.getOQueryText();
        goto L20
    L19:
        FLogger.a.w("SearchLocalItemAdapter", "invalid item " + r0);
        r1 = Unit.INSTANCE;
        goto L20
    L22:
        ((ArrayList) this.a).addAll(CollectionsKt.sortedWith(r7, new e(this)));
    L23:
        notifyDataSetChanged();
    }
}
