package com.ss.android.lark.feed.molten.serializer;

import com.google.gson.JsonObject;
import com.ss.android.lark.feed.app.entity.DigestElement;
import com.ss.android.lark.feed.app.entity.EmojiProperty;
import com.ss.android.lark.feed.app.entity.TextProperty;
import com.ss.android.lark.feed.app.entity.TextWithEmojiProperty;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/feed/molten/serializer/DigestElementTypeAdapter;", "Lcom/ss/android/lark/feed/molten/serializer/JsonTreeTypeAdapter;", "Lcom/ss/android/lark/feed/app/entity/DigestElement;", "<init>", "()V", "writeJsonObject", "Lcom/google/gson/JsonObject;", "value", "readJsonObject", "json", "Kind", "feed-molten_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DigestElementTypeAdapter extends JsonTreeTypeAdapter<DigestElement> {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/feed/molten/serializer/DigestElementTypeAdapter$Kind;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "TEXT_PROPERTY", "EMOJI_PROPERTY", "TEXT_WITH_EMOJI_PROPERTY", "feed-molten_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Kind extends Enum<Kind> {
        public static final Kind EMOJI_PROPERTY = null;
        public static final Kind TEXT_PROPERTY = null;
        public static final Kind TEXT_WITH_EMOJI_PROPERTY = null;
        public static final /* synthetic */ Kind[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String value;

        public static EnumEntries<Kind> getEntries() {
            return b;
        }

        static {
            Kind r0 = new Kind("TEXT_PROPERTY", 0, "TextProperty");
            TEXT_PROPERTY = r0;
            Kind r1 = new Kind("EMOJI_PROPERTY", 1, "EmojiProperty");
            EMOJI_PROPERTY = r1;
            Kind r2 = new Kind("TEXT_WITH_EMOJI_PROPERTY", 2, "TextWithEmojiProperty");
            TEXT_WITH_EMOJI_PROPERTY = r2;
            Kind[] r4 = {r0, r1, r2};
            a = r4;
            b = EnumEntriesKt.enumEntries(r4);
        }

        public static Kind[] values() {
            return (Kind[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static Kind valueOf(String r1) {
            return (Kind) r27.a.a(Kind.class, r1);
        }

        public Kind(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public DigestElementTypeAdapter() {
    }

    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final DigestElement a(JsonObject r5) {
        Intrinsics.checkNotNullParameter(r5, "json");
        String r0 = a.l(r5, IPortraitService.TYPE);
        boolean r1 = Intrinsics.areEqual(r0, Kind.TEXT_PROPERTY.getValue());
        String r3 = BuildConfig.FLAVOR;
        if (r1 == false) goto L10;
        String r6 = a.l(r5, "content");
        if (r6 == null) goto L8;
        r3 = r6;
    L8:
        DigestElement r2 = new TextProperty(r3);
    L28:
        return r2;
    L10:
        if (Intrinsics.areEqual(r0, Kind.EMOJI_PROPERTY.getValue()) == false) goto L17;
        String r4 = a.l(r5, "emojiKey");
        if (r4 == null) goto L15;
        r3 = r4;
    L15:
        r2 = new EmojiProperty(r3, a.l(r5, "defaultContent"));
        goto L28
    L17:
        if (Intrinsics.areEqual(r0, Kind.TEXT_WITH_EMOJI_PROPERTY.getValue()) == false) goto L23;
        String r7 = a.l(r5, "content");
        if (r7 == null) goto L22;
        r3 = r7;
    L22:
        r2 = new TextWithEmojiProperty(r3);
        goto L28
    L23:
        String r8 = a.l(r5, "content");
        if (r8 == null) goto L27;
        r3 = r8;
    L27:
        r2 = new TextProperty(r3);
        goto L28
    }

    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final JsonObject b(DigestElement r5) {
        DigestElement r6 = r5;
        Intrinsics.checkNotNullParameter(r6, "value");
        JsonObject r0 = new JsonObject();
        if ((r6 instanceof TextProperty) == false) goto L6;
        a.j(r0, IPortraitService.TYPE, Kind.TEXT_PROPERTY.getValue());
        a.j(r0, "content", ((TextProperty) r6).getContent());
    L11:
        return r0;
    L6:
        if ((r6 instanceof EmojiProperty) == false) goto L9;
        a.j(r0, IPortraitService.TYPE, Kind.EMOJI_PROPERTY.getValue());
        EmojiProperty r7 = (EmojiProperty) r6;
        a.j(r0, "emojiKey", r7.getEmojiKey());
        a.j(r0, "defaultContent", r7.getDefaultContent());
        goto L11
    L9:
        if ((r6 instanceof TextWithEmojiProperty) == false) goto L13;
        a.j(r0, IPortraitService.TYPE, Kind.TEXT_WITH_EMOJI_PROPERTY.getValue());
        a.j(r0, "content", ((TextWithEmojiProperty) r6).getContent());
        goto L11
    L13:
        throw new NoWhenBranchMatchedException();
    }
}
