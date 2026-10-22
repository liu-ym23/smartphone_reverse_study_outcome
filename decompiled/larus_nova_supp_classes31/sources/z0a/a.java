package z0a;

import com.larus.im.internal.delegate.b;
import com.larus.ugc.feed.api.model.AiBeautifyUserContentKmp;
import com.larus.ugc.feed.api.model.AuthorInfoKmp;
import com.larus.ugc.feed.api.model.CreationDynamicInfoKmp;
import com.larus.ugc.feed.api.model.CreationPublishExtraKmp;
import com.larus.ugc.feed.api.model.ImageInfoKmp;
import com.larus.ugc.feed.api.model.ResourceKmp;
import com.larus.ugc.feed.api.model.TplDetailKmp;
import com.larus.ugc.feed.api.model.TplInfoKmp;
import com.larus.ugc.feed.api.model.UserCreationContentKmp;
import com.larus.ugc.feed.api.model.UserCreationImageKmp;
import com.larus.ugc.feed.api.model.UserCreationKmp;
import com.larus.ugc.feed.api.model.UserCreationRefContentKmp;
import com.larus.ugc.feed.api.model.UserCreationUserAvatarKmp;
import com.larus.ugc.feed.api.model.VideoUserContentKmp;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public static final String a(UserCreationKmp r1) {
        Intrinsics.checkNotNullParameter(r1, "creation");
        switch(r1.getUserCreationType()) {
            case 2: goto L26;
            case 3: goto L19;
            case 4: goto L12;
            case 5: goto L26;
            case 6: goto L5;
            case 7: goto L5;
            case 8: goto L5;
            case 9: goto L5;
            case 10: goto L5;
            case 11: goto L5;
            case 12: goto L5;
            default: goto L32;
        };
    L5:
        UserCreationContentKmp r2 = r1.getContent();
        if (r2 == null) goto L32;
        VideoUserContentKmp r3 = r2.getVideoUserContent();
        if (r3 == null) goto L32;
        String r4 = r3.getPrompt();
        if (r4 == null) goto L32;
        return r4;
    L12:
        UserCreationContentKmp r5 = r1.getContent();
        if (r5 == null) goto L32;
        AiBeautifyUserContentKmp r6 = r5.getAiBeautifyUserContent();
        if (r6 == null) goto L32;
        String r7 = r6.getPrompt();
        if (r7 == null) goto L32;
        return r7;
    L19:
        UserCreationContentKmp r8 = r1.getContent();
        if (r8 == null) goto L32;
        UserCreationUserAvatarKmp r9 = r8.getUserAvatarContent();
        if (r9 == null) goto L32;
        String r10 = r9.getPrompt();
        if (r10 == null) goto L32;
        return r10;
    L26:
        UserCreationContentKmp r11 = r1.getContent();
        if (r11 == null) goto L32;
        UserCreationImageKmp r12 = r11.getImageContent();
        if (r12 == null) goto L32;
        String r13 = r12.getPrompt();
        if (r13 == null) goto L32;
        return r13;
    L32:
        return "";
    }

    public static final Integer b(UserCreationKmp r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        UserCreationRefContentKmp r0 = r5.getRefContent();
        if (r0 == null) goto L5;
        List<ResourceKmp> r1 = r0.getRefResources();
    L6:
        List<ResourceKmp> r2 = r1;
        int r4 = 0;
        if (r2 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == true) goto L36;
        List<ResourceKmp> r6 = r1;
        if ((r6 instanceof Collection) == true) goto L17;
    L19:
        Iterator<T> r7 = r6.iterator();
        int r8 = 0;
    L21:
        if (r7.hasNext() == false) goto L33;
        ResourceKmp r9 = (ResourceKmp) r7.next();
        if (r9 == null) goto L25;
        ImageInfoKmp r10 = r9.getImageInfo();
    L26:
        if (r10 == null) goto L28;
        boolean r11 = true;
    L29:
        if (r11 == false) goto L21;
        r8 = r8 + 1;
        if (r8 >= 0) goto L21;
        CollectionsKt.throwCountOverflow();
        goto L21
    L28:
        r11 = false;
        goto L29
    L25:
        r10 = null;
        goto L26
    L33:
        r4 = r8;
    L35:
        return Integer.valueOf(r4);
    L17:
        if (r6.isEmpty() == false) goto L19;
    L36:
        UserCreationRefContentKmp r12 = r5.getRefContent();
        if (r12 == null) goto L49;
        List<ImageInfoKmp> r13 = r12.getRefImages();
        if (r13 != null) goto L41;
        return null;
    L41:
        return Integer.valueOf(r13.size());
    L49:
        return null;
    L9:
        if (r2.isEmpty() == true) goto L12;
        r3 = false;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public static final String c(UserCreationKmp r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        String r0 = b.b.getUserId();
        AuthorInfoKmp r1 = r2.getAuthorInfo();
        if (r1 == null) goto L5;
        String r3 = r1.getUid();
    L7:
        if (Intrinsics.areEqual(r3, r0) == false) goto L10;
        return "self_created";
    L10:
        Integer r4 = r2.getContentSource();
        if (r4 != null) goto L13;
    L17:
        return "others_created";
    L13:
        if (r4.intValue() == 0) goto L17;
        if (r4.intValue() != 3) goto L17;
        return "default";
    L5:
        r3 = null;
        goto L7
    }

    public static final String d(UserCreationKmp r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        switch(r1.getUserCreationType()) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            case 10: goto L7;
            case 11: goto L6;
            case 12: goto L5;
            default: goto L4;
        };
    L4:
        return "";
    L5:
        return "refaudio2video";
    L6:
        return "videoimagedmixed2video";
    L7:
        return "avatar2video";
    L8:
        return "image2video_extend";
    L9:
        return "text2video_extend";
    L10:
        return "image2video";
    L11:
        return "text2video";
    L12:
        return "image2image";
    L13:
        return "avatar2image";
    L14:
        return "text2image";
    L15:
        return "text2music";
    }

    public static final String e(UserCreationKmp r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        switch(r1.getUserCreationType()) {
            case 1: goto L9;
            case 2: goto L8;
            case 3: goto L7;
            case 4: goto L6;
            case 5: goto L8;
            case 6: goto L5;
            case 7: goto L5;
            case 8: goto L5;
            case 9: goto L5;
            case 10: goto L5;
            case 11: goto L5;
            case 12: goto L5;
            default: goto L4;
        };
    L4:
        return "unKnow";
    L5:
        return "video";
    L6:
        return "image_edit";
    L7:
        return "replica";
    L8:
        return "pic";
    L9:
        return "music";
    }

    public static final String f(UserCreationKmp r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        CreationDynamicInfoKmp r2 = r1.getDynamicInfo();
        if (r2 == null) goto L9;
        TplInfoKmp r3 = r2.getTplInfo();
        if (r3 == null) goto L9;
        TplDetailKmp r4 = r3.getTplDetailForNoAvatar();
        if (r4 == null) goto L9;
        return r4.getTagType();
    L9:
        return null;
    }

    public static final boolean g(UserCreationKmp r1) {
        Intrinsics.checkNotNullParameter(r1, "creation");
        CreationPublishExtraKmp r2 = r1.getPublishExtra();
        if (r2 != null) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(r2.getPublicRefImage(), Boolean.TRUE);
    }
}
