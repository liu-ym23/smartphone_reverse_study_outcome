package com.obric.aiproactive.ui.preference;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiproactive.api.AiRuleItemDto;
import com.obric.memorydata.plugin.R;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.text.OTextView;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005 !\"#$B/\u0012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0004\b\n\u0010\u000bJ&\u0010\u000f\u001a\u00020\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0017H\u0016J\u0018\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001f\u001a\u00020\u0017H\u0016R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/obric/aiproactive/ui/preference/AiRuleAdapter;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$Adapter;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "onLongPressRule", "Lkotlin/Function2;", "Landroid/view/View;", "Lcom/obric/aiproactive/api/AiRuleItemDto;", "", "onGuidedEntryClick", "Lkotlin/Function0;", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "items", "", "Lcom/obric/aiproactive/ui/preference/AiRuleAdapter$AdapterItem;", "setData", "rules", "", "latestAssistantUpdatedText", "", "showGuidedEntry", "", "getItemViewType", "", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "getItemCount", "Companion", "AdapterItem", "HeaderViewHolder", "RuleViewHolder", "GuidedEntryViewHolder", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b extends RecyclerView.Adapter<RecyclerView.v> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0310b f6757a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function2<View, AiRuleItemDto, Unit> f6758b;
    private final Function0<Unit> c;
    private final List<a> d;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/obric/aiproactive/ui/preference/AiRuleAdapter$AdapterItem;", "", "<init>", "()V", "Header", "Rule", "GuidedEntry", "Lcom/obric/aiproactive/ui/preference/AiRuleAdapter$AdapterItem$GuidedEntry;", "Lcom/obric/aiproactive/ui/preference/AiRuleAdapter$AdapterItem$Header;", "Lcom/obric/aiproactive/ui/preference/AiRuleAdapter$AdapterItem$Rule;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static abstract class a {

        /* JADX INFO: renamed from: com.obric.aiproactive.ui.preference.b$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/aiproactive/ui/preference/AiRuleAdapter$AdapterItem$GuidedEntry;", "Lcom/obric/aiproactive/ui/preference/AiRuleAdapter$AdapterItem;", "<init>", "()V", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class C0308a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0308a f6759a = null;

            static {
                f6759a = new C0308a();
            }

            private C0308a() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: com.obric.aiproactive.ui.preference.b$a$b, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/obric/aiproactive/ui/preference/AiRuleAdapter$AdapterItem$Header;", "Lcom/obric/aiproactive/ui/preference/AiRuleAdapter$AdapterItem;", "title", "", "subtitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getSubtitle", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class C0309b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f6760a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final String f6761b;

            public C0309b(String r2, String r3) {
                Intrinsics.checkNotNullParameter(r2, "title");
                super(null);
                this.f6760a = r2;
                this.f6761b = r3;
            }

            public final String a() {
                return this.f6760a;
            }

            public final String b() {
                return this.f6761b;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, C0309b.class) == true) goto L8;
                return false;
            L8:
                C0309b r6 = (C0309b) ZeusTransformUtils.preCheckCast(r5, C0309b.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.f6760a, r6.f6760a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f6761b, r6.f6761b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public int hashCode() {
                int r0 = this.f6760a.hashCode() * 31;
                String r1 = this.f6761b;
                if (r1 != null) goto L5;
                int r2 = 0;
            L7:
                return r0 + r2;
            L5:
                r2 = r1.hashCode();
                goto L7
            }

            public String toString() {
                return "Header(title=" + this.f6760a + ", subtitle=" + this.f6761b + ')';
            }
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/obric/aiproactive/ui/preference/AiRuleAdapter$AdapterItem$Rule;", "Lcom/obric/aiproactive/ui/preference/AiRuleAdapter$AdapterItem;", "rule", "Lcom/obric/aiproactive/api/AiRuleItemDto;", "positionType", "", "showDivider", "", "<init>", "(Lcom/obric/aiproactive/api/AiRuleItemDto;IZ)V", "getRule", "()Lcom/obric/aiproactive/api/AiRuleItemDto;", "getPositionType", "()I", "getShowDivider", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class c extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final AiRuleItemDto f6762a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final int f6763b;
            private final boolean c;

            public c(AiRuleItemDto r2, int r3, boolean r4) {
                Intrinsics.checkNotNullParameter(r2, "rule");
                super(null);
                this.f6762a = r2;
                this.f6763b = r3;
                this.c = r4;
            }

            public final AiRuleItemDto a() {
                return this.f6762a;
            }

            public final int b() {
                return this.f6763b;
            }

            public final boolean c() {
                return this.c;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
                return false;
            L8:
                c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.f6762a, r6.f6762a) == true) goto L12;
                return false;
            L12:
                if (this.f6763b == r6.f6763b) goto L15;
                return false;
            L15:
                if (this.c == r6.c) goto L17;
                return false;
            L17:
                return true;
            }

            public int hashCode() {
                return (((this.f6762a.hashCode() * 31) + Integer.hashCode(this.f6763b)) * 31) + Boolean.hashCode(this.c);
            }

            public String toString() {
                return "Rule(rule=" + this.f6762a + ", positionType=" + this.f6763b + ", showDivider=" + this.c + ')';
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.preference.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/aiproactive/ui/preference/AiRuleAdapter$Companion;", "", "<init>", "()V", "TYPE_HEADER", "", "TYPE_RULE", "TYPE_GUIDED_ENTRY", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0310b {
        private C0310b() {
        }

        public /* synthetic */ C0310b(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/aiproactive/ui/preference/AiRuleAdapter$GuidedEntryViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends RecyclerView.v {
        public c(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/aiproactive/ui/preference/AiRuleAdapter$HeaderViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "sectionTitle", "Lcom/obric/oui/sectiontitlebar/OSectionTitleBar;", "getSectionTitle", "()Lcom/obric/oui/sectiontitlebar/OSectionTitleBar;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d extends RecyclerView.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final OSectionTitleBar f6764a;

        public d(View r4) {
            Intrinsics.checkNotNullParameter(r4, "view");
            super(r4);
            View r5 = r4.findViewById(ZeusTransformUtils.mapRes(R.id.section_title, OaidModel.KEY_ID, "section_title"));
            Intrinsics.checkNotNullExpressionValue(r5, "findViewById(...)");
            this.f6764a = (OSectionTitleBar) ZeusTransformUtils.preCheckCast(r5, OSectionTitleBar.class, "com.obric.memorydata.plugin");
        }

        public final OSectionTitleBar a() {
            return this.f6764a;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/aiproactive/ui/preference/AiRuleAdapter$RuleViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "cardItem", "Lcom/obric/oui/lisitem/OCardListItem;", "getCardItem", "()Lcom/obric/oui/lisitem/OCardListItem;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e extends RecyclerView.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final OCardListItem f6765a;

        public e(View r4) {
            Intrinsics.checkNotNullParameter(r4, "view");
            super(r4);
            View r5 = r4.findViewById(ZeusTransformUtils.mapRes(R.id.card_item, OaidModel.KEY_ID, "card_item"));
            Intrinsics.checkNotNullExpressionValue(r5, "findViewById(...)");
            this.f6765a = (OCardListItem) ZeusTransformUtils.preCheckCast(r5, OCardListItem.class, "com.obric.memorydata.plugin");
        }

        public final OCardListItem a() {
            return this.f6765a;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/aiproactive/ui/preference/AiRuleAdapter$onBindViewHolder$1$2", "Lcom/obric/oui/popover/OnLongClickListenerEx;", "onLongClick", "", BaseSwitches.V, "Landroid/view/View;", "rawPos", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class f extends com.obric.oui.popover.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f6766a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AiRuleItemDto f6767b;

        f(b r1, AiRuleItemDto r2) {
            this.f6766a = r1;
            this.f6767b = r2;
        }

        @Override // com.obric.oui.popover.f
        public boolean a(View r2, int[] r3) {
            Intrinsics.checkNotNullParameter(r2, BaseSwitches.V);
            Intrinsics.checkNotNullParameter(r3, "rawPos");
            b.a(this.f6766a).invoke(r2, this.f6767b);
            return true;
        }
    }

    static {
        f6757a = new C0310b(null);
    }

    public b(Function2<? super View, ? super AiRuleItemDto, Unit> r3, Function0<Unit> r4) {
        Function2<View, AiRuleItemDto, Unit> r5 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
        Function0<Unit> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "onLongPressRule");
        Intrinsics.checkNotNullParameter(r6, "onGuidedEntryClick");
        this.f6758b = r5;
        this.c = r6;
        this.d = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ Function2 a(b r0) {
        return r0.f6758b;
    }

    private static final void a(b r0, View r1) {
        r0.c.invoke();
    }

    public static /* synthetic */ void lambda$BKuSiPDbymp6lTlRAHJ3gJQO2u0(b r0, View r1) {
        a(r0, r1);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int a(int r2) {
        a r1 = (a) ZeusTransformUtils.preCheckCast(this.d.get(r2), a.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, a.C0309b.class) == false) goto L6;
        return 0;
    L6:
        if (ZeusTransformUtils.instanceOf(r1, a.c.class) == false) goto L9;
        return 1;
    L9:
        if (ZeusTransformUtils.instanceOf(r1, a.C0308a.class) == false) goto L13;
        return 2;
    L13:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public RecyclerView.v a(ViewGroup r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "parent");
        LayoutInflater r6 = LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        if (r8 != 0) goto L5;
        View r9 = ZeusTransformUtils.inflate(r6, ZeusTransformUtils.mapRes(R.layout.item_ai_rule_header, "layout", "item_ai_rule_header"), r7, false, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r9, "inflate(...)");
        Object r10 = new d(r9);
    L10:
        return (RecyclerView.v) ZeusTransformUtils.preCheckCast(r10, RecyclerView.v.class, "com.obric.memorydata.plugin");
    L5:
        if (r8 == 1) goto L7;
        View r11 = ZeusTransformUtils.inflate(r6, ZeusTransformUtils.mapRes(R.layout.layout_guided_preference_entry_card_preference, "layout", "layout_guided_preference_entry_card_preference"), r7, false, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r11, "inflate(...)");
        r10 = new c(r11);
        goto L10
    L7:
        View r12 = ZeusTransformUtils.inflate(r6, ZeusTransformUtils.mapRes(R.layout.item_ai_rule, "layout", "item_ai_rule"), r7, false, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r12, "inflate(...)");
        r10 = new e(r12);
        goto L10
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public void a(RecyclerView.v r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "holder");
        a r11 = (a) ZeusTransformUtils.preCheckCast(this.d.get(r10), a.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, d.class) == false) goto L15;
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type com.obric.aiproactive.ui.preference.AiRuleAdapter.AdapterItem.Header");
        a.C0309b r8 = (a.C0309b) ZeusTransformUtils.preCheckCast(r11, a.C0309b.class, "com.obric.memorydata.plugin");
        int r12 = (int) com.obric.oui.common.util.h.a(28.0f);
        if (r8.b() == null) goto L7;
        float r0 = 24.0f;
    L8:
        int r1 = (int) com.obric.oui.common.util.h.a(r0);
        ((d) ZeusTransformUtils.preCheckCast(r9, d.class, "com.obric.memorydata.plugin")).a().setPaddingRelative(r12, r1, r12, 0);
        ((d) ZeusTransformUtils.preCheckCast(r9, d.class, "com.obric.memorydata.plugin")).a().setTitleText((CharSequence) ZeusTransformUtils.preCheckCast(r8.a(), CharSequence.class, "com.obric.memorydata.plugin"));
        if (r8.b() == null) goto L13;
        ((d) ZeusTransformUtils.preCheckCast(r9, d.class, "com.obric.memorydata.plugin")).a().setDetailEndText((CharSequence) ZeusTransformUtils.preCheckCast(r8.b(), CharSequence.class, "com.obric.memorydata.plugin"));
        ((d) ZeusTransformUtils.preCheckCast(r9, d.class, "com.obric.memorydata.plugin")).a().a(true);
        OTextView r13 = ((d) ZeusTransformUtils.preCheckCast(r9, d.class, "com.obric.memorydata.plugin")).a().getEndDetail();
        if (r13 == null) goto L26;
        r13.setTextColor(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.ai_proactive_demo_text_disabled, TypedValues.Custom.S_COLOR, "ai_proactive_demo_text_disabled")));
        return;
    L26:
        return;
    L13:
        ((d) ZeusTransformUtils.preCheckCast(r9, d.class, "com.obric.memorydata.plugin")).a().a(false);
        ((d) ZeusTransformUtils.preCheckCast(r9, d.class, "com.obric.memorydata.plugin")).a().setDetailEndText((CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"));
        return;
    L7:
        r0 = 8.0f;
        goto L8
    L15:
        if (ZeusTransformUtils.instanceOf(r9, e.class) == false) goto L23;
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type com.obric.aiproactive.ui.preference.AiRuleAdapter.AdapterItem.Rule");
        a.c r14 = (a.c) ZeusTransformUtils.preCheckCast(r11, a.c.class, "com.obric.memorydata.plugin");
        AiRuleItemDto r2 = r14.a();
        OCardListItem r4 = ((e) ZeusTransformUtils.preCheckCast(r9, e.class, "com.obric.memorydata.plugin")).a();
        r4.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(r2.getContent(), CharSequence.class, "com.obric.memorydata.plugin"));
        r4.setCardType(0);
        OCardListItem.a(r4, r14.b(), false, 2, null);
        r4.g(r14.c());
        if (r14.c() == false) goto L21;
        View r15 = r4.findViewById(ZeusTransformUtils.mapRes(R.id.card_divider, OaidModel.KEY_ID, "card_divider"));
        if (r15 == null) goto L21;
        r15.setBackgroundColor(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.ai_proactive_demo_line_subtle, TypedValues.Custom.S_COLOR, "ai_proactive_demo_line_subtle")));
    L21:
        com.obric.oui.popover.a.f14317a.a((View) ZeusTransformUtils.preCheckCast(r4.getContentContainer(), View.class, "com.obric.memorydata.plugin"), (com.obric.oui.popover.f) ZeusTransformUtils.preCheckCast(new f(this, r2), com.obric.oui.popover.f.class, "com.obric.memorydata.plugin"));
        return;
    L23:
        if (ZeusTransformUtils.instanceOf(r9, c.class) == false) goto L30;
        r9.c.setOnClickListener(new $$Lambda$b$BKuSiPDbymp6lTlRAHJ3gJQO2u0(this));
        return;
    }

    public final void a(List<AiRuleItemDto> r3, String r4, boolean r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "rules");
        this.d.clear();
        this.d.addAll((Collection) ZeusTransformUtils.preCheckCast(com.obric.aiproactive.ui.preference.c.a(r6, r4, r5), Collection.class, "com.obric.memorydata.plugin"));
        h();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int d() {
        return this.d.size();
    }
}
