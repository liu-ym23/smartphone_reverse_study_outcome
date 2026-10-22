package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.text2img;

import android.animation.ObjectAnimator;
import com.larus.bot.impl.bean.BotAvatarIconData;
import com.larus.bot.impl.databinding.LarusLayoutBotEditBgChoosePageBinding;
import com.larus.common_ui.view.ViewBindingHolder;
import com.larus.utils.e1;
import com.larus.utils.w0;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001(BX\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012-\u0010\u0004\u001a)\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0005\u0012\u0018\u0010\f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0013\u001a\u00020\u0007H\u0002J\u000e\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0002J\b\u0010\u0018\u001a\u00020\u000bH\u0002JC\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0010\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0018\u00010\u001d2\u0010\u0010\u001f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010 \u0018\u00010\u001d2\b\u0010!\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010\"J\u0017\u0010#\u001a\u00020\u000b2\b\u0010!\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010$J\u0010\u0010%\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010&\u001a\u00020\u000bH\u0002J\b\u0010'\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R5\u0010\u0004\u001a)\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\u000b0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/text2img/Text2BgImageBindingViewHolder;", "Lcom/larus/common_ui/view/ViewBindingHolder;", "binding", "Lcom/larus/bot/impl/databinding/LarusLayoutBotEditBgChoosePageBinding;", "onClickImage", "Lkotlin/Function2;", "Lkotlin/Function0;", "", "Lkotlin/ParameterName;", "name", "index", "", "onClickRetry", "Lkotlin/Function1;", "<init>", "(Lcom/larus/bot/impl/databinding/LarusLayoutBotEditBgChoosePageBinding;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "pageIndex", "lightLoadingAnimation", "Landroid/animation/ObjectAnimator;", "getPageIndex", "bindData", "itemData", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/text2img/Text2BgImageBindingViewHolder$AIGenBgImageData;", "disableClick", "showError", "showGeneratedImage", "isTwoRow", "", "urlList", "", "Landroid/net/Uri;", "uriList", "", "selectedImageIndex", "(ZLjava/util/List;Ljava/util/List;Ljava/lang/Integer;)V", "onImageSelect", "(Ljava/lang/Integer;)V", "showLoading", "showLoadingAnim", "hideLoadingAnim", "AIGenBgImageData", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Text2BgImageBindingViewHolder extends ViewBindingHolder {
    public static final /* synthetic */ int f = 0;
    public final LarusLayoutBotEditBgChoosePageBinding a;
    public final Function2<Function0<Integer>, Integer, Unit> b;
    public final Function1<Function0<Integer>, Unit> c;
    public int d;
    public ObjectAnimator e;

    public static final class a {
        public final com.larus.network.http.a<List<BotAvatarIconData>> a;
        public final boolean b;
        public final int c;
        public final Integer d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L6:
            int r2 = (((r0 + r1) * 31) + this.c) * 31;
            Integer r3 = this.d;
            if (r3 != null) goto L9;
            int r4 = 0;
        L11:
            return r2 + r4;
        L9:
            r4 = r3.hashCode();
            goto L11
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "AIGenBgImageData(state=" + this.a + ", isTwoRow=" + this.b + ", pageIndex=" + this.c + ", selectedImageIndex=" + this.d + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(com.larus.network.http.a<? extends List<BotAvatarIconData>> r2, boolean r3, int r4, Integer r5) {
            Intrinsics.checkNotNullParameter(r2, "state");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }

        public static a a(a r3, com.larus.network.http.f r4, Integer r5, int r6) {
            if ((r6 & 1) == 0) goto L5;
            r4 = r3.a;
        L5:
            int r1 = 0;
            if ((r6 & 2) == 0) goto L8;
            boolean r0 = r3.b;
        L10:
            if ((r6 & 4) == 0) goto L13;
            r1 = r3.c;
        L13:
            if ((r6 & 8) == 0) goto L15;
            r5 = r3.d;
        L15:
            r3.getClass();
            Intrinsics.checkNotNullParameter(r4, "state");
            return new a(r4, r0, r1, r5);
        L8:
            r0 = false;
            goto L10
        }
    }

    public final void T3() {
        this.a.f.d.setEnabled(false);
        this.a.f.b.setEnabled(false);
        this.a.f.f.setEnabled(false);
        this.a.c.d.setEnabled(false);
        this.a.c.b.setEnabled(false);
        this.a.c.f.setEnabled(false);
        this.a.f.e.a.setVisibility(8);
        this.a.f.c.a.setVisibility(8);
        this.a.f.g.a.setVisibility(8);
        this.a.c.e.a.setVisibility(8);
        this.a.c.c.a.setVisibility(8);
        this.a.c.g.a.setVisibility(8);
    }

    public Text2BgImageBindingViewHolder(LarusLayoutBotEditBgChoosePageBinding r2, e r3, f r4) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        Intrinsics.checkNotNullParameter(r3, "onClickImage");
        Intrinsics.checkNotNullParameter(r4, "onClickRetry");
        super(r2);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        int r5 = c7.b(12);
        w0.e(r2.f.d, r5);
        w0.e(r2.f.b, r5);
        w0.e(r2.f.f, r5);
        w0.e(r2.c.d, r5);
        w0.e(r2.c.b, r5);
        w0.e(r2.c.f, r5);
        e1.d(r2.f.d, new i(this));
        e1.d(r2.f.b, new j(this));
        e1.d(r2.f.f, new k(this));
        e1.d(r2.c.d, new l(this));
        e1.d(r2.c.b, new m(this));
        e1.d(r2.c.f, new n(this));
        T3();
    }
}
