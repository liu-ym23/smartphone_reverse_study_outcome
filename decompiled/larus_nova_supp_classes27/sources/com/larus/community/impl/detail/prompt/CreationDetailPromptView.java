package com.larus.community.impl.detail.prompt;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.view.resourcebar.bean.ResourceType;
import com.larus.community.impl.databinding.LarusCommunityCreationDetailPromptLayoutBinding;
import com.larus.community.impl.detail.bottomtools.CreationDetailBottomToolsView;
import com.larus.platform.api.creation.AuthorInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationRefContent;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.larus.platform.service.AccountService;
import com.larus.ugc.community.adapter.RefViewAdapter;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import v19.b7;
import v19.r5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\u001c\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\b\u0010\u001d\u001a\u00020\u0014H\u0002J\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010 \u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000bH\u0002J\"\u0010!\u001a\u00020\u00142\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\rH\u0002J$\u0010%\u001a\u00020\u00142\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010(\u001a\u0004\u0018\u00010#H\u0002J\u001a\u0010)\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000b2\b\u0010(\u001a\u0004\u0018\u00010#H\u0002J\u001a\u0010*\u001a\u00020\u00142\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010\n\u001a\u00020\u000bH\u0002J+\u0010+\u001a\u00020\u00142\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010,\u001a\u00020\rH\u0002¢\u0006\u0002\u0010-J\u000e\u0010.\u001a\u00020\u00142\u0006\u0010/\u001a\u00020\rJ2\u00100\u001a\u00020\u00142\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0014\u00102\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u000104\u0012\u0004\u0012\u00020\u0014032\u0006\u00105\u001a\u00020\rJ\u0010\u00106\u001a\u00020\u00142\b\u00107\u001a\u0004\u0018\u000108J\u0010\u00109\u001a\u00020\u00142\b\u0010:\u001a\u0004\u0018\u00010;J\u0006\u0010<\u001a\u00020=J\u0006\u0010>\u001a\u00020=R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018¨\u0006?"}, d2 = {"Lcom/larus/community/impl/detail/prompt/CreationDetailPromptView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/community/impl/databinding/LarusCommunityCreationDetailPromptLayoutBinding;", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "usageCount", "", "refViewAdapter", "Lcom/larus/ugc/community/adapter/RefViewAdapter;", "creationTrackParamsWrap", "Lcom/larus/community/impl/detail/model/CreationTrackParamsWrap;", "onRefVideoOpenListener", "Lkotlin/Function0;", "", "getOnRefVideoOpenListener", "()Lkotlin/jvm/functions/Function0;", "setOnRefVideoOpenListener", "(Lkotlin/jvm/functions/Function0;)V", "onRefVideoCloseListener", "getOnRefVideoCloseListener", "setOnRefVideoCloseListener", "bindCreation", "fillCaptionText", "fillPromptText", "fillPromptToolView", "fillRefImage", "onClickRefMedia", "item", "Lcom/larus/ugc/community/adapter/RefData;", "canShowRefImageDetail", "openRefImageViewerDialog", "resourceType", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceType;", "refData", "openRefVideoViewerDialog", "mobClickCreationReferenceByType", "fillUseCountText", "forceNoRefDesc", "(Lcom/larus/platform/api/creation/UserCreation;Ljava/lang/Boolean;Z)V", "updateInspirationVisible", "isVisible", "bindAction", "likeAction", "makeSameAction", "Lkotlin/Function1;", "", "makeSameEnabled", "bindCreationLikeState", "likeState", "Lcom/larus/community/impl/detail/bottomtools/CreationLikeState;", "bindCreationRefImagePublicState", "refImagePublicState", "Lcom/larus/community/impl/detail/toptools/CreationRefImagePublicState;", "getToolsView", "Landroid/view/View;", "getUsageCount", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationDetailPromptView extends ConstraintLayout {
    public static final /* synthetic */ int h = 0;
    public final LarusCommunityCreationDetailPromptLayoutBinding a;
    public UserCreation b;
    public boolean c;
    public RefViewAdapter d;
    public j29.a e;
    public Function0<Unit> f;
    public Function0<Unit> g;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ResourceType.values().length];
            r0[ResourceType.VIDEO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ResourceType.AUDIO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public final View getToolsView() {
        return this.a.e;
    }

    public final View getUsageCount() {
        return this.a.g;
    }

    public final Function0<Unit> getOnRefVideoCloseListener() {
        return this.g;
    }

    public final Function0<Unit> getOnRefVideoOpenListener() {
        return this.f;
    }

    public CreationDetailPromptView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void setOnRefVideoCloseListener(Function0<Unit> r1) {
        this.g = r1;
    }

    public final void setOnRefVideoOpenListener(Function0<Unit> r1) {
        this.f = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CreationDetailPromptView(Context r9, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10);
        LayoutInflater.from(r9).inflate(2131561933, this);
        int r11 = 2131365139;
        AppCompatTextView r2 = ViewBindings.findChildViewById(this, 2131365139);
        if (r2 == null) goto L17;
        r11 = 2131369197;
        View r3 = ViewBindings.findChildViewById(this, 2131369197);
        if (r3 == null) goto L17;
        r11 = 2131383392;
        AppCompatTextView r4 = ViewBindings.findChildViewById(this, 2131383392);
        if (r4 == null) goto L17;
        r11 = 2131383393;
        CreationDetailBottomToolsView r5 = (CreationDetailBottomToolsView) ViewBindings.findChildViewById(this, 2131383393);
        if (r5 == null) goto L17;
        r11 = 2131384997;
        RecyclerView r6 = ViewBindings.findChildViewById(this, 2131384997);
        if (r6 == null) goto L17;
        r11 = 2131391970;
        AppCompatTextView r7 = ViewBindings.findChildViewById(this, 2131391970);
        if (r7 == null) goto L17;
        this.a = new LarusCommunityCreationDetailPromptLayoutBinding(this, r2, r3, r4, r5, r6, r7);
        return;
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r11)));
    }

    public final void S5(ResourceType r9, UserCreation r10) {
        j29.a r0 = this.e;
        String r1 = null;
        if (r0 == null) goto L7;
        zp9.g r2 = r0.a;
        if (r2 == null) goto L7;
        String r3 = r2.a;
    L8:
        String r4 = String.valueOf(r3);
        j29.a r5 = this.e;
        if (r5 == null) goto L13;
        zp9.g r6 = r5.a;
        if (r6 == null) goto L13;
        String r7 = r6.b;
    L14:
        String r8 = r10.a;
        UserCreationTrackParams r11 = r10.n;
        if (r11 == null) goto L17;
        r1 = r11.a;
    L17:
        String r12 = zp9.d.d(r10);
        String r13 = zp9.d.c(r10);
        JSONObject r14 = new JSONObject();
        Intrinsics.checkNotNullParameter(r14, "params");
        if (r9 != null) goto L20;
        int r15 = -1;
    L22:
        if (r15 != 1) goto L24;
        String r16 = "click_creation_avatar_reference";
    L37:
        r14.putOpt("current_page", r4);     // Catch: JSONException -> L33
        r14.putOpt("recommend_from", r7);     // Catch: JSONException -> L33
        r14.putOpt("template_id", r8);     // Catch: JSONException -> L33
        r14.putOpt("template_rec_req_id", r1);     // Catch: JSONException -> L33
        r14.putOpt("template_sub_type", r13);     // Catch: JSONException -> L33
        r14.putOpt("template_type", r12);     // Catch: JSONException -> L33
        r14.putOpt("click_from", "caption_detail");     // Catch: JSONException -> L33
    L35:
        TrackParams r17 = new TrackParams().merge(r14);
        by7.a r18 = new by7.a(r16);
        r18.a.merge(r17);
        r18.b();
        return;
    L33:
        e = move-exception;
        FLogger.a.e("CommunityEventHelper", "error in CommunityEventHelper mobClickCreationReference " + e.getLocalizedMessage());
        goto L35
    L24:
        if (r15 != 2) goto L26;
        r16 = "click_creation_image_reference";
        goto L37
    L26:
        if (r15 != 3) goto L39;
        r16 = "click_creation_video_reference";
        goto L37
    L39:
        return;
    L20:
        r15 = p29.a.C0135a.a[r9.ordinal()];
    L13:
        r7 = null;
    L7:
        r3 = null;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(UserCreation r16, Boolean r17, boolean r18) {
        if (r16 != null) goto L5;
        return;
    L5:
        if (r17 == null) goto L87;
        r17.booleanValue();
        boolean r2 = true;
        long r4 = 0;
        String r8 = null;
        String r9 = "";
        if (r16.m == null) goto L34;
        if (r17.booleanValue() == false) goto L28;
        StringBuilder r1 = new StringBuilder();
        int r10 = b7.a;
        Long r11 = r16.m;
        if (r11 == null) goto L13;
        long r12 = r11.longValue();
    L14:
        r1.append(b7.a(r12));
        r1.append(" · ");
        Context r13 = getContext();
        if (r13 == null) goto L26;
        Resources r14 = r13.getResources();
        if (r14 == null) goto L26;
        Long r15 = r16.f;
        if (r15 == null) goto L21;
        int r110 = (int) r15.longValue();
    L22:
        Object[] r111 = new Object[1];
        int r112 = r5.a;
        Context r113 = getContext();
        Long r114 = r16.f;
        if (r114 == null) goto L25;
        r4 = r114.longValue();
    L25:
        r111[0] = r5.a(r113, r4);
        String r5 = r14.getQuantityString(2131755159, r110, r111);
    L27:
        r1.append(r5);
        String r3 = r1.toString();
    L49:
        UserCreationRefContent r6 = r16.o;
        if (r6 == null) goto L56;
        List r7 = r6.c;
        if (r7 == null) goto L56;
        if ((!r7.isEmpty()) != true) goto L56;
        boolean r20 = true;
    L57:
        if (r20 == false) goto L78;
        if (r18 == true) goto L78;
        AuthorInfo r0 = r16.g;
        if (r0 == null) goto L63;
        r8 = r0.b;
    L63:
        if (Intrinsics.areEqual(r8, AccountService.a.getUserId()) == false) goto L78;
        if (q29.i.a() == false) goto L71;
        Resources r21 = getResources();
        if (r21 == null) goto L78;
        String r22 = r21.getString(2131901210);
        if (r22 == null) goto L78;
    L76:
        r9 = r22;
        goto L78
    L71:
        Resources r23 = getResources();
        if (r23 == null) goto L78;
        r22 = r23.getString(2131906332);
        if (r22 != null) goto L76;
    L78:
        if (r9.length() == 0) goto L81;
        r2 = false;
    L81:
        if (r2 == true) goto L84;
        r3 = r3 + " · " + r9;
    L84:
        this.a.g.setText(r3);
        return;
    L56:
        r20 = false;
        goto L57
    L21:
        r110 = 0;
    L26:
        r5 = null;
        goto L27
    L13:
        r12 = System.currentTimeMillis();
        goto L14
    L28:
        int r24 = b7.a;
        Long r25 = r16.m;
        if (r25 == null) goto L31;
        long r26 = r25.longValue();
    L32:
        r3 = b7.a(r26);
        goto L49
    L31:
        r26 = System.currentTimeMillis();
        goto L32
    L34:
        if (r17.booleanValue() == false) goto L48;
        Context r27 = getContext();
        if (r27 == null) goto L47;
        Resources r28 = r27.getResources();
        if (r28 == null) goto L47;
        Long r115 = r16.f;
        if (r115 == null) goto L42;
        int r116 = (int) r115.longValue();
    L43:
        Object[] r117 = new Object[1];
        int r118 = r5.a;
        Context r119 = getContext();
        Long r120 = r16.f;
        if (r120 == null) goto L46;
        r4 = r120.longValue();
    L46:
        r117[0] = r5.a(r119, r4);
        r3 = r28.getQuantityString(2131755159, r116, r117);
        goto L49
    L42:
        r116 = 0;
    L47:
        r3 = null;
        goto L49
    L48:
        r3 = "";
        goto L49
    }
}
