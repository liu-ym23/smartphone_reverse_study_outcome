package com.obric.assistant.card.layout.viewholder;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.image.loader.ImageLoaderKt;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.databinding.ObricCardItemMusicBinding;
import com.obric.assistant.card.layout.bean.MessageExtraForViewHolder;
import com.obric.assistant.card.layout.viewholder.style.AbsCardItemBaseStyle;
import com.obric.assistant.card.manager.NetEaseMusicManager;
import com.obric.capabilitykit.entity.app.Artist;
import com.obric.capabilitykit.entity.app.Cover;
import com.obric.capabilitykit.entity.app.MusicEntity;
import com.obric.capabilitykit.entity.app.Preview;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001#B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ0\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0014J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\u001a\u0010\u001c\u001a\u00020\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0015\u001a\u00020\u0002H\u0002J\b\u0010\u001f\u001a\u00020\u0010H\u0002J\u0018\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u0017H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/MusicViewHolder;", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemBaseStyle;", "Lcom/obric/capabilitykit/entity/app/MusicEntity;", "Lcom/obric/assistant/card/databinding/ObricCardItemMusicBinding;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "musicStateCallback", "Lcom/obric/assistant/card/manager/NetEaseMusicManager$MusicStateCallback;", "traceInfoFetcher", "Lkotlin/Function0;", "Landroid/os/Bundle;", "lastMusicOperationTime", NameKeys.UnloadStrategy_No_Strategy, "setTraceInfoFetcher", NameKeys.UnloadStrategy_No_Strategy, "traceInfo", "onBind", "messageExtra", "Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;", "entity", "position", NameKeys.UnloadStrategy_No_Strategy, "isDeleted", NameKeys.UnloadStrategy_No_Strategy, "isRefreshed", "isMusicOperationTooFrequent", "registerMusicStateCallback", "localMessageId", NameKeys.UnloadStrategy_No_Strategy, "removeMusicStateCallback", "updatePlayingViews", "isPlaying", "progress", "Companion", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MusicViewHolder extends AbsCardItemBaseStyle<MusicEntity, ObricCardItemMusicBinding> {
    public static final /* synthetic */ int o = 0;
    public m l;
    public Function0<Bundle> m;
    public long n;

    public static final class a {
    }

    static {
    }

    public MusicViewHolder(ViewGroup r13) {
        Intrinsics.checkNotNullParameter(r13, "parent");
        ConstraintLayout r14 = LayoutInflater.from(r13.getContext()).inflate(2131563953, r13, false);
        int r0 = 2131380486;
        SimpleDraweeView r4 = ViewBindings.findChildViewById(r14, 2131380486);
        if (r4 == null) goto L21;
        r0 = 2131380511;
        FrameLayout r5 = (FrameLayout) ViewBindings.findChildViewById(r14, 2131380511);
        if (r5 == null) goto L21;
        r0 = 2131380512;
        AppCompatImageView r6 = ViewBindings.findChildViewById(r14, 2131380512);
        if (r6 == null) goto L21;
        r0 = 2131380513;
        AppCompatImageView r7 = ViewBindings.findChildViewById(r14, 2131380513);
        if (r7 == null) goto L21;
        r0 = 2131380514;
        FrameLayout r8 = (FrameLayout) ViewBindings.findChildViewById(r14, 2131380514);
        if (r8 == null) goto L21;
        r0 = 2131380515;
        MusicCircularProgressView r9 = (MusicCircularProgressView) ViewBindings.findChildViewById(r14, 2131380515);
        if (r9 == null) goto L21;
        r0 = 2131380522;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r14, 2131380522);
        if (r10 == null) goto L21;
        r0 = 2131380525;
        TextView r11 = (TextView) ViewBindings.findChildViewById(r14, 2131380525);
        if (r11 == null) goto L21;
        super(new ObricCardItemMusicBinding(r14, r4, r5, r6, r7, r8, r9, r10, r11));
        return;
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r0)));
    }

    public final void a4(boolean r5, int r6) {
        AppCompatImageView r0 = ((ObricCardItemMusicBinding) this.a).e;
        int r1 = 8;
        if (r5 == false) goto L5;
        int r3 = 8;
    L6:
        r0.setVisibility(r3);
        FrameLayout r2 = ((ObricCardItemMusicBinding) this.a).c;
        if (r5 == false) goto L9;
        r1 = 0;
    L9:
        r2.setVisibility(r1);
        if (r5 == false) goto L13;
        ((ObricCardItemMusicBinding) this.a).g.setProgress(r6);
        return;
    L13:
        return;
    L5:
        r3 = 0;
        goto L6
    }

    @Override // com.obric.assistant.card.layout.viewholder.abs.AbsCardItemViewHolder
    public final void T3(final MessageExtraForViewHolder r28, Object r29, final int r30, boolean r31, boolean r32) {
        final MusicEntity r3 = (MusicEntity) r29;
        Intrinsics.checkNotNullParameter(r28, "messageExtra");
        Intrinsics.checkNotNullParameter(r3, "entity");
        Preview r4 = r3.getPreview();
        String r5 = null;
        if (r4 == null) goto L5;
        String r6 = r4.getVid();
    L7:
        if (r6 != null) goto L9;
    L12:
        boolean r7 = true;
    L14:
        if (r7 == true) goto L65;
        SimpleDraweeView r15 = ((ObricCardItemMusicBinding) this.a).b;
        NetEaseMusicManager r8 = NetEaseMusicManager.a;
        int r11 = i5.l0();
        int r10 = i5.l0();
        r8.getClass();
        if (r6 != null) goto L19;
    L63:
        String r9 = null;
    L64:
        ImageLoaderKt.u(r15, r9, "obric_chat.cards");
        goto L65
    L19:
        if (StringsKt.startsWith$default(r6, "http", false, 2, null) == true) goto L21;
    L23:
        int r12 = 2;
        r9 = r6;
    L25:
        if (StringsKt.contains$default(r6, "?webpunableparams=true", false, r12, null) == false) goto L27;
        String r13 = "jpeg";
    L29:
        if (TextUtils.isEmpty(r9) == true) goto L63;
        Uri r14 = UriProtector.parse(r9);
        if (r14 != null) goto L121;
    L46:
        boolean r16 = false;
    L47:
        if (r16 == false) goto L64;
        if (StringsKt.indexOf$default(r9, "?", 0, false, 6, null) == (-1)) goto L52;
        boolean r17 = true;
    L53:
        StringBuilder r18 = new StringBuilder();
        r18.append(r9);
        if (r17 == false) goto L56;
        String r19 = "&";
    L57:
        r18.append(r19);
        r18.append("imageView=1");
        StringBuilder r20 = new StringBuilder(r18.toString());
        if (r11 > 0) goto L60;
    L62:
        r20.append("&type=" + r13 + "&quality=80");
        r9 = r20.toString();
        goto L64
    L60:
        if (r10 <= 0) goto L62;
        r20.append("&thumbnail=" + r11 + "z" + r10);
        goto L62
    L56:
        r19 = "?";
        goto L57
    L52:
        r17 = false;
        goto L53
    L121:
        String r21 = r14.getHost();     // Catch: Exception -> L45
        if (r21 == null) goto L46;
        if (TextUtils.isEmpty(r21) == true) goto L46;
        String[] r22 = NetEaseMusicManager.b;
        int r23 = r22.length;
        int r110 = 0;
    L40:
        if (r110 >= r23) goto L46;
        if (StringsKt.endsWith$default(r21, r22[r110], false, r12, null) == true) goto L43;
        r110 = r110 + 1;
        goto L40
    L43:
        r16 = true;
        goto L47
    L27:
        r13 = "webp";
        goto L29
    L21:
        if (StringsKt.startsWith$default(r6, "https", false, 2, null) == true) goto L23;
        r12 = 2;
        r9 = StringsKt.replaceFirst$default(r6, "http", "https", false, 4, null);
    L65:
        boolean r24 = v19.h.a;
        if (v19.h.a(null) == false) goto L68;
        ((ObricCardItemMusicBinding) this.a).e.setImageResource(2131244338);
        ((ObricCardItemMusicBinding) this.a).d.setImageResource(2131244336);
        ((ObricCardItemMusicBinding) this.a).g.a(-1, getContext().getResources().getColor(2131103682));
    L69:
        ((ObricCardItemMusicBinding) this.a).e.setOnClickListener(new j(this, r28, r3, r30));
        ((ObricCardItemMusicBinding) this.a).c.setOnClickListener(new k(this, r30));
        a4(false, 0);
        String r1 = r28.e;
        final m r2 = this.l;
        if (r2 == null) goto L77;
        NetEaseMusicManager.a.getClass();
        Intrinsics.checkNotNullParameter(r2, "callback");
        Iterator r25 = ((LinkedHashMap) NetEaseMusicManager.e).entrySet().iterator();
    L73:
        if (r25.hasNext() == false) goto L77;
        Map.Entry r26 = (Map.Entry) r25.next();
        CollectionsKt.removeAll((List) r26.getValue(), new com.obric.assistant.card.manager.h(r2));
        if (((List) r26.getValue()).isEmpty() == false) goto L73;
        r25.remove();
    L77:
        final m r27 = new m(r1, r3, this);
        this.l = r27;
        NetEaseMusicManager r33 = NetEaseMusicManager.a;
        String r34 = r3.getId();
        r33.getClass();
        Intrinsics.checkNotNullParameter(r34, "musicId");
        Intrinsics.checkNotNullParameter(r27, "callback");
        NetEaseMusicManager.a();
        LinkedHashMap r35 = (LinkedHashMap) NetEaseMusicManager.e;
        Object r36 = r35.get(r34);
        if (r36 != null) goto L80;
        r36 = new ArrayList();
        r35.put(r34, r36);
    L80:
        List r37 = (List) r36;
        CollectionsKt.removeAll(r37, new com.obric.assistant.card.manager.g(r27));
        r37.add(new WeakReference(r27));
        r27.onMusicStateChanged(NetEaseMusicManager.f);
        TextView r38 = ((ObricCardItemMusicBinding) this.a).i;
        String r39 = r3.getName();
        String r40 = NameKeys.UnloadStrategy_No_Strategy;
        if (r39 != null) goto L83;
        r39 = NameKeys.UnloadStrategy_No_Strategy;
    L83:
        r38.setText(r39);
        List r41 = r3.getArtists();
        if (r41 == null) goto L88;
        Artist r42 = (Artist) CollectionsKt.firstOrNull(r41);
        if (r42 == null) goto L88;
        String r43 = r42.getName();
    L89:
        if (r43 != null) goto L91;
        r43 = NameKeys.UnloadStrategy_No_Strategy;
    L91:
        Cover r44 = r3.getCover();
        if (r44 == null) goto L94;
        r5 = r44.getName();
    L94:
        if (r5 != null) goto L97;
        r5 = NameKeys.UnloadStrategy_No_Strategy;
    L97:
        if (r43.length() <= 0) goto L99;
        boolean r45 = true;
    L100:
        if (r45 == false) goto L108;
        if (r5.length() <= 0) goto L104;
        boolean r46 = true;
    L105:
        if (r46 == false) goto L108;
        r40 = r43 + " · " + r5;
    L119:
        ((ObricCardItemMusicBinding) this.a).h.setText(r40);
        return;
    L104:
        r46 = false;
    L108:
        if (r43.length() <= 0) goto L110;
        boolean r47 = true;
    L111:
        if (r47 == false) goto L114;
        r40 = r43;
        goto L119
    L114:
        if (r5.length() <= 0) goto L116;
        boolean r111 = true;
    L117:
        if (r111 == false) goto L119;
        r40 = r5;
        goto L119
    L116:
        r111 = false;
        goto L117
    L110:
        r47 = false;
        goto L111
    L99:
        r45 = false;
    L88:
        r43 = null;
        goto L89
    L68:
        ((ObricCardItemMusicBinding) this.a).e.setImageResource(2131244337);
        ((ObricCardItemMusicBinding) this.a).d.setImageResource(2131244335);
        ((ObricCardItemMusicBinding) this.a).g.a(-16777216, getContext().getResources().getColor(2131103682));
        goto L69
    L9:
        if (StringsKt.isBlank(r6) == true) goto L12;
        r7 = false;
        goto L14
    L5:
        r6 = null;
        goto L7
    }
}
