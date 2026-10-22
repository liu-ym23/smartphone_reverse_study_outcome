package com.bytedance.securityguardkit.wordfilter;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum WordCategory extends Enum<WordCategory> {
    private static final /* synthetic */ WordCategory[] $VALUES = null;
    public static final WordCategory ABUSE = null;
    public static final WordCategory ABUSE_SOFT = null;
    public static final WordCategory CRIMINAL = null;
    public static final WordCategory CRIMINAL_SOFT = null;
    public static final WordCategory DISCRIMINATION = null;
    public static final WordCategory DISCRIMINATION_SOFT = null;
    public static final WordCategory DRUGS = null;
    public static final WordCategory DRUGS_SOFT = null;
    public static final WordCategory LEADER = null;
    public static final WordCategory LEADER_SOFT = null;
    public static final WordCategory PORNOGRAPHY = null;
    public static final WordCategory PORNOGRAPHY_SOFT = null;
    public static final WordCategory REACTIONARY = null;
    public static final WordCategory REACTIONARY_SOFT = null;
    private final String categoryName;

    private static /* synthetic */ WordCategory[] $values() {
        return new WordCategory[]{ABUSE, PORNOGRAPHY, DRUGS, CRIMINAL, REACTIONARY, LEADER, DISCRIMINATION, ABUSE_SOFT, PORNOGRAPHY_SOFT, DRUGS_SOFT, CRIMINAL_SOFT, REACTIONARY_SOFT, LEADER_SOFT, DISCRIMINATION_SOFT};
    }

    static {
        ABUSE = new WordCategory("ABUSE", 0, "abuse");
        PORNOGRAPHY = new WordCategory("PORNOGRAPHY", 1, "pornography");
        DRUGS = new WordCategory("DRUGS", 2, "drugs");
        CRIMINAL = new WordCategory("CRIMINAL", 3, "criminal");
        REACTIONARY = new WordCategory("REACTIONARY", 4, "reactionary");
        LEADER = new WordCategory("LEADER", 5, "leader");
        DISCRIMINATION = new WordCategory("DISCRIMINATION", 6, "discriminate");
        ABUSE_SOFT = new WordCategory("ABUSE_SOFT", 7, "abuse_soft");
        PORNOGRAPHY_SOFT = new WordCategory("PORNOGRAPHY_SOFT", 8, "pornography_soft");
        DRUGS_SOFT = new WordCategory("DRUGS_SOFT", 9, "drugs_soft");
        CRIMINAL_SOFT = new WordCategory("CRIMINAL_SOFT", 10, "criminal_soft");
        REACTIONARY_SOFT = new WordCategory("REACTIONARY_SOFT", 11, "reactionary_soft");
        LEADER_SOFT = new WordCategory("LEADER_SOFT", 12, "leader_soft");
        DISCRIMINATION_SOFT = new WordCategory("DISCRIMINATION_SOFT", 13, "discriminate_soft");
        $VALUES = $values();
    }

    private WordCategory(String r1, int r2, String r3) {
        super(r1, r2);
        this.categoryName = r3;
    }

    public static WordCategory valueOf(String r2) {
        return (WordCategory) ZeusTransformUtils.preCheckCast(Enum.valueOf(WordCategory.class, r2), WordCategory.class, "com.obric.memorydata.plugin");
    }

    public static WordCategory[] values() {
        return (WordCategory[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), WordCategory[].class, "com.obric.memorydata.plugin");
    }

    public String getCategoryName() {
        return this.categoryName;
    }
}
