package com.obric.memorydata.memory.ui.automemory;

import androidx.core.app.NotificationCompat;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R#\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryIconPools;", "", "<init>", "()V", "SEMANTIC_GENERAL", "", "pools", "", "", "getPools", "()Ljava/util/Map;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f10683a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, List<String>> f10684b = null;

    static {
        f10683a = new l();
        f10684b = MapsKt.mapOf(new Pair[]{TuplesKt.to(SlardarSettingsConstants.SETTING_GENERAL, CollectionsKt.listOf(new String[]{AutoMemoryResolvedIcon.GENERAL_1.getKey(), AutoMemoryResolvedIcon.GENERAL_2.getKey(), AutoMemoryResolvedIcon.GENERAL_3.getKey(), AutoMemoryResolvedIcon.GENERAL_4.getKey(), AutoMemoryResolvedIcon.GENERAL_5.getKey()})), TuplesKt.to("emotion_smile", CollectionsKt.listOf(AutoMemoryResolvedIcon.EMOTION_SMILE.getKey())), TuplesKt.to("emotion_sad", CollectionsKt.listOf(AutoMemoryResolvedIcon.EMOTION_SAD.getKey())), TuplesKt.to("emotion_angry", CollectionsKt.listOf(AutoMemoryResolvedIcon.EMOTION_ANGRY.getKey())), TuplesKt.to("emotion_surprised", CollectionsKt.listOf(AutoMemoryResolvedIcon.EMOTION_SURPRISED.getKey())), TuplesKt.to("emotion_laugh", CollectionsKt.listOf(AutoMemoryResolvedIcon.EMOTION_LAUGH.getKey())), TuplesKt.to("media_movie", CollectionsKt.listOf(AutoMemoryResolvedIcon.MEDIA_MOVIE.getKey())), TuplesKt.to("media_game", CollectionsKt.listOf(new String[]{AutoMemoryResolvedIcon.MEDIA_GAME_1.getKey(), AutoMemoryResolvedIcon.MEDIA_GAME_2.getKey()})), TuplesKt.to("media_music", CollectionsKt.listOf(AutoMemoryResolvedIcon.MEDIA_MUSIC.getKey())), TuplesKt.to("media_photo", CollectionsKt.listOf(AutoMemoryResolvedIcon.MEDIA_PHOTO.getKey())), TuplesKt.to("media_video", CollectionsKt.listOf(AutoMemoryResolvedIcon.MEDIA_VIDEO.getKey())), TuplesKt.to("relationship_running", CollectionsKt.listOf(new String[]{AutoMemoryResolvedIcon.RELATIONSHIP_RUNNING_1.getKey(), AutoMemoryResolvedIcon.RELATIONSHIP_RUNNING_2.getKey()})), TuplesKt.to("relationship_fitness", CollectionsKt.listOf(new String[]{AutoMemoryResolvedIcon.RELATIONSHIP_FITNESS_1.getKey(), AutoMemoryResolvedIcon.RELATIONSHIP_FITNESS_2.getKey(), AutoMemoryResolvedIcon.RELATIONSHIP_FITNESS_3.getKey(), AutoMemoryResolvedIcon.RELATIONSHIP_FITNESS_4.getKey()})), TuplesKt.to("relationship_exercise", CollectionsKt.listOf(new String[]{AutoMemoryResolvedIcon.RELATIONSHIP_EXERCISE_1.getKey(), AutoMemoryResolvedIcon.RELATIONSHIP_FIGURE.getKey()})), TuplesKt.to("relationship_group", CollectionsKt.listOf(AutoMemoryResolvedIcon.RELATIONSHIP_PARTY_1.getKey())), TuplesKt.to("relationship_person", CollectionsKt.listOf(new String[]{AutoMemoryResolvedIcon.RELATIONSHIP_PARTY_2.getKey(), AutoMemoryResolvedIcon.RELATIONSHIP_PARTY_3.getKey()})), TuplesKt.to("relationship_chat", CollectionsKt.listOf(AutoMemoryResolvedIcon.RELATIONSHIP_PARTY_4.getKey())), TuplesKt.to("relationship_support", CollectionsKt.listOf(AutoMemoryResolvedIcon.RELATIONSHIP_SUPPORT.getKey())), TuplesKt.to("relationship_profile", CollectionsKt.listOf(AutoMemoryResolvedIcon.RELATIONSHIP_PROFILE.getKey())), TuplesKt.to("relationship_private", CollectionsKt.listOf(AutoMemoryResolvedIcon.RELATIONSHIP_PRIVATE.getKey())), TuplesKt.to("calendar", CollectionsKt.listOf(AutoMemoryResolvedIcon.CALENDAR_1.getKey())), TuplesKt.to(NotificationCompat.CATEGORY_REMINDER, CollectionsKt.listOf(AutoMemoryResolvedIcon.CALENDAR_2.getKey())), TuplesKt.to("schedule_time", CollectionsKt.listOf(AutoMemoryResolvedIcon.CALENDAR_3.getKey())), TuplesKt.to("materials_document", CollectionsKt.listOf(AutoMemoryResolvedIcon.MATERIALS_1.getKey())), TuplesKt.to("materials_book", CollectionsKt.listOf(AutoMemoryResolvedIcon.MATERIALS_2.getKey())), TuplesKt.to("materials_note", CollectionsKt.listOf(AutoMemoryResolvedIcon.MATERIALS_3.getKey())), TuplesKt.to("materials_folder", CollectionsKt.listOf(AutoMemoryResolvedIcon.MATERIALS_4.getKey())), TuplesKt.to("health", CollectionsKt.listOf(new String[]{AutoMemoryResolvedIcon.HEALTH_1.getKey(), AutoMemoryResolvedIcon.HEALTH_2.getKey()})), TuplesKt.to("study", CollectionsKt.listOf(AutoMemoryResolvedIcon.STUDY_1.getKey())), TuplesKt.to("finance", CollectionsKt.listOf(new String[]{AutoMemoryResolvedIcon.FINANCE_1.getKey(), AutoMemoryResolvedIcon.FINANCE_2.getKey()})), TuplesKt.to("food", CollectionsKt.listOf(AutoMemoryResolvedIcon.FOOD.getKey())), TuplesKt.to("shopping", CollectionsKt.listOf(AutoMemoryResolvedIcon.SHOPPING.getKey())), TuplesKt.to("travel_fly", CollectionsKt.listOf(AutoMemoryResolvedIcon.TRAVEL_FLY.getKey())), TuplesKt.to("beer", CollectionsKt.listOf(AutoMemoryResolvedIcon.BEER.getKey())), TuplesKt.to("travel_train", CollectionsKt.listOf(AutoMemoryResolvedIcon.TRAVEL_TRAIN.getKey())), TuplesKt.to("travel_car", CollectionsKt.listOf(AutoMemoryResolvedIcon.TRAVEL_CAR.getKey())), TuplesKt.to("drink", CollectionsKt.listOf(AutoMemoryResolvedIcon.DRINK.getKey())), TuplesKt.to("vacation", CollectionsKt.listOf(AutoMemoryResolvedIcon.VACATION.getKey())), TuplesKt.to("cake", CollectionsKt.listOf(AutoMemoryResolvedIcon.CAKE.getKey())), TuplesKt.to("clothes", CollectionsKt.listOf(AutoMemoryResolvedIcon.CLOTHES.getKey())), TuplesKt.to("bag", CollectionsKt.listOf(AutoMemoryResolvedIcon.BAG.getKey())), TuplesKt.to("milestone", CollectionsKt.listOf(AutoMemoryResolvedIcon.MILESTONE.getKey())), TuplesKt.to("gift", CollectionsKt.listOf(AutoMemoryResolvedIcon.GIFT.getKey()))});
    }

    private l() {
    }

    public final Map<String, List<String>> a() {
        return f10684b;
    }
}
