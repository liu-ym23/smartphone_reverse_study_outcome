package com.ss.android.lark.contact.customized.search.view;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView;
import com.larksuite.framework.utils.ICUUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.tab.v1.space.DocTabPayload;
import com.ss.android.lark.contact.customized.common.OfficeContactUtils;
import com.ss.android.lark.contact.customized.databinding.ContactDbInviteExternalSearchResultItemLayoutBinding;
import com.ss.android.lark.image.ImageModule;
import com.ss.android.lark.image.entity.ListenerParams;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.q;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mtb.n;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000{\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\b\u0006*\u00010\b\u0007\u0018\u0000 32\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000234B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u0017J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bJ\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020 H\u0016J\u0010\u0010$\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010%\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010&\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0002H\u0016J\u0018\u0010'\u001a\u00020(2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\u000fH\u0002J \u0010*\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\t2\u0006\u0010#\u001a\u00020 2\u0006\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020\u0015H\u0002J\b\u00102\u001a\u00020 H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0004\n\u0002\u00101¨\u00065"}, d2 = {"Lcom/ss/android/lark/contact/customized/search/view/OfficeInviteExternalSearchAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/contact/customized/search/view/OfficeInviteExternalSearchAdapter$ViewHolder;", "fragment", "Landroidx/fragment/app/Fragment;", "<init>", "(Landroidx/fragment/app/Fragment;)V", "items", BuildConfig.FLAVOR, "Lcom/ss/android/lark/officesdk/contact/api/model/OfficeContactItemModel;", "exposedDbUserIds", "Ljava/util/HashSet;", BuildConfig.FLAVOR, "Lkotlin/collections/HashSet;", "query", BuildConfig.FLAVOR, "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "visibleRect", "Landroid/graphics/Rect;", "submitList", BuildConfig.FLAVOR, "list", BuildConfig.FLAVOR, "updateQuery", "updateStatus", ChameleonOpenTracker.ParamKey.RESULT, "Lcom/ss/android/lark/profile/dto/ProfileFinishResult;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", BuildConfig.FLAVOR, "onBindViewHolder", "holder", "position", "onAttachedToRecyclerView", "onDetachedFromRecyclerView", "onViewAttachedToWindow", "isDoubaoIdQuery", BuildConfig.FLAVOR, "doubaoId", "trackSearchResultShow", "item", "ratio", BuildConfig.FLAVOR, "checkHalfShownItems", "scrollListener", "com/ss/android/lark/contact/customized/search/view/OfficeInviteExternalSearchAdapter$scrollListener$1", "Lcom/ss/android/lark/contact/customized/search/view/OfficeInviteExternalSearchAdapter$scrollListener$1;", "getItemCount", "Companion", "ViewHolder", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeInviteExternalSearchAdapter extends RecyclerView.Adapter<ViewHolder> {
    public final Fragment a;
    public final List<mtb.d> b;
    public final HashSet<Long> c;
    public String d;
    public RecyclerView e;
    public final Rect f;
    public final OfficeInviteExternalSearchAdapter$scrollListener$1 g;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/contact/customized/search/view/OfficeInviteExternalSearchAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/ss/android/lark/contact/customized/databinding/ContactDbInviteExternalSearchResultItemLayoutBinding;", "<init>", "(Lcom/ss/android/lark/contact/customized/databinding/ContactDbInviteExternalSearchResultItemLayoutBinding;)V", "value", "Lcom/ss/android/lark/officesdk/contact/api/model/OfficeContactItemModel;", "boundItem", "getBoundItem", "()Lcom/ss/android/lark/officesdk/contact/api/model/OfficeContactItemModel;", "bind", BuildConfig.FLAVOR, "item", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public final ContactDbInviteExternalSearchResultItemLayoutBinding a;

        public ViewHolder(ContactDbInviteExternalSearchResultItemLayoutBinding r2) {
            Intrinsics.checkNotNullParameter(r2, "binding");
            super(r2.a);
            this.a = r2;
        }
    }

    public static final class a {
    }

    static {
    }

    public final int getItemCount() {
        return ((ArrayList) this.b).size();
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [com.ss.android.lark.contact.customized.search.view.OfficeInviteExternalSearchAdapter$scrollListener$1] */
    public OfficeInviteExternalSearchAdapter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
        this.b = new ArrayList();
        this.c = new HashSet();
        this.d = BuildConfig.FLAVOR;
        this.f = new Rect();
        this.g = new OfficeInviteExternalSearchAdapter$scrollListener$1(this);
    }

    public final void onAttachedToRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.onAttachedToRecyclerView(r2);
        this.e = r2;
        r2.addOnScrollListener(this.g);
    }

    public final void onDetachedFromRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        r2.removeOnScrollListener(this.g);
        this.e = null;
        super.onDetachedFromRecyclerView(r2);
    }

    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r4) {
        ViewHolder r5 = (ViewHolder) r4;
        Intrinsics.checkNotNullParameter(r5, "holder");
        super.onViewAttachedToWindow(r5);
        RecyclerView r0 = this.e;
        if (r0 == null) goto L26;
        LinearLayoutManager r1 = r0.getLayoutManager();
        if ((r1 instanceof LinearLayoutManager) == false) goto L8;
        LinearLayoutManager r2 = r1;
    L9:
        if (r2 == null) goto L27;
        int r3 = r5.getBindingAdapterPosition();
        if (r3 == (-1)) goto L24;
        if (r3 >= 0) goto L15;
    L17:
        boolean r6 = false;
    L18:
        if (r6 == false) goto L28;
        Lazy r7 = OfficeContactUtils.a;
        float r8 = OfficeContactUtils.d(((RecyclerView.ViewHolder) r5).itemView, r2.getOrientation(), this.f);
        if (r8 < 0.5f) goto L25;
        y2((mtb.d) ListProtector.get(this.b, r3), r3, r8);
        return;
    L25:
        return;
    L28:
        return;
    L15:
        if (r3 >= ((ArrayList) this.b).size()) goto L17;
        r6 = true;
        goto L18
    L24:
        return;
    L27:
        return;
    L8:
        r2 = null;
        goto L9
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r8, int r9) {
        ViewHolder r10 = (ViewHolder) r8;
        Intrinsics.checkNotNullParameter(r10, "holder");
        mtb.d r0 = (mtb.d) ListProtector.get(this.b, r9);
        q.a(((RecyclerView.ViewHolder) r10).itemView);
        ((RecyclerView.ViewHolder) r10).itemView.setOnClickListener(new com.ss.android.lark.contact.customized.search.view.a(this, r0, r9));
        Intrinsics.checkNotNullParameter(r0, "item");
        Context r11 = ((RecyclerView.ViewHolder) r10).itemView.getContext();
        LKUIRoundedImageView r1 = r10.a.b;
        String r2 = r0.g;
        String r3 = String.valueOf(r0.a);
        LoadParams r4 = new LoadParams();
        r4.a = UIHelper.dp2px(60.0f);
        r4.b = UIHelper.dp2px(60.0f);
        ListenerParams.a r5 = new ListenerParams.a();
        r5.d(Scene.Contact);
        r5.c(ListenerParams.FromType.AVATAR);
        r4.l = r5.b();
        ImageModule.a(r11, r1, r2, r3, r4);
        r10.a.e.setText(r0.c);
        if (r0.i == false) goto L5;
        r10.a.c.setText(UIHelper.getString(2131890055));
    L6:
        n r12 = r0.k;
        boolean r6 = false;
        if (r12 != null) goto L9;
    L11:
        boolean r7 = false;
    L13:
        if (r7 == false) goto L15;
        r10.a.d.setBackgroundResource(2131233647);
        r10.a.d.setTextColor(UIUtils.getColor(((RecyclerView.ViewHolder) r10).itemView.getContext(), 2131102042));
        r10.a.d.setText(UIHelper.getString(2131890032));
        return;
    L15:
        if (r12 != null) goto L17;
    L19:
        if (r6 == false) goto L21;
        r10.a.d.setBackgroundResource(2131233647);
        r10.a.d.setTextColor(UIUtils.getColor(((RecyclerView.ViewHolder) r10).itemView.getContext(), 2131102042));
        r10.a.d.setText(UIHelper.getString(2131890069));
        return;
    L21:
        r10.a.d.setBackgroundResource(2131233648);
        r10.a.d.setTextColor(UIUtils.getColor(((RecyclerView.ViewHolder) r10).itemView.getContext(), 2131102063));
        r10.a.d.setText(UIHelper.getString(2131890031));
        return;
    L17:
        if (r12.b != true) goto L19;
        r6 = true;
        goto L19
    L9:
        if (r12.a != true) goto L11;
        r7 = true;
        goto L13
    L5:
        ICUUtils.FormatArgsBuilder r13 = new ICUUtils.FormatArgsBuilder();
        r13.b("brandName", UIHelper.getAppName());
        r13.b("id", r0.h);
        List r14 = r13.a;
        String r15 = ICUUtils.icuFormat(UIHelper.getString(2131890051), r14);
        r10.a.c.setText(r15);
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "parent");
        View r10 = LayoutInflater.from(r8.getContext()).inflate(2131559914, r8, false);
        int r11 = 2131375629;
        LKUIRoundedImageView r3 = ViewBindings.findChildViewById(r10, 2131375629);
        if (r3 == null) goto L15;
        r11 = 2131375630;
        if (((LinearLayout) ViewBindings.findChildViewById(r10, 2131375630)) == null) goto L15;
        r11 = 2131375631;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r10, 2131375631);
        if (r4 == null) goto L15;
        r11 = 2131375632;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r10, 2131375632);
        if (r5 == null) goto L15;
        r11 = 2131375634;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r10, 2131375634);
        if (r6 == null) goto L15;
        return new ViewHolder(new ContactDbInviteExternalSearchResultItemLayoutBinding((LinearLayout) r10, r3, r4, r5, r6));
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public final void y2(mtb.d r7, int r8, float r9) {
        if (this.c.add(Long.valueOf(r7.b)) == true) goto L5;
        return;
    L5:
        Log.i("Contact_InvExternalSearchAdapter", "search_result_show exposed dbUserId=" + r7.b + " rank=" + r8 + " ratio=" + ((int) (r9 * 100)) + "% queryEmpty=" + StringsKt.isBlank(this.d));
        int r10 = com.ss.android.lark.contact.customized.common.b.a;
        boolean r0 = true;
        int r11 = !StringsKt.isBlank(this.d) ? 1 : 0;
        String r1 = String.valueOf(r7.b);
        String r12 = String.valueOf(r8);
        n r13 = r7.k;
        if (r13 != null) goto L8;
    L10:
        r0 = false;
    L11:
        if (r0 == false) goto L13;
        String r14 = "1";
    L14:
        Intrinsics.checkNotNullParameter("profile_add_friend", "currentPage");
        Intrinsics.checkNotNullParameter("contact", "functionType");
        Intrinsics.checkNotNullParameter("contact", "queryType");
        Intrinsics.checkNotNullParameter(r1, "entityId");
        Intrinsics.checkNotNullParameter(r12, "rank");
        Intrinsics.checkNotNullParameter(r14, "isAdded");
        Statistics.sendEvent("search_result_show", new JSONObject().put("current_page", "profile_add_friend").put("function_type", "contact").put("if_have_query", r11).put("query_type", "contact").put("entity_id", r1).put("rank", r12).put("is_added", r14));
        return;
    L13:
        r14 = DocTabPayload.DocType.UNKNOWN;
        goto L14
    L8:
        if (r13.a != true) goto L10;
        goto L10
    }
}
