package com.larus.collection.impl.view;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.music.applet.MusicAppletPage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u001c\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/larus/collection/impl/view/NormalCollectionItemHolder;", "Lcom/larus/collection/impl/view/BaseCollectionItemHolder;", "itemView", "Landroid/view/View;", "callback", "Lcom/larus/collection/impl/view/CollectionListHolderCallback;", "<init>", "(Landroid/view/View;Lcom/larus/collection/impl/view/CollectionListHolderCallback;)V", "imageCover", "Lcom/facebook/drawee/view/SimpleDraweeView;", "subIcon", "imageGroup", "Landroidx/constraintlayout/widget/Group;", "title", "Landroid/widget/TextView;", "description", "createTimeView", MusicAppletPage.KEY_SOURCE, "touchXOffset", "", "touchYOffset", "bindData", "", "item", "Lcom/larus/platform/model/MessageCollection;", "setIconUrl", "coverUrl", "", "subIconUrl", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NormalCollectionItemHolder extends BaseCollectionItemHolder {
    public static final /* synthetic */ int l = 0;
    public final View a;
    public final com.larus.collection.impl.view.a b;
    public final SimpleDraweeView c;
    public final SimpleDraweeView d;
    public final Group e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    public int j;
    public int k;

    public static final class a {
    }

    static {
    }

    public NormalCollectionItemHolder(ConstraintLayout r2, com.larus.collection.impl.view.a r3) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "callback");
        super(r2);
        this.a = r2;
        this.b = r3;
        this.c = r2.findViewById(2131375138);
        this.d = r2.findViewById(2131387536);
        this.e = r2.findViewById(2131375778);
        this.f = (TextView) r2.findViewById(2131388772);
        this.g = (TextView) r2.findViewById(2131368849);
        this.h = (TextView) r2.findViewById(2131367162);
        this.i = (TextView) r2.findViewById(2131387007);
    }
}
