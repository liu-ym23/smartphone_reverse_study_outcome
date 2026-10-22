package com.ss.android.lark.chat.entity.chatter;

import com.larksuite.component.ui.tag.LarkNameTag;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/chat/entity/chatter/TagInfo;", "Ljava/io/Serializable;", "text", BuildConfig.FLAVOR, IPortraitService.TYPE, "Lcom/ss/android/lark/chat/entity/chatter/TagType;", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/chat/entity/chatter/TagType;)V", "getText", "()Ljava/lang/String;", "getType", "()Lcom/ss/android/lark/chat/entity/chatter/TagType;", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "component1", "component2", "copy", "toString", "Companion", "Factory", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TagInfo implements Serializable {
    public static final a Companion = null;
    public static final Lazy<b> a = null;
    private static final long serialVersionUID = -351515894162L;
    private final String text;
    private final TagType type;

    public static final class a {

        /* JADX INFO: renamed from: com.ss.android.lark.chat.entity.chatter.TagInfo$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0095a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[com.bytedance.lark.pb.basic.v1.Chatter.ChatExtra.ChatChatterTagInfo.TagInfo.TagType.values().length];
                r0[com.bytedance.lark.pb.basic.v1.Chatter.ChatExtra.ChatChatterTagInfo.TagInfo.TagType.CLASS_TEACHER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[com.bytedance.lark.pb.basic.v1.Chatter.ChatExtra.ChatChatterTagInfo.TagInfo.TagType.DISCIPLINE_TEACHER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[com.bytedance.lark.pb.basic.v1.Chatter.ChatExtra.ChatChatterTagInfo.TagInfo.TagType.ADMIN_USER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }

        public a() {
        }

        @JvmStatic
        public static void a(LarkNameTag.c r2, List r3, List r4) {
            Intrinsics.checkNotNullParameter(r2, "builder");
            Intrinsics.checkNotNullParameter(r4, "rules");
            if (r3 != null) goto L5;
            return;
        L5:
            List<TagInfo> r5 = CollectionsKt.toList(r3);
            Intrinsics.checkNotNullParameter(r5, "<this>");
            Intrinsics.checkNotNullParameter(r4, "rules");
            Iterator r6 = r4.iterator();
        L7:
            if (r6.hasNext() == false) goto L9;
            r5 = ((com.ss.android.lark.chat.entity.chatter.b) r6.next()).a(r5);
            goto L7
        L9:
            Iterator<T> r7 = r5.iterator();
        L11:
            if (r7.hasNext() == false) goto L13;
            d.a(r2, (TagInfo) r7.next());
            goto L11
        }
    }

    public static final class b {
        public b() {
        }
    }

    @JvmStatic
    public static final void apply(LarkNameTag.c r1, List<TagInfo> r2, List<? extends com.ss.android.lark.chat.entity.chatter.b> r3) {
        Companion.getClass();
        a.a(r1, r2, r3);
    }

    public static /* synthetic */ TagInfo copy$default(TagInfo r0, String r1, TagType r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.text;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.type;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.text;
    }

    public final TagType component2() {
        return this.type;
    }

    public final TagInfo copy(String r2, TagType r3) {
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r3, IPortraitService.TYPE);
        return new TagInfo(r2, r3);
    }

    public String toString() {
        return "TagInfo(text=" + this.text + ", type=" + this.type + ')';
    }

    static {
        Companion = new a();
        a = LazyKt.lazy(TagInfo$Companion$factory$2.INSTANCE);
    }

    public static final b getFactory() {
        Companion.getClass();
        return (b) access$getFactory$delegate$cp().getValue();
    }

    public int hashCode() {
        return (this.text.hashCode() * 31) + this.type.hashCode();
    }

    public static final /* synthetic */ Lazy access$getFactory$delegate$cp() {
        return a;
    }

    public final String getText() {
        return this.text;
    }

    public final TagType getType() {
        return this.type;
    }

    @JvmStatic
    public static final TagInfo map(com.bytedance.lark.pb.basic.v1.Chatter.ChatExtra.ChatChatterTagInfo.TagInfo r3) {
        a r0 = Companion;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "tagInfo");
        String r1 = StringsKt.trim(r3.description).toString();
        com.bytedance.lark.pb.basic.v1.Chatter.ChatExtra.ChatChatterTagInfo.TagInfo.TagType r4 = r3.tag_type;
        r0.getClass();
        int r5 = a.C0095a.a[r4.ordinal()];
        if (r5 != 1) goto L5;
        TagType r6 = TagType.CLASS_TEACHER;
    L13:
        return new TagInfo(r1, r6);
    L5:
        if (r5 != 2) goto L7;
        r6 = TagType.DISCIPLINE_TEACHER;
        goto L13
    L7:
        if (r5 == 3) goto L9;
        r6 = TagType.UNKNOWN;
        goto L13
    L9:
        r6 = TagType.ADMIN_USER;
        goto L13
    }

    public boolean equals(Object r6) {
        if ((r6 instanceof TagInfo) == false) goto L5;
        TagInfo r7 = (TagInfo) r6;
        boolean r0 = Intrinsics.areEqual(this.text, r7.text);
        boolean r1 = false;
        boolean r2 = r0 | false;
        if (this.type.getBgColor() != r7.type.getBgColor()) goto L9;
        boolean r3 = true;
    L10:
        boolean r4 = r2 | r3;
        if (this.type.getOrder() != r7.type.getOrder()) goto L13;
        boolean r5 = true;
    L14:
        boolean r8 = r4 | r5;
        if (this.type.getTextColor() != r7.type.getTextColor()) goto L18;
        r1 = true;
    L18:
        return r8 | r1;
    L13:
        r5 = false;
        goto L14
    L9:
        r3 = false;
        goto L10
    L5:
        return super.equals(r6);
    }

    public TagInfo(String r2, TagType r3) {
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r3, IPortraitService.TYPE);
        this.text = r2;
        this.type = r3;
    }

    @JvmStatic
    public static final void apply(LarkNameTag.c r1, TagInfo r2) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r1, "builder");
        Intrinsics.checkNotNullParameter(r2, "tagInfo");
        d.a(r1, r2);
    }

    @JvmStatic
    public static final void apply(LarkNameTag.c r1, List<TagInfo> r2) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r1, "builder");
        a.a(r1, r2, CollectionsKt.emptyList());
    }

    @JvmStatic
    public static final void apply(LarkNameTag.c r1, List<TagInfo> r2, com.ss.android.lark.chat.entity.chatter.b r3) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r1, "builder");
        Intrinsics.checkNotNullParameter(r2, "infos");
        Intrinsics.checkNotNullParameter(r3, "rules");
        a.a(r1, r2, CollectionsKt.listOf(r3));
    }
}
