package com.larus.chat.gallery.impl.providers.input;

import android.content.res.ColorStateList;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.collection.LruCache;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.larus.asr.e2;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.g9;
import com.larus.bmhome.chat.component.bottom.core.h9;
import com.larus.bmhome.chat.component.bottom.core.speaker.g;
import com.larus.bmhome.chat.component.bottom.core.speaker.h;
import com.larus.bmhome.chat.component.bottom.core.speaker.l;
import com.larus.bmhome.chat.component.bottom.core.z8;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.chat.gallery.impl.preview.provider.n0;
import com.larus.chat.gallery.impl.preview.provider.z0;
import com.larus.chat.gallery.providers.input.GalleryInputFragment;
import com.larus.chat.gallery.providers.input.v;
import com.larus.chat.gallery.providers.input.w;
import com.larus.common_ui.view.SuggestedActionBar;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.model.action.SuggestedAction;
import com.larus.platform.model.action.SuggestedActionKey;
import com.larus.platform.model.action.SuggestedActionScene;
import com.larus.platform.model.action.SuggestedActionType;
import com.larus.platform.model.action.SuggestedExt;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tx9.t3;
import v19.i5;
import va8.o;
import zy8.d;
import zy8.e;
import zy8.f;
import zy8.i;
import zy8.j;
import zy8.k;
import zy8.m;
import zy8.n;
import zy8.p;
import zy8.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u00ad\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001#\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010*\u001a\u00020+H\u0016J\u0010\u00106\u001a\u00020+2\u0006\u00107\u001a\u000208H\u0016J\f\u00109\u001a\u00020&*\u00020:H\u0002J\f\u0010;\u001a\u00020&*\u00020:H\u0002J\f\u0010<\u001a\u00020&*\u00020:H\u0002J\f\u0010=\u001a\u00020+*\u00020:H\u0002J\u0014\u0010>\u001a\u00020+2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010:H\u0002J\b\u0010@\u001a\u00020+H\u0016J\b\u0010A\u001a\u00020+H\u0016J\u0010\u0010B\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0016J\u0012\u0010C\u001a\u00020+2\b\u0010D\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010E\u001a\u00020+2\u0006\u0010F\u001a\u00020\u0007H\u0016J\u0016\u0010G\u001a\u00020+2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020&0IH\u0016J\b\u0010J\u001a\u00020+H\u0016J\b\u0010K\u001a\u00020+H\u0016J\u0017\u0010L\u001a\u00020+2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016¢\u0006\u0002\u0010MJ\b\u0010N\u001a\u00020\u0007H\u0016J\u001e\u0010S\u001a\u00020+2\u0014\u0010T\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020+\u0018\u00010PH\u0016J\b\u0010U\u001a\u00020+H\u0002J \u0010V\u001a\u00020+2\u0006\u0010W\u001a\u00020&2\u000e\u0010X\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010IH\u0016J\u0010\u0010Y\u001a\u00020+2\u0006\u0010Z\u001a\u00020&H\u0016J2\u0010[\u001a\u00020+2\f\u0010\\\u001a\b\u0012\u0004\u0012\u0002000/2\b\u0010]\u001a\u0004\u0018\u0001022\u0006\u0010^\u001a\u0002042\b\u0010_\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010`\u001a\u00020+H\u0016J\u0012\u0010a\u001a\u00020+2\b\b\u0002\u0010b\u001a\u00020&H\u0002J\u0018\u0010c\u001a\u00020+2\u0006\u0010d\u001a\u0002082\u0006\u0010e\u001a\u00020&H\u0002J\f\u0010f\u001a\u00020&*\u000200H\u0002J>\u0010g\u001a\u00020+2\u0006\u0010h\u001a\u00020&2\u0006\u0010i\u001a\u0002002\f\u0010\\\u001a\b\u0012\u0004\u0012\u0002000/2\u0006\u0010j\u001a\u0002042\u0006\u0010k\u001a\u0002042\u0006\u0010l\u001a\u00020&H\u0002J\u0010\u0010n\u001a\u00020+2\u0006\u0010o\u001a\u00020&H\u0016J\u0010\u0010p\u001a\u00020+2\u0006\u0010o\u001a\u00020&H\u0002J\u0010\u0010s\u001a\u00020+2\u0006\u0010o\u001a\u00020&H\u0002J\u0010\u0010t\u001a\u00020+2\u0006\u0010o\u001a\u00020&H\u0002J\u0010\u0010u\u001a\u00020+2\u0006\u0010o\u001a\u00020&H\u0002J\u0010\u0010v\u001a\u0002042\u0006\u0010o\u001a\u00020&H\u0002J\u0016\u0010w\u001a\b\u0012\u0004\u0012\u00020x0/2\u0006\u0010y\u001a\u00020zH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\r\u001a\u0004\b\u001f\u0010 R\u0010\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0004\n\u0002\u0010$R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0004\n\u0002\u0010)R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u0002000/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010O\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020+\u0018\u00010PX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010Q\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0004\n\u0002\u0010RR\u000e\u0010m\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006{"}, d2 = {"Lcom/larus/chat/gallery/impl/providers/input/GalleryInputComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/chat/gallery/providers/input/GalleryInputAbility;", "<init>", "()V", "tag", "", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "Lkotlin/Lazy;", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "speakerAbility", "Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "getSpeakerAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "speakerAbility$delegate", "suggestedActionAbility", "Lcom/larus/bmhome/chat/action/ISuggestedActionAbility;", "getSuggestedActionAbility", "()Lcom/larus/bmhome/chat/action/ISuggestedActionAbility;", "suggestedActionAbility$delegate", "coreInputManager", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputManager;", "getCoreInputManager", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputManager;", "coreInputManager$delegate", "speakerStateListener", "com/larus/chat/gallery/impl/providers/input/GalleryInputComponent$speakerStateListener$1", "Lcom/larus/chat/gallery/impl/providers/input/GalleryInputComponent$speakerStateListener$1;", "speakerStateListenerRegistered", "", "chatKey", "", "Ljava/lang/Long;", "onAttach", "", "callback", "Lcom/larus/chat/gallery/providers/input/GalleryInputCallback;", "boundSuggestedActions", "", "Lcom/larus/platform/model/action/SuggestedAction;", "boundSuggestedActionScene", "Lcom/larus/platform/model/action/SuggestedActionScene;", "boundAttachmentCount", "", "boundBotId", "onViewCreated", "view", "Landroid/view/View;", "onReadyToInput", "Lcom/larus/bmhome/chat/component/bottom/core/InputView$Operator;", "onReadyToSend", "onReadyToSpeak", "operateCommonConfig", "renderActionEntrance", "operator", "onResume", "onFragmentViewDestroyed", "setCallback", "setInputHint", "hint", "setInputText", ShareType.TEXT, "setExternalImeShowingFunc", "func", "Lkotlin/Function0;", "hideIme", "prepareForNavigation", "setChatKey", "(Ljava/lang/Long;)V", "getInputText", "sugIndexHideStateListener", "Lkotlin/Function1;", "lastSugIndexHideActive", "Ljava/lang/Boolean;", "setSugIndexHideStateListener", "listener", "notifySugIndexHideStateChanged", "configPlusButtonInterceptor", "enableShown", "onClick", "onPreviewChanged", "isVideo", "updateSuggestedActions", "actions", "scene", "attachmentCount", "botId", "clearSuggestedActions", "renderSuggestedActions", "animatedForInputText", "setSuggestedActionAreaVisible", "area", "visible", "isSingleImageCreationRedirection", "reportSuggestedAction", "showOrClick", "action", "row", "column", "directShow", "isVideoDisabled", "setVideoInputDisabled", "disabled", "applyVideoInputStyle", "videoDisabledTouchInterceptor", "Landroid/view/View$OnTouchListener;", "applyTouchInterceptors", "applyButtonTint", "applySpeakTextColor", "resolveInputActionColor", "findTextViewsRecursive", "Landroid/widget/TextView;", "viewGroup", "Landroid/view/ViewGroup;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GalleryInputComponent extends BaseContentWidget implements com.larus.chat.gallery.providers.input.a {
    public static final /* synthetic */ int E = 0;
    public Function1<? super Boolean, Unit> A;
    public Boolean B;
    public boolean C;
    public final m D;
    public final String m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final c s;
    public boolean t;
    public Long u;
    public com.larus.chat.gallery.providers.input.b v;
    public List<SuggestedAction> w;
    public SuggestedActionScene x;
    public int y;
    public String z;

    public static final class a implements ICoreInputAbility.e {
        public final /* synthetic */ GalleryInputComponent a;

        public a(GalleryInputComponent r1) {
            this.a = r1;
        }

        public final void h(String r2) {
            Intrinsics.checkNotNullParameter(r2, "content");
        }

        public final void i(String r2) {
            Intrinsics.checkNotNullParameter(r2, "content");
            com.larus.chat.gallery.providers.input.b r0 = this.a.v;
            if (r0 == null) goto L5;
            r0.a(r2);
        L5:
            this.a.Q3(null);
            this.a.G3();
        }

        public final void j(String r2) {
            Intrinsics.checkNotNullParameter(r2, "content");
        }
    }

    public static final class b implements SuggestedActionBar.a {
        public final /* synthetic */ List<SuggestedAction> a;
        public final /* synthetic */ GalleryInputComponent b;
        public final /* synthetic */ SuggestedActionScene c;

        public b(List<SuggestedAction> r1, GalleryInputComponent r2, SuggestedActionScene r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a(String r10, int r11, int r12, boolean r13) {
            Intrinsics.checkNotNullParameter(r10, "key");
            Iterator<T> r0 = this.a.iterator();
        L4:
            if (r0.hasNext() == false) goto L8;
            Object r1 = r0.next();
            if (Intrinsics.areEqual(((SuggestedAction) r1).getSuggestedActionKey(), r10) == false) goto L4;
        L9:
            SuggestedAction r2 = (SuggestedAction) r1;
            if (r2 != null) goto L12;
            return;
        L12:
            GalleryInputComponent.Y2(this.b, false, r2, this.a, r11, r12, r13);
            int r14 = r2.getSuggestedActionType();
            if (r14 != SuggestedActionType.Redirection.getValue()) goto L22;
            bc8.a r15 = (bc8.a) this.b.q.getValue();
            boolean r16 = false;
            if (r15 != null) goto L17;
        L19:
            if (r16 == true) goto L31;
            FLogger.a.e(this.b.m, "unsupported redirection suggested action, key=" + r10);
            return;
        L31:
            return;
        L17:
            if (r15.Ge(r2) != true) goto L19;
            r16 = true;
            goto L19
        L22:
            if (r14 != SuggestedActionType.MessageWithPromptReplacement.getValue()) goto L26;
            com.larus.chat.gallery.providers.input.b r17 = this.b.v;
            if (r17 == null) goto L33;
            r17.e(r2, this.c);
            return;
        L33:
            return;
        L26:
            FLogger.a.e(this.b.m, "unsupported suggested action type=" + r2.getSuggestedActionType() + ", key=" + r10);
            return;
        L8:
            r1 = null;
            goto L9
        }

        public final void b(String r10, int r11, int r12, boolean r13) {
            Intrinsics.checkNotNullParameter(r10, "key");
            Iterator<T> r0 = this.a.iterator();
        L4:
            if (r0.hasNext() == false) goto L8;
            Object r1 = r0.next();
            if (Intrinsics.areEqual(((SuggestedAction) r1).getSuggestedActionKey(), r10) == false) goto L4;
        L9:
            SuggestedAction r4 = (SuggestedAction) r1;
            if (r4 != null) goto L12;
            return;
        L12:
            GalleryInputComponent.Y2(this.b, true, r4, this.a, r11, r12, r13);
            return;
        L8:
            r1 = null;
            goto L9
        }
    }

    public static final class c implements h {
        public final /* synthetic */ GalleryInputComponent a;

        public c(GalleryInputComponent r1) {
            this.a = r1;
        }

        public final void a(g r3) {
            Intrinsics.checkNotNullParameter(r3, "state");
            Fragment r0 = s1a.a.c(this.a);
            if ((r0 instanceof GalleryInputFragment) == false) goto L5;
            GalleryInputFragment r1 = (GalleryInputFragment) r0;
        L7:
            if (Intrinsics.areEqual(r3, g.c.a) == false) goto L16;
            if (r1 == null) goto L35;
            if (r1.aa0() == false) goto L35;
            r1.s = true;
            r1.la0();
            View r2 = r1.d;
            if (r2 == null) goto L35;
            r2.post(r1.y);
        L35:
            if ((r3 instanceof g.e) == true) goto L37;
            return;
        L37:
            g.e r4 = (g.e) r3;
            if (r4.c == false) goto L40;
            return;
        L40:
            com.larus.chat.gallery.providers.input.b r5 = this.a.v;
            if (r5 == null) goto L44;
            r5.b(r4.a);
            return;
        L44:
            return;
        L16:
            if (Intrinsics.areEqual(r3, g.a.a) == false) goto L18;
        L27:
            if (r1 == null) goto L35;
            if (r1.aa0() == false) goto L35;
            r1.s = false;
            r1.la0();
            View r6 = r1.d;
            if (r6 == null) goto L35;
            r6.post(r1.y);
            goto L35
        L18:
            if (Intrinsics.areEqual(r3, g.b.a) == true) goto L27;
            if ((r3 instanceof g.e) == true) goto L27;
            if ((r3 instanceof g.d) == true) goto L35;
            throw new NoWhenBranchMatchedException();
        L5:
            r1 = null;
            goto L7
        }
    }

    public final void A2() {
        if (this.t == false) goto L9;
        l r0 = (l) this.p.getValue();
        if (r0 == null) goto L7;
        r0.B9(this.s);
    L7:
        this.t = false;
        return;
    }

    public final o C3() {
        return (o) this.o.getValue();
    }

    public final ICoreInputAbility D3() {
        return (ICoreInputAbility) this.n.getValue();
    }

    public final z8 E3() {
        return (z8) this.r.getValue();
    }

    public final void onResume() {
        FLogger.a.i(this.m, "onResume");
        l r0 = (l) this.p.getValue();
        if (r0 == null) goto L6;
        l.a.b(r0, new f());
    L6:
        if (this.t == true) goto L10;
        l r1 = (l) this.p.getValue();
        if (r1 == null) goto L10;
        r1.e8(this.s);
        this.t = true;
    L10:
        ICoreInputAbility r2 = D3();
        if (r2 == null) goto L13;
        r2.YT(new a(this));
    L13:
        ICoreInputAbility r3 = D3();
        if (r3 == null) goto L17;
        r3.tr(new zy8.g(this));
        return;
    }

    public final void y2() {
        FLogger.a.i(this.m, "onAttach");
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, com.larus.chat.gallery.providers.input.a.class);
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [zy8.m] */
    public GalleryInputComponent() {
        this.m = "GalleryInputComponent";
        this.n = LazyKt.lazy(new zy8.b(this));
        this.o = LazyKt.lazy(new i(this));
        this.p = LazyKt.lazy(new j(this));
        this.q = LazyKt.lazy(new k(this));
        this.r = LazyKt.lazy(new zy8.l(this));
        this.s = new c(this);
        this.w = CollectionsKt.emptyList();
        this.D = new m();
    }

    public final void G3() {
        ICoreInputAbility r0 = D3();
        boolean r1 = false;
        if (r0 == null) goto L8;
        if (r0.b9() != true) goto L8;
        r1 = true;
    L8:
        if (Intrinsics.areEqual(this.B, Boolean.valueOf(r1)) == false) goto L10;
        return;
    L10:
        this.B = Boolean.valueOf(r1);
        V3(true);
        Function1<? super Boolean, Unit> r2 = this.A;
        if (r2 == null) goto L14;
        r2.invoke(Boolean.valueOf(r1));
        return;
    }

    @Override // com.larus.chat.gallery.providers.input.a
    public final void at() {
        o r0 = C3();
        if (r0 == null) goto L5;
        r0.c3();
    L5:
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r1 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        if ((r1 instanceof GalleryInputFragment) == false) goto L8;
        GalleryInputFragment r2 = (GalleryInputFragment) r1;
    L9:
        if (r2 != null) goto L11;
        return;
    L11:
        if (r2.Y90() == false) goto L16;
        r2.n = true;
        r2.f = false;
        r2.g = true;
        Handler r3 = t0.a;
        final v r4 = r2.B;
        r3.removeCallbacks(new w(r4));
        r2.ea0();
        return;
    L16:
        return;
    L8:
        r2 = null;
        goto L9
    }

    @Override // com.larus.chat.gallery.providers.input.a
    public final void g() {
        ICoreInputAbility r0 = D3();
        if (r0 == null) goto L6;
        r0.qp(false);
        return;
    }

    @Override // com.larus.chat.gallery.providers.input.a
    public final void qC() {
        this.w = CollectionsKt.emptyList();
        this.x = null;
        this.y = 0;
        this.z = null;
        V3(false);
    }

    public static List B3(ViewGroup r5) {
        ArrayList r0 = new ArrayList();
        int r1 = r5.getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L11;
        View r3 = r5.getChildAt(r2);
        if ((r3 instanceof TextView) == false) goto L8;
        r0.add(r3);
    L10:
        r2 = r2 + 1;
        goto L3
    L8:
        if ((r3 instanceof ViewGroup) == false) goto L10;
        r0.addAll(B3((ViewGroup) r3));
        goto L10
    L11:
        return r0;
    }

    public final void H3(g9.c r6) {
        ICoreInputAbility r0 = D3();
        String r1 = null;
        if (r0 == null) goto L7;
        z8.a r2 = r0.Jd();
        if (r2 == null) goto L7;
        z8.b r3 = r2.l;
    L9:
        if (r3 != null) goto L11;
    L13:
        boolean r4 = false;
    L14:
        o r5 = C3();
        if (r5 == null) goto L17;
        r1 = r5.u7();
    L17:
        if (r4 == false) goto L27;
        if (r1 != null) goto L20;
    L23:
        boolean r7 = true;
    L24:
        if (r7 == false) goto L27;
        r6.e().e(true);
        r6.h().e(false);
    L37:
        Q3(r6);
        return;
    L20:
        if (r1.length() == 0) goto L23;
        r7 = false;
    L27:
        if (r4 == false) goto L36;
        ICoreInputAbility r8 = D3();
        if (r8 != null) goto L31;
    L33:
        boolean r9 = false;
    L34:
        if (r9 == false) goto L36;
        r6.e().e(true);
        h9 r10 = r6.h();
        r10.e(true);
        r10.b(true);
        r10.a(1.0f);
        goto L37
    L31:
        if (r8.CS() != true) goto L33;
        r9 = true;
    L36:
        r6.e().e(false);
        h9 r11 = r6.h();
        r11.e(true);
        r11.b(true);
        r11.a(1.0f);
        goto L37
    L11:
        if (r3.a != true) goto L13;
        r4 = true;
    L7:
        r3 = null;
        goto L9
    }

    @Override // com.larus.chat.gallery.providers.input.a
    public final void JC(Long r1) {
        this.u = r1;
    }

    @Override // com.larus.chat.gallery.providers.input.a
    public final void LK(boolean r4) {
        z8 r0 = E3();
        if (r0 == null) goto L15;
        Pair[] r1 = new Pair[2];
        if (r4 == false) goto L7;
        String r5 = "video_detail";
    L8:
        r1[0] = TuplesKt.to("take_over_current_page", r5);
        Long r6 = this.u;
        if (r6 == null) goto L12;
        String r7 = r6.toString();
        if (r7 == null) goto L12;
    L13:
        r1[1] = TuplesKt.to("take_over_chat_key", r7);
        r0.g9(MapsKt.mapOf(r1));
        return;
    L12:
        r7 = "";
        goto L13
    L7:
        r5 = "picture_detail";
        goto L8
    }

    public final void Q3(g9.c r5) {
        String r0 = null;
        if (r5 != null) goto L10;
        ICoreInputAbility r6 = D3();
        if (r6 == null) goto L7;
        r5 = r6.q20();
    L8:
        if (r5 != null) goto L10;
        return;
    L7:
        r5 = null;
    L10:
        boolean r2 = false;
        r5.c().e(false);
        r5.b().c(2131242487);
        h9 r7 = r5.a();
        com.larus.chat.gallery.providers.input.b r1 = this.v;
        if (r1 != null) goto L13;
    L15:
        boolean r3 = false;
    L16:
        if (r3 == false) goto L35;
        o r4 = C3();
        if (r4 == null) goto L20;
        r0 = r4.u7();
    L20:
        if (r0 != null) goto L22;
    L25:
        boolean r8 = true;
    L26:
        if (r8 == true) goto L34;
        ICoreInputAbility r9 = D3();
        if (r9 != null) goto L30;
    L32:
        boolean r10 = false;
    L33:
        if (r10 == false) goto L35;
    L30:
        if (r9.J8() != true) goto L32;
        r10 = true;
    L34:
        r2 = true;
        goto L35
    L22:
        if (r0.length() == 0) goto L25;
        r8 = false;
    L35:
        r7.e(r2);
        return;
    L13:
        if (r1.d() != true) goto L15;
        r3 = true;
        goto L16
    }

    @Override // com.larus.chat.gallery.providers.input.a
    public final void TG(String r3) {
        if (this.C == false) goto L5;
        return;
    L5:
        ICoreInputAbility r0 = D3();
        if (r0 == null) goto L9;
        r0.Uu(r3, false);
        return;
    }

    public final void V3(boolean r22) {
        Intrinsics.checkNotNullParameter(this, "<this>");
        View r0 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getView();
        if (r0 != null) goto L5;
        return;
    L5:
        View r2 = r0.findViewById(2131373416);
        View r3 = null;
        if (r2 != null) goto L10;
        ICoreInputAbility r1 = D3();
        if (r1 == null) goto L10;
        g9.c r4 = r1.q20();
    L11:
        if (r2 != null) goto L19;
        if (r4 == null) goto L18;
        g9.b r5 = r4.a;
        r5.getClass();
        View r6 = r5.a;
        if (r6 == null) goto L16;
        View r7 = r6.findViewById(2131375413);
    L17:
        final View r8 = r7;
    L20:
        if (r2 == null) goto L142;
        final SuggestedActionBar r9 = (SuggestedActionBar) r2.findViewById(2131373415);
    L38:
        if (r2 == null) goto L40;
        r3 = r2.findViewById(2131373417);
    L44:
        if (r8 == null) goto L159;
        if (r9 == null) goto L160;
        if (r3 == null) goto L161;
        ICoreInputAbility r10 = D3();
        if (r10 != null) goto L51;
    L53:
        boolean r11 = false;
    L55:
        if (r11 == false) goto L57;
    L130:
        r3.setVisibility(8);
        if (r11 == false) goto L140;
        if (r22 == false) goto L140;
        if (r9.getVisibility() != 0) goto L136;
        boolean r12 = true;
    L137:
        if (r12 == false) goto L140;
        r9.g = true;
        r9.b(new zy8.h(this, r8, r9));
        r9.requestLayout();
        return;
    L136:
        r12 = false;
    L140:
        W3(r8, false);
        r9.j();
        r9.setVisibility(8);
        return;
    L57:
        if (this.C == true) goto L130;
        if (this.x == null) goto L130;
        if (this.w.isEmpty() == true) goto L130;
        SuggestedActionScene r13 = this.x;
        if (r13 != null) goto L66;
        return;
    L66:
        List<SuggestedAction> r14 = this.w;
        ArrayList r15 = new ArrayList();
        Iterator<T> r16 = r14.iterator();
    L68:
        if (r16.hasNext() == false) goto L73;
        Object r17 = r16.next();
        if (Intrinsics.areEqual(((SuggestedAction) r17).getSuggestedActionKey(), SuggestedActionKey.Loading.getValue()) == true) goto L68;
        r15.add(r17);
        goto L68
    L73:
        if (r15.isEmpty() == false) goto L76;
        r3.setVisibility(8);
        W3(r8, false);
        r9.j();
        r9.setVisibility(8);
        return;
    L76:
        ArrayList r18 = new ArrayList();
        Iterator r19 = r15.iterator();
    L78:
        if (r19.hasNext() == false) goto L103;
        Object r110 = r19.next();
        SuggestedAction r111 = (SuggestedAction) r110;
        IFlowSdkDepend r112 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r112 == null) goto L83;
        r112.v();
    L83:
        if (CollectionsKt.contains(CollectionsKt.emptyList(), r111.getSuggestedActionKey()) == false) goto L85;
    L99:
        boolean r113 = true;
    L100:
        if (r113 == true) goto L78;
        r18.add(r110);
        goto L78
    L85:
        if (r13 == SuggestedActionScene.AttachmentAreaMultiImg) goto L87;
    L98:
        r113 = false;
        goto L100
    L87:
        if (r111.getSuggestedActionType() == SuggestedActionType.Redirection.getValue()) goto L90;
    L94:
        boolean r114 = false;
    L96:
        if (r114 == false) goto L98;
    L90:
        if (Intrinsics.areEqual(r111.getSuggestedActionKey(), SuggestedActionKey.AIBeautify.getValue()) == false) goto L92;
    L95:
        r114 = true;
        goto L96
    L92:
        if (Intrinsics.areEqual(r111.getSuggestedActionKey(), SuggestedActionKey.AIVideoGenerate.getValue()) == false) goto L94;
    L103:
        if (r18.isEmpty() == false) goto L106;
        r3.setVisibility(8);
        W3(r8, false);
        r9.j();
        r9.setVisibility(8);
        return;
    L106:
        ArrayList r115 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));
        Iterator r116 = r18.iterator();
    L108:
        if (r116.hasNext() == false) goto L117;
        SuggestedAction r117 = (SuggestedAction) r116.next();
        String r118 = r117.getSuggestedActionKey();
        if (r118 != null) goto L112;
        String r119 = "";
    L113:
        int r120 = r117.getRow();
        String r121 = r117.getDisplayName();
        if (r121 != null) goto L116;
        r121 = "";
    L116:
        r115.add(new SuggestedActionBar.c(r119, r120, r121, false, false, 224));
        goto L108
    L112:
        r119 = r118;
        goto L113
    L117:
        r8.setBackgroundColor(0);
        r9.setDarkMode(true);
        if (r2 == null) goto L120;
        int r20 = i5.h();
    L121:
        r9.setPaddingRelative(r20, r9.getPaddingTop(), r20, r9.getPaddingBottom());
        r9.e(r115, new b(r18, this, r13), false, 2131239765);
        r3.setVisibility(8);
        if (r9.getVisibility() != 0) goto L124;
        boolean r21 = true;
    L125:
        boolean r23 = !r21;
        r9.setVisibility(0);
        W3(r8, true);
        if (r22 == false) goto L157;
        if (r23 == false) goto L158;
        r9.g = true;
        r9.c();
        return;
    L158:
        return;
    L157:
        return;
    L124:
        r21 = false;
        goto L125
    L120:
        r20 = 0;
        goto L121
    L51:
        if (r10.b9() != true) goto L53;
        r11 = true;
        goto L55
    L161:
        return;
    L160:
        return;
    L159:
        return;
    L40:
        if (r4 == null) goto L44;
        g9.b r24 = r4.a;
        r24.getClass();
        View r25 = r24.a;
        if (r25 == null) goto L44;
        r3 = r25.findViewById(2131375414);
        goto L44
    L142:
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L32
        if (r4 == null) goto L29;
        g9.b r27 = r4.a;     // Catch: Throwable -> L32
        r27.getClass();     // Catch: Throwable -> L32
        View r28 = r27.a;     // Catch: Throwable -> L32
        if (r28 == null) goto L27;
        View r29 = r28.findViewById(2131375412);     // Catch: Throwable -> L32
    L28:
        Intrinsics.checkNotNull(r29, "null cannot be cast to non-null type com.larus.common_ui.view.SuggestedActionBar");     // Catch: Throwable -> L32
        SuggestedActionBar r30 = (SuggestedActionBar) r29;     // Catch: Throwable -> L32
    L30:
        Object r31 = Result.constructor-impl(r30);     // Catch: Throwable -> L32
    L35:
        if (Result.isFailure-impl(r31) == false) goto L37;
        r31 = null;
    L37:
        r9 = (SuggestedActionBar) r31;
        goto L38
    L27:
        r29 = null;
        goto L28
    L29:
        r30 = null;
    L32:
        th = move-exception;
        Result.Companion r32 = Result.Companion;
        r31 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L35
    L16:
        r7 = null;
        goto L17
    L18:
        r8 = null;
        goto L20
    L19:
        r8 = r2;
    L10:
        r4 = null;
        goto L11
    }

    @Override // com.larus.chat.gallery.providers.input.a
    public final void gY(boolean r5) {
        if (this.C != r5) goto L5;
        return;
    L5:
        this.C = r5;
        FLogger r0 = FLogger.a;
        String r1 = this.m;
        StringBuilder r2 = new StringBuilder("setVideoInputDisabled: disabled=");
        r2.append(r5);
        r2.append(", lastStatus=");
        ICoreInputAbility r3 = D3();
        if (r3 == null) goto L8;
        Integer r4 = Integer.valueOf(r3.Rp());
    L9:
        r2.append(r4);
        r0.i(r1, r2.toString());
        z3(r5);
        return;
    L8:
        r4 = null;
        goto L9
    }

    public final void h3(boolean r8) {
        if (r8 == false) goto L4;
        int r9 = 2131103194;
    L5:
        Intrinsics.checkNotNullParameter(this, "<this>");
        ColorStateList r10 = ColorStateList.valueOf(ContextCompat.getColor(com.larus.ui.arch.component.internal.attach.a.b(this, this).requireContext(), r9));
        o r0 = C3();
        ImageView r1 = null;
        if (r0 == null) goto L8;
        va8.b r2 = r0.rX();
    L9:
        if (r2 == null) goto L11;
        View r3 = r2.e;
    L13:
        if ((r3 instanceof ImageView) == false) goto L15;
        ImageView r4 = (ImageView) r3;
    L16:
        if (r4 == null) goto L18;
        r4.setImageTintList(r10);
    L18:
        if (r2 == null) goto L35;
        View r5 = r2.g;
        if (r5 == null) goto L35;
        if ((r5 instanceof ImageView) == false) goto L25;
        ((ImageView) r5).setImageTintList(r10);
        goto L35
    L25:
        if ((r5 instanceof ViewGroup) == false) goto L35;
        ViewGroup r6 = (ViewGroup) r5;
        int r7 = r6.getChildCount();
        int r11 = 0;
    L27:
        if (r11 >= r7) goto L35;
        View r12 = r6.getChildAt(r11);
        if ((r12 instanceof ImageView) == false) goto L31;
        ImageView r13 = (ImageView) r12;
    L32:
        if (r13 == null) goto L34;
        r13.setImageTintList(r10);
    L34:
        r11 = r11 + 1;
        goto L27
    L31:
        r13 = null;
    L35:
        if (r2 == null) goto L37;
        View r14 = r2.h;
    L39:
        if ((r14 instanceof ImageView) == false) goto L41;
        ImageView r15 = (ImageView) r14;
    L42:
        if (r15 == null) goto L44;
        r15.setImageTintList(r10);
    L44:
        if (r2 == null) goto L46;
        View r16 = r2.j;
    L48:
        if ((r16 instanceof ImageView) == false) goto L50;
        r1 = (ImageView) r16;
    L50:
        if (r1 == null) goto L56;
        r1.setImageTintList(r10);
        return;
    L56:
        return;
    L46:
        r16 = null;
        goto L48
    L41:
        r15 = null;
        goto L42
    L37:
        r14 = null;
        goto L39
    L15:
        r4 = null;
        goto L16
    L11:
        r3 = null;
        goto L13
    L8:
        r2 = null;
        goto L9
    L4:
        r9 = 2131103298;
        goto L5
    }

    @Override // com.larus.chat.gallery.providers.input.a
    public final void i1(Function0<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "func");
        o r0 = C3();
        if (r0 == null) goto L6;
        r0.i1(r2);
        return;
    }

    @Override // com.larus.chat.gallery.providers.input.a
    public final void lY(z0 r1) {
        this.A = r1;
        this.B = null;
        G3();
    }

    public final void m3(boolean r5) {
        if (r5 == false) goto L4;
        int r6 = 2131103194;
    L5:
        Intrinsics.checkNotNullParameter(this, "<this>");
        int r7 = ContextCompat.getColor(com.larus.ui.arch.component.internal.attach.a.b(this, this).requireContext(), r6);
        o r0 = C3();
        ViewGroup r1 = null;
        if (r0 == null) goto L8;
        va8.b r2 = r0.rX();
    L9:
        if (r2 == null) goto L11;
        View r3 = r2.f;
    L13:
        if ((r3 instanceof ViewGroup) == false) goto L15;
        ViewGroup r4 = (ViewGroup) r3;
    L16:
        if (r4 == null) goto L21;
        Iterator r8 = ((ArrayList) B3(r4)).iterator();
    L19:
        if (r8.hasNext() == false) goto L21;
        ((TextView) r8.next()).setTextColor(r7);
    L21:
        if (r2 == null) goto L23;
        View r9 = r2.g;
    L25:
        if ((r9 instanceof ViewGroup) == false) goto L27;
        r1 = (ViewGroup) r9;
    L27:
        if (r1 == null) goto L32;
        Iterator r10 = ((ArrayList) B3(r1)).iterator();
    L30:
        if (r10.hasNext() == false) goto L35;
        ((TextView) r10.next()).setTextColor(r7);
        goto L30
    L35:
        return;
    L32:
        return;
    L23:
        r9 = null;
        goto L25
    L15:
        r4 = null;
        goto L16
    L11:
        r3 = null;
        goto L13
    L8:
        r2 = null;
        goto L9
    L4:
        r6 = 2131103298;
        goto L5
    }

    public final void onViewCreated(View r7) {
        Intrinsics.checkNotNullParameter(r7, "view");
        FLogger.a.i(this.m, "onViewCreated");
        z8 r0 = E3();
        if (r0 == null) goto L5;
        r0.z9(true);
    L5:
        z8 r1 = E3();
        if (r1 == null) goto L8;
        r1.R8();
    L8:
        z8 r2 = E3();
        if (r2 == null) goto L11;
        r2.s9();
    L11:
        z8 r3 = E3();
        if (r3 == null) goto L14;
        r3.w8();
    L14:
        z8 r4 = E3();
        if (r4 == null) goto L17;
        r4.w9(false);
    L17:
        z8 r5 = E3();
        if (r5 == null) goto L20;
        r5.r8(false, null);
    L20:
        z8 r6 = E3();
        if (r6 == null) goto L23;
        r6.y9(1, new g9.a(new n(this)));
    L23:
        z8 r8 = E3();
        if (r8 == null) goto L26;
        r8.y9(2, new g9.a(new zy8.o(this)));
    L26:
        z8 r9 = E3();
        if (r9 == null) goto L29;
        r9.y9(3, new g9.a(new p(this)));
    L29:
        z8 r10 = E3();
        if (r10 == null) goto L32;
        r10.S8(true);
    L32:
        ICoreInputAbility r11 = D3();
        if (r11 == null) goto L35;
        r11.v6(new q(this));
    L35:
        z8 r12 = E3();
        if (r12 == null) goto L38;
        r12.W8(new z8.c(new zy8.c(this), new d()));
    L38:
        o r13 = C3();
        if (r13 == null) goto L41;
        r13.N4();
    L41:
        l r14 = (l) this.p.getValue();
        if (r14 == null) goto L44;
        r14.N4();
    L44:
        Intrinsics.checkNotNullParameter(this, "<this>");
        DialogFragment r15 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getParentFragment();
        if ((r15 instanceof DialogFragment) == false) goto L47;
        DialogFragment r16 = r15;
    L48:
        if (r16 == null) goto L50;
        View r17 = r16.getView();
    L52:
        if ((r17 instanceof ViewGroup) == false) goto L54;
        ViewGroup r18 = (ViewGroup) r17;
    L55:
        if (r18 == null) goto L59;
        o r19 = C3();
        if (r19 == null) goto L59;
        r19.m1(r18);
    L59:
        Q3(null);
        V3(false);
        G3();
        r7.post(new e(this));
        return;
    L54:
        r18 = null;
        goto L55
    L50:
        r17 = null;
        goto L52
    L47:
        r16 = null;
        goto L48
    }

    public final void p3(boolean r6) {
        m r0 = null;
        if (r6 == false) goto L5;
        m r1 = this.D;
    L6:
        o r2 = C3();
        if (r2 == null) goto L9;
        va8.b r3 = r2.rX();
    L10:
        if (r3 == null) goto L14;
        View r4 = r3.b;
        if (r4 == null) goto L14;
        r4.setOnTouchListener(r1);
    L14:
        if (r3 == null) goto L23;
        View r5 = r3.f;
        if (r5 == null) goto L23;
        if (r6 == false) goto L19;
        r0 = this.D;
    L22:
        r5.setOnTouchListener(r0);
        goto L23
    L19:
        e2 r7 = s1a.d.a(this).getAbility(e2.class);
        if (r7 == null) goto L22;
        r0 = r7.lK();
    L23:
        if (r3 == null) goto L27;
        View r8 = r3.d;
        if (r8 == null) goto L27;
        r8.setOnTouchListener(r1);
    L27:
        if (r3 == null) goto L31;
        View r9 = r3.h;
        if (r9 == null) goto L31;
        r9.setOnTouchListener(r1);
    L31:
        if (r3 == null) goto L35;
        View r10 = r3.j;
        if (r10 == null) goto L35;
        r10.setOnTouchListener(r1);
    L35:
        if (r3 == null) goto L40;
        View r11 = r3.i;
        if (r11 == null) goto L41;
        r11.setOnTouchListener(r1);
        return;
    L41:
        return;
    L40:
        return;
    L9:
        r3 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.larus.chat.gallery.providers.input.a
    public final void ri(com.larus.chat.gallery.providers.input.b r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        FLogger.a.i(this.m, "setCallback");
        this.v = r4;
        Q3(null);
        V3(false);
    }

    @Override // com.larus.chat.gallery.providers.input.a
    public final void xS(String r10) {
        Intrinsics.checkNotNullParameter(r10, ShareType.TEXT);
        ICoreInputAbility r1 = D3();
        if (r1 == null) goto L5;
        ICoreInputAbility.b.d(r1, r10, false, false, null, null, false, 56);
    L5:
        G3();
    }

    public final void z3(boolean r4) {
        ICoreInputAbility r0 = D3();
        if (r0 == null) goto L6;
        r0.setEnabled(!r4);
    L6:
        if (r4 == false) goto L13;
        ICoreInputAbility r1 = D3();
        if (r1 == null) goto L10;
        r1.p80(true);
    L10:
        Intrinsics.checkNotNullParameter(this, "<this>");
        String r2 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getString(2131899434);
        ICoreInputAbility r3 = D3();
        if (r3 == null) goto L13;
        r3.Uu(r2, false);
    L13:
        h3(r4);
        m3(r4);
        p3(r4);
        V3(false);
    }

    public final void W3(View r3, boolean r4) {
        if (r3.getId() != 2131373416) goto L10;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r5 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        if ((r5 instanceof GalleryInputFragment) == false) goto L7;
        GalleryInputFragment r6 = (GalleryInputFragment) r5;
    L8:
        if (r6 == null) goto L15;
        r6.t = r4;
        r6.la0();
        return;
    L15:
        return;
    L7:
        r6 = null;
        goto L8
    L10:
        if (r4 == false) goto L12;
        int r7 = 0;
    L13:
        r3.setVisibility(r7);
        return;
    L12:
        r7 = 8;
        goto L13
    }

    @Override // com.larus.chat.gallery.providers.input.a
    public final void zp(boolean r5, n0 r6) {
        FLogger.a.i(this.m, "configPlusButtonInterceptor: enableShown=" + r5);
        z8 r0 = E3();
        if (r0 == null) goto L6;
        r0.l9(new z8.b(r5, r6));
        return;
    }

    @Override // com.larus.chat.gallery.providers.input.a
    public final void el(List<SuggestedAction> r2, SuggestedActionScene r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "actions");
        this.w = r2;
        this.x = r3;
        this.y = r4;
        this.z = r5;
        V3(false);
    }

    public static final void Y2(GalleryInputComponent r18, boolean r19, SuggestedAction r20, List r21, int r22, int r23, boolean r24) {
        Long r1 = r18.u;
        if (r1 == null) goto L5;
        long r2 = r1.longValue();
    L6:
        if (r24 == false) goto L8;
        String r3 = "direct";
    L9:
        String r5 = r3;
        LinkedHashMap r4 = new LinkedHashMap();
        Iterator r6 = r21.iterator();
    L11:
        if (r6.hasNext() == false) goto L17;
        Object r7 = r6.next();
        Integer r8 = Integer.valueOf(((SuggestedAction) r7).getRow());
        Object r9 = r4.get(r8);
        if (r9 != null) goto L15;
        r9 = new ArrayList();
        r4.put(r8, r9);
    L15:
        ((List) r9).add(r7);
        goto L11
    L17:
        if (r4.size() <= 1) goto L19;
        String r10 = "multi_line";
    L20:
        String r11 = r10;
        if (r19 == false) goto L27;
        LruCache<String, wc9.e> r12 = ko8.a.a;
        String r13 = ko8.a.e(r2);
        SuggestedExt r14 = r20.getExt();
        if (r14 == null) goto L25;
        String r15 = r14.getDisplayNameStartlingKey();
    L26:
        t3.b("picture_detail", r5, null, r13, r15, r11, String.valueOf(r23 + 1), String.valueOf(r22 + 1), "pic_upload", Integer.valueOf(r18.y), r18.z, "input_attachment_sug", null, 12292);
        return;
    L25:
        r15 = null;
        goto L26
    L27:
        LruCache<String, wc9.e> r16 = ko8.a.a;
        String r17 = ko8.a.e(r2);
        SuggestedExt r25 = r20.getExt();
        if (r25 == null) goto L30;
        String r26 = r25.getDisplayNameStartlingKey();
    L31:
        t3.a("picture_detail", r5, null, r17, r26, r11, String.valueOf(r23 + 1), String.valueOf(r22 + 1), "pic_upload", Integer.valueOf(r18.y), r18.z, "input_attachment_sug", null, 12292);
        return;
    L30:
        r26 = null;
        goto L31
    L19:
        r10 = "single_line";
        goto L20
    L8:
        r3 = "slide";
        goto L9
    L5:
        r2 = ko8.a.e;
        goto L6
    }
}
