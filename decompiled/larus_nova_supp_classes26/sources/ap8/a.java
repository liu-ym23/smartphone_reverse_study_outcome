package ap8;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.creative.CreativeScene;
import com.larus.im.bean.message.AICreationTaskDurationInfo;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {

    /* JADX INFO: renamed from: ap8.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/larus/bmhome/creative/CreativeExtKt$getAICreationTaskDurationInfo$1$listType$1", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/larus/im/bean/message/AICreationTaskDurationInfo;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C0000a extends TypeToken<List<? extends AICreationTaskDurationInfo>> {
        public C0000a() {
        }
    }

    public static final List<AICreationTaskDurationInfo> a(Message r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Map r4 = r3.getExt();
        if (r4 == null) goto L11;
        String r5 = (String) r4.get("ai_creation_duration_info");
        if (r5 == null) goto L11;
        Type r0 = new C0000a().getType();
        return (List) new Gson().fromJson(r5, r0);
    L9:
        e = move-exception;
        FLogger.a.e("CreativeExt", "getAICreationTaskDurationInfo error", e);
    L11:
        return null;
    }

    public static final String b(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Map r2 = r1.getExt();
        if (r2 != null) goto L7;
        return null;
    L7:
        return (String) r2.get("creativity_scene");
    }

    public static final boolean c(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Map r2 = r1.getExt();
        if (r2 == null) goto L5;
        String r3 = (String) r2.get("disable_puzzle");
    L7:
        return Intrinsics.areEqual(r3, "true");
    L5:
        r3 = null;
        goto L7
    }

    public static final int d(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        switch(r1.hashCode()) {
            case -2096799662: goto L18;
            case -578836747: goto L14;
            case 100313435: goto L10;
            case 104263205: goto L6;
            default: goto L21;
        };
    L21:
        return 0;
    L6:
        if (r1.equals("music") == false) goto L21;
        return 1;
    L10:
        if (r1.equals("image") == false) goto L21;
        return 2;
    L14:
        if (r1.equals(CreativeScene.AVATAR_IMAGE) == false) goto L21;
        return 3;
    L18:
        if (r1.equals(CreativeScene.AI_BEAUTIFY_IMAGE) == false) goto L21;
        return 4;
    }
}
