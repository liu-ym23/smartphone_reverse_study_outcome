package com.obric.livecard.api.entity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/obric/livecard/api/entity/SceneEntityParser;", "", "()V", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "parse", "Lcom/obric/livecard/api/entity/ISceneEntity;", "json", "", "SceneEntityDeserializer", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SceneEntityParser {
    public static final SceneEntityParser INSTANCE = null;
    private static final Gson gson = null;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\"\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/obric/livecard/api/entity/SceneEntityParser$SceneEntityDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/obric/livecard/api/entity/ISceneEntity;", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class SceneEntityDeserializer implements JsonDeserializer<ISceneEntity> {

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r0 = new int[SceneType.values().length];
                r0[SceneType.AI_SUGGESTION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[SceneType.AI_TASK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[SceneType.NOTIFICATION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                $EnumSwitchMapping$0 = r0;
            }
        }

        public SceneEntityDeserializer() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.JsonDeserializer
        public ISceneEntity deserialize(JsonElement r2, Type r3, JsonDeserializationContext r4) {
            Type r1 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.memorydata.plugin");
            JsonDeserializationContext r5 = (JsonDeserializationContext) ZeusTransformUtils.wrapperContextForParams(r4, JsonDeserializationContext.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "json");
            Intrinsics.checkNotNullParameter(r1, "typeOfT");
            Intrinsics.checkNotNullParameter(r5, "context");
            JsonElement r6 = r2.getAsJsonObject().get("sceneType");
            if (r6 == null) goto L5;
            String r7 = r6.getAsString();
        L6:
            if (r7 != null) goto L8;
            return null;
        L8:
            int r8 = WhenMappings.$EnumSwitchMapping$0[SceneType.valueOf(r7).ordinal()];
            if (r8 != 1) goto L11;
            Object r9 = SuggestionSceneEntity.class;
        L20:
            return (ISceneEntity) ZeusTransformUtils.preCheckCast(r5.deserialize(r2, (Type) ZeusTransformUtils.preCheckCast(r9, Type.class, "com.obric.memorydata.plugin")), ISceneEntity.class, "com.obric.memorydata.plugin");
        L11:
            if (r8 != 2) goto L13;
            r9 = TaskSceneEntity.class;
            goto L20
        L13:
            if (r8 != 3) goto L16;
            r9 = NotificationSceneEntity.class;
            goto L20
        L16:
            throw new NoWhenBranchMatchedException();
        L5:
            r7 = null;
            goto L6
        }

        @Override // com.google.gson.JsonDeserializer
        public /* synthetic */ ISceneEntity deserialize(JsonElement r3, Type r4, JsonDeserializationContext r5) {
            return deserialize(r3, (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.memorydata.plugin"), (JsonDeserializationContext) ZeusTransformUtils.wrapperContextForParams(r5, JsonDeserializationContext.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        INSTANCE = new SceneEntityParser();
        Gson r0 = new GsonBuilder().registerTypeAdapter((Type) ZeusTransformUtils.preCheckCast(ISceneEntity.class, Type.class, "com.obric.memorydata.plugin"), new SceneEntityDeserializer()).create();
        Intrinsics.checkNotNullExpressionValue(r0, "GsonBuilder()\n        .r…izer())\n        .create()");
        gson = r0;
    }

    private SceneEntityParser() {
    }

    public final Gson getGson() {
        return gson;
    }

    public final ISceneEntity parse(String r4) {
        Object r3 = null;
        if (r4 != null) goto L5;
        return null;
    L5:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L8;
        r4 = null;
    L8:
        if (r4 == null) goto L23;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L12
        Object r5 = Result.m1421constructorimpl((ISceneEntity) ZeusTransformUtils.preCheckCast(gson.fromJson(r4, ISceneEntity.class), ISceneEntity.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L12
    L15:
        if (Result.m1427isFailureimpl(r5) == true) goto L19;
        r3 = r5;
    L19:
        return (ISceneEntity) ZeusTransformUtils.preCheckCast(r3, ISceneEntity.class, "com.obric.memorydata.plugin");
    L12:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L15
    L23:
        return null;
    }
}
