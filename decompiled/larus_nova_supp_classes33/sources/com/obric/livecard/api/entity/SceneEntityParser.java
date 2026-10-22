package com.obric.livecard.api.entity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/obric/livecard/api/entity/SceneEntityParser;", "", "()V", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "parse", "Lcom/obric/livecard/api/entity/ISceneEntity;", "json", "", "SceneEntityDeserializer", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SceneEntityParser {
    public static final SceneEntityParser INSTANCE = null;
    private static final Gson gson = null;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\"\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/obric/livecard/api/entity/SceneEntityParser$SceneEntityDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/obric/livecard/api/entity/ISceneEntity;", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class SceneEntityDeserializer implements JsonDeserializer<ISceneEntity> {

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

        public ISceneEntity deserialize(JsonElement r2, Type r3, JsonDeserializationContext r4) {
            Intrinsics.checkNotNullParameter(r2, "json");
            Intrinsics.checkNotNullParameter(r3, "typeOfT");
            Intrinsics.checkNotNullParameter(r4, "context");
            JsonElement r5 = r2.getAsJsonObject().get("sceneType");
            if (r5 == null) goto L5;
            String r6 = r5.getAsString();
        L6:
            if (r6 != null) goto L8;
            return null;
        L8:
            int r7 = WhenMappings.$EnumSwitchMapping$0[SceneType.valueOf(r6).ordinal()];
            if (r7 == 1) goto L19;
            if (r7 == 2) goto L21;
            if (r7 != 3) goto L16;
            return (ISceneEntity) r4.deserialize(r2, NotificationSceneEntity.class);
        L16:
            throw new NoWhenBranchMatchedException();
        L21:
            return (ISceneEntity) r4.deserialize(r2, TaskSceneEntity.class);
        L19:
            return (ISceneEntity) r4.deserialize(r2, SuggestionSceneEntity.class);
        L5:
            r6 = null;
            goto L6
        }

        /* JADX INFO: renamed from: deserialize, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m51deserialize(JsonElement r1, Type r2, JsonDeserializationContext r3) {
            return deserialize(r1, r2, r3);
        }
    }

    private SceneEntityParser() {
    }

    static {
        INSTANCE = new SceneEntityParser();
        gson = new GsonBuilder().registerTypeAdapter(ISceneEntity.class, new SceneEntityDeserializer()).create();
    }

    public final Gson getGson() {
        return gson;
    }

    public final ISceneEntity parse(String r4) {
        Object r0 = null;
        if (r4 != null) goto L5;
        return null;
    L5:
        if ((!StringsKt.isBlank(r4)) == true) goto L8;
        r4 = null;
    L8:
        if (r4 == null) goto L23;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        Object r5 = Result.constructor-impl((ISceneEntity) gson.fromJson(r4, ISceneEntity.class));     // Catch: Throwable -> L12
    L15:
        if (Result.isFailure-impl(r5) == true) goto L19;
        r0 = r5;
    L19:
        return (ISceneEntity) r0;
    L12:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L23:
        return null;
    }
}
