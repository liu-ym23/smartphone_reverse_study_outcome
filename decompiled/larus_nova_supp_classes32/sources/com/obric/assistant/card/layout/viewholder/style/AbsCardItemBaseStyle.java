package com.obric.assistant.card.layout.viewholder.style;

import androidx.viewbinding.ViewBinding;
import com.bytedance.keva.Keva;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.image.loader.ImageLoaderKt;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.xelement.webview.LynxUIWebView;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.layout.viewholder.abs.AbsCardItemViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lca.a;
import xg9.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004B\u000f\u0012\u0006\u0010\u0005\u001a\u00028\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0004J\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J$\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0015J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0014J \u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemBaseStyle;", "T", "V", "Landroidx/viewbinding/ViewBinding;", "Lcom/obric/assistant/card/layout/viewholder/abs/AbsCardItemViewHolder;", "viewBinding", "<init>", "(Landroidx/viewbinding/ViewBinding;)V", "keva", "Lcom/bytedance/keva/Keva;", "setImageResource", NameKeys.UnloadStrategy_No_Strategy, "imageView", "Lcom/facebook/drawee/view/GenericDraweeView;", "res", "Lcom/obric/assistant/card/layout/bean/HybridResource;", "loadImage", LynxResourceModule.URI_KEY, "Landroid/net/Uri;", "setEnabled", "isEnabled", NameKeys.UnloadStrategy_No_Strategy, "messageId", NameKeys.UnloadStrategy_No_Strategy, "isLatestMessage", "onEnabledStateChanged", "setAlphaAnimated", "view", "Landroid/view/View;", "targetAlpha", NameKeys.UnloadStrategy_No_Strategy, "duration", NameKeys.UnloadStrategy_No_Strategy, "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsCardItemBaseStyle<T, V extends ViewBinding> extends AbsCardItemViewHolder<T, V> {
    public static final /* synthetic */ int k = 0;
    public final Keva j;

    public void X3(boolean r1) {
    }

    public AbsCardItemBaseStyle(V r2) {
        Intrinsics.checkNotNullParameter(r2, "viewBinding");
        super(r2, true);
        this.j = b.a();
    }

    public static void Z3(SimpleDraweeView r8, a r9) {
        Intrinsics.checkNotNullParameter(r8, "imageView");
        if (r9 == null) goto L5;
        RoundingParams r0 = r9.c;
    L6:
        if (r0 == null) goto L8;
        r8.getHierarchy().setRoundingParams(r9.c);
    L8:
        int r1 = 0;
        if (r9 != null) goto L13;
        r8.setImageResource(0);
        return;
    L13:
        if (r9.b == null) goto L18;
        GenericDraweeHierarchy r2 = r8.getHierarchy();
        Integer r3 = r9.a;
        if (r3 == null) goto L17;
        r1 = r3.intValue();
    L17:
        r2.setPlaceholderImage(r1);
        ImageLoaderKt.x(r8, r9.b, "obric_chat.cards", null, new rca.a(), 4);
        return;
    L18:
        Integer r10 = r9.a;
        if (r10 == null) goto L21;
        r8.setImageResource(r10.intValue());
        return;
    L21:
        r8.setImageResource(0);
        return;
    L5:
        r0 = null;
        goto L6
    }

    public final void Y3(boolean r7, String r8, boolean r9) {
        if (r7 == false) goto L4;
        float r0 = 1.0f;
    L6:
        if (r9 == false) goto L12;
        Keva r10 = this.j;
        if (r8 != null) goto L10;
        r8 = NameKeys.UnloadStrategy_No_Strategy;
    L10:
        r10.storeString("last_card_show_message_id", r8);
        this.a.getRoot().animate().alpha(r0).setDuration(0).start();
    L15:
        X3(r7);
        return;
    L12:
        if (Intrinsics.areEqual(r8, this.j.getString("last_card_show_message_id", LynxUIWebView.DEFAULT)) == false) goto L14;
        this.j.storeString("last_card_show_message_id", NameKeys.UnloadStrategy_No_Strategy);
        this.a.getRoot().animate().alpha(r0).setDuration(500).start();
        goto L15
    L14:
        this.a.getRoot().animate().alpha(r0).setDuration(0).start();
        goto L15
    L4:
        r0 = 0.3f;
        goto L6
    }
}
