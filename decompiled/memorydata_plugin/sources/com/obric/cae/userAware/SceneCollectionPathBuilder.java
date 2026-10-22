package com.obric.cae.userAware;

import java.io.File;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class SceneCollectionPathBuilder {
    private static final int MAX_PATH_SEGMENT_LENGTH = 80;
    public static final String SCENE_COLLECTION_DATA_DIR = "airport_data";

    public static final class PathLayout {
        public final String category;
        public final String descriptionFileStem;
        public final String location;
        public final String sceneName;
        public final File sessionDir;
        public final String sessionFolderName;

        public PathLayout(String r1, String r2, String r3, String r4, String r5, File r6) {
            this.sceneName = r1;
            this.category = r2;
            this.location = r3;
            this.sessionFolderName = r4;
            this.descriptionFileStem = r5;
            this.sessionDir = r6;
        }
    }

    private SceneCollectionPathBuilder() {
    }

    public static String buildCollectionDesc(String r0, String r1, String r2, String r3) {
        String r4 = buildDescriptionFileStem(r0, r1, r2);
        String r5 = sanitizeSegment(r3);
        if (r5.isEmpty() == false) goto L6;
        return r4;
    L6:
        return r4 + "_" + r5;
    }

    public static String buildDescriptionFileStem(String r2, String r3, String r4) {
        return joinNonEmpty(new String[]{sanitizeSegment(r2), sanitizeSegment(r3), sanitizeSegment(r4)});
    }

    public static PathLayout buildLayout(File r7, String r8, String r9, String r10, long r11) {
        String r1 = sanitizeSegment(r8);
        String r2 = sanitizeSegment(r9);
        String r3 = sanitizeSegment(r10);
        if (r7 != null) goto L5;
        return null;
    L5:
        if (r1.isEmpty() == false) goto L7;
        return null;
    L7:
        if (r2.isEmpty() == false) goto L9;
        return null;
    L9:
        if (r3.isEmpty() == true) goto L17;
        Calendar r12 = Calendar.getInstance();
        r12.setTimeInMillis(r11);
        String r4 = String.format(Locale.CHINA, "%ty%tm%td_%tH%tM%tS", new Object[]{r12, r12, r12, r12, r12, r12});
        return new PathLayout(r1, r2, r3, r4, buildDescriptionFileStem(r1, r2, r3), new File(new File(new File(new File(new File(r7, SCENE_COLLECTION_DATA_DIR), r1), r2), r3), r4));
    L17:
        return null;
    }

    private static String joinNonEmpty(String... r5) {
        StringBuilder r0 = new StringBuilder();
        int r1 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L15;
        String r3 = r5[r2];
        if (r3 == null) goto L13;
        if (r3.isEmpty() == true) goto L13;
        if (r0.length() <= 0) goto L12;
        r0.append('_');
    L12:
        r0.append(r3);
    L13:
        r2 = r2 + 1;
        goto L3
    L15:
        return r0.toString();
    }

    public static String sanitizeSegment(String r3) {
        if (r3 != null) goto L5;
        return "";
    L5:
        String r4 = r3.trim().replaceAll("[\\\\/:*?\"<>|]", "_");
        if (r4.isEmpty() == true) goto L11;
        if (r4.replace(".", "").isEmpty() == false) goto L11;
        return "_";
    L11:
        if (r4.length() > 80) goto L13;
        return r4;
    L13:
        return r4.substring(0, 80);
    }
}
