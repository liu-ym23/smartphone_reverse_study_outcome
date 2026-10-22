package com.obric.memorydata.memory.ui.automemory;

import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b@\b\u0086\u0081\u0002\u0018\u0000 D2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001DB\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bAj\u0002\bBj\u0002\bC¨\u0006E"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryResolvedIcon;", "", "key", "", "drawableRes", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getKey", "()Ljava/lang/String;", "getDrawableRes", "()I", "GENERAL_1", "GENERAL_2", "GENERAL_3", "GENERAL_4", "GENERAL_5", "EMOTION_SMILE", "EMOTION_SAD", "EMOTION_ANGRY", "EMOTION_SURPRISED", "EMOTION_LAUGH", "MEDIA_MOVIE", "MEDIA_GAME_1", "MEDIA_GAME_2", "MEDIA_MUSIC", "MEDIA_PHOTO", "MEDIA_VIDEO", "RELATIONSHIP_RUNNING_1", "RELATIONSHIP_RUNNING_2", "RELATIONSHIP_FITNESS_1", "RELATIONSHIP_FITNESS_2", "RELATIONSHIP_FITNESS_3", "RELATIONSHIP_FITNESS_4", "RELATIONSHIP_EXERCISE_1", "RELATIONSHIP_FIGURE", "RELATIONSHIP_PARTY_1", "RELATIONSHIP_PARTY_2", "RELATIONSHIP_PARTY_3", "RELATIONSHIP_PARTY_4", "RELATIONSHIP_SUPPORT", "RELATIONSHIP_PROFILE", "RELATIONSHIP_PRIVATE", "CALENDAR_1", "CALENDAR_2", "CALENDAR_3", "MATERIALS_1", "MATERIALS_2", "MATERIALS_3", "MATERIALS_4", "HEALTH_1", "HEALTH_2", "STUDY_1", "FINANCE_1", "FINANCE_2", "FOOD", "SHOPPING", "TRAVEL_FLY", "BEER", "TRAVEL_TRAIN", "TRAVEL_CAR", "DRINK", "VACATION", "CAKE", "CLOTHES", "BAG", "MILESTONE", "GIFT", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum AutoMemoryResolvedIcon extends Enum<AutoMemoryResolvedIcon> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AutoMemoryResolvedIcon[] $VALUES = null;
    public static final AutoMemoryResolvedIcon BAG = null;
    public static final AutoMemoryResolvedIcon BEER = null;
    public static final AutoMemoryResolvedIcon CAKE = null;
    public static final AutoMemoryResolvedIcon CALENDAR_1 = null;
    public static final AutoMemoryResolvedIcon CALENDAR_2 = null;
    public static final AutoMemoryResolvedIcon CALENDAR_3 = null;
    public static final AutoMemoryResolvedIcon CLOTHES = null;
    public static final a Companion = null;
    public static final AutoMemoryResolvedIcon DRINK = null;
    public static final AutoMemoryResolvedIcon EMOTION_ANGRY = null;
    public static final AutoMemoryResolvedIcon EMOTION_LAUGH = null;
    public static final AutoMemoryResolvedIcon EMOTION_SAD = null;
    public static final AutoMemoryResolvedIcon EMOTION_SMILE = null;
    public static final AutoMemoryResolvedIcon EMOTION_SURPRISED = null;
    public static final AutoMemoryResolvedIcon FINANCE_1 = null;
    public static final AutoMemoryResolvedIcon FINANCE_2 = null;
    public static final AutoMemoryResolvedIcon FOOD = null;
    public static final AutoMemoryResolvedIcon GENERAL_1 = null;
    public static final AutoMemoryResolvedIcon GENERAL_2 = null;
    public static final AutoMemoryResolvedIcon GENERAL_3 = null;
    public static final AutoMemoryResolvedIcon GENERAL_4 = null;
    public static final AutoMemoryResolvedIcon GENERAL_5 = null;
    public static final AutoMemoryResolvedIcon GIFT = null;
    public static final AutoMemoryResolvedIcon HEALTH_1 = null;
    public static final AutoMemoryResolvedIcon HEALTH_2 = null;
    public static final AutoMemoryResolvedIcon MATERIALS_1 = null;
    public static final AutoMemoryResolvedIcon MATERIALS_2 = null;
    public static final AutoMemoryResolvedIcon MATERIALS_3 = null;
    public static final AutoMemoryResolvedIcon MATERIALS_4 = null;
    public static final AutoMemoryResolvedIcon MEDIA_GAME_1 = null;
    public static final AutoMemoryResolvedIcon MEDIA_GAME_2 = null;
    public static final AutoMemoryResolvedIcon MEDIA_MOVIE = null;
    public static final AutoMemoryResolvedIcon MEDIA_MUSIC = null;
    public static final AutoMemoryResolvedIcon MEDIA_PHOTO = null;
    public static final AutoMemoryResolvedIcon MEDIA_VIDEO = null;
    public static final AutoMemoryResolvedIcon MILESTONE = null;
    public static final AutoMemoryResolvedIcon RELATIONSHIP_EXERCISE_1 = null;
    public static final AutoMemoryResolvedIcon RELATIONSHIP_FIGURE = null;
    public static final AutoMemoryResolvedIcon RELATIONSHIP_FITNESS_1 = null;
    public static final AutoMemoryResolvedIcon RELATIONSHIP_FITNESS_2 = null;
    public static final AutoMemoryResolvedIcon RELATIONSHIP_FITNESS_3 = null;
    public static final AutoMemoryResolvedIcon RELATIONSHIP_FITNESS_4 = null;
    public static final AutoMemoryResolvedIcon RELATIONSHIP_PARTY_1 = null;
    public static final AutoMemoryResolvedIcon RELATIONSHIP_PARTY_2 = null;
    public static final AutoMemoryResolvedIcon RELATIONSHIP_PARTY_3 = null;
    public static final AutoMemoryResolvedIcon RELATIONSHIP_PARTY_4 = null;
    public static final AutoMemoryResolvedIcon RELATIONSHIP_PRIVATE = null;
    public static final AutoMemoryResolvedIcon RELATIONSHIP_PROFILE = null;
    public static final AutoMemoryResolvedIcon RELATIONSHIP_RUNNING_1 = null;
    public static final AutoMemoryResolvedIcon RELATIONSHIP_RUNNING_2 = null;
    public static final AutoMemoryResolvedIcon RELATIONSHIP_SUPPORT = null;
    public static final AutoMemoryResolvedIcon SHOPPING = null;
    public static final AutoMemoryResolvedIcon STUDY_1 = null;
    public static final AutoMemoryResolvedIcon TRAVEL_CAR = null;
    public static final AutoMemoryResolvedIcon TRAVEL_FLY = null;
    public static final AutoMemoryResolvedIcon TRAVEL_TRAIN = null;
    public static final AutoMemoryResolvedIcon VACATION = null;
    private static final Map<String, AutoMemoryResolvedIcon> iconsByKey = null;
    private final int drawableRes;
    private final String key;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0006R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryResolvedIcon$Companion;", "", "<init>", "()V", "iconsByKey", "", "", "Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryResolvedIcon;", "fromKey", "key", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final AutoMemoryResolvedIcon a(String r3) {
            Map r2 = AutoMemoryResolvedIcon.access$getIconsByKey$cp();
            if (r3 == null) goto L7;
            String r4 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).toString();
            if (r4 == null) goto L7;
            String r5 = r4.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(r5, "toLowerCase(...)");
        L9:
            return (AutoMemoryResolvedIcon) ZeusTransformUtils.preCheckCast(r2.get(r5), AutoMemoryResolvedIcon.class, "com.obric.memorydata.plugin");
        L7:
            r5 = null;
            goto L9
        }
    }

    private static final /* synthetic */ AutoMemoryResolvedIcon[] $values() {
        return new AutoMemoryResolvedIcon[]{GENERAL_1, GENERAL_2, GENERAL_3, GENERAL_4, GENERAL_5, EMOTION_SMILE, EMOTION_SAD, EMOTION_ANGRY, EMOTION_SURPRISED, EMOTION_LAUGH, MEDIA_MOVIE, MEDIA_GAME_1, MEDIA_GAME_2, MEDIA_MUSIC, MEDIA_PHOTO, MEDIA_VIDEO, RELATIONSHIP_RUNNING_1, RELATIONSHIP_RUNNING_2, RELATIONSHIP_FITNESS_1, RELATIONSHIP_FITNESS_2, RELATIONSHIP_FITNESS_3, RELATIONSHIP_FITNESS_4, RELATIONSHIP_EXERCISE_1, RELATIONSHIP_FIGURE, RELATIONSHIP_PARTY_1, RELATIONSHIP_PARTY_2, RELATIONSHIP_PARTY_3, RELATIONSHIP_PARTY_4, RELATIONSHIP_SUPPORT, RELATIONSHIP_PROFILE, RELATIONSHIP_PRIVATE, CALENDAR_1, CALENDAR_2, CALENDAR_3, MATERIALS_1, MATERIALS_2, MATERIALS_3, MATERIALS_4, HEALTH_1, HEALTH_2, STUDY_1, FINANCE_1, FINANCE_2, FOOD, SHOPPING, TRAVEL_FLY, BEER, TRAVEL_TRAIN, TRAVEL_CAR, DRINK, VACATION, CAKE, CLOTHES, BAG, MILESTONE, GIFT};
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        GENERAL_1 = new AutoMemoryResolvedIcon("GENERAL_1", 0, "general_1", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_general_1, "drawable", "ic_auto_memory_task_general_1"));
        GENERAL_2 = new AutoMemoryResolvedIcon("GENERAL_2", 1, "general_2", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_general_2, "drawable", "ic_auto_memory_task_general_2"));
        GENERAL_3 = new AutoMemoryResolvedIcon("GENERAL_3", 2, "general_3", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_general_3, "drawable", "ic_auto_memory_task_general_3"));
        GENERAL_4 = new AutoMemoryResolvedIcon("GENERAL_4", 3, "general_4", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_general_4, "drawable", "ic_auto_memory_task_general_4"));
        GENERAL_5 = new AutoMemoryResolvedIcon("GENERAL_5", 4, "general_5", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_general_5, "drawable", "ic_auto_memory_task_general_5"));
        EMOTION_SMILE = new AutoMemoryResolvedIcon("EMOTION_SMILE", 5, "emotion_smile", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_emotion_smile, "drawable", "ic_auto_memory_task_emotion_smile"));
        EMOTION_SAD = new AutoMemoryResolvedIcon("EMOTION_SAD", 6, "emotion_sad", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_emotion_sad, "drawable", "ic_auto_memory_task_emotion_sad"));
        EMOTION_ANGRY = new AutoMemoryResolvedIcon("EMOTION_ANGRY", 7, "emotion_angry", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_emotion_angry, "drawable", "ic_auto_memory_task_emotion_angry"));
        EMOTION_SURPRISED = new AutoMemoryResolvedIcon("EMOTION_SURPRISED", 8, "emotion_surprised", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_emotion_surprised, "drawable", "ic_auto_memory_task_emotion_surprised"));
        EMOTION_LAUGH = new AutoMemoryResolvedIcon("EMOTION_LAUGH", 9, "emotion_laugh", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_emotion_laugh, "drawable", "ic_auto_memory_task_emotion_laugh"));
        MEDIA_MOVIE = new AutoMemoryResolvedIcon("MEDIA_MOVIE", 10, "media_movie", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_media_movie, "drawable", "ic_auto_memory_task_media_movie"));
        MEDIA_GAME_1 = new AutoMemoryResolvedIcon("MEDIA_GAME_1", 11, "media_game_1", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_media_game_1, "drawable", "ic_auto_memory_task_media_game_1"));
        MEDIA_GAME_2 = new AutoMemoryResolvedIcon("MEDIA_GAME_2", 12, "media_game_2", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_media_game_2, "drawable", "ic_auto_memory_task_media_game_2"));
        MEDIA_MUSIC = new AutoMemoryResolvedIcon("MEDIA_MUSIC", 13, "media_music", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_media_music, "drawable", "ic_auto_memory_task_media_music"));
        MEDIA_PHOTO = new AutoMemoryResolvedIcon("MEDIA_PHOTO", 14, "media_photo", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_media_photo, "drawable", "ic_auto_memory_task_media_photo"));
        MEDIA_VIDEO = new AutoMemoryResolvedIcon("MEDIA_VIDEO", 15, "media_video", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_media_video, "drawable", "ic_auto_memory_task_media_video"));
        RELATIONSHIP_RUNNING_1 = new AutoMemoryResolvedIcon("RELATIONSHIP_RUNNING_1", 16, "relationship_running_1", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_relationship_running_1, "drawable", "ic_auto_memory_task_relationship_running_1"));
        RELATIONSHIP_RUNNING_2 = new AutoMemoryResolvedIcon("RELATIONSHIP_RUNNING_2", 17, "relationship_running_2", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_relationship_running_2, "drawable", "ic_auto_memory_task_relationship_running_2"));
        RELATIONSHIP_FITNESS_1 = new AutoMemoryResolvedIcon("RELATIONSHIP_FITNESS_1", 18, "relationship_fitness_1", ZeusTransformUtils.mapRes(R.drawable.relationship_fitness_1, "drawable", "relationship_fitness_1"));
        RELATIONSHIP_FITNESS_2 = new AutoMemoryResolvedIcon("RELATIONSHIP_FITNESS_2", 19, "relationship_fitness_2", ZeusTransformUtils.mapRes(R.drawable.relationship_fitness_2, "drawable", "relationship_fitness_2"));
        RELATIONSHIP_FITNESS_3 = new AutoMemoryResolvedIcon("RELATIONSHIP_FITNESS_3", 20, "relationship_fitness_3", ZeusTransformUtils.mapRes(R.drawable.relationship_fitness_3, "drawable", "relationship_fitness_3"));
        RELATIONSHIP_FITNESS_4 = new AutoMemoryResolvedIcon("RELATIONSHIP_FITNESS_4", 21, "relationship_fitness_4", ZeusTransformUtils.mapRes(R.drawable.relationship_fitness_4, "drawable", "relationship_fitness_4"));
        RELATIONSHIP_EXERCISE_1 = new AutoMemoryResolvedIcon("RELATIONSHIP_EXERCISE_1", 22, "relationship_exercise_1", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_relationship_exercise_1, "drawable", "ic_auto_memory_task_relationship_exercise_1"));
        RELATIONSHIP_FIGURE = new AutoMemoryResolvedIcon("RELATIONSHIP_FIGURE", 23, "relationship_exercise_2", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_relationship_exercise_2, "drawable", "ic_auto_memory_task_relationship_exercise_2"));
        RELATIONSHIP_PARTY_1 = new AutoMemoryResolvedIcon("RELATIONSHIP_PARTY_1", 24, "relationship_party_1", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_relationship_party_1, "drawable", "ic_auto_memory_task_relationship_party_1"));
        RELATIONSHIP_PARTY_2 = new AutoMemoryResolvedIcon("RELATIONSHIP_PARTY_2", 25, "relationship_party_2", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_relationship_party_2, "drawable", "ic_auto_memory_task_relationship_party_2"));
        RELATIONSHIP_PARTY_3 = new AutoMemoryResolvedIcon("RELATIONSHIP_PARTY_3", 26, "relationship_party_3", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_relationship_party_3, "drawable", "ic_auto_memory_task_relationship_party_3"));
        RELATIONSHIP_PARTY_4 = new AutoMemoryResolvedIcon("RELATIONSHIP_PARTY_4", 27, "relationship_party_4", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_relationship_party_4, "drawable", "ic_auto_memory_task_relationship_party_4"));
        RELATIONSHIP_SUPPORT = new AutoMemoryResolvedIcon("RELATIONSHIP_SUPPORT", 28, "relationship_support", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_relationship_support, "drawable", "ic_auto_memory_task_relationship_support"));
        RELATIONSHIP_PROFILE = new AutoMemoryResolvedIcon("RELATIONSHIP_PROFILE", 29, "relationship_profile", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_relationship_profile, "drawable", "ic_auto_memory_task_relationship_profile"));
        RELATIONSHIP_PRIVATE = new AutoMemoryResolvedIcon("RELATIONSHIP_PRIVATE", 30, "relationship_private", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_relationship_private, "drawable", "ic_auto_memory_task_relationship_private"));
        CALENDAR_1 = new AutoMemoryResolvedIcon("CALENDAR_1", 31, "calendar_1", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_calendar_1, "drawable", "ic_auto_memory_task_calendar_1"));
        CALENDAR_2 = new AutoMemoryResolvedIcon("CALENDAR_2", 32, "calendar_2", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_calendar_2, "drawable", "ic_auto_memory_task_calendar_2"));
        CALENDAR_3 = new AutoMemoryResolvedIcon("CALENDAR_3", 33, "calendar_3", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_calendar_3, "drawable", "ic_auto_memory_task_calendar_3"));
        MATERIALS_1 = new AutoMemoryResolvedIcon("MATERIALS_1", 34, "materials_1", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_materials_1, "drawable", "ic_auto_memory_task_materials_1"));
        MATERIALS_2 = new AutoMemoryResolvedIcon("MATERIALS_2", 35, "materials_2", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_materials_2, "drawable", "ic_auto_memory_task_materials_2"));
        MATERIALS_3 = new AutoMemoryResolvedIcon("MATERIALS_3", 36, "materials_3", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_materials_3, "drawable", "ic_auto_memory_task_materials_3"));
        MATERIALS_4 = new AutoMemoryResolvedIcon("MATERIALS_4", 37, "materials_4", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_materials_4, "drawable", "ic_auto_memory_task_materials_4"));
        HEALTH_1 = new AutoMemoryResolvedIcon("HEALTH_1", 38, "health_1", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_health_1, "drawable", "ic_auto_memory_task_health_1"));
        HEALTH_2 = new AutoMemoryResolvedIcon("HEALTH_2", 39, "health_2", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_health_2, "drawable", "ic_auto_memory_task_health_2"));
        STUDY_1 = new AutoMemoryResolvedIcon("STUDY_1", 40, "study_1", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_study_1, "drawable", "ic_auto_memory_task_study_1"));
        FINANCE_1 = new AutoMemoryResolvedIcon("FINANCE_1", 41, "finance_1", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_finance_1, "drawable", "ic_auto_memory_task_finance_1"));
        FINANCE_2 = new AutoMemoryResolvedIcon("FINANCE_2", 42, "finance_2", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_finance_2, "drawable", "ic_auto_memory_task_finance_2"));
        FOOD = new AutoMemoryResolvedIcon("FOOD", 43, "food", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_life_food, "drawable", "ic_auto_memory_task_life_food"));
        SHOPPING = new AutoMemoryResolvedIcon("SHOPPING", 44, "shopping", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_life_shopping, "drawable", "ic_auto_memory_task_life_shopping"));
        TRAVEL_FLY = new AutoMemoryResolvedIcon("TRAVEL_FLY", 45, "travel_fly", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_life_travel_fly, "drawable", "ic_auto_memory_task_life_travel_fly"));
        BEER = new AutoMemoryResolvedIcon("BEER", 46, "beer", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_life_beer, "drawable", "ic_auto_memory_task_life_beer"));
        TRAVEL_TRAIN = new AutoMemoryResolvedIcon("TRAVEL_TRAIN", 47, "travel_train", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_life_train, "drawable", "ic_auto_memory_task_life_train"));
        TRAVEL_CAR = new AutoMemoryResolvedIcon("TRAVEL_CAR", 48, "travel_car", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_life_car, "drawable", "ic_auto_memory_task_life_car"));
        DRINK = new AutoMemoryResolvedIcon("DRINK", 49, "drink", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_life_drink, "drawable", "ic_auto_memory_task_life_drink"));
        VACATION = new AutoMemoryResolvedIcon("VACATION", 50, "vacation", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_life_vacation, "drawable", "ic_auto_memory_task_life_vacation"));
        CAKE = new AutoMemoryResolvedIcon("CAKE", 51, "cake", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_life_cake, "drawable", "ic_auto_memory_task_life_cake"));
        CLOTHES = new AutoMemoryResolvedIcon("CLOTHES", 52, "clothes", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_life_clothes, "drawable", "ic_auto_memory_task_life_clothes"));
        BAG = new AutoMemoryResolvedIcon("BAG", 53, "bag", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_life_bag, "drawable", "ic_auto_memory_task_life_bag"));
        MILESTONE = new AutoMemoryResolvedIcon("MILESTONE", 54, "milestone", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_life_milestone, "drawable", "ic_auto_memory_task_life_milestone"));
        GIFT = new AutoMemoryResolvedIcon("GIFT", 55, "gift", ZeusTransformUtils.mapRes(R.drawable.ic_auto_memory_task_life_gift, "drawable", "ic_auto_memory_task_life_gift"));
        AutoMemoryResolvedIcon[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        Companion = new a(null);
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(getEntries(), Iterable.class, "com.obric.memorydata.plugin");
        Map<String, AutoMemoryResolvedIcon> r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r1, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        Object r4 = r3.next();
        r2.put(((AutoMemoryResolvedIcon) ZeusTransformUtils.preCheckCast(r4, AutoMemoryResolvedIcon.class, "com.obric.memorydata.plugin")).key, r4);
        goto L4
    L6:
        iconsByKey = r2;
    }

    private AutoMemoryResolvedIcon(String r1, int r2, String r3, int r4) {
        super(r1, r2);
        this.key = r3;
        this.drawableRes = r4;
    }

    public static final /* synthetic */ Map access$getIconsByKey$cp() {
        return iconsByKey;
    }

    public static EnumEntries<AutoMemoryResolvedIcon> getEntries() {
        return $ENTRIES;
    }

    public static AutoMemoryResolvedIcon valueOf(String r2) {
        return (AutoMemoryResolvedIcon) ZeusTransformUtils.preCheckCast(Enum.valueOf(AutoMemoryResolvedIcon.class, r2), AutoMemoryResolvedIcon.class, "com.obric.memorydata.plugin");
    }

    public static AutoMemoryResolvedIcon[] values() {
        return (AutoMemoryResolvedIcon[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AutoMemoryResolvedIcon[].class, "com.obric.memorydata.plugin");
    }

    public final int getDrawableRes() {
        return this.drawableRes;
    }

    public final String getKey() {
        return this.key;
    }
}
