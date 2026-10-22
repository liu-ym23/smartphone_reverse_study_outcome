package com.ss.android.lark.chat.chatwindow.chat.model.preload.v2;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.content.MediaContent;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.player.player.LarkPlayerUtils;
import com.ss.android.lark.preload.v2.task.OneTimeTask;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import o1c.b;
import o1c.c;
import w4b.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 $2\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\u0011\u001a\u00020\u00122\u0010\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000fH\u0002J\u0018\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000fH\u0002J\u0018\u0010\u0019\u001a\u00020\u00042\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0002J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J+\u0010\u001e\u001a\u0004\u0018\u00010\u00042\u0010\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0002\u0010!J+\u0010\"\u001a\u0004\u0018\u00010\u00042\u0010\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0002\u0010!J \u0010#\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00022\u0010\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/model/preload/v2/MediaResourceLoadTask;", "Lcom/ss/android/lark/preload/v2/task/OneTimeTask;", BuildConfig.FLAVOR, "Lcom/ss/android/lark/chat/entity/message/MessageInfo;", BuildConfig.FLAVOR, "<init>", "()V", "biz", "Lcom/ss/android/lark/appreciablelib/Biz;", "getBiz", "()Lcom/ss/android/lark/appreciablelib/Biz;", "loginDependency", "Lcom/ss/android/lark/chat/core/dependency/LoginDependency;", "kotlin.jvm.PlatformType", "session", BuildConfig.FLAVOR, "userId", "doPreload", BuildConfig.FLAVOR, "params", "addActionViewToUrl", "url", ChameleonOpenTracker.Stage.PRELOAD, "preloadUrl", "cacheKeyPrefix", "load", "messageInfoList", "isMessageValid", "msg", "Lcom/ss/android/lark/chat/entity/message/Message;", "getCacheExt", "extra", BuildConfig.FLAVOR, "(Ljava/util/Set;Ljava/lang/Object;)Ljava/lang/Boolean;", "getCache", "getCacheKeys", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MediaResourceLoadTask extends OneTimeTask<Set<? extends MessageInfo>, Boolean> {
    public final Biz p;
    public final u q;
    public final String r;
    public final String s;

    public static final class a {
    }

    static {
    }

    public MediaResourceLoadTask() {
        this.p = Biz.Messenger;
        u r0 = ChatCoreModule.a().getLoginDependency();
        this.q = r0;
        String r1 = r0.getSession();
        String r2 = BuildConfig.FLAVOR;
        if (r1 != null) goto L5;
        r1 = BuildConfig.FLAVOR;
    L5:
        this.r = r1;
        String r3 = r0.getUserId();
        if (r3 == null) goto L9;
        r2 = r3;
    L9:
        this.s = r2;
    }

    public final Biz getBiz() {
        return this.p;
    }

    public static String g(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return r2;
    L6:
        return UriProtector.parse(r2).buildUpon().appendQueryParameter(Keys.API_PARAM_KEY_ACTION, "view").build().toString();
    }

    public final void d(Object r10) {
        Set r11 = (Set) r10;
        if (r11 == null) goto L81;
        Log.i("MediaResourceLoadTask", "MediaResourceLoadTask load");
        ArrayList r0 = new ArrayList();
        Iterator r12 = r11.iterator();
    L5:
        Message r2 = null;
        if (r12.hasNext() == false) goto L12;
        MessageInfo r1 = (MessageInfo) r12.next();
        if (r1 == null) goto L10;
        r2 = r1.getMessage();
    L10:
        if (r2 == null) goto L5;
        r0.add(r2);
        goto L5
    L12:
        ArrayList r13 = new ArrayList();
        Iterator r3 = r0.iterator();
    L13:
        boolean r4 = true;
        if (r3.hasNext() == false) goto L29;
        Object r5 = r3.next();
        Message r6 = (Message) r5;
        if (r6.isPreMessage() == false) goto L18;
    L26:
        r4 = false;
    L27:
        if (r4 == false) goto L13;
        r13.add(r5);
        goto L13
    L18:
        if (r6.isRecalled() == true) goto L26;
        if (r6.isRemoved() == true) goto L26;
        if (r6.isBurned() == true) goto L26;
        if (r6.isSecret() == true) goto L26;
    L29:
        Iterator r14 = r13.iterator();
    L31:
        if (r14.hasNext() == false) goto L120;
        Message r7 = (Message) r14.next();
        if (r7.getType() == Message.Type.MEDIA) goto L34;
        if (r7.getType() != Message.Type.POST) goto L31;
        RichText r8 = ((PostContent) r7.getContent()).getRichText();
        if (r8 == null) goto L31;
        List r9 = r8.getMediaIds();
        if (r9 == null) goto L31;
        List r15 = CollectionsKt.filterNotNull(r9);
        if (r15 == null) goto L31;
        Iterator r16 = r15.iterator();
    L55:
        if (r16.hasNext() == false) goto L31;
        String r17 = (String) r16.next();
        RichText.RichTextElements r18 = r8.getElements();
        if (r18 == null) goto L63;
        Map r19 = r18.getDictionary();
        if (r19 == null) goto L63;
        RichTextElement r20 = (RichTextElement) r19.get(r17);
        if (r20 == null) goto L63;
        RichTextElement.RichTextProperty r21 = r20.getProperty();
    L65:
        if ((r21 instanceof RichTextElement.MediaProperty) == false) goto L55;
        RichTextElement.MediaProperty r22 = (RichTextElement.MediaProperty) r21;
        String r23 = r22.getUrl();
        if (r23 != null) goto L69;
    L72:
        boolean r24 = true;
    L73:
        if (r24 == true) goto L55;
        String r25 = g(r22.getUrl());
        String r26 = r7.getId();
        if (LarkPlayerUtils.d() == false) goto L77;
        LarkPlayerUtils.e(r25, r26, this.r);
    L78:
        b r27 = ((o1c.a) this).n;
        if (r27 == null) goto L55;
        r27.a(this, SetsKt.setOf(r7.getId()));
        goto L55
    L77:
        LarkPlayerUtils.f(r25, r26, this.s);
        goto L78
    L69:
        if (r23.length() == 0) goto L72;
        r24 = false;
    L63:
        r21 = null;
        goto L65
    L34:
        MediaContent r28 = (MediaContent) r7.getContent();
        if (r28.isOriginal() == true) goto L31;
        String r29 = r28.getUrl();
        if (TextUtils.isEmpty(r29) == true) goto L31;
        String r30 = g(r29);
        String r31 = r7.getId();
        if (LarkPlayerUtils.d() == false) goto L41;
        LarkPlayerUtils.e(r30, r31, this.r);
    L42:
        b r32 = ((o1c.a) this).n;
        if (r32 == null) goto L31;
        r32.a(this, SetsKt.setOf(r7.getId()));
        goto L31
    L41:
        LarkPlayerUtils.f(r30, r31, this.s);
        goto L42
    L120:
        return;
    }

    public final Set f(Object r3) {
        Set r4 = (Set) r3;
        HashSet r0 = new HashSet();
        if (r4 == null) goto L10;
        Iterator r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        MessageInfo r1 = (MessageInfo) r5.next();
        if (r1 == null) goto L6;
        r0.add(r1.getId());
    L10:
        return r0;
    }

    public final Object j(Object r9) {
        if (r9 == null) goto L26;
        Set r10 = SetsKt.setOf((String) r9);
        b r0 = ((o1c.a) this).n;
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        c.a r3 = ((o1c.a) this).k;
        if (r3 == null) goto L13;
        r3.k(this, r1, MapsKt.mapOf(TuplesKt.to("source_type", BuildConfig.FLAVOR)));
    L13:
        b r4 = ((o1c.a) this).n;
        if (r4 != null) goto L16;
    L18:
        boolean r11 = false;
    L19:
        if (r1 == false) goto L25;
        if (r11 == true) goto L25;
        c.a r12 = ((o1c.a) this).k;
        if (r12 == null) goto L25;
        r12.m(this, MapsKt.mapOf(new Pair[]{TuplesKt.to("source_type", BuildConfig.FLAVOR), TuplesKt.to("first_hit_interval", Long.valueOf(SystemClock.elapsedRealtime() - ((o1c.a) this).m))}));
    L25:
        return Boolean.valueOf(r1);
    L16:
        if (r4.c(this, r10) != true) goto L18;
        r11 = true;
        goto L19
    L7:
        if (r0.d(this, r10) != true) goto L9;
        r1 = true;
        goto L10
    L26:
        return Boolean.FALSE;
    }
}
