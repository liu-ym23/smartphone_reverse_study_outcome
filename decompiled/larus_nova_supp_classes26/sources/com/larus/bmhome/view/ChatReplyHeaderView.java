package com.larus.bmhome.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.chat.common.databinding.LarusLayoutChatReplyHeaderBinding;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.IFlowThemeConfigProvider;
import com.larus.platform.api.ThemeColorKey;
import com.larus.platform.api.ThemeConfigScene;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.platform.service.n0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J5\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0015J\u0006\u0010\u0016\u001a\u00020\u000eR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/larus/bmhome/view/ChatReplyHeaderView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/chat/common/databinding/LarusLayoutChatReplyHeaderBinding;", "setImmerseMode", "show", "", ShareType.TEXT, "", "isImmerse", "", "isSelf", "hintResId", "(Ljava/lang/String;Ljava/lang/Boolean;ZLjava/lang/Integer;)V", "hide", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatReplyHeaderView extends LinearLayout {
    public static final /* synthetic */ int b = 0;
    public final LarusLayoutChatReplyHeaderBinding a;

    public ChatReplyHeaderView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ChatReplyHeaderView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public ChatReplyHeaderView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131562782, this);
        int r5 = 2131384353;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(this, 2131384353);
        if (r6 == null) goto L9;
        r5 = 2131384362;
        TextView r7 = (TextView) ViewBindings.findChildViewById(this, 2131384362);
        if (r7 == null) goto L9;
        this.a = new LarusLayoutChatReplyHeaderBinding(this, r6, r7);
        return;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r5)));
    }

    public /* synthetic */ ChatReplyHeaderView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void a(String r7, Boolean r8, boolean r9, Integer r10) {
        Intrinsics.checkNotNullParameter(r7, ShareType.TEXT);
        LarusLayoutChatReplyHeaderBinding r0 = this.a;
        if (r0 == null) goto L41;
        Boolean r1 = Boolean.TRUE;
        if (Intrinsics.areEqual(r8, r1) == false) goto L13;
        LarusLayoutChatReplyHeaderBinding r2 = this.a;
        if (r2 == null) goto L13;
        r2.c.setTextColor(ve8.d.a(2131106540, AppHost.a.getApplication()));
        ImageView r3 = r2.b;
        if (n0.a.b() == false) goto L11;
        int r4 = 2131241862;
    L12:
        r3.setImageResource(r4);
        goto L13
    L11:
        r4 = 2131241863;
    L13:
        r0.c.setText(r7);
        if (r9 == true) goto L17;
        r0.c.setTextColor(ve8.d.a(2131103684, AppHost.a.getApplication()));
        r0.b.setImageResource(2131241865);
    L21:
        if (r10 != null) goto L23;
    L25:
        if (r9 == false) goto L41;
        if (n0.a.b() == false) goto L29;
        r0.c.setAlpha(1.0f);
    L29:
        IFlowThemeConfigProvider r11 = (IFlowThemeConfigProvider) ServiceManager.get().getService(IFlowThemeConfigProvider.class);
        if (r11 == null) goto L32;
        r11.d(r0.c, ThemeColorKey.MESSAGE_REPLY_TEXT_COLOR, ThemeConfigScene.CHAT, AdaptThemeFeatureKey.MESSAGE_REPLY_TEXT_COLOR);
    L32:
        IFlowThemeConfigProvider r12 = (IFlowThemeConfigProvider) ServiceManager.get().getService(IFlowThemeConfigProvider.class);
        if (r12 == null) goto L35;
        r12.c(r0.b, ThemeColorKey.MESSAGE_REPLY_LINE_COLOR, ThemeConfigScene.CHAT, AdaptThemeFeatureKey.MESSAGE_REPLY_LINE_COLOR);
    L35:
        if (r10 == null) goto L41;
        if (r10.intValue() == 0) goto L41;
        IFlowThemeConfigProvider r13 = (IFlowThemeConfigProvider) ServiceManager.get().getService(IFlowThemeConfigProvider.class);
        if (r13 == null) goto L41;
        r13.c(r0.b, ThemeColorKey.MESSAGE_REPLY_ICON_COLOR, ThemeConfigScene.CHAT, AdaptThemeFeatureKey.MESSAGE_REPLY_ICON_COLOR);
        goto L41
    L23:
        if (r10.intValue() == 0) goto L25;
        r0.b.setImageResource(r10.intValue());
        goto L25
    L17:
        if (n0.a.b() == false) goto L21;
        if (Intrinsics.areEqual(r8, r1) == true) goto L21;
        r0.b.setImageResource(2131241860);
    L41:
        setVisibility(0);
    }
}
