package com.obric.sva.sdk.data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface ISmModel {
    public static final String SUFFIX_DEFAULT_SOUND_MODEL = ".uim";
    public static final String SUFFIX_LANGUAGE_MODEL = ".lm";
    public static final String SUFFIX_MERGED_LANGUAGE_MODEL = ".lat";
    public static final String SUFFIX_TRAINED_SOUND_MODEL = ".udm";
    public static final int SVA_SOUND_MODEL_TYPE = 1;
    public static final int UNKNOWN_SOUND_MODEL_TYPE = 0;
    public static final int VERSION_0100 = 256;
    public static final int VERSION_0200 = 512;
    public static final int VERSION_0300 = 768;
    public static final int VERSION_0400 = 1024;
    public static final int VERSION_0500 = 1280;
    public static final int VERSION_0600 = 1536;
    public static final int VERSION_0700 = 1792;
    public static final int VERSION_UNKNOWN = 0;

    public static final enum ModelVersion extends Enum<ModelVersion> {
        private static final /* synthetic */ ModelVersion[] $VALUES = null;
        public static final ModelVersion VERSION_1_0 = null;
        public static final ModelVersion VERSION_2_0 = null;
        public static final ModelVersion VERSION_3_0 = null;
        public static final ModelVersion VERSION_4_0 = null;
        public static final ModelVersion VERSION_5_0 = null;
        public static final ModelVersion VERSION_6_0 = null;
        public static final ModelVersion VERSION_7_0 = null;
        public static final ModelVersion VERSION_UNKNOWN = null;
        private String lable;
        private int number;

        static {
            ModelVersion r0 = new ModelVersion("VERSION_UNKNOWN", 0, "Unknown", 0);
            VERSION_UNKNOWN = r0;
            ModelVersion r1 = new ModelVersion("VERSION_1_0", 1, "1.0", 1);
            VERSION_1_0 = r1;
            ModelVersion r2 = new ModelVersion("VERSION_2_0", 2, "2.0", 2);
            VERSION_2_0 = r2;
            ModelVersion r4 = new ModelVersion("VERSION_3_0", 3, "3.0", 3);
            VERSION_3_0 = r4;
            ModelVersion r6 = new ModelVersion("VERSION_4_0", 4, "4.0", 4);
            VERSION_4_0 = r6;
            ModelVersion r8 = new ModelVersion("VERSION_5_0", 5, "5.0", 5);
            VERSION_5_0 = r8;
            ModelVersion r10 = new ModelVersion("VERSION_6_0", 6, "6.0", 6);
            VERSION_6_0 = r10;
            ModelVersion r12 = new ModelVersion("VERSION_7_0", 7, "7.0", 7);
            VERSION_7_0 = r12;
            $VALUES = new ModelVersion[]{r0, r1, r2, r4, r6, r8, r10, r12};
        }

        public static ModelVersion[] values() {
            return (ModelVersion[]) $VALUES.clone();
        }

        public String getLable() {
            return this.lable;
        }

        public int getVersionNumber() {
            return this.number;
        }

        public static ModelVersion valueOf(String r1) {
            return (ModelVersion) a.a(ModelVersion.class, r1);
        }

        private ModelVersion(String r1, int r2, String r3, int r4) {
            super(r1, r2);
            this.lable = r3;
            this.number = r4;
        }
    }

    void addKeyphrase(String r1, int r2);

    void addKeyphraseAndUser(String r1, int r2, String r3, int r4);

    boolean canAddUser();

    ArrayList<IUserModel> getAllUsers();

    IKeyphraseModel getKeyphraseModel(String r1);

    String getKeyphraseNameById(int r1);

    String getSoundModelFullFileName();

    List<IKeyphraseModel> getSoundModelKeyphraseList();

    String getSoundModelPrettyFileName();

    String getSoundModelPrettyKeyphrase();

    String getSoundModelSuffix();

    int getSoundModelType();

    UUID getSoundModelUUID();

    ModelVersion getSoundModelVersion();

    boolean isSupportExtendedOpaqueData();

    boolean isUdkSm();

    boolean isUserExistForKeyphrase(String r1, String r2);

    boolean isUserTrainedSoundModel();

    void removeKeyphrase(String r1);

    void removeUser(String r1, String r2);

    void setSoundModelFullFileName(String r1);

    void setSoundModelPrettyFileName(String r1);

    void setSoundModelPrettyKeyphrase(String r1);

    void setSoundModelSuffix(String r1);

    void setSoundModelType(int r1);

    void setSoundModelVersion(ModelVersion r1);
}
