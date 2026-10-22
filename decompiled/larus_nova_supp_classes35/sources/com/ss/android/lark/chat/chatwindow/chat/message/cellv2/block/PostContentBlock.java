package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Layout;
import android.text.TextUtils;
import android.util.Range;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.FragmentActivity;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.lark.pb.basic.v1.File;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.chat.base.view.vo.message.PostContentVO;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.columns.ColumnsUtils;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.table.TableUtils;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.TextLayoutRender;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.TextLayoutRenderExtKt;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2.TextLayoutRenderConfigs;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chat.ChatAnnouncement;
import com.ss.android.lark.chat.entity.chat.ChatDisplayModeSetting;
import com.ss.android.lark.chat.entity.media.MediaImageSet;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageEditInfo;
import com.ss.android.lark.chat.entity.message.MessageIdentity;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.MessageLink;
import com.ss.android.lark.chat.entity.message.MessageStreamStatus;
import com.ss.android.lark.chat.entity.message.SendStatus;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.ss.android.lark.chat.message.menu.MessageLongPressTextSelectHelper;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.ss.android.lark.chat.utils.ReplyInThreadUtil;
import com.ss.android.lark.chatbase.view.post.PostChatView;
import com.ss.android.lark.chatwindow.view.photopreview.OperateListenerImpl;
import com.ss.android.lark.chatwindow.view.widget.TouchInterceptionLayout;
import com.ss.android.lark.coremd.clickcompat.MomentsAppLinkPatcher;
import com.ss.android.lark.coremd.facade.bizext.IMContextExtend;
import com.ss.android.lark.doc.entity.Doc;
import com.ss.android.lark.doc.entity.DocResult;
import com.ss.android.lark.doc.entity.DocType;
import com.ss.android.lark.dto.chat.ProfileSource;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.statistics.chat.ChatHitPointExtraParams;
import com.ss.android.lark.statistics.chat.ChatHitPointNew;
import com.ss.android.lark.statistics.message.MessageHitPoint;
import com.ss.android.lark.utils.Contexts;
import com.ss.android.lark.widget.codeblock.preview.CodeBlockV2Info;
import com.ss.android.lark.widget.codeblock.process.CodeBlockV2ProcessParams;
import com.ss.android.lark.widget.columns.entity.ColumnsInfo;
import com.ss.android.lark.widget.light.LKUILightTextView;
import com.ss.android.lark.widget.photo.preview.EnterSource;
import com.ss.android.lark.widget.photopicker.animation.activitytransition.ActivityTransitionLauncher;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.android.lark.widget.richtext.Image;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.span.AbbreviationInfo;
import com.ss.android.lark.widget.span.AtUserGroupInfo;
import com.ss.android.lark.widget.span.MediaInfo;
import com.ss.android.lark.widget.span.UrlInfo;
import com.ss.android.lark.widget.table.entity.TableInfo;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class PostContentBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<PostContentVO>, PostContentVO> {
    public static final /* synthetic */ int o = 0;
    public final IMMessageKeys$Blocks g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final BrowserDependency l;
    public final w4b.c.h m;
    public final g3b.r n;

    public static final class a {
    }

    public static final class b implements com.ss.android.lark.blueprint.k<View>, e9c.a {
        public final View a;
        public final LottieAnimationView b;
        public final PostChatView c;
        public final TextView d;
        public final TouchInterceptionLayout e;
        public final ViewStub f;
        public View g;
        public PostChatView h;
        public TextView i;
        public ImageView j;
        public View k;
        public Group l;

        public final TextView d() {
            return this.i;
        }

        public final ImageView e() {
            return this.j;
        }

        public final View getView() {
            return this.a;
        }

        public b(View r10) {
            Intrinsics.checkNotNullParameter(r10, "view");
            this.a = r10;
            LottieAnimationView r1 = r10.findViewById(2131380556);
            this.b = r1;
            PostChatView r2 = (PostChatView) r10.findViewById(2131365577);
            this.c = r2;
            this.d = (TextView) r10.findViewById(2131390708);
            this.e = (TouchInterceptionLayout) r10.findViewById(2131382829);
            this.f = (ViewStub) r10.findViewById(2131382830);
            a(r2);
            Range<Integer> r11 = ChatCoreModule.a().getMyAIDependency().e();
            r1.setMinAndMaxFrame(((Number) r11.getLower()).intValue(), ((Number) r11.getUpper()).intValue());
            AssetManager r12 = r1.getContext().getAssets();
            boolean r3 = false;
            PolarisFileWrapper r4 = new PolarisFileWrapper("ai_message_loading.lottie");     // Catch: IOException -> L14
            String r5 = r4.getParent();     // Catch: IOException -> L14
            if (r5 == null) goto L7;
            String r6 = StringsKt.replace$default(r5, "\\", "/", false, 4, null);     // Catch: IOException -> L14
            if (r6 == null) goto L7;
        L8:
            String r7 = r4.getName();     // Catch: IOException -> L14
            String[] r13 = r12.list(r6);     // Catch: IOException -> L14
            if (r13 == null) goto L16;
            if (ArraysKt.contains(r13, r7) != true) goto L16;
            r3 = true;
        L16:
            if (r3 == false) goto L21;
            this.b.setAnimation("ai_message_loading.lottie");
            return;
        L21:
            return;
        L7:
            r6 = BuildConfig.FLAVOR;
        L14:
            e = move-exception;
            e.printStackTrace();
            goto L16
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(PostChatView r3) {
            r3.setTitleTextSize(zz7.b.h(r3.getContext(), 17));
            r3.setTextSize((int) zz7.b.h(r3.getContext(), 17));
            r3.setShowMoreTextSize(zz7.b.h(r3.getContext(), 14));
            zz7.a.d(this.d, LarkFont.BODY1);
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ PostContentBlock a;
        public final /* synthetic */ b b;

        public c(PostContentBlock r1, b r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            if (this.a.c.e0() == true) goto L6;
            this.b.c.performClick();
            return;
        }
    }

    public static final class d implements PostChatView.a {
        public final /* synthetic */ PostContentBlock a;
        public final /* synthetic */ y6b.a<PostContentVO> b;

        public d(PostContentBlock r1, y6b.a<PostContentVO> r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.ss.android.lark.chatbase.view.post.PostChatView.a
        public final void onClick() {
            b3b.f r0 = (b3b.f) this.a.k.getValue();
            if (r0 == null) goto L6;
            r0.b(this.b.getId());
            return;
        }
    }

    public static final class e {
        public final /* synthetic */ y6b.a<PostContentVO> a;
        public final /* synthetic */ com.ss.android.lark.blueprint.m<y6b.a<PostContentVO>> b;
        public final /* synthetic */ PostContentBlock c;

        public e(y6b.a<PostContentVO> r1, com.ss.android.lark.blueprint.m<y6b.a<PostContentVO>> r2, PostContentBlock r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class f implements mcc.f {
        public final /* synthetic */ PostContentBlock a;
        public final /* synthetic */ y6b.a<PostContentVO> b;

        public f(PostContentBlock r1, y6b.a<PostContentVO> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void q(View r3, ColumnsInfo r4) {
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "columnsInfo");
            w4b.g r5 = ChatCoreModule.a().getChatDependency();
            Context r0 = this.a.getContext();
            this.b.b().g();
            this.a.c.getChatId();
            this.b.getId();
            r5.b(r0, r4);
        }
    }

    public static final class g implements mcc.a {
        public final /* synthetic */ PostContentBlock a;
        public final /* synthetic */ y6b.a<PostContentVO> b;

        public g(PostContentBlock r1, y6b.a<PostContentVO> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void s(View r1, AbbreviationInfo r2, float r3, float r4) {
            Intrinsics.checkNotNullParameter(r1, "view");
            Intrinsics.checkNotNullParameter(r2, "abbreviationInfo");
            if (r2.bizType != AbbreviationInfo.AbbreviationType.CALENDAR) goto L6;
            ChatCoreModule.a().getIRecommendEventAiDependency();
            this.a.c.getContext();
            throw null;
        L6:
            ChatCoreModule.a().getEnterpriseTopicDependency();
            this.a.c.getChatId();
            this.b.h();
            throw null;
        }
    }

    public static final class h implements mcc.l {
        public final /* synthetic */ PostContentBlock a;

        public final void b(View r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "view");
            Intrinsics.checkNotNullParameter(r3, "phoneNumber");
        }

        public h(PostContentBlock r1) {
            this.a = r1;
        }

        public final void a(View r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "view");
            Intrinsics.checkNotNullParameter(r3, "phoneNumber");
            PostContentBlock r4 = this.a;
            r4.m.a(r4.getContext(), r3);
        }
    }

    public static final class i implements mcc.o {
        public final /* synthetic */ PostContentBlock a;
        public final /* synthetic */ y6b.a<PostContentVO> b;

        public final boolean t(View r2, UrlInfo r3) {
            Intrinsics.checkNotNullParameter(r2, "view");
            Intrinsics.checkNotNullParameter(r3, "urlInfo");
            return false;
        }

        public i(PostContentBlock r1, y6b.a<PostContentVO> r2) {
            this.a = r1;
            this.b = r2;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void r(View r11, UrlInfo r12) {
            Intrinsics.checkNotNullParameter(r11, "view");
            Intrinsics.checkNotNullParameter(r12, "urlInfo");
            ChatCoreModule.a().getPerfEnterChatMonitor().c();
            mya.w r13 = this.a.c.j5().b(mya.w.class);
            if (r13 == null) goto L6;
            this.b.getId();
            String r0 = r12.href;
            if (r13.w() == false) goto L6;
        L7:
            String r14 = h7b.l.b(this.a.c.isMeeting(), this.a.c.isGroup(), this.a.c.X());
            Intrinsics.checkNotNull(r14);
            MessageHitPoint.e("richtext", r14, this.b.getId());
            if (this.a.c.isSecretChat() == true) goto L10;
            ChatCoreModule.a().getAuditDependency().auditLinkEvent(this.a.c.getChatId(), r12.href);
        L10:
            String r1 = null;
            if (this.a.c.e0() == false) goto L14;
            ChatHitPointExtraParams.Occasion r15 = ChatHitPointExtraParams.Occasion.MULTI_FORWARD;
        L17:
            PostContentBlock r2 = this.a;
            y6b.a<PostContentVO> r3 = this.b;
            String r4 = r12.href;
            r2.getClass();
            PostContentVO r5 = r3.b();
            DocResult r6 = r5.i;
            Map<String, PreviewHangPoint> r7 = ((PostContent) r5.a).getPreviewHangPoints();
            Map<String, Doc> r8 = ((PostContent) r5.a).getDocEntityMap();
            String r9 = "docs";
            if (r6 == null) goto L20;
            String r10 = r6.getDoc().getId();
            DocType r16 = r6.getDoc().getDocType();
        L54:
            ChatHitPointNew.j(r3);
            com.ss.android.lark.chat.utils.d.a(r4, r15, r7);
            if (r2.c.m() == false) goto L57;
        L62:
            b3b.f r17 = (b3b.f) this.a.i.getValue();
            if (r17 == null) goto L72;
            r17.p(this.b.getId(), r12.href);
            return;
        L72:
            return;
        L57:
            if (r2.c.Y() == true) goto L62;
            if (r16 == null) goto L61;
            r1 = ChatHitPointNew.k(r16);
        L61:
            ChatHitPointNew.f(r2.c.getChat(), r9, ChatHitPointNew.c(r9), ChatHitPointNew.b(r2.c, r3, r10, r1, r4));
            goto L62
        L20:
            if (r8 == null) goto L30;
            if (CollectionUtils.isNotEmpty(r8) == false) goto L30;
            Iterator r18 = CollectionsKt.toList(r8.values()).iterator();
        L25:
            if (r18.hasNext() == false) goto L53;
            Doc r19 = (Doc) r18.next();
            if (TextUtils.equals(r4, r19.getUrl()) == false) goto L25;
            r10 = r19.getId();
            r16 = r19.getDocType();
        L53:
            r9 = "url";
            r10 = null;
            r16 = null;
        L30:
            if ((!r7.isEmpty()) == false) goto L53;
            Iterator<PreviewHangPoint> r20 = r7.values().iterator();
        L33:
            if (r20.hasNext() == false) goto L53;
            PreviewHangPoint r21 = r20.next();
            String r22 = r21.getUrl();
            String r23 = r21.getPreviewId();
            UrlCardPreviewEntity r24 = r21.getUrlCardPreviewEntity();
            if (TextUtils.equals(r22, r4) == false) goto L33;
            if (r24 == null) goto L38;
            UrlInlinePreviewEntity r25 = r24.getInlineEntity();
        L39:
            if (r25 == null) goto L41;
            UrlInlinePreviewEntity.AppInfo r26 = r25.getAppInfo();
        L42:
            if (r26 != null) goto L44;
            String r27 = null;
            String r28 = null;
        L52:
            ChatHitPointNew.i(r22, r23, r28, r27, r3);
            goto L53
        L44:
            if (r26.getAppId() == null) goto L46;
            r28 = String.valueOf(r26.getAppId());
        L48:
            if (r26.getSceneType() == null) goto L50;
            r27 = String.valueOf(r26.getSceneType());
            goto L52
        L50:
            r27 = null;
            goto L52
        L46:
            r28 = null;
            goto L48
        L41:
            r26 = null;
            goto L42
        L38:
            r25 = null;
            goto L39
        L14:
            if ((this.a.c instanceof s2b.d) == false) goto L16;
            r15 = ChatHitPointExtraParams.Occasion.MSG;
            goto L17
        L16:
            r15 = null;
        L6:
            Bundle r110 = com.ss.android.lark.chat.utils.i0.c(r12.urlPreviewId, this.b);
            boolean r29 = this.a.c.isGroup();
            String r30 = MomentsAppLinkPatcher.a(r12.href);
            PostContentBlock r31 = this.a;
            r31.l.b(r31.getContext(), r30, r29 ? 1 : 0, r110);
            com.ss.android.lark.chat.utils.i0.e(r12.urlPreviewId, this.b);
            goto L7
        }
    }

    public static final class j implements mcc.b {
        public final /* synthetic */ PostContentBlock a;
        public final /* synthetic */ y6b.a<PostContentVO> b;

        public final boolean c(View r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "view");
            Intrinsics.checkNotNullParameter(r3, "text");
            Intrinsics.checkNotNullParameter(r4, "userId");
            return false;
        }

        public j(PostContentBlock r1, y6b.a<PostContentVO> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void d(View r4, String r5, String r6) {
            Intrinsics.checkNotNullParameter(r4, "view");
            Intrinsics.checkNotNullParameter(r5, "text");
            Intrinsics.checkNotNullParameter(r6, "userId");
            w4b.b0 r7 = ChatCoreModule.a().getProfileDependency();
            Context r8 = this.a.getContext();
            ProfileSource.a r0 = new ProfileSource.a();
            r0.e = r6;
            r0.d = this.b.getChatId();
            r0.b = 1;
            r0.c = com.ss.android.lark.chat.utils.k.a(this.a.c.getChat());
            r7.e(r8, new ProfileSource(r0));
            PostContentBlock r9 = this.a;
            y6b.a<PostContentVO> r10 = this.b;
            if (r9.c.m() == false) goto L5;
            return;
        L5:
            if (r9.c.Y() == true) goto L10;
            ChatHitPointNew.f(r9.c.getChat(), "@someone", ChatHitPointNew.c("@someone"), ChatHitPointNew.b(r9.c, r10, null, null, null));
            return;
        }
    }

    public static final class k implements mcc.c {
        public final /* synthetic */ PostContentBlock a;
        public final /* synthetic */ y6b.a<PostContentVO> b;

        public k(PostContentBlock r1, y6b.a<PostContentVO> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void i(View r4, AtUserGroupInfo r5) {
            Intrinsics.checkNotNullParameter(r4, "view");
            Intrinsics.checkNotNullParameter(r5, "info");
            x1b.b r6 = this.a.c.get();
            Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type com.ss.android.lark.chat.chatwindow.chat.v2.push.IChatAppContainer");
            ((com.ss.android.lark.chat.chatwindow.chat.v2.push.v) r6).E().H8(this.a.getContext(), r5);
            PostContentBlock r7 = this.a;
            y6b.a<PostContentVO> r0 = this.b;
            if (r7.c.m() == false) goto L5;
            return;
        L5:
            if (r7.c.Y() == true) goto L10;
            Map r1 = MapsKt.toMutableMap(ChatHitPointNew.b(r7.c, r0, null, null, null));
            r1.put("at_user_group", "true");
            r1.put("user_group_id", String.valueOf(r5.getUserGroupId()));
            ChatHitPointNew.f(r7.c.getChat(), "@someone", ChatHitPointNew.c("@someone"), r1);
            return;
        }
    }

    public static final class l implements mcc.i {
        public final /* synthetic */ PostContentBlock a;

        public final boolean o(View r1, String r2, String r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r1, "view");
            Intrinsics.checkNotNullParameter(r2, "id");
            Intrinsics.checkNotNullParameter(r3, IPortraitService.NAME);
            return false;
        }

        public l(PostContentBlock r1) {
            this.a = r1;
        }

        public final void p(View r1, String r2, String r3, boolean r4, String r5) {
            Intrinsics.checkNotNullParameter(r1, "view");
            Intrinsics.checkNotNullParameter(r2, "id");
            Intrinsics.checkNotNullParameter(r3, IPortraitService.NAME);
            ChatCoreModule.a().openAppLinkUrl(this.a.getContext(), r5);
        }
    }

    public static final class m implements View.OnLongClickListener {
        public final /* synthetic */ y6b.a<PostContentVO> a;
        public final /* synthetic */ PostContentBlock b;
        public final /* synthetic */ PostChatView c;
        public final /* synthetic */ com.ss.android.lark.blueprint.m<y6b.a<PostContentVO>> d;
        public final /* synthetic */ boolean e;

        public m(y6b.a<PostContentVO> r1, PostContentBlock r2, PostChatView r3, com.ss.android.lark.blueprint.m<y6b.a<PostContentVO>> r4, boolean r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r12) {
            Intrinsics.checkNotNullParameter(r12, "v");
            if (this.a.L() != MessageStreamStatus.Transport) goto L5;
            return true;
        L5:
            PostContentBlock r0 = this.b;
            g3b.r r1 = r0.n;
            e6b.b r3 = null;
            if (r1 == null) goto L8;
            Function1<? super View, Unit> r2 = r1.d.b;
        L9:
            if (r2 == null) goto L12;
            r2.invoke(r12);
            return true;
        L12:
            com.ss.android.lark.biz.im.api.message.params.z r13 = r0.c.d0(com.ss.android.lark.biz.im.api.message.params.z.class);
            boolean r4 = false;
            if (r13 != null) goto L15;
        L17:
            boolean r14 = false;
        L18:
            PostContentBlock r5 = this.b;
            y6b.a<PostContentVO> r6 = this.a;
            if (r5.c.e0() == false) goto L21;
        L23:
            boolean r7 = false;
        L24:
            if (r7 == true) goto L26;
        L38:
            com.ss.android.lark.blueprint.m<y6b.a<PostContentVO>> r15 = this.d;
            if ((r15 instanceof e6b.b) == false) goto L41;
            r3 = (e6b.b) r15;
        L41:
            if (r3 == null) goto L43;
            r3.e(this.b, this.a);
        L43:
            return true;
        L26:
            if (this.c.e.getVisibility() != 0) goto L28;
            boolean r8 = true;
        L29:
            if (r8 == true) goto L38;
            LKUILightTextView r9 = this.c.getContentView();
            WeakReference<com.ss.android.lark.widget.select.m> r10 = com.ss.android.lark.chat.message.menu.a.a;
            Intrinsics.checkNotNullParameter(r9, "view");
            if (com.ss.android.lark.chat.message.menu.a.b(r9) == false) goto L33;
        L34:
            r4 = true;
        L35:
            if (r4 == false) goto L38;
            if (r14 == true) goto L38;
            PostContentBlock r16 = this.b;
            com.ss.android.lark.blueprint.m<y6b.a<PostContentVO>> r11 = this.d;
            PostChatView r17 = this.c;
            y6b.a<PostContentVO> r18 = this.a;
            boolean r19 = this.e;
            r16.getClass();
            MessageLongPressTextSelectHelper.f(r17.getContentView(), r16.c, r19, new PostContentBlock$showTextSelect$1(r18, r16), new PostContentBlock$showTextSelect$2(null, r18, r16, r11), null);
            goto L43
        L33:
            if (com.ss.android.lark.chat.utils.u.a.a.e == true) goto L35;
        L28:
            r8 = false;
            goto L29
        L21:
            if (r6.b().i() == true) goto L23;
            r7 = true;
            goto L24
        L15:
            if (r13.a != true) goto L17;
            r14 = true;
            goto L18
        L8:
            r2 = null;
            goto L9
        }
    }

    public static final class n implements mcc.h {
        public final /* synthetic */ y6b.a<PostContentVO> a;
        public final /* synthetic */ PostContentBlock b;

        public n(y6b.a<PostContentVO> r1, PostContentBlock r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void m(View r18, MediaInfo r19) {
            Intrinsics.checkNotNullParameter(r18, "view");
            Intrinsics.checkNotNullParameter(r19, Keys.API_PARAM_KEY_MEDIA_INFO);
            RichTextElement.MediaProperty r3 = com.ss.android.lark.widget.richtext.d.b(this.a.b().g(), r19);
            if (r3 != null) goto L5;
            return;
        L5:
            MediaImageSet r4 = com.ss.android.lark.parser.internal.d.d(this.a, r3);
            if (this.b.n == null) goto L11;
            if (r4.getMessageIdentity() == null) goto L11;
            r4.getMessageIdentity().setSourceType(this.b.n.e);
        L11:
            if (this.b.e == null) goto L13;
            MessageIdentity r5 = r4.getMessageIdentity();
            r5.setSourceId(this.a.I());
            r5.setSourceType(this.a.J());
        L13:
            List r6 = com.ss.android.lark.widget.photopicker.utils.l.b(CollectionsKt.listOf(r4));
            if (CollectionUtils.isEmpty(r6) == true) goto L68;
            OperateListenerImpl r7 = new OperateListenerImpl(this.b.c.getChat());
            if (this.b.c.isSecretChat() == false) goto L19;
            Scene r8 = Scene.SecretChat;
        L25:
            ActivityTransitionLauncher.LocationInfo r9 = new ActivityTransitionLauncher.LocationInfo(r19.width, r19.height, r19.left, r19.top);
            boolean r10 = false;
            PhotoItem r11 = (PhotoItem) ListProtector.get(r6, 0);
            if (r11 == null) goto L29;
            r11.setThumbnail(r19.mediaThumbnail);
        L29:
            if (this.b.c.getChat() == null) goto L33;
            int r2 = com.ss.android.lark.chat.utils.y0.a;
            if (com.ss.android.lark.chat.utils.y0.d(this.b.c.getChat()) == false) goto L33;
            boolean r12 = true;
        L35:
            if (this.b.c.isSecretChat() == true) goto L39;
            int r13 = com.ss.android.lark.chat.utils.y0.a;
            if (com.ss.android.lark.chat.utils.y0.b(this.b.c.getChat()) == false) goto L39;
            boolean r14 = true;
        L40:
            int r15 = com.ss.android.lark.chat.utils.y0.a;
            if (com.ss.android.lark.chat.utils.y0.c(this.b.c.getChat()) == true) goto L43;
        L45:
            boolean r16 = false;
        L47:
            if (this.b.c.isSecretChat() == false) goto L49;
        L51:
            boolean r17 = false;
        L52:
            boolean r110 = com.ss.android.lark.chat.utils.y0.e(this.b.c.getChat());
            String r111 = ChatCoreModule.a().getMergeForwardDependnecy().a();
            if (TextUtils.isEmpty(r111) == true) goto L57;
            int r112 = ((ArrayList) r6).size();
            int r113 = 0;
        L55:
            if (r113 >= r112) goto L57;
            ((PhotoItem) ListProtector.get(r6, r113)).setEntityId(r111);
            r113 = r113 + 1;
        L57:
            EnterSource.a r20 = EnterSource.Companion;
            Message.SourceType r114 = this.a.J();
            r20.getClass();
            EnterSource r21 = EnterSource.a.a(r114);
            if (ChatCoreModule.a().getMergeForwardDependnecy().c() == false) goto L60;
            r21 = EnterSource.Favorite;
        L60:
            v4b.d r115 = this.b.e;
            w4b.u r116 = MessagePermissionUtil.a;
            int r117 = com.ss.android.lark.widget.photo.preview.k.a;
            com.ss.android.lark.widget.photo.preview.k.c r1 = com.ss.android.lark.widget.photo.preview.k.a.a(new ArrayList(r6), 0, r18);
            r1.d(false);
            r1.c = r9;
            boolean r22 = this.b.c.isSecretChat();
            r1.a.putBoolean("is_secret", r22);
            if (this.b.c.isSecretChat() == false) goto L63;
        L65:
            r1.j(r10);
            r1.g(r17);
            r1.a.putString("preview_id", null);
            r1.a.putString("msg_link_token", null);
            r1.l(r14);
            r1.n(r14);
            r1.m(r12);
            r1.f(r7);
            r1.e(true ^ r110);
            r1.q(Biz.Messenger, r8, 2);
            r1.h(r16);
            r1.b(r21);
            r1.u(Contexts.requireActivity(this.b.getContext()));
            return;
        L63:
            if (this.b.c.e0() == true) goto L65;
            r10 = true;
            goto L65
        L49:
            if (com.ss.android.lark.chat.utils.y0.a(this.b.c.getChat()) == false) goto L51;
            r17 = true;
            goto L52
        L43:
            if (this.a.isPreMessage() == true) goto L45;
            r16 = true;
        L39:
            r14 = false;
        L33:
            r12 = false;
            goto L35
        L19:
            if (this.b.c.r() == false) goto L21;
        L24:
            r8 = Scene.Thread;
            goto L25
        L21:
            if (this.b.c.q() == true) goto L24;
            r8 = Scene.Chat;
            goto L25
        }
    }

    public static final class o implements mcc.e {
        public final /* synthetic */ y6b.a<PostContentVO> a;
        public final /* synthetic */ PostContentBlock b;

        public o(y6b.a<PostContentVO> r1, PostContentBlock r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void n(View r2, CodeBlockV2Info r3) {
            Intrinsics.checkNotNullParameter(r2, "view");
            Intrinsics.checkNotNullParameter(r3, "codeBlockV2Info");
            if (this.a.L() != MessageStreamStatus.Transport) goto L6;
            Log.i("PostContentBlock", "message is transporting, disable code block click");
            return;
        L6:
            float r4 = zz7.b.h(this.b.getContext(), 14);
            CodeBlockV2ProcessParams.Companion.getClass();
            CodeBlockV2ProcessParams r5 = CodeBlockV2ProcessParams.b.a((int) r4);
            com.ss.android.lark.widget.richtext.codeblockv2.h.a(this.b.getContext(), r3.getLineContents(), r5);
        }
    }

    public static final class p implements mcc.n {
        public final /* synthetic */ PostContentBlock a;
        public final /* synthetic */ y6b.a<PostContentVO> b;

        public p(PostContentBlock r1, y6b.a<PostContentVO> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void g(LKUILightTextView r3, TableInfo r4) {
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "tableInfo");
            w4b.g r5 = ChatCoreModule.a().getChatDependency();
            Context r0 = this.a.getContext();
            this.b.b().g();
            this.b.getId();
            r5.y(r0, r4);
        }
    }

    public static final class q implements mcc.g {
        public final /* synthetic */ y6b.a<PostContentVO> a;
        public final /* synthetic */ PostChatView b;
        public final /* synthetic */ RichText c;
        public final /* synthetic */ PostContentBlock d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ mya.h f;

        public final void j(View r11, mcc.p r12) {
            Intrinsics.checkNotNullParameter(r11, "view");
            Intrinsics.checkNotNullParameter(r12, "imageClickInfo");
            if (this.a.b().i() == false) goto L6;
            this.b.performClick();
            return;
        L6:
            Image r2 = com.ss.android.lark.widget.richtext.d.a(this.c, r12.c, r12.b);
            if (r2 != null) goto L10;
            Log.e("PostContentBlock", "Can't find select image, token:" + r12.c + ", url:" + r12.b);
            return;
        L10:
            com.ss.android.lark.image.entity.Image r7 = com.ss.android.lark.parser.internal.i0.a(r2);
            if (r7 != null) goto L13;
            return;
        L13:
            RichText r3 = this.c;
            String r4 = this.a.getId();
            boolean r5 = this.a.h();
            PostContentBlock r6 = this.d;
            y6b.a<PostContentVO> r8 = this.a;
            r6.getClass();
            y6b.b r9 = r8.a();
            if (r9 == null) goto L17;
            String r10 = r9.w;
            if (r10 == null) goto L17;
        L18:
            PhotoItem r13 = com.ss.android.lark.chat.utils.v0.d(r3, r7, r4, r5, r10);
            if (r13 != null) goto L21;
            return;
        L21:
            MessageIdentity r14 = r13.getMessageIdentity();
            if (r14 == null) goto L24;
            r14.setRiskObjectKeys(((PostContent) this.a.b().a).getRiskObjectKeys());
        L24:
            r13.getTranslateProperty().setTranslated(this.e);
            r13.setThumbnail(r12.h);
            this.d.getClass();
            ActivityTransitionLauncher.LocationInfo r15 = new ActivityTransitionLauncher.LocationInfo();
            r15.width = r12.d;
            r15.height = r12.e;
            r15.left = r12.f;
            r15.top = r12.g;
            if (this.d.e == null) goto L30;
            mya.s r16 = this.f.b(mya.s.class);
            if (r16 == null) goto L30;
            m2b.a r17 = this.d.c;
            int r18 = com.ss.android.lark.chat.chatwindow.chat.message.actionimpl.e.a;
            Intrinsics.checkNotNullParameter(r12, "imageClickInfo");
            int r1 = r12.f;
            int r19 = r12.g;
            r16.b(r17, r11, new Rect(r1, r19, r12.d + r1, r12.e + r19), this.a, r7, this.e, 2);
            return;
        L30:
            b3b.f r20 = (b3b.f) this.d.j.getValue();
            if (r20 == null) goto L34;
            r20.s(r11, r15, r13, false, this.e, 2, this.a.J());
            return;
        L34:
            return;
        L17:
            r10 = BuildConfig.FLAVOR;
            goto L18
        }

        public q(y6b.a<PostContentVO> r1, PostChatView r2, RichText r3, PostContentBlock r4, boolean r5, mya.h r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    static {
    }

    public final com.ss.android.lark.blueprint.j getKey() {
        return this.g;
    }

    public PostContentBlock(com.ss.android.lark.blueprint.g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        this.g = IMMessageKeys$Blocks.POST_CONTENT;
        this.h = LazyKt.lazy(new PostContentBlock$mTranslateListener$2(this));
        this.i = LazyKt.lazy(new PostContentBlock$mUrlClickListener$2(this));
        this.j = LazyKt.lazy(new PostContentBlock$mMediaClickListener$2(this));
        this.k = LazyKt.lazy(new PostContentBlock$mPostMessageCallback$2(this));
        this.l = ChatCoreModule.a().getBrowserDependency();
        this.m = ChatCoreModule.a().getPhoneDependency();
        this.n = (g3b.r) this.c.d0(g3b.r.class);
    }

    public final boolean i(y6b.a<?> r4) {
        int r0 = com.ss.android.lark.chat.chatwindow.chat.model.preload.a.a;
        Intrinsics.checkNotNullParameter(r4, "messageVO");
        if (r4.r() < 1000) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == true) goto L8;
    L18:
        return false;
    L8:
        if (this.c.m() == true) goto L18;
        if (this.c.e0() == true) goto L18;
        if (this.c.r() == true) goto L18;
        if (this.c.q() == true) goto L18;
        if (this.c.Y() == true) goto L18;
        return true;
    L5:
        r5 = false;
        goto L6
    }

    public final com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b j(y6b.a<?> r7) {
        com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r0 = new com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b();
        r0.p = r7.getId();
        y6b.b r1 = r7.a();
        if (r1 == null) goto L6;
        String r2 = r1.w;
        if (r2 == null) goto L6;
    L7:
        r0.q = r2;
        if (this.c.m() == false) goto L10;
        r0.x = 19;
    L10:
        boolean r3 = true;
        if (this.c.Y() == false) goto L22;
        if ((r7 instanceof y6b.c) == true) goto L15;
    L17:
        int r4 = 23;
    L18:
        r0.x = r4;
        if (this.c.b0() == false) goto L22;
        r0.Z = true;
        goto L22
    L15:
        if (((y6b.c) r7).Y() == false) goto L17;
        r4 = 22;
    L22:
        if (i(r7) == false) goto L24;
        r0.m = false;
    L24:
        ValidateIMFileResult r5 = r7.N();
        if (r5 == null) goto L27;
        IMFileResult r6 = r5.getResultType();
    L28:
        MessagePermissionUtil.ReceiveAuthorizationState r8 = MessagePermissionUtil.h(r6);
        ValidateResult r9 = MessagePermissionUtil.b();
        r0.a(r9);
        r0.o = MessagePermissionUtil.f(r7, this.c.getChat(), r9);
        Intrinsics.checkNotNullParameter(r8, "receiveAuthorizationState");
        r0.B = r8;
        r0.C = r7.N();
        com.ss.android.lark.biz.im.api.message.params.e r10 = this.c.d0(com.ss.android.lark.biz.im.api.message.params.e.class);
        if (r10 == null) goto L37;
        com.ss.android.lark.biz.im.api.message.params.o r11 = r10.b;
        if (r11 == null) goto L37;
        if (r7.h() == false) goto L35;
        int r12 = r11.a;
    L36:
        r0.t = Integer.valueOf(r12);
        goto L37
    L35:
        r12 = r11.b;
    L37:
        g3b.r r13 = (g3b.r) this.c.d0(g3b.r.class);
        if (r13 != null) goto L40;
    L43:
        boolean r14 = true;
    L44:
        r0.D = r14;
        if (r13 != null) goto L47;
    L50:
        boolean r15 = true;
    L51:
        r0.E = r15;
        if (r13 != null) goto L54;
    L56:
        r3 = false;
    L57:
        r0.O = r3;
        return r0;
    L54:
        if (r13.c.a == false) goto L56;
    L47:
        if (r13.a.b == true) goto L50;
        r15 = false;
        goto L51
    L40:
        if (r13.a.a == true) goto L43;
        r14 = false;
        goto L44
    L27:
        r6 = null;
    L6:
        r2 = BuildConfig.FLAVOR;
        goto L7
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(final com.ss.android.lark.blueprint.m<y6b.a<PostContentVO>> r18, com.ss.android.lark.blueprint.q<y6b.a<PostContentVO>> r19, final y6b.a<PostContentVO> r20) {
        Intrinsics.checkNotNullParameter(r18, "cell");
        Intrinsics.checkNotNullParameter(r19, "layout");
        Intrinsics.checkNotNullParameter(r20, Keys.API_RETURN_KEY_DATA);
        final b r11 = (b) r19.c(this.g, IMMessageKeys$Slots.CONTENT, PostContentBlock$update$blockView$1.INSTANCE);
        r11.b.setVisibility(8);
        r11.b.cancelAnimation();
        r11.c.setVisibility(8);
        r11.d.setVisibility(8);
        View r0 = r11.g;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        MessageStreamStatus r1 = r20.L();
        MessageStreamStatus r2 = MessageStreamStatus.Prepare;
        int r3 = 0;
        if (r1 != r2) goto L8;
        boolean r4 = true;
    L10:
        if (r20.L() != r2) goto L12;
        int r5 = 0;
        int r6 = 8;
    L13:
        r11.b.setVisibility(r5);
        r11.c.setVisibility(r6);
        View r7 = r11.g;
        if (r7 == null) goto L16;
        r7.setVisibility(r6);
    L16:
        if (r4 == false) goto L19;
        r11.b.playAnimation();
        return;
    L19:
        PostContentVO r13 = r20.b();
        m2b.a r8 = this.c;
        Intrinsics.checkNotNullParameter(r8, "<this>");
        if ((r8.k() & 16) <= 0) goto L22;
        boolean r9 = true;
    L24:
        if (h7b.l.d(r13) == true) goto L27;
        if (r9 == false) goto L27;
        boolean r14 = true;
    L29:
        if (r13.f != 3) goto L31;
        boolean r15 = true;
    L32:
        if (r14 == false) goto L36;
        if (r15 == true) goto L36;
        boolean r10 = false;
    L37:
        if (r14 == true) goto L39;
        View r12 = r11.g;
        if (r12 == null) goto L50;
        r12.setVisibility(8);
    L50:
        ConstraintLayout r16 = r11.c;
        if (r10 == false) goto L53;
        int r17 = 0;
    L54:
        r16.setVisibility(r17);
        View r21 = r11.g;
        if (r21 == null) goto L60;
        if (r14 == false) goto L58;
        int r22 = 0;
    L59:
        r21.setVisibility(r22);
        goto L60
    L58:
        r22 = 8;
    L60:
        Group r23 = r11.l;
        if (r23 == null) goto L68;
        if (r10 == false) goto L65;
        if (r14 == false) goto L65;
    L66:
        r23.setVisibility(r3);
    L65:
        r3 = 8;
    L68:
        if (e9c.b.a(r11, r20, this.c) == true) goto L71;
        return;
    L71:
        if (this.c.q8() == false) goto L75;
        if (this.c.e0() == true) goto L75;
    L77:
        UIUtils.disableAllParentClipChild(r11.i);
        TextView r24 = r11.i;
        b3b.f r25 = (b3b.f) this.h.getValue();
        m2b.a r26 = this.c;
        Intrinsics.checkNotNullParameter(r20, "item");
        if (r24 == null) goto L80;
        r24.setOnClickListener(new e9c.c(r25, r20, r26));
    L80:
        TextView r27 = r11.i;
        if (r27 == null) goto L83;
        r27.setOnLongClickListener(new d0(r18, this, r20));
    L83:
        ImageView r28 = r11.j;
        b3b.f r29 = (b3b.f) this.h.getValue();
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type com.ss.android.lark.chat.vo.AbsMessageVO<com.ss.android.lark.chat.export.vo.ContentVO<*>>");
        e9c.b.c(r28, r29, r20, this.c);
        r11.e.setIsEnableDoubleClick(true);
        r11.e.setDoubleClickListener(new AnonymousClass1(this, r18, r11, r20));
        if (r10 == false) goto L86;
        m(r11, r11.c, r20, r13.i());
        l(r18, r11.c, r13.g(), r20, false);
        String r110 = "null cannot be cast to non-null type com.ss.android.lark.chat.base.view.vo.message.PostContentVO";
        k(r11.c, r20, r18, r13, r11, r20, false);
    L88:
        if (r13.i() == false) goto L90;
        TextView r30 = r11.d;
        r30.setVisibility(8);
        r30.setOnClickListener(new f0(this));
    L91:
        if (r14 == false) goto L101;
        if (r15 == false) goto L102;
        Object r31 = r13.g;
        Intrinsics.checkNotNull(r31, r110);
        PostContentVO r32 = (PostContentVO) r31;
        m(r11, r11.h, r20, r32.i());
        l(r18, r11.h, r32.g(), r20, true);
        k(r11.h, r20, r18, r32, r11, r20, true);
        View r33 = r11.k;
        if (r33 == null) goto L103;
        boolean r34 = r20.h();
        int r35 = p3b.a.W;
        if (r34 == false) goto L98;
        int r36 = v4b.a.h;
    L99:
        r33.setBackgroundColor(r36);
        return;
    L98:
        r36 = v4b.a.G;
        goto L99
    L103:
        return;
    L102:
        return;
    L101:
        return;
    L90:
        r11.d.setVisibility(8);
        goto L91
    L86:
        r110 = "null cannot be cast to non-null type com.ss.android.lark.chat.base.view.vo.message.PostContentVO";
        Object r37 = r13.g;
        Intrinsics.checkNotNull(r37, r110);
        PostContentVO r38 = (PostContentVO) r37;
        m(r11, r11.h, r20, r38.i());
        l(r18, r11.h, r38.g(), r20, true);
        k(r11.h, r20, r18, r38, r11, r20, true);
    L75:
        if (e9c.b.a == false) goto L77;
        UIUtils.hide(r11.i);
        UIUtils.hide(r11.j);
        goto L77
    L53:
        r17 = 8;
        goto L54
    L39:
        if (r11.g != null) goto L41;
        View r39 = dwa.j.d(r11.f.getContext()).f(r11.f);
        r11.g = r39;
        PostChatView r40 = (PostChatView) r39.findViewById(2131389347);
        r11.h = r40;
        r11.k = r39.findViewById(2131389342);
        r11.i = (TextView) r39.findViewById(2131389354);
        r11.j = (ImageView) r39.findViewById(2131389346);
        r11.l = r39.findViewById(2131369224);
        Intrinsics.checkNotNull(r40);
        r11.a(r40);
    L41:
        View r41 = r11.g;
        if (r41 == null) goto L44;
        r41.setVisibility(0);
    L44:
        TextView r42 = r11.i;
        if (r42 == null) goto L50;
        zz7.a.c(r42, 12);
    L36:
        r10 = true;
        goto L37
    L31:
        r15 = false;
    L27:
        r14 = false;
        goto L29
    L22:
        r9 = false;
        goto L24
    L12:
        r5 = 8;
        r6 = 0;
        goto L13
    L8:
        r4 = false;
        goto L10
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m<y6b.a<PostContentVO>> r1, com.ss.android.lark.blueprint.q<y6b.a<PostContentVO>> r2, y6b.a<PostContentVO> r3) {
        update2(r1, r2, r3);
    }

    public final void h(y6b.a<PostContentVO> r3, boolean r4, com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r5, com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2.n r6) {
        int r0 = TextLayoutRender.j;
        if (TextLayoutRender.c.a() == false) goto L10;
        r6.a(r6.f.b(com.ss.android.lark.coremd.base.parse.c.a(IMContextExtend.A, PostContentBlock$asyncParseLayoutCompat$1.INSTANCE)));
        b3b.f r7 = (b3b.f) this.k.getValue();
        if (r7 != null) goto L8;
        return;
    L8:
        if (i(r3) == false) goto L17;
        int r1 = com.ss.android.lark.chat.chatwindow.chat.model.preload.a.a;
        com.ss.android.lark.chat.chatwindow.chat.model.preload.a.b(this.c.I8(), r4, r3, r6, r7);
        return;
    L17:
        return;
    L10:
        b3b.f r8 = (b3b.f) this.k.getValue();
        if (r8 != null) goto L14;
        return;
    L14:
        if (i(r3) == false) goto L19;
        int r9 = com.ss.android.lark.chat.chatwindow.chat.model.preload.a.a;
        com.ss.android.lark.chat.chatwindow.chat.model.preload.a.a(this.c.I8(), r3, r5, r8);
        return;
    }

    public final void m(b r6, PostChatView r7, y6b.a<PostContentVO> r8, boolean r9) {
        if (r7 != null) goto L4;
        return;
    L4:
        boolean r0 = r8.h();
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.ss.android.lark.chat.vo.ChatMessageVO<*>");
        y6b.c r10 = (y6b.c) r8;
        r7.setTitleTextColor(UIUtils.getColor(getContext(), 2131106622));
        if (this.c.Y() == false) goto L7;
    L10:
        Drawable r1 = UIUtils.getDrawable(getContext(), 2131247396);
    L12:
        if (r10.S1 == Message.ThreadMessageType.THREAD_ROOT_MESSAGE) goto L14;
    L18:
        g3b.r r11 = (g3b.r) this.c.d0(g3b.r.class);
        if (r11 == null) goto L24;
        if (r11.f == false) goto L24;
        r1 = p3b.a.c(getContext(), r0);
    L24:
        if (r11 == null) goto L26;
        CharSequence r4 = r11.g;
    L27:
        r7.setShowMoreTextOverride(r4);
        if (r11 != null) goto L30;
    L32:
        r7.setShowMoreViewBg(r1);
        if (r9 == false) goto L35;
        r7.getTitleDivisionView().setBackground(null);
        int r12 = UIUtils.dp2px(getContext(), 12.0f);
        r6.a.setPadding(r12, r12, r12, 0);
        return;
    L35:
        View r13 = r7.getTitleDivisionView();
        int r14 = p3b.a.W;
        if (r0 == false) goto L38;
        int r15 = v4b.a.h;
    L39:
        r13.setBackgroundColor(r15);
        r6.a.setPadding(0, 0, 0, 0);
        return;
    L38:
        r15 = v4b.a.G;
        goto L39
    L30:
        if (r11.b.a == false) goto L32;
        r1 = UIUtils.getDrawable(getContext(), 2131247396);
        goto L32
    L26:
        r4 = null;
        goto L27
    L14:
        if (ChatCoreModule.a().getFeatureGatingDependency().isEnable("im.message.thread_reply_bubble_optimize") == false) goto L18;
        if (r10.b2 == ChatDisplayModeSetting.THREAD) goto L18;
        r1 = p3b.a.c(getContext(), r0);
        goto L18
    L7:
        if (r10.d() == true) goto L10;
        r1 = p3b.a.c(getContext(), r0);
        goto L12
    }

    public final void l(com.ss.android.lark.blueprint.m<y6b.a<PostContentVO>> r11, PostChatView r12, RichText r13, y6b.a<PostContentVO> r14, boolean r15) {
        v4b.d r0 = this.e;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L10;
        return;
    L10:
        if (r12 != null) goto L12;
        return;
    L12:
        r12.setPhoneSpanClickListener(new h(this));
        r12.setUrlSpanClickListener(new i(this, r14));
        r12.setAtSpanClickListener(new j(this, r14));
        r12.setAtUserGroupSpanClickListener(new k(this, r14));
        r12.setMentionSpanClickListener(new l(this));
        r12.setOnLongClickListener(new m(r14, this, r12, r11, r15));
        r12.setImageClickListener(new q(r14, r12, r13, this, r15, this.c.j5()));
        r12.setVideoClickListener(new n(r14, this));
        r12.setCodeBlockV2ClickListener(new o(r14, this));
        r12.setTableClickListener(new p(this, r14));
        r12.setColumnsClickListener(new f(this, r14));
        r12.setAbbreviationsClickListener(new g(this, r14));
        if (this.c.isAIChat() == false) goto L16;
    L14:
        r1 = false;
    L18:
        r12.setSupportJumpToThread(r1);
        return;
    L16:
        if (this.c.Y() == false) goto L18;
    L5:
        if (r0.i != true) goto L7;
        r2 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void k(PostChatView r24, final y6b.a<PostContentVO> r25, final com.ss.android.lark.blueprint.m<y6b.a<PostContentVO>> r26, PostContentVO r27, b r28, y6b.a<PostContentVO> r29, boolean r30) {
        if (r24 != 0) goto L6;
        return;
    L6:
        if (r29.isPreMessage() == true) goto L8;
        r24.setPreMessageOnClickListener(null);
    L9:
        r24.setOnLongTextClickListener(new d(this, r29));
        com.ss.android.lark.biz.im.api.message.params.e r2 = this.c.d0(com.ss.android.lark.biz.im.api.message.params.e.class);
        if (r2 == null) goto L12;
        List r3 = r2.a;
    L13:
        PostContentVO r4 = r29.b();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.ss.android.lark.chat.base.view.vo.message.BaseTextContentVO<*>");
        PostContentVO r5 = r4;
        r24.setMaxHeightFactor(r5.s);
        r24.setEnableEllipsize(r5.q);
        g3b.r r6 = (g3b.r) this.c.d0(g3b.r.class);
        if (r6 == null) goto L18;
        g3b.f r7 = r6.b;
        if (r7.a == false) goto L18;
        r24.setEnableEllipsize(r7.b);
        r24.setMaxHeightFactor(r6.b.c);
    L18:
        Chat r8 = this.c.getChat();
        if (r8 == null) goto L21;
        ChatAnnouncement r9 = r8.getChatAnnouncement();
    L23:
        if (r9 == null) goto L30;
        Chat r10 = this.c.getChat();
        if (r10 == null) goto L30;
        ChatAnnouncement r11 = r10.getChatAnnouncement();
        if (r11 == null) goto L30;
        String r12 = r11.getAnnounceUrl();
        if (r12 == null) goto L30;
    L31:
        Layout r13 = r27.z;
        z2b.b r14 = this.c.I8();
        if (r14 != null) goto L34;
        int r15 = TextLayoutRender.j;
        r14 = w2b.b.d;
    L34:
        v4b.d r16 = this.e;
        if (r16 != null) goto L37;
    L39:
        boolean r17 = false;
    L41:
        if (r17 == false) goto L67;
        com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r18 = j(r29);
        r18.h = this.c.isSecretChat();
        r18.p = r29.getId();
        y6b.b r19 = r29.a();
        if (r19 == null) goto L46;
        String r110 = r19.w;
        if (r110 == null) goto L46;
    L47:
        r18.q = r110;
        r18.k = r30;
        MessageEditInfo r111 = r29.u();
        if (r111 != null) goto L50;
    L52:
        boolean r112 = false;
    L53:
        r18.r = r112;
        r16.getClass();
        r18.s = false;
        PostContent r113 = (PostContent) r29.b().a;
        w4b.d0 r114 = h7b.l.a;
        if (r113 != null) goto L56;
        boolean r115 = false;
    L57:
        r18.i = r115;
        int r116 = TextLayoutRender.j;
        w2b.b r117 = w2b.b.d;
        RichText r20 = r29.b().g();
        FragmentActivity r21 = this.c.getContext();
        String r118 = BuildConfig.FLAVOR;
        TableUtils.a(r20, r18, r21, r117, new TableUtils.CalculateTableLayoutSceneInfo(r29.getId(), "PostMessageCell"));
        ColumnsUtils.a(r29.b().g(), r18, this.c.getContext(), r117, new ColumnsUtils.CalculateColumnsLayoutSceneInfo(r29.getId(), "PostMessageCell"));
        r18.H = TableUtils.a;
        r18.I = ColumnsUtils.a;
        r18.Z = r16.j;
        if (TextLayoutRender.c.a() == false) goto L62;
        com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2.n r1 = TextLayoutRenderConfigs.b(this.c, r29, r30, r16, r3);
        RichText r22 = r29.b().g();
        if (r22 == null) goto L65;
        CharSequence r23 = TextLayoutRenderExtKt.a(r117, r22, r1);
    L66:
        Log.d("PostContentBlock", "render text with charSequence: " + r23);
        CharSequence r31 = r23;
        Layout r32 = r13;
        boolean r119 = true;
    L93:
        if (this.c.e0() == false) goto L95;
    L98:
        boolean r120 = true;
    L99:
        if (r16 == null) goto L104;
        if (r16.i != true) goto L104;
        boolean r121 = true;
    L106:
        if (this.c.m() == true) goto L110;
        if (this.c.Y() == true) goto L110;
    L112:
        String r33 = r27.h(ChatCoreModule.a().getContext());
    L113:
        boolean r34 = r29.isPreMessage();
        String r35 = r29.getChatId();
        String r36 = r29.getId();
        String r122 = r29.F();
        boolean r210 = r27.i();
        if (r27.i() == true) goto L117;
        r12 = r118;
    L117:
        this.c.isSecretChat();
        r24.R5(r33, r32, r31, r34, r35, r36, r122, r210, r12, r120, this.c.e0(), r119, r121);
        com.ss.android.lark.chatwindow.view.preview.i.c(r24.c, r27.C);
        ArrayList<File> r37 = r29.b().f();
        if ((!r37.isEmpty()) == false) goto L136;
        Function1<View, Boolean> r38 = new PostContentBlock$setupFullTextMode$onItemLongClick$1(r26, this, r25);
        if (r24.i != null) goto L123;
        View r39 = View.inflate(r24.getContext(), 2131559284, null);
        r24.h = r39;
        r24.g.addView(r39, new LinearLayout.LayoutParams(-2, -2));
        r24.i = (LinearLayout) r24.h.findViewById(2131363346);
    L123:
        LinearLayout r40 = r24.i;
        String r41 = r29.getId();
        Chat r42 = this.c.getChat();
        int r43 = r29.A();
        boolean r44 = r29.isPreMessage();
        if (r29.isPreMessage() == true) goto L126;
    L128:
        boolean r45 = false;
    L129:
        ArrayList<String> r46 = ((PostContent) r29.b().a).getRiskObjectKeys();
        m2b.a r123 = this.c;
        if (r16 == null) goto L134;
        MessageInfo r124 = r16.f;
        if (r124 == null) goto L134;
        Message r125 = r124.getMessage();
    L135:
        com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.text.d.a(r40, r37, r41, r42, r43, r44, r38, r45, r46, r29, r123, r125, null, null);
    L142:
        com.ss.android.lark.biz.im.api.message.params.y r47 = this.c.d0(com.ss.android.lark.biz.im.api.message.params.y.class);
        if (r47 == null) goto L161;
        com.ss.android.lark.biz.im.api.message.params.a0 r48 = r47.f;
        if (r48 != null) goto L147;
    L157:
        boolean r49 = r47.h;
        r24.C = r49;
        if (r49 == false) goto L160;
        com.ss.android.lark.blueprint.m<y6b.a<PostContentVO>> r50 = r26;
        r24.D = new e(r25, r50, this);
    L163:
        if (r29.b().i() == true) goto L172;
        r24.setTitleDivisionViewVisible(8);
        if (r24.getTitleDivisionView().getVisibility() != 8) goto L167;
        boolean r51 = true;
    L168:
        if (r51 == false) goto L172;
        ConstraintLayout.LayoutParams r52 = r24.getTitleDivisionView().getLayoutParams();
        Intrinsics.checkNotNull(r52, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        r52.setMargins(0, 0, 0, 0);
        goto L172
    L167:
        r51 = false;
    L172:
        if (this.c.q8() == true) goto L175;
        return;
    L175:
        if (this.c.isSecretChat() == false) goto L178;
        return;
    L178:
        if (r29.isPreMessage() == false) goto L181;
        return;
    L181:
        if (r27.i() == true) goto L204;
        v4b.d r53 = this.e;
        if (r53 == null) goto L190;
        MessageLink.ChatInfo r54 = r53.g;
        if (r54 == null) goto L190;
        if (r54.isAuth() == true) goto L190;
        boolean r55 = true;
    L191:
        if (r55 == false) goto L194;
        return;
    L194:
        if (this.c.L8() == false) goto L196;
    L198:
        boolean r56 = false;
    L199:
        r24.setOnClickListener(new e0(this, r56, r29, r50));
        return;
    L196:
        if (ReplyInThreadUtil.b(r29) == false) goto L198;
        r56 = true;
    L190:
        r55 = false;
        goto L191
    L204:
        return;
    L160:
        r50 = r26;
        r24.D = null;
        goto L163
    L147:
        if ((r25 instanceof y6b.c) == false) goto L157;
        y6b.c r57 = (y6b.c) r25;
        if (r57.K2 == true) goto L151;
    L153:
        boolean r58 = false;
    L154:
        LKUILightTextView r59 = r24.c;
        if (r59 == null) goto L157;
        r59.setEnableUnderline(r58);
        r59.setUnderlineColor(r48.a);
        r59.setUnderlineWidth(r48.b);
        r59.setUnderlineOffsetY(r48.c);
        goto L157
    L151:
        if (r57.i == false) goto L153;
        r58 = true;
        goto L154
    L161:
        r50 = r26;
    L134:
        r125 = null;
        goto L135
    L126:
        if (r29.G() != SendStatus.FAIL) goto L128;
        r45 = true;
        goto L129
    L136:
        LinearLayout r60 = r24.i;
        if (r60 == null) goto L139;
        r60.removeAllViews();
        r24.i.setVisibility(8);
    L139:
        View r61 = r24.h;
        if (r61 == null) goto L142;
        r61.setVisibility(8);
    L110:
        if (r27.i() == true) goto L112;
        r33 = r118;
    L104:
        r121 = false;
        goto L106
    L95:
        if (r29.L() == MessageStreamStatus.Transport) goto L98;
        r120 = false;
    L65:
        r23 = null;
        goto L66
    L62:
        RichText r62 = r29.b().g();
        if (r62 == null) goto L65;
        int r63 = v2b.d.a;
        FragmentActivity r64 = this.c.getContext();
        int r65 = r16.d;
        Intrinsics.checkNotNullParameter(r62, "oriRichText");
        Intrinsics.checkNotNullParameter(r18, "processParams");
        Intrinsics.checkNotNullParameter(r64, "context");
        r23 = v2b.c.a(r62, r18, r64, r65);
        goto L66
    L56:
        r115 = r113.isGroupAnnouncement();
        goto L57
    L50:
        if (r111.isEdited() != true) goto L52;
        r112 = true;
    L46:
        r110 = BuildConfig.FLAVOR;
        goto L47
    L67:
        r118 = BuildConfig.FLAVOR;
        if (r13 != null) goto L89;
        long r66 = System.currentTimeMillis();
        com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2.n r67 = TextLayoutRenderConfigs.b(this.c, r29, r30, null, r3);
        com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r68 = j(r29);
        r68.h = this.c.isSecretChat();
        r68.p = r29.getId();
        y6b.b r126 = r29.a();
        if (r126 == null) goto L73;
        String r127 = r126.w;
        if (r127 == null) goto L73;
    L74:
        r68.q = r127;
        r68.k = r30;
        m2b.a r128 = this.c;
        int r129 = f3b.b.a;
        Intrinsics.checkNotNullParameter(r128, "<this>");
        r68.G = new f3b.a(r128);
        Chat r130 = this.c.getChat();
        if (r130 == null) goto L78;
        String r131 = r130.getAnonymousId();
        if (r131 == null) goto L78;
    L79:
        r68.l = r131;
        RichText r132 = r27.g();
        if (r132 != null) goto L82;
        r132 = new RichText();
    L82:
        int r133 = TextLayoutRender.j;
        if (TextLayoutRender.c.a() == false) goto L85;
        Layout r69 = TextLayoutRenderExtKt.f(r14, r132, r67);
    L86:
        com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r70 = j(r29);
        r70.k = r30;
        r70.m = true;
        m2b.a r134 = this.c;
        Intrinsics.checkNotNullParameter(r134, "<this>");
        r70.G = new f3b.a(r134);
        h(r29, r30, r70, r67);
        Log.i("PostContentBlock", "bind text layout is null, rebuild layout. Time cost:" + (System.currentTimeMillis() - r66));
        r13 = r69;
    L87:
        CharSequence r135 = null;
    L91:
        r32 = r13;
        r31 = r135;
        r119 = false;
        goto L93
    L85:
        r69 = TextLayoutRenderExtKt.d(r14, r29, r68, this.c.getContext());
    L78:
        r131 = r118;
    L73:
        r127 = r118;
        goto L74
    L89:
        if (r27.A == false) goto L87;
        Log.i("AsyncParseLog", "needReParseLayout for POST message " + r29.getId());
        r135 = null;
        com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2.n r71 = TextLayoutRenderConfigs.b(this.c, r29, r30, null, r3);
        com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r72 = j(r29);
        r72.k = r30;
        r72.m = true;
        m2b.a r73 = this.c;
        int r74 = f3b.b.a;
        Intrinsics.checkNotNullParameter(r73, "<this>");
        r72.G = new f3b.a(r73);
        h(r29, r30, r72, r71);
        goto L91
    L37:
        if (r16.b != true) goto L39;
        r17 = true;
    L30:
        r12 = BuildConfig.FLAVOR;
        goto L31
    L21:
        r9 = null;
        goto L23
    L12:
        r3 = null;
        goto L13
    L8:
        r24.setPreMessageOnClickListener(new c(this, r28));
        goto L9
    }
}
