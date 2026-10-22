package com.ss.android.lark.feed.molten.serializer;

import com.bytedance.lark.pb.basic.v1.TagData;
import com.bytedance.lark.pb.feed.v1.Digest;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.ss.android.lark.biz.im.api.MuteUrgentInfo;
import com.ss.android.lark.feed.app.entity.DigestElement;
import com.ss.android.lark.feed.shared.data.preview.FeedPreview;
import java.lang.reflect.Field;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public final f a;
    public final TypeAdapter<Digest> b;
    public final TypeAdapter<MuteUrgentInfo> c;
    public final TypeAdapter<TagData> d;
    public final TypeAdapter<List<DigestElement>> e;
    public final Field f;

    public final void a(JsonObject r4, FeedPreview r5) {
        Intrinsics.checkNotNullParameter(r4, "json");
        Intrinsics.checkNotNullParameter(r5, "value");
        this.a.b(r4, r5);
        r5.setOriginDigest((Digest) a.k(r4, "originDigest", this.b));
        Integer r0 = a.e(r4, "lastMessagePosition");
        boolean r1 = false;
        if (r0 == null) goto L5;
        int r2 = r0.intValue();
    L6:
        r5.setLastMessagePosition(r2);
        r5.setLastMessageId(a.l(r4, "lastMessageId"));
        r5.setMarkText(a.l(r4, "markText"));
        Boolean r3 = a.c(r4, "isDelayed");
        if (r3 == null) goto L9;
        boolean r6 = r3.booleanValue();
    L10:
        r5.setDelayed(r6);
        Boolean r7 = a.c(r4, "isDisplayedInDelayedFeed");
        if (r7 == null) goto L13;
        boolean r8 = r7.booleanValue();
    L14:
        r5.setDisplayedInDelayedFeed(r8);
        r5.setMuteUrgentInfo((MuteUrgentInfo) a.k(r4, "muteUrgentInfo", this.c));
        Integer r9 = a.e(r4, "atInfoCount");
        if (r9 == null) goto L17;
        int r10 = r9.intValue();
    L18:
        r5.setAtInfoCount(r10);
        Boolean r11 = a.c(r4, "isCustomer");
        if (r11 == null) goto L21;
        boolean r12 = r11.booleanValue();
    L22:
        r5.setCustomer(r12);
        Boolean r13 = a.c(r4, "isSimpleTenant");
        if (r13 == null) goto L25;
        boolean r14 = r13.booleanValue();
    L26:
        r5.setSimpleTenant(r14);
        r5.setTagData((TagData) a.k(r4, "tagData", this.d));
        Boolean r15 = a.c(r4, "isTranslateEmojiCode");
        if (r15 == null) goto L29;
        r1 = r15.booleanValue();
    L29:
        r5.setTranslateEmojiCode(r1);
        this.f.set(r5, a.b(r4, "feedPreviewDraftDigestMessage", this.e));
        r5.setCustomStatusIconKey(a.l(r4, "customStatusIconKey"));
        return;
    L25:
        r14 = false;
        goto L26
    L21:
        r12 = false;
        goto L22
    L17:
        r10 = 0;
        goto L18
    L13:
        r8 = false;
        goto L14
    L9:
        r6 = false;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final void b(JsonObject r4, FeedPreview r5) {
        Intrinsics.checkNotNullParameter(r4, "json");
        Intrinsics.checkNotNullParameter(r5, "value");
        this.a.a(r4, r5);
        a.i(r4, "originDigest", r5.getOriginDigest(), this.b);
        a.h(r4, "lastMessagePosition", Integer.valueOf(r5.getLastMessagePosition()));
        a.j(r4, "lastMessageId", r5.getLastMessageId());
        a.j(r4, "markText", r5.getMarkText());
        a.g(r4, "isDelayed", Boolean.valueOf(r5.isDelayed()));
        a.g(r4, "isDisplayedInDelayedFeed", Boolean.valueOf(r5.isDisplayedInDelayedFeed()));
        a.i(r4, "muteUrgentInfo", r5.getMuteUrgentInfo(), this.c);
        a.h(r4, "atInfoCount", Integer.valueOf(r5.getAtInfoCount()));
        a.g(r4, "isCustomer", Boolean.valueOf(r5.isCustomer()));
        a.g(r4, "isSimpleTenant", Boolean.valueOf(r5.isSimpleTenant()));
        a.i(r4, "tagData", r5.getTagData(), this.d);
        a.g(r4, "isTranslateEmojiCode", Boolean.valueOf(r5.isTranslateEmojiCode()));
        a.a(r4, "feedPreviewDraftDigestMessage", r5.getDraftDigestMessage(), this.e);
        a.j(r4, "customStatusIconKey", r5.getCustomStatusIconKey());
    }

    public c(f r2, WireMessageTypeAdapter r3, MuteUrgentInfoTypeAdapter r4, WireMessageTypeAdapter r5, ListTypeAdapter r6) {
        Intrinsics.checkNotNullParameter(r2, "uiFeedCardFieldCodec");
        Intrinsics.checkNotNullParameter(r3, "originDigestAdapter");
        Intrinsics.checkNotNullParameter(r4, "muteUrgentInfoAdapter");
        Intrinsics.checkNotNullParameter(r5, "tagDataAdapter");
        Intrinsics.checkNotNullParameter(r6, "digestElementListAdapter");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        Field r7 = FeedPreview.class.getDeclaredField("draftDigestMessage");
        r7.setAccessible(true);
        this.f = r7;
    }
}
