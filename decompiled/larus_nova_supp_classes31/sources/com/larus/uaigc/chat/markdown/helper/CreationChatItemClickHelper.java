package com.larus.uaigc.chat.markdown.helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.bigimg.n1;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageItem;
import com.larus.bmhome.chat.layout.holder.video.bean.AiGenVideoContentData;
import com.larus.bmhome.chat.layout.holder.video.bean.CoverImageEntity;
import com.larus.bmhome.chat.layout.holder.video.bean.CoverItem;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.utils.c4;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Cover;
import com.larus.im.bean.message.CreationGenDetail;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.FileType;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageData;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkEntityType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.im.bean.message.VideoData;
import com.larus.im.bean.message.VideoExtension;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.platform.api.IVideoController;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager$d;
import com.larus.uaigc.service.ICreationMetadataService;
import com.larus.uaigc.service.ICreationReportService;
import com.larus.uaigc.service.ICreationWorkflowService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import tx9.a4;
import tx9.b2;
import tx9.l3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class CreationChatItemClickHelper {
    public static final CreationChatItemClickHelper a = null;
    public static Pair<a, ? extends com.larus.uaigc.chat.markdown.image.component.a> b;
    public static Pair<a, ? extends com.larus.uaigc.chat.markdown.image.component.k> c;

    public static final class a {
        public final String a;
        public final String b;

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
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            String r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "EditorDependencyCacheKey(botId=" + this.a + ", conversationId=" + this.b + ')';
        }

        public a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "botId");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b implements com.larus.uaigc.chat.markdown.image.component.a {
        public final CoroutineScope a;
        public final /* synthetic */ String b;
        public final /* synthetic */ com.larus.uaigc.chat.markdown.image.component.a c;
        public final /* synthetic */ ChatPageContext d;
        public final /* synthetic */ Fragment e;
        public final /* synthetic */ String f;

        @Override // com.larus.uaigc.chat.markdown.image.component.a
        public final String K() {
            String r0 = this.f;
            if (r0 == null) goto L5;
            return r0;
        L5:
            return this.c.K();
        }

        @Override // com.larus.uaigc.chat.markdown.image.component.a
        public final boolean O() {
            return this.c.O();
        }

        @Override // com.larus.uaigc.chat.markdown.image.component.a
        public final com.larus.bmhome.actionbar.model.z0 P() {
            return this.c.P();
        }

        @Override // com.larus.uaigc.chat.markdown.image.component.a
        public final BotModel a() {
            return this.c.a();
        }

        @Override // com.larus.uaigc.chat.markdown.image.component.a
        public final String L() {
            return this.b;
        }

        @Override // com.larus.uaigc.chat.markdown.image.component.a
        public final Fragment M() {
            return this.e;
        }

        @Override // com.larus.uaigc.chat.markdown.image.component.a
        public final ChatPageContext N() {
            return this.d;
        }

        @Override // com.larus.uaigc.chat.markdown.image.component.a
        public final CoroutineScope getScope() {
            return this.a;
        }

        public b(CoroutineScope r1, String r2, com.larus.uaigc.chat.markdown.image.component.a r3, ChatPageContext r4, Fragment r5, String r6) {
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.a = r1;
        }
    }

    public static final class c implements com.larus.uaigc.chat.markdown.image.component.a {
        public final CoroutineScope a;
        public final /* synthetic */ String b;
        public final /* synthetic */ BotModel c;
        public final /* synthetic */ Ref.BooleanRef d;
        public final /* synthetic */ Ref.ObjectRef<com.larus.bmhome.actionbar.model.z0> e;
        public final /* synthetic */ ChatPageContext f;
        public final /* synthetic */ Fragment g;
        public final /* synthetic */ String h;

        @Override // com.larus.uaigc.chat.markdown.image.component.a
        public final boolean O() {
            return this.d.element;
        }

        @Override // com.larus.uaigc.chat.markdown.image.component.a
        public final com.larus.bmhome.actionbar.model.z0 P() {
            return (com.larus.bmhome.actionbar.model.z0) this.e.element;
        }

        @Override // com.larus.uaigc.chat.markdown.image.component.a
        public final String K() {
            return this.h;
        }

        @Override // com.larus.uaigc.chat.markdown.image.component.a
        public final String L() {
            return this.b;
        }

        @Override // com.larus.uaigc.chat.markdown.image.component.a
        public final Fragment M() {
            return this.g;
        }

        @Override // com.larus.uaigc.chat.markdown.image.component.a
        public final ChatPageContext N() {
            return this.f;
        }

        @Override // com.larus.uaigc.chat.markdown.image.component.a
        public final BotModel a() {
            return this.c;
        }

        @Override // com.larus.uaigc.chat.markdown.image.component.a
        public final CoroutineScope getScope() {
            return this.a;
        }

        public c(CoroutineScope r1, String r2, BotModel r3, Ref.BooleanRef r4, Ref.ObjectRef<com.larus.bmhome.actionbar.model.z0> r5, ChatPageContext r6, Fragment r7, String r8) {
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.a = r1;
        }
    }

    public static final class d implements com.larus.uaigc.chat.markdown.image.component.k {
        public final CoroutineScope a;
        public final /* synthetic */ String b;
        public final /* synthetic */ com.larus.uaigc.chat.markdown.image.component.k c;
        public final /* synthetic */ ChatPageContext d;
        public final /* synthetic */ Fragment e;
        public final /* synthetic */ String f;

        @Override // com.larus.uaigc.chat.markdown.image.component.k
        public final String K() {
            String r0 = this.f;
            if (r0 == null) goto L5;
            return r0;
        L5:
            return this.c.K();
        }

        @Override // com.larus.uaigc.chat.markdown.image.component.k
        public final boolean O() {
            return this.c.O();
        }

        @Override // com.larus.uaigc.chat.markdown.image.component.k
        public final com.larus.bmhome.actionbar.model.z0 P() {
            return this.c.P();
        }

        @Override // com.larus.uaigc.chat.markdown.image.component.k
        public final BotModel a() {
            return this.c.a();
        }

        @Override // com.larus.uaigc.chat.markdown.image.component.k
        public final String L() {
            return this.b;
        }

        @Override // com.larus.uaigc.chat.markdown.image.component.k
        public final Fragment M() {
            return this.e;
        }

        @Override // com.larus.uaigc.chat.markdown.image.component.k
        public final ChatPageContext N() {
            return this.d;
        }

        @Override // com.larus.uaigc.chat.markdown.image.component.k
        public final CoroutineScope getScope() {
            return this.a;
        }

        public d(CoroutineScope r1, String r2, com.larus.uaigc.chat.markdown.image.component.k r3, ChatPageContext r4, Fragment r5, String r6) {
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.a = r1;
        }
    }

    public static final class e implements com.larus.uaigc.chat.markdown.image.component.k {
        public final CoroutineScope a;
        public final /* synthetic */ String b;
        public final /* synthetic */ BotModel c;
        public final /* synthetic */ Ref.BooleanRef d;
        public final /* synthetic */ Ref.ObjectRef<com.larus.bmhome.actionbar.model.z0> e;
        public final /* synthetic */ ChatPageContext f;
        public final /* synthetic */ Fragment g;
        public final /* synthetic */ String h;

        @Override // com.larus.uaigc.chat.markdown.image.component.k
        public final boolean O() {
            return this.d.element;
        }

        @Override // com.larus.uaigc.chat.markdown.image.component.k
        public final com.larus.bmhome.actionbar.model.z0 P() {
            return (com.larus.bmhome.actionbar.model.z0) this.e.element;
        }

        @Override // com.larus.uaigc.chat.markdown.image.component.k
        public final String K() {
            return this.h;
        }

        @Override // com.larus.uaigc.chat.markdown.image.component.k
        public final String L() {
            return this.b;
        }

        @Override // com.larus.uaigc.chat.markdown.image.component.k
        public final Fragment M() {
            return this.g;
        }

        @Override // com.larus.uaigc.chat.markdown.image.component.k
        public final ChatPageContext N() {
            return this.f;
        }

        @Override // com.larus.uaigc.chat.markdown.image.component.k
        public final BotModel a() {
            return this.c;
        }

        @Override // com.larus.uaigc.chat.markdown.image.component.k
        public final CoroutineScope getScope() {
            return this.a;
        }

        public e(CoroutineScope r1, String r2, BotModel r3, Ref.BooleanRef r4, Ref.ObjectRef<com.larus.bmhome.actionbar.model.z0> r5, ChatPageContext r6, Fragment r7, String r8) {
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.a = r1;
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/im/internal/core/util/GsonHolder$fromJson$1$1", "Lcom/google/gson/reflect/TypeToken;", "runtime_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class f extends TypeToken<Map<String, ? extends fz9.a>> {
        public f() {
        }
    }

    public static final class g implements IIMCallback<Message> {
        public final /* synthetic */ kotlinx.coroutines.i<Message> a;

        public final boolean mustInMain() {
            return !com.larus.im.internal.delegate.y0.a();
        }

        public g(kotlinx.coroutines.j r1) {
            this.a = r1;
        }

        public final void onFailure(IIMError r4) {
            Intrinsics.checkNotNullParameter(r4, "error");
            FLogger.a.e("MDImageScrollWidget", "getMessageFromDb failed", r4.getException());
            if (this.a.isActive() == false) goto L6;
            this.a.resumeWith(Result.constructor-impl(null));
            return;
        }

        public final void onSuccess(Object r2) {
            Message r3 = (Message) r2;
            Intrinsics.checkNotNullParameter(r3, "result");
            if (this.a.isActive() == false) goto L6;
            this.a.resumeWith(Result.constructor-impl(r3));
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/im/internal/core/util/GsonHolder$fromJson$1$1", "Lcom/google/gson/reflect/TypeToken;", "runtime_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class h extends TypeToken<Map<String, ? extends String>> {
        public h() {
        }
    }

    static {
        a = new CreationChatItemClickHelper();
    }

    public CreationChatItemClickHelper() {
    }

    public static Map j(Message r7) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Object r2 = null;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L25
        Map r8 = r7.getExt();     // Catch: Throwable -> L25
        if (r8 == null) goto L22;
        String r9 = (String) r8.get("creation_canvas_creation_info");     // Catch: Throwable -> L25
        if (r9 == null) goto L22;
        zd9.h r4 = zd9.h.a;     // Catch: Throwable -> L25
        if (StringsKt.isBlank(r9) == false) goto L35;
    L20:
        Object r10 = null;
    L21:
        Map r11 = (Map) r10;     // Catch: Throwable -> L25
    L23:
        Object r12 = Result.constructor-impl(r11);     // Catch: Throwable -> L25
    L28:
        if (Result.isFailure-impl(r12) == true) goto L32;
        r2 = r12;
    L32:
        return (Map) r2;
    L35:
        r4.getClass();     // Catch: Throwable -> L13
        r10 = Result.constructor-impl(zd9.h.b.fromJson(r9, new f().getType()));     // Catch: Throwable -> L13
    L15:
        Throwable r5 = Result.exceptionOrNull-impl(r10);     // Catch: Throwable -> L25
        if (r5 == null) goto L19;
        com.larus.im.internal.delegate.c0 r6 = com.larus.im.internal.delegate.c0.b;     // Catch: Throwable -> L25
        StringBuilder r13 = new StringBuilder("fromJson failed, stack: ");     // Catch: Throwable -> L25
        Intrinsics.checkNotNullParameter(r5, "<this>");     // Catch: Throwable -> L25
        r13.append(ExceptionsKt.stackTraceToString(r5));     // Catch: Throwable -> L25
        r6.e("GsonHolder", r13.toString());     // Catch: Throwable -> L25
    L19:
        if (Result.isFailure-impl(r10) == false) goto L21;
    L13:
        th = move-exception;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L25
        r10 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L25
    L22:
        r11 = null;
    L25:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    }

    public static Object m(String r3, Continuation r4) {
        kotlinx.coroutines.j r0 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r4), 1);
        r0.C();
        com.larus.im.d.e().m(r3, new g(r0));
        Object r5 = r0.B();
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r4);
    L5:
        return r5;
    }

    public static Object n(Message r3, Continuation r4) {
        return BuildersKt.withContext(Dispatchers.getIO(), new CreationChatItemClickHelper$getVideoRecommendParams$2(r3, null), r4);
    }

    public static boolean o(Map r3, String r4) {
        Object r5 = r3.get(r4);
        String r6 = null;
        if (r5 == null) goto L5;
        String r7 = r5.toString();
    L7:
        if (r7 != null) goto L9;
    L16:
        if (r6 == null) goto L19;
        return true;
    L19:
        return false;
    L9:
        if ((!StringsKt.isBlank(r7)) == true) goto L11;
    L13:
        boolean r2 = false;
    L14:
        if (r2 == false) goto L16;
        r6 = r7;
        goto L16
    L11:
        if (Intrinsics.areEqual(r7, "null") == true) goto L13;
        r2 = true;
        goto L14
    L5:
        r7 = null;
        goto L7
    }

    public static iy9.b i(final rd8.b r7, Long r8, Bitmap r9) {
        return new iy9.b(new com.larus.uaigc.chat.markdown.helper.a(r7), new l(r7), new s(r7), r8, r9);
    }

    public static void s(Map r6, Message r7, boolean r8) {
        if (r7 == null) goto L50;
        Map r9 = r7.getExt();
        if (r9 == null) goto L51;
        String r10 = (String) r9.get("creation_template");
        if (r10 == null) goto L52;
        String r1 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L24
        zd9.h r3 = zd9.h.a;     // Catch: Throwable -> L24
        if (StringsKt.isBlank(r10) == false) goto L48;
    L21:
        Object r11 = null;
    L22:
        Object r12 = Result.constructor-impl((Map) r11);     // Catch: Throwable -> L24
    L27:
        if (Result.isFailure-impl(r12) == false) goto L29;
        r12 = null;
    L29:
        Map r13 = (Map) r12;
        CreationChatItemClickHelper r0 = a;
        if (r13 == null) goto L32;
        String r4 = (String) r13.get("recommend_from");
    L33:
        r0.getClass();
        t(r6, "recommend_from", r4, r8);
        if (r13 == null) goto L36;
        String r5 = (String) r13.get("template_rec_extra");
    L37:
        t(r6, "template_rec_extra", r5, r8);
        if (r13 == null) goto L40;
        String r14 = (String) r13.get("template_rec_req_id");
    L41:
        t(r6, "template_rec_req_id", r14, r8);
        if (r13 == null) goto L44;
        r1 = (String) r13.get("from_template_id");
    L44:
        t(r6, "from_template_id", r1, r8);
        return;
    L40:
        r14 = null;
        goto L41
    L36:
        r5 = null;
        goto L37
    L32:
        r4 = null;
        goto L33
    L48:
        r3.getClass();     // Catch: Throwable -> L14
        r11 = Result.constructor-impl(zd9.h.b.fromJson(r10, new h().getType()));     // Catch: Throwable -> L14
    L16:
        Throwable r15 = Result.exceptionOrNull-impl(r11);     // Catch: Throwable -> L24
        if (r15 == null) goto L20;
        com.larus.im.internal.delegate.c0 r16 = com.larus.im.internal.delegate.c0.b;     // Catch: Throwable -> L24
        StringBuilder r17 = new StringBuilder("fromJson failed, stack: ");     // Catch: Throwable -> L24
        Intrinsics.checkNotNullParameter(r15, "<this>");     // Catch: Throwable -> L24
        r17.append(ExceptionsKt.stackTraceToString(r15));     // Catch: Throwable -> L24
        r16.e("GsonHolder", r17.toString());     // Catch: Throwable -> L24
    L20:
        if (Result.isFailure-impl(r11) == false) goto L22;
    L14:
        th = move-exception;
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L24
        r11 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L27
    L52:
        return;
    L51:
        return;
    }

    public static final ChatParam a(CreationChatItemClickHelper r7, String r8, String r9, boolean r10) {
        r7.getClass();
        if (r10 == false) goto L10;
        wc9.e r11 = (wc9.e) AuthModelDelegate.b.y().getValue();
        if (r11 == null) goto L7;
        r8 = r11.a;
    L8:
        if (r8 != null) goto L10;
        r8 = "";
        goto L10
    L7:
        r8 = null;
    L10:
        String r1 = r8;
        if (r10 == false) goto L18;
        com.larus.bmhome.chat.api.e0 r12 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r12 == null) goto L17;
        LaunchInfo r13 = r12.a;
        if (r13 == null) goto L17;
        r9 = r13.W();
    L17:
        String r2 = null;
    L20:
        return new ChatParam(r1, r2, null, null, null, 252);
    L18:
        r2 = r9;
        goto L20
    }

    public static void t(Map r2, String r3, String r4, boolean r5) {
        if (r4 == null) goto L11;
        boolean r1 = true;
        if ((!StringsKt.isBlank(r4)) == true) goto L6;
    L8:
        r1 = false;
    L9:
        if (r1 == false) goto L11;
    L12:
        if (r4 == null) goto L18;
        if (r5 == true) goto L16;
        a.getClass();
        if (o(r2, r3) == false) goto L16;
        return;
    L16:
        r2.put(r3, r4);
        return;
    L18:
        return;
    L6:
        if (Intrinsics.areEqual(r4, "null") == true) goto L8;
    L11:
        r4 = null;
        goto L12
    }

    public static /* synthetic */ boolean f(CreationChatItemClickHelper r9, View r10, Fragment r11, Message r12, String r13, Map r14) {
        r9.getClass();
        return e(r10, r11, r12, null, null, null, null, r13, r14);
    }

    public static com.larus.uaigc.chat.markdown.image.component.a g(CoroutineScope r15, String r16, BotModel r17, ChatPageContext r18, Fragment r19, String r20) {
        Intrinsics.checkNotNullParameter(r15, "lifecycleScope");
        String r0 = "";
        if (r16 != null) goto L5;
        String r3 = "";
    L6:
        a r9 = new a(r3, r20);
        Pair<a, ? extends com.larus.uaigc.chat.markdown.image.component.a> r4 = b;
        if (r4 != null) goto L9;
    L12:
        IActionBarService r5 = (IActionBarService) ServiceManager.get().getService(IActionBarService.class);
        if (r16 == null) goto L16;
        r0 = r16;
    L16:
        List r1 = r5.f(r0);
        if (Intrinsics.areEqual(z2.a.getCreationEditControlConfig().b(), Boolean.TRUE) == false) goto L19;
        int r6 = 28;
    L20:
        Ref.ObjectRef r7 = new Ref.ObjectRef();
        boolean r8 = false;
        if (r1 == null) goto L39;
        Iterator r11 = r1.iterator();
    L24:
        if (r11.hasNext() == false) goto L36;
        Object r12 = r11.next();
        com.larus.bmhome.actionbar.model.r r13 = ((com.larus.bmhome.actionbar.model.z0) r12).q;
        if (r13 == null) goto L33;
        Integer r14 = r13.a;
        if (r14 == null) goto L33;
        if (r14.intValue() != r6) goto L33;
        boolean r110 = true;
    L34:
        if (r110 == false) goto L24;
    L37:
        com.larus.bmhome.actionbar.model.z0 r111 = (com.larus.bmhome.actionbar.model.z0) r12;
        if (r111 == null) goto L39;
    L57:
        r7.element = r111;
        Ref.BooleanRef r112 = new Ref.BooleanRef();
        if (r7.element != null) goto L105;
        com.larus.bmhome.chat.api.e0 r2 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r2 == null) goto L64;
        LaunchInfo r10 = r2.a;
        if (r10 == null) goto L64;
        String r21 = r10.W();
    L66:
        if (Intrinsics.areEqual(r21, r16) == true) goto L105;
        List r22 = ((IActionBarService) ServiceManager.get().getService(IActionBarService.class)).f(r21);
        if (r22 == null) goto L86;
        Iterator r113 = r22.iterator();
    L71:
        if (r113.hasNext() == false) goto L83;
        Object r114 = r113.next();
        com.larus.bmhome.actionbar.model.r r115 = ((com.larus.bmhome.actionbar.model.z0) r114).q;
        if (r115 == null) goto L80;
        Integer r116 = r115.a;
        if (r116 == null) goto L80;
        if (r116.intValue() != r6) goto L80;
        boolean r117 = true;
    L81:
        if (r117 == false) goto L71;
    L84:
        com.larus.bmhome.actionbar.model.z0 r118 = (com.larus.bmhome.actionbar.model.z0) r114;
        if (r118 == null) goto L86;
    L104:
        r7.element = r118;
        r112.element = true;
    L80:
        r117 = false;
        goto L81
    L83:
        r114 = null;
    L86:
        if (r22 == null) goto L103;
        Iterator r23 = r22.iterator();
    L89:
        if (r23.hasNext() == false) goto L101;
        Object r24 = r23.next();
        com.larus.bmhome.actionbar.model.r r119 = ((com.larus.bmhome.actionbar.model.z0) r24).q;
        if (r119 == null) goto L98;
        Integer r120 = r119.a;
        if (r120 == null) goto L98;
        if (r120.intValue() != 16) goto L98;
        boolean r121 = true;
    L99:
        if (r121 == false) goto L89;
    L102:
        r118 = (com.larus.bmhome.actionbar.model.z0) r24;
    L98:
        r121 = false;
        goto L99
    L101:
        r24 = null;
        goto L102
    L103:
        r118 = null;
    L64:
        r21 = null;
    L105:
        com.larus.bmhome.actionbar.model.z0 r25 = (com.larus.bmhome.actionbar.model.z0) r7.element;
        if (r25 == null) goto L110;
        com.larus.bmhome.actionbar.model.r r26 = r25.q;
        if (r26 == null) goto L110;
        r8 = Intrinsics.areEqual(r26.h, Boolean.TRUE);
    L110:
        if (r8 == false) goto L133;
        c r122 = new c(r15, r16, r17, r112, r7, r18, r19, r20);
        b = TuplesKt.to(r9, r122);
        return r122;
    L133:
        return null;
    L33:
        r110 = false;
        goto L34
    L36:
        r12 = null;
    L39:
        if (r1 == null) goto L56;
        Iterator r27 = r1.iterator();
    L42:
        if (r27.hasNext() == false) goto L54;
        Object r123 = r27.next();
        com.larus.bmhome.actionbar.model.r r124 = ((com.larus.bmhome.actionbar.model.z0) r123).q;
        if (r124 == null) goto L51;
        Integer r125 = r124.a;
        if (r125 == null) goto L51;
        if (r125.intValue() != 16) goto L51;
        boolean r126 = true;
    L52:
        if (r126 == false) goto L42;
    L55:
        r111 = (com.larus.bmhome.actionbar.model.z0) r123;
    L51:
        r126 = false;
        goto L52
    L54:
        r123 = null;
        goto L55
    L56:
        r111 = null;
        goto L57
    L19:
        r6 = 16;
        goto L20
    L9:
        if (Intrinsics.areEqual(r9, r4.getFirst()) == false) goto L12;
        return new b(r15, r16, (com.larus.uaigc.chat.markdown.image.component.a) r4.getSecond(), r18, r19, r20);
    L5:
        r3 = r16;
        goto L6
    }

    public static com.larus.uaigc.chat.markdown.image.component.k h(CoroutineScope r13, String r14, BotModel r15, ChatPageContext r16, Fragment r17, String r18) {
        Intrinsics.checkNotNullParameter(r13, "lifecycleScope");
        String r0 = "";
        if (r14 != null) goto L5;
        String r3 = "";
    L6:
        a r9 = new a(r3, r18);
        Pair<a, ? extends com.larus.uaigc.chat.markdown.image.component.k> r4 = c;
        if (r4 != null) goto L9;
    L12:
        IActionBarService r5 = (IActionBarService) ServiceManager.get().getService(IActionBarService.class);
        if (r14 == null) goto L16;
        r0 = r14;
    L16:
        List r1 = r5.f(r0);
        Ref.ObjectRef r6 = new Ref.ObjectRef();
        boolean r7 = false;
        if (r1 == null) goto L34;
        Iterator r2 = r1.iterator();
    L20:
        if (r2.hasNext() == false) goto L32;
        Object r10 = r2.next();
        com.larus.bmhome.actionbar.model.r r11 = ((com.larus.bmhome.actionbar.model.z0) r10).q;
        if (r11 == null) goto L29;
        Integer r12 = r11.a;
        if (r12 == null) goto L29;
        if (r12.intValue() != 24) goto L29;
        boolean r19 = true;
    L30:
        if (r19 == false) goto L20;
    L33:
        com.larus.bmhome.actionbar.model.z0 r110 = (com.larus.bmhome.actionbar.model.z0) r10;
    L35:
        r6.element = r110;
        Ref.BooleanRef r111 = new Ref.BooleanRef();
        if (r6.element != null) goto L65;
        com.larus.bmhome.chat.api.e0 r8 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r8 == null) goto L42;
        LaunchInfo r20 = r8.a;
        if (r20 == null) goto L42;
        String r21 = r20.W();
    L44:
        if (Intrinsics.areEqual(r21, r14) == true) goto L65;
        List r22 = ((IActionBarService) ServiceManager.get().getService(IActionBarService.class)).f(r21);
        if (r22 == null) goto L63;
        Iterator r23 = r22.iterator();
    L49:
        if (r23.hasNext() == false) goto L61;
        Object r112 = r23.next();
        com.larus.bmhome.actionbar.model.r r113 = ((com.larus.bmhome.actionbar.model.z0) r112).q;
        if (r113 == null) goto L58;
        Integer r114 = r113.a;
        if (r114 == null) goto L58;
        if (r114.intValue() != 24) goto L58;
        boolean r115 = true;
    L59:
        if (r115 == false) goto L49;
    L62:
        com.larus.bmhome.actionbar.model.z0 r116 = (com.larus.bmhome.actionbar.model.z0) r112;
    L64:
        r6.element = r116;
        r111.element = true;
    L58:
        r115 = false;
        goto L59
    L61:
        r112 = null;
        goto L62
    L63:
        r116 = null;
    L42:
        r21 = null;
    L65:
        com.larus.bmhome.actionbar.model.z0 r24 = (com.larus.bmhome.actionbar.model.z0) r6.element;
        if (r24 == null) goto L70;
        com.larus.bmhome.actionbar.model.r r25 = r24.q;
        if (r25 == null) goto L70;
        r7 = Intrinsics.areEqual(r25.h, Boolean.TRUE);
    L70:
        if (r7 == false) goto L73;
        e r117 = new e(r13, r14, r15, r111, r6, r16, r17, r18);
        c = TuplesKt.to(r9, r117);
        return r117;
    L73:
        return null;
    L29:
        r19 = false;
        goto L30
    L32:
        r10 = null;
        goto L33
    L34:
        r110 = null;
        goto L35
    L9:
        if (Intrinsics.areEqual(r9, r4.getFirst()) == false) goto L12;
        return new d(r13, r14, (com.larus.uaigc.chat.markdown.image.component.k) r4.getSecond(), r16, r17, r18);
    L5:
        r3 = r14;
        goto L6
    }

    public static void v(Context r22, int r23, String r24, String r25, Message r26, com.larus.bmhome.actionbar.model.z0 r27) {
        hy9.d r2 = ICreationReportService.a.j();
        String r3 = r22.getString(r23);
        if (r27 == null) goto L9;
        com.larus.bmhome.actionbar.model.r r7 = r27.q;
        if (r7 == null) goto L9;
        Integer r8 = r7.a;
        if (r8 == null) goto L9;
        String r10 = r8.toString();
    L10:
        if (r27 == null) goto L14;
        com.larus.bmhome.actionbar.model.r r0 = r27.q;
        if (r0 == null) goto L14;
        String r11 = r0.g;
    L15:
        hy9.d.a.b(r2, r3, null, null, "picture_detail", r24, r25, null, r10, r11, "chat", Boolean.valueOf(com.larus.im.bean.message.a.C0(r26)), tz9.a.a(r26), null, null, null, null, null, null, 1044550);
        return;
    L14:
        r11 = null;
    L9:
        r10 = null;
        goto L10
    }

    public static void u(Context r26, int r27, String r28, String r29, Message r30, Map r31, com.larus.bmhome.actionbar.model.z0 r32) {
        hy9.d r3 = ICreationReportService.a.j();
        String r4 = r26.getString(r27);
        if (r32 == null) goto L9;
        com.larus.bmhome.actionbar.model.r r5 = r32.q;
        if (r5 == null) goto L9;
        Integer r6 = r5.a;
        if (r6 == null) goto L9;
        String r11 = r6.toString();
    L10:
        if (r32 == null) goto L14;
        com.larus.bmhome.actionbar.model.r r1 = r32.q;
        if (r1 == null) goto L14;
        String r12 = r1.g;
    L15:
        boolean r2 = com.larus.im.bean.message.a.C0(r30);
        String r15 = tz9.a.a(r30);
        String r16 = String.valueOf(r31.get("recommend_from"));
        String r19 = String.valueOf(r31.get("template_rec_extra"));
        String r18 = String.valueOf(r31.get("template_rec_req_id"));
        hy9.d.a.a(r3, r4, null, null, "picture_detail", r28, r29, null, r11, r12, "chat", Boolean.valueOf(r2), r15, r16, String.valueOf(r31.get("from_template_id")), r18, r19, null, null, null, null, null, 4128838);
        return;
    L14:
        r12 = null;
    L9:
        r11 = null;
        goto L10
    }

    public static boolean e(View r50, Fragment r51, Message r52, String r53, String r54, String r55, String r56, String r57, Map r58) {
        Intrinsics.checkNotNullParameter(r50, "anchorView");
        Intrinsics.checkNotNullParameter(r57, "fromScene");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("creation_task_id", r53);
        r0.put("vid", r54);
        String r8 = r55;
        r0.put("cover_url", r8);
        String r10 = r56;
        r0.put("download_url", r10);
        if (r58 == null) goto L8;
        Iterator r11 = r58.entrySet().iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        Map.Entry r12 = (Map.Entry) r11.next();
        r0.put((String) r12.getKey(), (String) r12.getValue());
    L8:
        LinkedHashMap r13 = new LinkedHashMap();
        Iterator r1 = r0.entrySet().iterator();
    L9:
        boolean r14 = false;
        if (r1.hasNext() == false) goto L19;
        Map.Entry r15 = (Map.Entry) r1.next();
        String r16 = (String) r15.getValue();
        if (r16 != null) goto L14;
    L15:
        r14 = true;
    L17:
        if ((!r14) == false) goto L9;
        r13.put(r15.getKey(), r15.getValue());
        goto L9
    L14:
        if (StringsKt.isBlank(r16) == false) goto L17;
    L19:
        Object r17 = null;
        if ((!r13.isEmpty()) == true) goto L23;
        r13 = null;
    L23:
        if (r13 == null) goto L28;
        String r2 = (String) r13.get("creation_task_id");
        if (r2 == null) goto L28;
        String r32 = r2;
    L29:
        if (r13 == null) goto L34;
        String r3 = (String) r13.get("vid");
        if (r3 == null) goto L34;
        String r18 = r3;
    L35:
        if (r13 == null) goto L40;
        String r4 = (String) r13.get("cover_url");
        if (r4 == null) goto L40;
        r8 = r4;
    L40:
        if (r13 == null) goto L90;
        String r5 = (String) r13.get("download_url");
        if (r5 == null) goto L90;
        r10 = r5;
    L90:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L82
        if (r18 != null) goto L48;
    L51:
        boolean r7 = true;
    L52:
        if (r7 == false) goto L66;
        if (r8 != null) goto L55;
    L58:
        boolean r9 = true;
    L59:
        if (r9 == false) goto L66;
        if (r10 != null) goto L62;
    L63:
        r14 = true;
    L64:
        if (r14 == false) goto L66;
        UplinkFileEntity r19 = null;
    L80:
        Object r20 = Result.constructor-impl(r19);     // Catch: Throwable -> L82
    L85:
        if (Result.isFailure-impl(r20) == true) goto L88;
        r17 = r20;
    L88:
        ic8.o r21 = ic8.o.a;
        CreationChatItemClickHelper$citeOrQuestionAttachmentToInput$1 r22 = new CreationChatItemClickHelper$citeOrQuestionAttachmentToInput$1(CreationNoWatermarkManager.a);
        r21.getClass();
        return ic8.o.a(r50, r51, r52, r32, (UplinkFileEntity) r17, r57, r13, r22);
    L62:
        if (StringsKt.isBlank(r10) == false) goto L64;
    L55:
        if (StringsKt.isBlank(r8) == true) goto L58;
        r9 = false;
    L66:
        int r23 = UplinkEntityType.EntityTypeFile.getValue();     // Catch: Throwable -> L82
        Integer r24 = Integer.valueOf(FileType.FileTypeVideo.getValue());     // Catch: Throwable -> L82
        if (r8 != null) goto L69;
    L74:
        Image r110 = null;
    L76:
        if (r10 != null) goto L78;
        String r25 = "";
    L79:
        r19 = new UplinkFileEntity(Integer.valueOf(r23), new UplinkEntityContent(new UplinkFileInfo(null, null, null, r24, null, null, new VideoExtension(r18, null, r110, null, r25, null, null, null, null, null, 1002, null), null, null, null, 951, null), null, 2, null), r32, null, null, null, null, null, null, false, null, null, null, r13, 8184, null);     // Catch: Throwable -> L82
        goto L80
    L78:
        r25 = r10;
        goto L79
    L69:
        if ((!StringsKt.isBlank(r8)) == false) goto L71;
        String r111 = r8;
    L72:
        if (r111 == null) goto L74;
        r110 = new Image(null, null, null, null, null, null, null, null, new ImageObj(r111, 0, 0, null, null, 30, null), null, null, null, null, null, 16127, null);     // Catch: Throwable -> L82
        goto L76
    L71:
        r111 = null;
        goto L72
    L48:
        if (StringsKt.isBlank(r18) == true) goto L51;
        r7 = false;
    L82:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r20 = Result.constructor-impl(ResultKt.createFailure(th));
    L34:
        r18 = r54;
    L28:
        r32 = r53;
        goto L29
    }

    public static /* synthetic */ Object l(CreationChatItemClickHelper r10, Message r11, String r12, String r13, Boolean r14, BotModel r15, wc9.e r16, List r17, Continuation r18) {
        return r10.k(r11, r12, r13, r14, r15, r16, r17, MapsKt.emptyMap(), r18);
    }

    public final Object k(Message r19, String r20, String r21, Boolean r22, BotModel r23, wc9.e r24, List<Message> r25, Map<String, ? extends Object> r26, Continuation<? super Map<String, ? extends Object>> r27) {
        Message r0 = r19;
        if ((r27 instanceof CreationChatItemClickHelper$getCommonParamsWithRepoFallback$1) == false) goto L7;
        CreationChatItemClickHelper$getCommonParamsWithRepoFallback$1 r4 = (CreationChatItemClickHelper$getCommonParamsWithRepoFallback$1) r27;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        if (r7 == 0) goto L14;
        if (r7 != 1) goto L13;
        Map r1 = (Map) r4.L$1;
        Message r2 = (Message) r4.L$0;
        ResultKt.throwOnFailure(r3);
        Map r8 = r1;
        r0 = r2;
    L101:
        Message r9 = (Message) r3;
    L103:
        Map r10 = MapsKt.toMutableMap(r8);
        a.getClass();
        s(r10, r9, false);
        if (r9 == null) goto L108;
        Map r11 = r9.getExt();
        if (r11 == null) goto L108;
        String r12 = (String) r11.get("creation_template");
    L109:
        if (r12 == null) goto L111;
        r10.put("message", r0);
    L111:
        return r10;
    L108:
        r12 = null;
        goto L109
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r3);
        Intrinsics.checkNotNullParameter(r26, "extraParams");
        Pair[] r13 = new Pair[12];
        r13[0] = TuplesKt.to("user_type", "bot");
        String r14 = "chat";
        r13[1] = TuplesKt.to("enter_picture_method", "chat");
        if (Intrinsics.areEqual(r22, Boolean.TRUE) == false) goto L17;
        r14 = "temporary_chat";
    L17:
        r13[2] = TuplesKt.to("enter_from", r14);
        if (r0 == null) goto L20;
        String r15 = r19.getMessageId();
    L21:
        String r16 = "";
        if (r15 != null) goto L24;
        r15 = "";
    L24:
        r13[3] = TuplesKt.to("message_id", r15);
        if (r0 == null) goto L27;
        String r17 = r19.getConversationId();
    L28:
        if (r17 != null) goto L30;
        r17 = "";
    L30:
        r13[4] = TuplesKt.to("conversation_id", r17);
        if (r23 == null) goto L34;
        String r18 = r23.getBotId();
        if (r18 == null) goto L34;
    L35:
        r13[5] = TuplesKt.to("bot_id", r18);
        IAIChatControlTraceService.Companion r28 = IAIChatControlTraceService.a;
        if (r24 == null) goto L38;
        Integer r29 = r24.v;
    L39:
        if (r23 == null) goto L41;
        Integer r110 = r23.getBotType();
    L42:
        if (r23 == null) goto L46;
        BotCreatorInfo r111 = r23.getBotCreatorInfo();
        if (r111 == null) goto L46;
        String r112 = r111.getId();
    L47:
        r13[6] = TuplesKt.to("chat_type", r28.g(r29, r110, Intrinsics.areEqual(r112, AccountService.a.getUserId())));
        if (r20 != null) goto L50;
        String r30 = "";
    L51:
        r13[7] = TuplesKt.to("current_page", r30);
        if (r21 == null) goto L55;
        r16 = r21;
    L55:
        r13[8] = TuplesKt.to("previous_page", r16);
        String r31 = "0";
        r13[9] = TuplesKt.to("is_feely_img", "0");
        if (r0 == null) goto L61;
        String r32 = l3.f(Boolean.valueOf(com.larus.im.bean.message.a.C0(r19)));
        if (r32 == null) goto L61;
        r31 = r32;
    L61:
        r13[10] = TuplesKt.to("is_deep_thinking", r31);
        r13[11] = TuplesKt.to("ai_create_show_mode", "mixed");
        r8 = MapsKt.mutableMapOf(r13);
        if (r0 == null) goto L74;
        String r33 = r19.getReplyId();
        if (r33 == null) goto L74;
        if (r25 == null) goto L74;
        Iterator<T> r34 = r25.iterator();
    L68:
        if (r34.hasNext() == false) goto L72;
        Object r113 = r34.next();
        if (Intrinsics.areEqual(((Message) r113).getMessageId(), r33) == false) goto L68;
    L73:
        Message r114 = (Message) r113;
    L75:
        a.getClass();
        s(r8, r114, true);
        if (r114 == null) goto L80;
        Map r35 = r114.getExt();
        if (r35 == null) goto L80;
        String r36 = (String) r35.get("creation_template");
    L81:
        if (r36 == null) goto L83;
        r8.put("message", r0);
    L83:
        r8.putAll(r26);
        if (o(r8, "recommend_from") == true) goto L86;
    L92:
        boolean r37 = false;
    L93:
        if (r37 == false) goto L95;
        return r8;
    L95:
        if (r0 == null) goto L102;
        String r38 = r19.getReplyId();
        if (r38 == null) goto L102;
        IChatRepoService r39 = RepoDispatcherDelegate.b.e();
        r4.L$0 = r0;
        r4.L$1 = r8;
        r4.label = 1;
        r3 = r39.E1(r38, r4);
        if (r3 != r6) goto L101;
        return r6;
    L102:
        r9 = null;
        goto L103
    L86:
        if (o(r8, "template_rec_extra") == false) goto L92;
        if (o(r8, "template_rec_req_id") == false) goto L92;
        if (o(r8, "from_template_id") == false) goto L92;
        r37 = true;
    L80:
        r36 = null;
        goto L81
    L72:
        r113 = null;
    L74:
        r114 = null;
        goto L75
    L50:
        r30 = r20;
    L46:
        r112 = null;
        goto L47
    L41:
        r110 = null;
        goto L42
    L38:
        r29 = null;
    L34:
        r18 = "";
        goto L35
    L27:
        r17 = null;
        goto L28
    L20:
        r15 = null;
    L7:
        r4 = new CreationChatItemClickHelper$getCommonParamsWithRepoFallback$1(this, r27);
        goto L8
    }

    public static ic8.d d(final Context r12, boolean r13, final Message r14, final Map r15, final String r16, final kc8.q r17, final CoroutineScope r18, final com.larus.uaigc.chat.markdown.image.component.a r19, final int r20, final int r21) {
        return new ic8.d(r13, new i(r19, r12, r18, r20, r14, r16, r17, r21, r15), new j(r12, r21, r16, r14, r19), false, null, null, 56);
    }

    public final Object b(cz9.b r33, View r34, Message r35, ViewGroup r36, Map<String, ? extends Object> r37, JSONObject r38, boolean r39, Function5<? super View, ? super Message, ? super df8.a, ? super ViewGroup, ? super JSONObject, Unit> r40, Function4<? super View, ? super Message, ? super AiGenVideoContentData, ? super JSONObject, Unit> r41, Continuation<? super Unit> r42) {
        Message r1 = r35;
        if ((r42 instanceof CreationChatItemClickHelper$bindCreationItemLongClickListener$1) == false) goto L7;
        CreationChatItemClickHelper$bindCreationItemLongClickListener$1 r4 = (CreationChatItemClickHelper$bindCreationItemLongClickListener$1) r42;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        if (r7 == 0) goto L14;
        if (r7 != 1) goto L13;
        AiGenVideoContentData r0 = (AiGenVideoContentData) r4.L$5;
        r1 = (Message) r4.L$4;
        View r2 = (View) r4.L$3;
        Function4<? super View, ? super Message, ? super AiGenVideoContentData, ? super JSONObject, Unit> r8 = (Function4) r4.L$2;
        JSONObject r9 = (JSONObject) r4.L$1;
        JSONObject r10 = (JSONObject) r4.L$0;
        ResultKt.throwOnFailure(r3);
        View r11 = r2;
    L137:
        JSONObject r12 = (JSONObject) r3;
        AiGenVideoContentData r13 = r0;
    L139:
        com.larus.uaigc.helper.h0.a(r9, r12);
        Unit r14 = Unit.INSTANCE;
        r8.invoke(r11, r1, r13, r10);
    L141:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r3);
        CreationItem r15 = r33.a();
        if (r15 != null) goto L17;
    L19:
        boolean r16 = false;
    L20:
        if (r16 == false) goto L22;
        if (r1 == null) goto L25;
        String r17 = null;
        if ((r33 instanceof cz9.h) == false) goto L64;
        cz9.h r18 = (cz9.h) r33;
        CreationItem r19 = r18.d;
        if (r19 == null) goto L141;
        ImageData r20 = r19.image;
        if (r20 == null) goto L141;
        ImageItem r21 = bz9.a.k(r20, r19.genDetail);
        CreationNoWatermarkManager r22 = CreationNoWatermarkManager.a;
        String r23 = r20.imageUri;
        if (r23 != null) goto L35;
    L39:
        r23 = r20.key;
    L40:
        CreationNoWatermarkManager$d r24 = r22.X(r23, r21);
        if (r24.b == false) goto L43;
        ImageItem r25 = (ImageItem) r24.a;
    L44:
        if (r25 == null) goto L47;
        r21 = r25;
    L47:
        if (r40 == null) goto L141;
        df8.a r26 = new df8.a(r18.f, r21, null, r37);
        JSONObject r27 = new JSONObject();
        r27.putOpt("position", Boxing.boxInt(r18.f + 1));
        CreationItem r28 = r18.d;
        if (r28 == null) goto L51;
        String r29 = r28.id;
    L52:
        r27.putOpt("creation_task_id", r29);
        if (r39 == false) goto L55;
        b2.c(r27);
    L55:
        ICreationMetadataService.Companion r30 = ICreationMetadataService.a;
        Message r31 = r18.e;
        CreationItem r110 = r18.d;
        if (r110 == null) goto L58;
        String r111 = r110.id;
    L59:
        UserCreationFromIM r32 = r30.I(r31, r111, String.valueOf(r18.f + 1));
        if (r32 == null) goto L62;
        r17 = r32.getCreationId();
    L62:
        r27.putOpt("creation_id", r17);
        Unit r43 = Unit.INSTANCE;
        r40.invoke(r34, r35, r26, r36, r27);
        goto L141
    L58:
        r111 = null;
        goto L59
    L51:
        r29 = null;
        goto L52
    L43:
        r25 = (ImageItem) r22.R(r21).a;
        goto L44
    L35:
        if (Boxing.boxBoolean(!StringsKt.isBlank(r23)).booleanValue() == true) goto L38;
        r23 = null;
    L38:
        if (r23 != null) goto L40;
    L64:
        if ((r33 instanceof cz9.o) == false) goto L141;
        cz9.o r44 = (cz9.o) r33;
        CreationItem r45 = r44.d;
        if (r45 == null) goto L68;
        VideoData r46 = r45.video;
    L69:
        if (r46 == null) goto L104;
        Intrinsics.checkNotNullParameter(r46, "<this>");
        String r112 = r46.vid;
        Long r113 = r46.width;
        if (r113 == null) goto L73;
        Integer r114 = Integer.valueOf((int) r113.longValue());
    L74:
        Long r47 = r46.height;
        if (r47 == null) goto L77;
        Integer r115 = Integer.valueOf((int) r47.longValue());
    L78:
        Integer r48 = r46.status;
        if (r48 == null) goto L81;
        String r116 = r48.toString();
    L82:
        Cover r49 = r46.cover;
        if (r49 == null) goto L85;
        String r117 = r49.key;
    L86:
        if (r49 == null) goto L90;
        ImageObj r50 = r49.imagePreview;
        if (r50 == null) goto L90;
        Intrinsics.checkNotNullParameter(r50, "<this>");
        CoverImageEntity r210 = new CoverImageEntity(r50.url, r50.getHeicUrl(), r50.width, r50.height);
    L91:
        Cover r51 = r46.cover;
        if (r51 == null) goto L96;
        ImageObj r52 = r51.imageThumb;
        if (r52 == null) goto L96;
        Intrinsics.checkNotNullParameter(r52, "<this>");
        CoverImageEntity r211 = new CoverImageEntity(r52.url, r52.getHeicUrl(), r52.width, r52.height);
    L97:
        AiGenVideoContentData r212 = new AiGenVideoContentData(r112, r114, r115, r116, new CoverItem(r117, r211, r210, null, 8, null), r46.videoModel, null, r46.downloadUrl, r46.downloadFilehash, r46.duration, r46.videoType, null, null, 6208, null);
        CreationItem r53 = r44.d;
        if (r53 == null) goto L102;
        CreationGenDetail r54 = r53.genDetail;
        if (r54 == null) goto L102;
        Integer r213 = r54.taskType;
    L103:
        AiGenVideoContentData r55 = AiGenVideoContentData.copy$default(r212, null, null, null, null, null, null, null, null, null, null, null, null, r213, 4095, null);
    L105:
        CreationNoWatermarkManager r56 = CreationNoWatermarkManager.a;
        if (r46 == null) goto L108;
        String r57 = r46.vid;
    L109:
        if (r46 == null) goto L113;
        Cover r58 = r46.cover;
        if (r58 == null) goto L113;
        String r59 = r58.key;
    L114:
        r13 = r56.a0(r57, r55, r59);
        if (r41 == null) goto L141;
        r9 = new JSONObject();
        CreationItem r60 = r44.d;
        if (r60 == null) goto L119;
        String r61 = r60.id;
    L120:
        r9.putOpt("creation_task_id", r61);
        r9.putOpt("position", Boxing.boxInt(r44.f + 1));
        r9.putOpt("is_upload_video", "0");
        if (r39 == false) goto L123;
        b2.c(r9);
    L123:
        ICreationMetadataService.Companion r62 = ICreationMetadataService.a;
        Message r63 = r44.e;
        CreationItem r64 = r44.d;
        if (r64 == null) goto L126;
        String r65 = r64.id;
    L127:
        UserCreationFromIM r66 = r62.I(r63, r65, String.valueOf(r44.f));
        if (r66 == null) goto L130;
        String r67 = r66.getCreationId();
    L131:
        r9.putOpt("creation_id", r67);
        if (r38 != null) goto L138;
        CreationChatItemClickHelper r68 = a;
        r4.L$0 = r9;
        r4.L$1 = r9;
        r4.L$2 = r41;
        r11 = r34;
        r4.L$3 = r11;
        r4.L$4 = r1;
        r4.L$5 = r13;
        r4.label = 1;
        r68.getClass();
        Object r69 = n(r1, r4);
        Object r70 = r6;
        if (r69 != r70) goto L136;
        return r70;
    L136:
        r8 = r41;
        r10 = r9;
        r3 = r69;
        r0 = r13;
        goto L137
    L138:
        r11 = r34;
        r8 = r41;
        r10 = r9;
        r12 = r38;
        goto L139
    L130:
        r67 = null;
        goto L131
    L126:
        r65 = null;
        goto L127
    L119:
        r61 = null;
    L113:
        r59 = null;
        goto L114
    L108:
        r57 = null;
    L102:
        r213 = null;
    L96:
        r211 = null;
    L90:
        r210 = null;
        goto L91
    L85:
        r117 = null;
        goto L86
    L81:
        r116 = null;
        goto L82
    L77:
        r115 = null;
        goto L78
    L73:
        r114 = null;
        goto L74
    L104:
        r6 = r6;
        r55 = null;
        goto L105
    L68:
        r46 = null;
        goto L69
    L25:
        return Unit.INSTANCE;
    L22:
        return Unit.INSTANCE;
    L17:
        if (bz9.a.f(r15) != true) goto L19;
        r16 = true;
    L7:
        r4 = new CreationChatItemClickHelper$bindCreationItemLongClickListener$1(this, r42);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object c(CreationChatItemClickHelper r11, cz9.b r12, View r13, Message r14, Map r15, JSONObject r16, boolean r17, Function5 r18, Function4 r19, ContinuationImpl r20, int r21) {
        if ((r21 & 16) == 0) goto L5;
        Map r5 = null;
    L7:
        if ((r21 & 32) == 0) goto L9;
        JSONObject r6 = null;
    L11:
        if ((r21 & 64) == 0) goto L13;
        boolean r7 = false;
    L15:
        if ((r21 & 128) == 0) goto L17;
        Function5 r8 = null;
    L19:
        if ((r21 & 256) == 0) goto L21;
        Function4 r9 = null;
    L23:
        return r11.b(r12, r13, r14, null, r5, r6, r7, r8, r9, r20);
    L21:
        r9 = r19;
        goto L23
    L17:
        r8 = r18;
        goto L19
    L13:
        r7 = r17;
        goto L15
    L9:
        r6 = r16;
        goto L11
    L5:
        r5 = r15;
        goto L7
    }

    public static void r(final Context r44, int r45, final Message r46, List r47, List r48, final Map r49, uo8.k r50, int r51, long r52, final kc8.q r54, final String r55, com.larus.bmhome.bigimg.e r56, final CoroutineScope r57, final com.larus.uaigc.chat.markdown.image.component.a r58, final com.larus.uaigc.chat.markdown.image.component.k r59, jy9.x r60) {
        Intrinsics.checkNotNullParameter(r44, "context");
        Intrinsics.checkNotNullParameter(r46, "curMessage");
        Intrinsics.checkNotNullParameter(r48, "initList");
        Intrinsics.checkNotNullParameter(r49, "commonParams");
        Intrinsics.checkNotNullParameter(r57, "lifecycleScope");
        boolean r0 = Intrinsics.areEqual(PollingConfigService.a.f("cre_pic_sc_dg"), "1");
        if (com.larus.im.bean.message.a.e0(r46) == true) goto L6;
        if (r0 == true) goto L6;
        boolean r18 = true;
    L7:
        if (r58 == null) goto L13;
        com.larus.bmhome.actionbar.model.z0 r1 = r58.P();
        if (r1 == null) goto L13;
        com.larus.bmhome.actionbar.model.r r2 = r1.q;
        if (r2 == null) goto L13;
        boolean r19 = Intrinsics.areEqual(r2.h, Boolean.TRUE);
    L14:
        ICreationWorkflowService.Companion r9 = ICreationWorkflowService.a;
        if (r47 != null) goto L17;
        List r20 = CollectionsKt.emptyList();
    L18:
        String r3 = r46.getMessageId();
        if (r3 != null) goto L21;
        r3 = "";
    L21:
        String r26 = r3;
        Map r4 = r46.getBusinessExt();
        if (r4 == null) goto L24;
        String r5 = (String) r4.get("message_case_mode");
    L25:
        boolean r34 = Intrinsics.areEqual(r5, "1");
        String r27 = r46.getMessageId();
        if (r58 == null) goto L29;
        if (r18 == false) goto L29;
        boolean r21 = true;
    L30:
        boolean r6 = r21;
        ic8.d r28 = new ic8.d(r6, new com.larus.uaigc.chat.markdown.helper.f(r57, r54, r55, r44, r46, r49, r58), new com.larus.uaigc.chat.markdown.helper.g(r44, r58, r46), false, null, null, 56);
        if (r59 == null) goto L34;
        if (r18 == false) goto L34;
        boolean r36 = true;
    L35:
        Function1 r37 = new k(r57, r44, r55, r46, r49, r59, r54);
        Function1 r7 = new m(r44, r55, r46, r59);
        if ((CollectionsKt.getOrNull(r48, r45) instanceof zo8.e) == true) goto L38;
    L40:
        boolean r39 = false;
    L41:
        ic8.d r30 = new ic8.d(r36, r37, r7, r39, new n(r44), null, 32);
        if (r19 == false) goto L45;
        if (r18 == false) goto L45;
        boolean r8 = true;
    L46:
        ic8.d r32 = d(r44, r8, r46, r49, r55, r54, r57, r58, 2, 2131906326);
        if (r19 == false) goto L50;
        if (r18 == false) goto L50;
        boolean r10 = true;
    L51:
        ic8.d r33 = d(r44, r10, r46, r49, r55, r54, r57, r58, 1, 2131906330);
        if (r19 == false) goto L55;
        if (r18 == false) goto L55;
        boolean r11 = true;
    L56:
        ic8.d r29 = d(r44, r11, r46, r49, r55, r54, r57, r58, 3, 2131906329);
        List r17 = r20;
        r9.b0(r44, new iy9.a(r48, r45, r50, r56, r26, r17, null, 0, r27, null, null, 0, null, Integer.valueOf(r51), r28, r30, r32, r29, r33, false, r52, r34, new com.larus.uaigc.chat.markdown.helper.c(r54), 12647360), r60);
        return;
    L55:
        r11 = false;
    L50:
        r10 = false;
    L45:
        r8 = false;
        goto L46
    L38:
        if (z2.a.getCreationExtendVideoConfig().b() == false) goto L40;
        r39 = true;
    L34:
        r36 = false;
    L29:
        r21 = false;
        goto L30
    L24:
        r5 = null;
        goto L25
    L17:
        r20 = r47;
    L13:
        r19 = false;
    L6:
        r18 = false;
        goto L7
    }

    public final Object p(String r61, View r62, View r63, String r64, String r65, Boolean r66, kc8.q r67, String r68, CreationItem r69, com.larus.bmhome.bigimg.e r70, CoroutineScope r71, com.larus.uaigc.chat.markdown.image.component.a r72, com.larus.uaigc.chat.markdown.image.component.k r73, iy9.b r74, Message r75, List<CreationItem> r76, boolean r77, boolean r78, Continuation<? super Unit> r79) {
        String r0 = r61;
        View r1 = r62;
        View r2 = r63;
        String r3 = r64;
        String r4 = r65;
        kc8.q r6 = r67;
        String r7 = r68;
        CreationItem r8 = r69;
        com.larus.bmhome.bigimg.e r9 = r70;
        CoroutineScope r10 = r71;
        if ((r79 instanceof CreationChatItemClickHelper$onClickBlockItem$1) == false) goto L7;
        CreationChatItemClickHelper$onClickBlockItem$1 r13 = (CreationChatItemClickHelper$onClickBlockItem$1) r79;
        int r12 = r13.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r710 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r13.label;
        if (r14 != 0) goto L11;
        ResultKt.throwOnFailure(r15);
        if (bz9.a.f(r69) == false) goto L27;
        long r11 = System.currentTimeMillis();
        if (r78 == false) goto L37;
        if (r75 != null) goto L36;
        r13.L$0 = r0;
        r13.L$1 = r1;
        r13.L$2 = r2;
        r13.L$3 = r3;
        r13.L$4 = r4;
        r13.L$5 = r66;
        r13.L$6 = r6;
        r13.L$7 = r7;
        r13.L$8 = r8;
        r13.L$9 = r9;
        r13.L$10 = r10;
        com.larus.uaigc.chat.markdown.image.component.a r16 = r72;
        r13.L$11 = r16;
        r13.L$12 = r73;
        r13.L$13 = r74;
        r13.L$14 = r76;
        r13.Z$0 = r77;
        r13.J$0 = r11;
        r13.label = 1;
        Object r17 = m(r7, r13);
        Object r18 = r710;
        if (r17 != r18) goto L34;
        return r18;
    L34:
        Boolean r19 = r66;
        Object r23 = r17;
        long r21 = r11;
        com.larus.uaigc.chat.markdown.image.component.k r5 = r73;
        List<CreationItem> r110 = r76;
        boolean r20 = r77;
        String r111 = r4;
        iy9.b r22 = r74;
    L35:
        r710 = r18;
        List<CreationItem> r25 = r110;
        boolean r26 = r20;
        long r27 = r21;
        Message r112 = (Message) r23;
        com.larus.uaigc.chat.markdown.image.component.k r58 = r5;
        iy9.b r24 = r22;
        r4 = r111;
        Boolean r113 = r19;
        kc8.q r114 = r6;
        com.larus.uaigc.chat.markdown.image.component.k r28 = r58;
    L45:
        if (r112 != null) goto L48;
        FLogger.a.w(r0, "onClickBlockItem, message missing, messageId=" + r7);
        return Unit.INSTANCE;
    L48:
        r13.L$0 = r0;
        r13.L$1 = r1;
        r13.L$2 = r2;
        r13.L$3 = r3;
        r13.L$4 = r4;
        r13.L$5 = r113;
        r13.L$6 = r114;
        r13.L$7 = r8;
        r13.L$8 = r9;
        r13.L$9 = r10;
        r13.L$10 = r16;
        r13.L$11 = r28;
        r13.L$12 = r24;
        List<CreationItem> r29 = r25;
        r13.L$13 = r29;
        r13.L$14 = r112;
        View r115 = r1;
        r13.L$15 = null;
        boolean r30 = r26;
        r13.Z$0 = r30;
        String r210 = r0;
        long r31 = r27;
        r13.J$0 = r31;
        r13.label = 3;
        Object r32 = n(r112, r13);
        Object r33 = r710;
        if (r32 != r33) goto L51;
        return r33;
    L51:
        r710 = r33;
        iy9.b r34 = r24;
        Boolean r711 = r113;
        com.larus.uaigc.chat.markdown.image.component.a r116 = r16;
        View r712 = r115;
        String r117 = r4;
        final Message r118 = r112;
        final kc8.q r119 = r114;
        long r35 = r31;
        com.larus.uaigc.chat.markdown.image.component.k r120 = r28;
        boolean r36 = r30;
        String r211 = r3;
        Object r212 = r32;
        String r37 = r210;
    L52:
        JSONObject r38 = (JSONObject) r212;
        if (r29 != null) goto L55;
        r29 = bz9.a.g(r118);
    L55:
        long r213 = r35;
        ArrayList r39 = new ArrayList();
        final Context r40 = r712.getContext();
        boolean r214 = r36;
        Map r41 = j(r118);
        List<CreationItem> r215 = r29;
        List<CreationItem> r216 = r29;
        ArrayList r42 = new ArrayList();
        Iterator<T> r217 = r215.iterator();
        CoroutineScope r218 = r10;
        com.larus.uaigc.chat.markdown.image.component.k r219 = r120;
        com.larus.uaigc.chat.markdown.image.component.a r220 = r116;
        int r221 = 0;
        ArrayList r121 = r39;
        CreationItem r122 = r8;
        kc8.q r123 = r119;
    L57:
        if (r217.hasNext() == false) goto L290;
        Object r310 = r217.next();
        int r311 = r221 + 1;
        if (r221 >= 0) goto L61;
        CollectionsKt.throwIndexOverflow();
    L61:
        com.larus.bmhome.bigimg.e r312 = r9;
        final CreationItem r43 = (CreationItem) r310;
        View r313 = r2;
        Integer r44 = r43.type;
        if (r44 != null) goto L64;
        ArrayList r314 = r42;
        CreationChatItemClickHelper$onClickBlockItem$1 r315 = r13;
    L157:
        if (r44 != null) goto L160;
    L283:
        r40 = r40;
        r122 = r122;
        r123 = r123;
        r118 = r118;
        Map r45 = r41;
    L284:
        n1 r46 = null;
    L285:
        r123 = r123;
        r122 = r122;
    L286:
        ArrayList r47 = r314;
        if (r46 == null) goto L289;
        r47.add(r46);
    L289:
        r118 = r118;
        r42 = r47;
        r39 = r39;
        r41 = r45;
        r34 = r34;
        r2 = r313;
        r221 = r311;
        r9 = r312;
        r13 = r315;
        r37 = r37;
        r40 = r40;
        r38 = r38;
        goto L57
    L160:
        if (r44.intValue() != 1) goto L283;
        a.getClass();
        ImageData r48 = r43.image;
        if (r48 != null) goto L165;
        r122 = r122;
        r123 = r123;
        r118 = r118;
        r45 = r41;
        Pair r49 = null;
    L281:
        if (r49 == null) goto L284;
        r121.add((zo8.b) r49.component2());
        r46 = (n1) r49.getFirst();
        goto L285
    L165:
        if (CreationNoWatermarkManager.a.D() == true) goto L167;
        CreationNoWatermarkManager$d r50 = new CreationNoWatermarkManager$d(r48, false);
    L208:
        ImageData r51 = (ImageData) r50.a;
        if (r51 != null) goto L211;
        r51 = r48;
    L211:
        z2 r52 = z2.a;
        if (r52.enableBlockImagePreviewResize() == false) goto L216;
        ImageObj r53 = r51.imagePreviewResize;
        if (r53 != null) goto L217;
        r53 = r51.imagePreview;
    L217:
        if (r53 == null) goto L219;
        String r54 = bz9.a.a(r53);
    L220:
        if (r54 != null) goto L223;
        r54 = "";
    L223:
        if (r54.length() != 0) goto L225;
        boolean r55 = true;
    L226:
        if (r55 == false) goto L229;
        r54 = bz9.a.c(r51);
    L229:
        if (ap8.a.c(r118) == true) goto L238;
        CreationGenDetail r56 = r43.genDetail;
        if (r56 == null) goto L238;
        List r57 = r56.refImages;
        if (r57 == null) goto L238;
        ImageObj r59 = (ImageObj) CollectionsKt.firstOrNull(r57);
        if (r59 == null) goto L238;
        String r60 = r59.url;
    L240:
        if (com.larus.bmhome.utils.u.c() == false) goto L243;
        String r80 = bz9.a.c(r51);
        if (r80 == null) goto L243;
    L244:
        ImageObj r124 = r48.imageOrigin;
        if (r124 == null) goto L247;
        String r81 = r124.url;
    L248:
        ImageObj r125 = r48.imageOriRaw;
        if (r125 == null) goto L251;
        String r126 = r125.url;
    L252:
        if (r124 == null) goto L254;
        Long r127 = Long.valueOf(r124.width);
    L255:
        ImageObj r128 = r48.imageOrigin;
        if (r128 == null) goto L258;
        Long r129 = Long.valueOf(r128.height);
    L259:
        n1 r82 = new n1(r54, r81, r126, r60, r127, r129);
        if (r41 == 0) goto L262;
        r45 = r41;
        fz9.a r83 = (fz9.a) r45.get(r43.id);
    L263:
        String r130 = r43.id;
        Boolean r84 = r43.canPublish;
        if (r84 == null) goto L266;
        boolean r85 = r84.booleanValue();
    L267:
        if (r85 == false) goto L269;
        r52.w3();
        boolean r86 = true;
    L271:
        if (r83 == null) goto L273;
        String r131 = r83.a();
    L274:
        if (r83 == null) goto L276;
        String r87 = r83.b();
    L277:
        String r132 = r48.imageUri;
        if (r132 != null) goto L280;
        r132 = r48.key;
    L280:
        r49 = TuplesKt.to(r82, new zo8.b(r82, r80, "", r130, r86, true, r131, r87, r132));
        goto L281
    L276:
        r87 = null;
        goto L277
    L273:
        r131 = null;
        goto L274
    L269:
        r86 = false;
        goto L271
    L266:
        r85 = false;
        goto L267
    L262:
        r45 = r41;
        r83 = null;
        goto L263
    L258:
        r129 = null;
        goto L259
    L254:
        r127 = null;
        goto L255
    L251:
        r126 = null;
        goto L252
    L247:
        r81 = null;
    L243:
        r80 = "";
    L238:
        r60 = null;
        goto L240
    L225:
        r55 = false;
        goto L226
    L219:
        r54 = null;
        goto L220
    L216:
        r53 = r51.imagePreview;
        goto L217
    L167:
        String[] r88 = new String[8];
        r88[0] = r48.imageUri;
        r88[1] = r48.key;
        ImageObj r89 = r48.imageOrigin;
        if (r89 == null) goto L170;
        String r90 = r89.url;
    L171:
        r88[2] = r90;
        ImageObj r91 = r48.imagePreview;
        if (r91 == null) goto L174;
        String r92 = r91.url;
    L175:
        r88[3] = r92;
        ImageObj r93 = r48.imagePreviewResize;
        if (r93 == null) goto L178;
        String r94 = r93.url;
    L179:
        r88[4] = r94;
        ImageObj r95 = r48.imageThumb;
        if (r95 == null) goto L182;
        String r96 = r95.url;
    L183:
        r88[5] = r96;
        ImageObj r97 = r48.imageThumbRaw;
        if (r97 == null) goto L186;
        String r98 = r97.url;
    L187:
        r88[6] = r98;
        ImageObj r99 = r48.imageOriRaw;
        if (r99 == null) goto L190;
        String r100 = r99.url;
    L191:
        r88[7] = r100;
        List r101 = CollectionsKt.listOfNotNull(r88);
        ArrayList r102 = new ArrayList();
        Iterator r103 = r101.iterator();
    L193:
        if (r103.hasNext() == false) goto L197;
        Object r104 = r103.next();
        if ((!StringsKt.isBlank((String) r104)) == false) goto L193;
        r102.add(r104);
        goto L193
    L197:
        Iterator r105 = CollectionsKt.distinct(r102).iterator();
    L199:
        if (r105.hasNext() == false) goto L207;
        String r106 = (String) r105.next();
        String r107 = (String) CreationNoWatermarkManager.l.get(r106);
        if (r107 == null) goto L204;
        r106 = r107;
    L204:
        CreationNoWatermarkManager$d r108 = CreationNoWatermarkManager.a.W(r106, r48);
        if (r108.b == false) goto L199;
        r50 = r108;
        goto L208
    L207:
        r50 = new CreationNoWatermarkManager$d(r48, false);
        goto L208
    L190:
        r100 = null;
        goto L191
    L186:
        r98 = null;
        goto L187
    L182:
        r96 = null;
        goto L183
    L178:
        r94 = null;
        goto L179
    L174:
        r92 = null;
        goto L175
    L170:
        r90 = null;
        goto L171
    L64:
        r315 = r13;
        r314 = r42;
        if (r44.intValue() != 2) goto L157;
        a.getClass();
        VideoData r109 = r43.video;
        if (r109 != null) goto L69;
        r38 = r38;
        Pair r133 = null;
    L152:
        if (r133 == null) goto L154;
        r39 = r39;
        r39.add((zo8.e) r133.component2());
        r46 = (n1) r133.getFirst();
    L155:
        r121 = r39;
        r40 = r40;
        r118 = r118;
        r45 = r41;
        goto L286
    L154:
        r39 = r39;
        r46 = null;
        goto L155
    L69:
        nr9.g r134 = bz9.a.l(r109);
        CreationNoWatermarkManager r135 = CreationNoWatermarkManager.a;
        String r136 = r109.vid;
        Cover r137 = r109.cover;
        if (r137 == null) goto L72;
        String r138 = r137.key;
    L73:
        nr9.g r139 = r135.c0(r136, r134, r138);
        if (r139 != null) goto L77;
        r139 = r134;
    L77:
        if (com.larus.utils.o0.d(r122.id) == true) goto L79;
    L81:
        boolean r140 = false;
    L82:
        int r141 = hz9.a.a;
        String r142 = r43.id;
        if (r142 != null) goto L86;
        r142 = "";
    L86:
        if (r142.length() != 0) goto L88;
        boolean r143 = true;
    L89:
        if (r143 == false) goto L91;
        r142 = String.valueOf(r221);
    L91:
        String r144 = hz9.a.b(r118, r142, false, 12);
        n1 r145 = new n1("", "");
        String r146 = r43.id;
        if (r123 == null) goto L96;
        kc8.a0 r147 = r123.d;
        if (r147 == null) goto L96;
        String r148 = r147.getBotId();
    L97:
        String r316 = r118.getMessageId();
        if (r123 == null) goto L102;
        kc8.a0 r149 = r123.d;
        if (r149 == null) goto L102;
        BotModel r150 = r149.j0();
    L103:
        if (r123 == null) goto L107;
        kc8.a0 r151 = r123.d;
        if (r151 == null) goto L107;
        wc9.e r152 = r151.h();
    L108:
        c4 r317 = new c4(r148, r316, "chat", r150, r152, "click", "0", r43.id, Integer.valueOf(r311), tz9.a.a(r118), Boolean.valueOf(com.larus.im.bean.message.a.C0(r118)), r118, r38, null, 8192);
        String r153 = r109.vid;
        if (r153 != null) goto L111;
        r153 = "";
    L111:
        if (r140 == false) goto L116;
        if (r34 == null) goto L116;
        Long r154 = r34.d;
        if (r154 == null) goto L116;
        r38 = r38;
        int r155 = (int) r154.longValue();
    L124:
        String r156 = r43.id;
        if (r156 != null) goto L128;
        r156 = "";
    L128:
        if (r156.length() != 0) goto L130;
        boolean r157 = true;
    L131:
        if (r157 == false) goto L133;
        r156 = String.valueOf(r221);
    L133:
        String r158 = hz9.a.a(r118, r156, true, String.valueOf(r221));
        a0 r159 = new a0(r34);
        z2 r160 = z2.a;
        boolean r161 = r160.getCreationExtendVideoConfig().b();
        if (r140 == false) goto L141;
        nr9.f r162 = r139.g;
        if (r162 == null) goto L141;
        if (r34 == null) goto L139;
        Bitmap r163 = r34.e;
    L140:
        r162.f = r163;
        goto L141
    L139:
        r163 = null;
    L141:
        if (r34 == null) goto L143;
        Function2<String, IVideoController, Unit> r164 = r34.b;
    L144:
        Boolean r165 = r8.canPublish;
        if (r165 == null) goto L147;
        boolean r166 = r165.booleanValue();
    L148:
        if (r166 == false) goto L150;
        r160.w3();
        boolean r167 = true;
    L151:
        r133 = TuplesKt.to(r145, new zo8.e(null, r317, r139, r155, r158, r159, r164, r161, new com.larus.uaigc.chat.markdown.helper.d(), new com.larus.uaigc.chat.markdown.helper.e(r40, r118, r43, r119), r146, r167, true, 1));
        r122 = r8;
        r123 = r119;
        goto L152
    L150:
        r167 = false;
        goto L151
    L147:
        r166 = false;
        goto L148
    L143:
        r164 = null;
        goto L144
    L130:
        r157 = false;
    L116:
        r38 = r38;
        IVideoController r168 = IAIChatUgcAIGCService.a.L().a(r144, "ugc_video", "message_card");
        if (r168 == null) goto L119;
        r155 = r168.getCurrentPlaybackTime();
        goto L124
    L119:
        if (r34 == null) goto L123;
        Function1<String, Integer> r169 = r34.a;
        if (r169 == null) goto L123;
        r155 = ((Number) r169.invoke(r153)).intValue();
    L123:
        r155 = 0;
    L107:
        r152 = null;
    L102:
        r150 = null;
    L96:
        r148 = null;
        goto L97
    L88:
        r143 = false;
        goto L89
    L79:
        if (Intrinsics.areEqual(r122.id, r43.id) == false) goto L81;
        r140 = true;
        goto L82
    L72:
        r138 = null;
        goto L73
    L290:
        String r318 = r37;
        iy9.b r222 = r34;
        View r319 = r2;
        JSONObject r713 = r38;
        ArrayList r170 = r39;
        ArrayList r171 = r42;
        com.larus.bmhome.bigimg.e r320 = r9;
        CreationChatItemClickHelper$onClickBlockItem$1 r321 = r13;
        Message r714 = r118;
        Result.Companion r172 = Result.Companion;     // Catch: Throwable -> L293
        FLogger.a.i(r318, "onClickBlockItem, hide ime");     // Catch: Throwable -> L293
        com.larus.utils.e1.p(r712);     // Catch: Throwable -> L293
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L293
    L295:
        Iterator r173 = r170.iterator();
        int r174 = 0;
    L297:
        if (r173.hasNext() == false) goto L321;
        zo8.e r175 = (zo8.a) r173.next();
        if (com.larus.utils.o0.d(r8.id) == false) goto L302;
        boolean r176 = Intrinsics.areEqual(r175.a(), r8.id);
    L318:
        if (r176 == true) goto L322;
        r174 = r174 + 1;
    L322:
        if (r174 != (-1)) goto L324;
        r174 = 0;
    L324:
        if (r119 == null) goto L328;
        kc8.a0 r177 = r119.d;
        if (r177 == null) goto L328;
        String r178 = r177.getBotId();
    L329:
        Context r179 = r712.getContext();
        if (r119 == null) goto L334;
        kc8.a0 r180 = r119.d;
        if (r180 == null) goto L334;
        BotModel r181 = r180.j0();
    L335:
        if (r119 == null) goto L339;
        kc8.a0 r182 = r119.d;
        if (r182 == null) goto L339;
        wc9.e r183 = r182.h();
    L340:
        if (r119 == null) goto L344;
        Function0 r184 = r119.i;
        if (r184 == null) goto L344;
        List r185 = (List) r184.invoke();
    L345:
        r321.L$0 = r712;
        r321.L$1 = r319;
        r321.L$2 = r119;
        r321.L$3 = r8;
        r321.L$4 = r320;
        r321.L$5 = r218;
        r321.L$6 = r220;
        CreationItem r223 = r8;
        r321.L$7 = r219;
        r321.L$8 = r222;
        r321.L$9 = r714;
        View r224 = r712;
        r321.L$10 = r713;
        r321.L$11 = r216;
        r321.L$12 = r170;
        r321.L$13 = r171;
        r321.L$14 = r178;
        r321.L$15 = r179;
        r321.Z$0 = r214;
        r321.J$0 = r213;
        r321.I$0 = r174;
        r321.label = 4;
        Object r186 = l(this, r714, r211, r117, r711, r181, r183, r185, r321);
        Object r187 = r710;
        if (r186 != r187) goto L348;
        return r187;
    L348:
        long r410 = r213;
        com.larus.bmhome.bigimg.e r510 = r320;
        CoroutineScope r511 = r218;
        com.larus.uaigc.chat.markdown.image.component.a r512 = r220;
        boolean r188 = r214;
        iy9.b r225 = r222;
        com.larus.uaigc.chat.markdown.image.component.k r513 = r219;
        View r189 = r224;
        List r411 = r171;
        List r412 = r170;
        Context r190 = r179;
        r15 = r186;
        View r226 = r319;
        CreationItem r191 = r223;
        Message r192 = r714;
        List<CreationItem> r193 = r216;
        JSONObject r194 = r713;
    L349:
        Map r195 = (Map) r15;
        if (k1.a(r189) == true) goto L352;
        Intrinsics.checkNotNull(r190);
        if (r119 == null) goto L356;
        Fragment r227 = r119.a;
    L357:
        if (r119 == null) goto L361;
        com.larus.bmhome.chat.api.q0 r196 = r119.l;
        if (r196 == null) goto L361;
        com.larus.bmhome.chat.api.q0.a r228 = r196.getProvider();
    L362:
        if (r119 == null) goto L366;
        Function0 r197 = r119.e;
        if (r197 == null) goto L366;
        boolean r322 = ((Boolean) r197.invoke()).booleanValue();
    L367:
        if (r119 == null) goto L378;
        Fragment r198 = r119.a;
        if (r198 == null) goto L378;
        Bundle r199 = r198.getArguments();
        if (r199 == null) goto L378;
        if (r199.getBoolean("preview_collection_readonly") == false) goto L376;
    L377:
        boolean r323 = true;
    L379:
        if (r119 == null) goto L381;
        rd8.b r324 = r119.g;
    L382:
        if (r119 == null) goto L386;
        final kc8.b0 r200 = r119.k;
        if (r200 == null) goto L386;
        Function4 r325 = new t(r200);
    L387:
        if (r119 == null) goto L391;
        final kc8.b0 r201 = r119.k;
        if (r201 == null) goto L391;
        Function1 r326 = new u(r201);
    L392:
        if (r119 == null) goto L396;
        final kc8.b0 r202 = r119.k;
        if (r202 == null) goto L396;
        Function4 r413 = new v(r202);
    L397:
        if (r119 == null) goto L401;
        final kc8.b0 r203 = r119.k;
        if (r203 == null) goto L401;
        Function1 r414 = new w(r203);
    L402:
        if (r119 == null) goto L406;
        final kc8.b0 r204 = r119.k;
        if (r204 == null) goto L406;
        Function0 r415 = new x(r204);
    L407:
        jy9.x r514 = new jy9.x(r192, r228, r225, null, r191, r174, r511, null, r226, r227, r510, new y(r119), new z(r119), new com.larus.uaigc.chat.markdown.helper.b(r119), r322, r323, r324, r325, null, r326, r413, r414, r415, 3146520);
        List<CreationItem> r205 = r193;
        ArrayList r206 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r205, 10));
        Iterator r207 = r205.iterator();
        int r208 = 0;
    L409:
        if (r207.hasNext() == false) goto L429;
        Object r209 = r207.next();
        int r1100 = r208 + 1;
        if (r208 >= 0) goto L413;
        CollectionsKt.throwIndexOverflow();
    L413:
        CreationItem r229 = (CreationItem) r209;
        Iterator r610 = r207;
        Pair[] r230 = new Pair[5];
        JSONObject r1101 = r194;
        r230[0] = TuplesKt.to("position", Integer.valueOf(r1100));
        ImageData r231 = r229.image;
        if (r231 == null) goto L416;
        String r232 = r231.key;
    L417:
        if (r232 != null) goto L419;
        r232 = "";
    L419:
        r230[1] = TuplesKt.to("pic_id", r232);
        ImageData r233 = r229.image;
        if (r233 == null) goto L422;
        String r234 = r233.requestId;
    L423:
        if (r234 != null) goto L425;
        r234 = "";
    L425:
        r230[2] = TuplesKt.to("request_id", r234);
        String r235 = r229.id;
        if (r235 != null) goto L428;
        r235 = "";
    L428:
        r230[3] = TuplesKt.to("creation_task_id", r235);
        r230[4] = TuplesKt.to("is_feely_img", "0");
        r206.add(MapsKt.mutableMapOf(r230));
        r207 = r610;
        r208 = r1100;
        r194 = r1101;
        goto L409
    L422:
        r234 = null;
        goto L423
    L416:
        r232 = null;
        goto L417
    L429:
        JSONObject r1102 = r194;
        uo8.k r236 = new uo8.k(r195, r206);
        CreationGenDetail r237 = r191.genDetail;
        if (r237 == null) goto L432;
        Integer r238 = r237.taskType;
    L433:
        if (r238 != null) goto L436;
    L438:
        if (r238 != null) goto L441;
    L443:
        if (r238 != null) goto L446;
    L448:
        if (r238 != null) goto L451;
    L453:
        int r416 = 2;
    L454:
        r(r190, r174, r192, r411, r412, r195, r236, r416, r410, r119, r178, r510, r511, r512, r513, r514);
        if (r188 == false) goto L498;
        Integer r239 = r191.type;
        if (r239 != null) goto L460;
    L466:
        if (r239 == null) goto L498;
        if (r239.intValue() != 1) goto L498;
        com.larus.platform.service.o r240 = com.larus.platform.service.o.a;
        JSONObject r241 = new JSONObject();
        if (r178 != null) goto L473;
        r178 = "";
    L473:
        r241.put("bot_id", r178);
        r241.put("message_id", r192.getMessageId());
        r241.put("conversation_id", r192.getConversationId());
        r241.put("user_type", "bot");
        r241.put("pic_position", String.valueOf(r174 + 1));
        ImageData r242 = r191.image;
        if (r242 == null) goto L476;
        String r1103 = r242.key;
    L477:
        r241.put("pic_id", r1103);
        ImageData r243 = r191.image;
        if (r243 == null) goto L483;
        String r244 = r243.requestId;
        if (r244 == null) goto L483;
        String r1104 = r244;
    L484:
        r241.put("request_id", r1104);
        r241.put("is_onboarding", 0);
        Object r245 = r195.get("recommend_from");
        if (r245 == null) goto L487;
        r241.put("recommend_from", r245);
    L487:
        Object r246 = r195.get("template_rec_extra");
        if (r246 == null) goto L490;
        r241.put("template_rec_extra", r246);
    L490:
        Object r247 = r195.get("template_rec_req_id");
        if (r247 == null) goto L493;
        r241.put("template_rec_req_id", r247);
    L493:
        Object r248 = r195.get("from_template_id");
        if (r248 == null) goto L496;
        r241.put("from_template_id", r248);
    L496:
        Unit r249 = Unit.INSTANCE;
        r240.reportEvent("picture_message_click", r241);
    L483:
        r1104 = "";
        goto L484
    L476:
        r1103 = null;
        goto L477
    L460:
        if (r239.intValue() != 2) goto L466;
        VideoData r250 = r191.video;
        if (r250 == null) goto L464;
        String r1105 = r250.vid;
    L465:
        a4.c(r1105, r192.getMessageId(), r178, r1102);
        goto L498
    L464:
        r1105 = null;
    L498:
        return Unit.INSTANCE;
    L451:
        if (r238.intValue() != 2) goto L453;
        r416 = 5;
        goto L454
    L446:
        if (r238.intValue() != 6) goto L448;
        r416 = 6;
        goto L454
    L441:
        if (r238.intValue() != 7) goto L443;
        r416 = 4;
        goto L454
    L436:
        if (r238.intValue() != 5) goto L438;
        r416 = 3;
        goto L454
    L432:
        r238 = null;
    L406:
        r415 = null;
    L401:
        r414 = null;
    L396:
        r413 = null;
    L391:
        r326 = null;
    L386:
        r325 = null;
        goto L387
    L381:
        r324 = null;
        goto L382
    L376:
        if (Intrinsics.areEqual(r199.getString("as_container"), "READONLY_FORWARD_DETAIL") == true) goto L377;
    L378:
        r323 = false;
    L366:
        r322 = false;
    L361:
        r228 = null;
        goto L362
    L356:
        r227 = null;
        goto L357
    L352:
        return Unit.INSTANCE;
    L344:
        r185 = null;
    L339:
        r183 = null;
    L334:
        r181 = null;
    L328:
        r178 = null;
        goto L329
    L302:
        if ((r175 instanceof zo8.e) == false) goto L309;
        String r251 = r175.c.a;
        VideoData r252 = r8.video;
        if (r252 == null) goto L306;
        String r253 = r252.vid;
    L307:
        r176 = Intrinsics.areEqual(r251, r253);
        goto L318
    L306:
        r253 = null;
        goto L307
    L309:
        if ((r175 instanceof zo8.b) == false) goto L317;
        String r254 = ((zo8.b) r175).a.c;
        ImageData r255 = r8.image;
        if (r255 == null) goto L315;
        ImageObj r256 = r255.imageOrigin;
        if (r256 == null) goto L315;
        String r257 = r256.url;
    L316:
        r176 = Intrinsics.areEqual(r254, r257);
    L315:
        r257 = null;
        goto L316
    L317:
        r176 = false;
        goto L318
    L321:
        r174 = -1;
    L293:
        th = move-exception;
        Result.Companion r258 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L295
    L36:
        r16 = r72;
        r25 = r76;
        r26 = r77;
        r113 = r66;
        r112 = r75;
        r27 = r11;
        r24 = r74;
        r114 = r6;
        r28 = r73;
        goto L45
    L37:
        r16 = r72;
        Object r1106 = r710;
        r13.L$0 = r0;
        r13.L$1 = r1;
        r13.L$2 = r2;
        r13.L$3 = r3;
        r13.L$4 = r4;
        r13.L$5 = r66;
        r13.L$6 = r6;
        r13.L$7 = r7;
        r13.L$8 = r8;
        r13.L$9 = r9;
        r13.L$10 = r10;
        r13.L$11 = r16;
        r13.L$12 = r73;
        r13.L$13 = r74;
        r13.L$14 = r75;
        r13.L$15 = r76;
        r13.Z$0 = r77;
        r13.J$0 = r11;
        r13.label = 2;
        Object r259 = m(r7, r13);
        if (r259 != r1106) goto L40;
        return r1106;
    L40:
        r1 = r62;
        boolean r260 = r77;
        Object r261 = r259;
        long r262 = r11;
        r0 = r61;
        Message r1107 = r75;
        List<CreationItem> r263 = r76;
        r113 = r66;
        r114 = r6;
        r28 = r73;
        r24 = r74;
    L41:
        Message r264 = (Message) r261;
        r710 = r1106;
        if (r264 != null) goto L44;
        r112 = r1107;
        r25 = r263;
        r26 = r260;
        r27 = r262;
        goto L45
    L44:
        r25 = r263;
        r26 = r260;
        r27 = r262;
        r112 = r264;
        goto L45
    L27:
        return Unit.INSTANCE;
    L11:
        if (r14 != 1) goto L13;
        long r265 = r13.J$0;
        boolean r266 = r13.Z$0;
        List<CreationItem> r267 = (List) r13.L$14;
        r22 = (iy9.b) r13.L$13;
        r5 = (com.larus.uaigc.chat.markdown.image.component.k) r13.L$12;
        com.larus.uaigc.chat.markdown.image.component.a r268 = (com.larus.uaigc.chat.markdown.image.component.a) r13.L$11;
        CoroutineScope r269 = (CoroutineScope) r13.L$10;
        com.larus.bmhome.bigimg.e r270 = (com.larus.bmhome.bigimg.e) r13.L$9;
        CreationItem r271 = (CreationItem) r13.L$8;
        String r1108 = (String) r13.L$7;
        kc8.q r1109 = (kc8.q) r13.L$6;
        r19 = (Boolean) r13.L$5;
        r111 = (String) r13.L$4;
        String r272 = (String) r13.L$3;
        View r273 = (View) r13.L$2;
        View r274 = (View) r13.L$1;
        r0 = (String) r13.L$0;
        ResultKt.throwOnFailure(r15);
        r21 = r265;
        r20 = r266;
        r110 = r267;
        r23 = r15;
        r3 = r272;
        r2 = r273;
        r16 = r268;
        r6 = r1109;
        r1 = r274;
        r18 = r710;
        r10 = r269;
        r7 = r1108;
        r9 = r270;
        r8 = r271;
        goto L35
    L13:
        if (r14 != 2) goto L15;
        long r275 = r13.J$0;
        boolean r276 = r13.Z$0;
        List<CreationItem> r277 = (List) r13.L$15;
        Message r278 = (Message) r13.L$14;
        r24 = (iy9.b) r13.L$13;
        r28 = (com.larus.uaigc.chat.markdown.image.component.k) r13.L$12;
        com.larus.uaigc.chat.markdown.image.component.a r279 = (com.larus.uaigc.chat.markdown.image.component.a) r13.L$11;
        CoroutineScope r280 = (CoroutineScope) r13.L$10;
        r9 = (com.larus.bmhome.bigimg.e) r13.L$9;
        CreationItem r1110 = (CreationItem) r13.L$8;
        String r1111 = (String) r13.L$7;
        r114 = (kc8.q) r13.L$6;
        r113 = (Boolean) r13.L$5;
        String r281 = (String) r13.L$4;
        String r282 = (String) r13.L$3;
        View r283 = (View) r13.L$2;
        View r284 = (View) r13.L$1;
        r0 = (String) r13.L$0;
        ResultKt.throwOnFailure(r15);
        r262 = r275;
        r260 = r276;
        r263 = r277;
        r1107 = r278;
        r261 = r15;
        r4 = r281;
        r2 = r283;
        r3 = r282;
        r16 = r279;
        r7 = r1111;
        r1 = r284;
        r1106 = r710;
        r10 = r280;
        r8 = r1110;
        goto L41
    L15:
        if (r14 != 3) goto L17;
        long r285 = r13.J$0;
        boolean r286 = r13.Z$0;
        Message r287 = (Message) r13.L$14;
        List<CreationItem> r288 = (List) r13.L$13;
        iy9.b r289 = (iy9.b) r13.L$12;
        com.larus.uaigc.chat.markdown.image.component.k r290 = (com.larus.uaigc.chat.markdown.image.component.k) r13.L$11;
        com.larus.uaigc.chat.markdown.image.component.a r291 = (com.larus.uaigc.chat.markdown.image.component.a) r13.L$10;
        CoroutineScope r292 = (CoroutineScope) r13.L$9;
        r9 = (com.larus.bmhome.bigimg.e) r13.L$8;
        CreationItem r1112 = (CreationItem) r13.L$7;
        r119 = (kc8.q) r13.L$6;
        Boolean r1113 = (Boolean) r13.L$5;
        String r1114 = (String) r13.L$4;
        String r293 = (String) r13.L$3;
        View r294 = (View) r13.L$2;
        View r295 = (View) r13.L$1;
        r37 = (String) r13.L$0;
        ResultKt.throwOnFailure(r15);
        r211 = r293;
        r712 = r295;
        r711 = r1113;
        r117 = r1114;
        r212 = r15;
        r118 = r287;
        r120 = r290;
        r116 = r291;
        r36 = r286;
        r29 = r288;
        r2 = r294;
        r34 = r289;
        r35 = r285;
        r10 = r292;
        r8 = r1112;
        goto L52
    L17:
        if (r14 != 4) goto L20;
        int r296 = r13.I$0;
        long r297 = r13.J$0;
        r188 = r13.Z$0;
        r190 = (Context) r13.L$15;
        r178 = (String) r13.L$14;
        List r298 = (List) r13.L$13;
        List r299 = (List) r13.L$12;
        r193 = (List) r13.L$11;
        r194 = (JSONObject) r13.L$10;
        r192 = (Message) r13.L$9;
        iy9.b r1115 = (iy9.b) r13.L$8;
        com.larus.uaigc.chat.markdown.image.component.k r1116 = (com.larus.uaigc.chat.markdown.image.component.k) r13.L$7;
        com.larus.uaigc.chat.markdown.image.component.a r1117 = (com.larus.uaigc.chat.markdown.image.component.a) r13.L$6;
        CoroutineScope r300 = (CoroutineScope) r13.L$5;
        com.larus.bmhome.bigimg.e r301 = (com.larus.bmhome.bigimg.e) r13.L$4;
        CreationItem r302 = (CreationItem) r13.L$3;
        kc8.q r303 = (kc8.q) r13.L$2;
        View r304 = (View) r13.L$1;
        r189 = (View) r13.L$0;
        ResultKt.throwOnFailure(r15);
        r511 = r300;
        r510 = r301;
        r226 = r304;
        r410 = r297;
        r411 = r298;
        r412 = r299;
        r225 = r1115;
        r513 = r1116;
        r512 = r1117;
        r174 = r296;
        r191 = r302;
        r119 = r303;
        goto L349
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r13 = new CreationChatItemClickHelper$onClickBlockItem$1(this, r79);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object q(CreationChatItemClickHelper r23, String r24, View r25, View r26, String r27, String r28, Boolean r29, kc8.q r30, String r31, CreationItem r32, com.larus.uaigc.chat.block.create.horizontal.j r33, CoroutineScope r34, com.larus.uaigc.chat.markdown.image.component.a r35, com.larus.uaigc.chat.markdown.image.component.k r36, iy9.b r37, Message r38, List r39, boolean r40, Continuation r41, int r42) {
        if ((r42 & 64) == 0) goto L5;
        kc8.q r10 = null;
    L7:
        if ((r42 & 512) == 0) goto L9;
        com.larus.uaigc.chat.block.create.horizontal.j r13 = null;
    L11:
        if ((r42 & 2048) == 0) goto L13;
        com.larus.uaigc.chat.markdown.image.component.a r15 = null;
    L15:
        if ((r42 & 4096) == 0) goto L17;
        com.larus.uaigc.chat.markdown.image.component.k r16 = null;
    L19:
        if ((r42 & 8192) == 0) goto L21;
        iy9.b r17 = null;
    L23:
        if ((r42 & 16384) == 0) goto L25;
        Message r18 = null;
    L27:
        if ((32768 & r42) == 0) goto L29;
        List r19 = null;
    L31:
        if ((65536 & r42) == 0) goto L33;
        boolean r20 = true;
    L35:
        if ((r42 & 131072) == 0) goto L37;
        boolean r21 = false;
    L39:
        return r23.p(r24, r25, r26, r27, r28, r29, r10, r31, r32, r13, r34, r15, r16, r17, r18, r19, r20, r21, r41);
    L37:
        r21 = r40;
        goto L39
    L33:
        r20 = false;
        goto L35
    L29:
        r19 = r39;
        goto L31
    L25:
        r18 = r38;
        goto L27
    L21:
        r17 = r37;
        goto L23
    L17:
        r16 = r36;
        goto L19
    L13:
        r15 = r35;
        goto L15
    L9:
        r13 = r33;
        goto L11
    L5:
        r10 = r30;
        goto L7
    }
}
