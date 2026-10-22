package com.obric.aiagent.assistant.common.ui.icon;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public static final Map<String, List<String>> a = null;

    static {
        a = MapsKt.linkedMapOf(new Pair[]{TuplesKt.to("general", a(new TaskResolvedIcon[]{TaskResolvedIcon.GENERAL_1, TaskResolvedIcon.GENERAL_2, TaskResolvedIcon.GENERAL_3, TaskResolvedIcon.GENERAL_4, TaskResolvedIcon.GENERAL_5})), TuplesKt.to("emotion_smile", a(new TaskResolvedIcon[]{TaskResolvedIcon.EMOTION_SMILE})), TuplesKt.to("emotion_sad", a(new TaskResolvedIcon[]{TaskResolvedIcon.EMOTION_SAD})), TuplesKt.to("emotion_angry", a(new TaskResolvedIcon[]{TaskResolvedIcon.EMOTION_ANGRY})), TuplesKt.to("emotion_surprised", a(new TaskResolvedIcon[]{TaskResolvedIcon.EMOTION_SURPRISED})), TuplesKt.to("emotion_laugh", a(new TaskResolvedIcon[]{TaskResolvedIcon.EMOTION_LAUGH})), TuplesKt.to("media_movie", a(new TaskResolvedIcon[]{TaskResolvedIcon.MEDIA_MOVIE})), TuplesKt.to("media_game", a(new TaskResolvedIcon[]{TaskResolvedIcon.MEDIA_GAME_1, TaskResolvedIcon.MEDIA_GAME_2})), TuplesKt.to("media_music", a(new TaskResolvedIcon[]{TaskResolvedIcon.MEDIA_MUSIC})), TuplesKt.to("media_photo", a(new TaskResolvedIcon[]{TaskResolvedIcon.MEDIA_PHOTO})), TuplesKt.to("media_video", a(new TaskResolvedIcon[]{TaskResolvedIcon.MEDIA_VIDEO})), TuplesKt.to("relationship_running", a(new TaskResolvedIcon[]{TaskResolvedIcon.RELATIONSHIP_RUNNING_1, TaskResolvedIcon.RELATIONSHIP_RUNNING_2})), TuplesKt.to("relationship_fitness", a(new TaskResolvedIcon[]{TaskResolvedIcon.RELATIONSHIP_FITNESS_1, TaskResolvedIcon.RELATIONSHIP_FITNESS_2, TaskResolvedIcon.RELATIONSHIP_FITNESS_3, TaskResolvedIcon.RELATIONSHIP_FITNESS_4})), TuplesKt.to("relationship_exercise", a(new TaskResolvedIcon[]{TaskResolvedIcon.RELATIONSHIP_EXERCISE_1, TaskResolvedIcon.RELATIONSHIP_FIGURE})), TuplesKt.to("relationship_group", a(new TaskResolvedIcon[]{TaskResolvedIcon.RELATIONSHIP_PARTY_1})), TuplesKt.to("relationship_person", a(new TaskResolvedIcon[]{TaskResolvedIcon.RELATIONSHIP_PARTY_2, TaskResolvedIcon.RELATIONSHIP_PARTY_3})), TuplesKt.to("relationship_chat", a(new TaskResolvedIcon[]{TaskResolvedIcon.RELATIONSHIP_PARTY_4})), TuplesKt.to("relationship_support", a(new TaskResolvedIcon[]{TaskResolvedIcon.RELATIONSHIP_SUPPORT})), TuplesKt.to("relationship_profile", a(new TaskResolvedIcon[]{TaskResolvedIcon.RELATIONSHIP_PROFILE})), TuplesKt.to("relationship_private", a(new TaskResolvedIcon[]{TaskResolvedIcon.RELATIONSHIP_PRIVATE})), TuplesKt.to("calendar", a(new TaskResolvedIcon[]{TaskResolvedIcon.CALENDAR_1})), TuplesKt.to("reminder", a(new TaskResolvedIcon[]{TaskResolvedIcon.CALENDAR_2})), TuplesKt.to("schedule_time", a(new TaskResolvedIcon[]{TaskResolvedIcon.CALENDAR_3})), TuplesKt.to("materials_document", a(new TaskResolvedIcon[]{TaskResolvedIcon.MATERIALS_1})), TuplesKt.to("materials_book", a(new TaskResolvedIcon[]{TaskResolvedIcon.MATERIALS_2})), TuplesKt.to("materials_note", a(new TaskResolvedIcon[]{TaskResolvedIcon.MATERIALS_3})), TuplesKt.to("materials_folder", a(new TaskResolvedIcon[]{TaskResolvedIcon.MATERIALS_4})), TuplesKt.to("health", a(new TaskResolvedIcon[]{TaskResolvedIcon.HEALTH_1, TaskResolvedIcon.HEALTH_2})), TuplesKt.to("study", a(new TaskResolvedIcon[]{TaskResolvedIcon.STUDY_1})), TuplesKt.to("finance", a(new TaskResolvedIcon[]{TaskResolvedIcon.FINANCE_1, TaskResolvedIcon.FINANCE_2})), TuplesKt.to("food", a(new TaskResolvedIcon[]{TaskResolvedIcon.FOOD})), TuplesKt.to("shopping", a(new TaskResolvedIcon[]{TaskResolvedIcon.SHOPPING})), TuplesKt.to("travel_fly", a(new TaskResolvedIcon[]{TaskResolvedIcon.TRAVEL_FLY})), TuplesKt.to("beer", a(new TaskResolvedIcon[]{TaskResolvedIcon.BEER})), TuplesKt.to("travel_train", a(new TaskResolvedIcon[]{TaskResolvedIcon.TRAVEL_TRAIN})), TuplesKt.to("travel_car", a(new TaskResolvedIcon[]{TaskResolvedIcon.TRAVEL_CAR})), TuplesKt.to("drink", a(new TaskResolvedIcon[]{TaskResolvedIcon.DRINK})), TuplesKt.to("vacation", a(new TaskResolvedIcon[]{TaskResolvedIcon.VACATION})), TuplesKt.to("cake", a(new TaskResolvedIcon[]{TaskResolvedIcon.CAKE})), TuplesKt.to("clothes", a(new TaskResolvedIcon[]{TaskResolvedIcon.CLOTHES})), TuplesKt.to("bag", a(new TaskResolvedIcon[]{TaskResolvedIcon.BAG})), TuplesKt.to("milestone", a(new TaskResolvedIcon[]{TaskResolvedIcon.MILESTONE})), TuplesKt.to("gift", a(new TaskResolvedIcon[]{TaskResolvedIcon.GIFT}))});
    }

    public static List a(TaskResolvedIcon... r4) {
        ArrayList r0 = new ArrayList(r4.length);
        int r1 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.add(r4[r2].getKey());
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }
}
