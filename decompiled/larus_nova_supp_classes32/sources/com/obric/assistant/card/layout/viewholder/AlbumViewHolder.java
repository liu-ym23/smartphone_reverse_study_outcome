package com.obric.assistant.card.layout.viewholder;

import android.content.Context;
import android.net.Uri;
import android.view.ViewGroup;
import com.facebook.drawee.generic.RoundingParams;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.layout.viewholder.style.AbsCardItemTitleSubTitleStyle;
import com.obric.assistant.card.provider.PrivilegedUriProvider;
import com.obric.capabilitykit.entity.app.AlbumEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/AlbumViewHolder;", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleSubTitleStyle;", "Lcom/obric/capabilitykit/entity/app/AlbumEntity;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "angle", NameKeys.UnloadStrategy_No_Strategy, "getAngle", "()F", "angle$delegate", "Lkotlin/Lazy;", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleSubTitleStyle$StyleData;", "entity", "position", NameKeys.UnloadStrategy_No_Strategy, "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AlbumViewHolder extends AbsCardItemTitleSubTitleStyle<AlbumEntity> {
    public static final /* synthetic */ int m = 0;
    public final Lazy l;

    public AlbumViewHolder(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        super(r2);
        this.l = LazyKt.lazy(new f(this));
    }

    @Override // com.obric.assistant.card.layout.viewholder.style.AbsCardItemTitleSubTitleStyle
    public final AbsCardItemTitleSubTitleStyle.a a4(Object r12) {
        AlbumEntity r13 = (AlbumEntity) r12;
        Intrinsics.checkNotNullParameter(r13, "entity");
        FileEntity r0 = r13.getCover();
        if (r0 == null) goto L9;
        String r1 = r0.getMimeType();
        if (r1 == null) goto L9;
        if (StringsKt.startsWith(r1, "video/", true) != true) goto L9;
        boolean r2 = true;
    L10:
        FileEntity r5 = r13.getCover();
        if (r5 == null) goto L15;
        Uri r6 = r5.getContentUrl();
        if (r6 == null) goto L15;
        int r7 = PrivilegedUriProvider.b;
        Uri r3 = PrivilegedUriProvider.a.a(r6, r13.getPackageName(), r2, r2);
    L16:
        lca.a r4 = new lca.a(2131244325, r3, RoundingParams.fromCornersRadius(((Number) this.l.getValue()).floatValue()));
        String r8 = r13.getName();
        Context r9 = getContext();
        int r10 = com.obric.assistant.card.utils.j.a;
        return new AbsCardItemTitleSubTitleStyle.a(r4, r8, false, r9.getString(2131912670, new Object[]{com.obric.assistant.card.utils.j.c(getContext(), r13.getLastModifiedTime())}), null, 52);
    L15:
        r3 = null;
    L9:
        r2 = false;
        goto L10
    }
}
