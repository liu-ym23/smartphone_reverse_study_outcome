package com.ss.android.lark.image.impl.avatar;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.keyboard.plugin.tool.face.Conf$StickerSetManagerPosition;
import com.ss.android.lark.utils.UIHelper;
import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class AvatarImageNameManager {
    private static String BIG_SIZE_SUFFIX = "_hd";
    private static String DEFAULT_AVATER_PREFIX = "default-avatar_";
    private static String MID_SIZE_SUFFIX = "_mid";
    private static String SMALL_SIZE_SUFFIX = "_th";
    private LruCache<String, String> mMd5NameCache;
    private List<String> mSpecialEntityId;
    private int[][] mSuffixSizeConfig;

    /* JADX INFO: renamed from: com.ss.android.lark.image.impl.avatar.AvatarImageNameManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class HOLDER {
        private static final AvatarImageNameManager INSTANCE = null;

        static {
            INSTANCE = new AvatarImageNameManager(null);
        }

        public static /* synthetic */ AvatarImageNameManager access$000() {
            return INSTANCE;
        }
    }

    private int getDensityIndex(float r2) {
        if (r2 > 1.0f) goto L7;
        return 0;
    L7:
        if (r2 > 2.0f) goto L10;
        return 1;
    L10:
        return 2;
    }

    private AvatarImageNameManager() {
        Class r2 = Integer.TYPE;
        this.mSuffixSizeConfig = (int[][]) Array.newInstance(r2, new int[]{3, 2});
        this.mMd5NameCache = new LruCache(100);
        ArrayList r1 = new ArrayList();
        this.mSpecialEntityId = r1;
        int[][] r3 = this.mSuffixSizeConfig;
        int[] r4 = r3[0];
        r4[0] = 32;
        r4[1] = 79;
        int[] r5 = r3[1];
        r5[0] = 32;
        r5[1] = 79;
        int[] r0 = r3[2];
        r0[0] = 32;
        r0[1] = 79;
        r1.add(Conf$StickerSetManagerPosition.STICKER_SET_CHAT_PANEL);
        this.mSpecialEntityId.add(Conf$StickerSetManagerPosition.STICKER_SET_SHOP);
    }

    public static final AvatarImageNameManager inst() {
        return HOLDER.access$000();
    }

    public /* synthetic */ AvatarImageNameManager(AnonymousClass1 r1) {
        this();
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_ss_android_lark_image_impl_avatar_AvatarImageNameManager_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    private String generatePrefix(AvatarImage r8) {
        long r0 = r8.getEntityId();
        String r2 = r8.getEntityIdStr();
        String r3 = r8.getKey();
        if (r0 != 0) goto L5;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == false) goto L15;
        return r3;
    L15:
        return getEncryptEntityId(r8.getEntityIdStr());
    L5:
        if (this.mSpecialEntityId.contains(r2) == true) goto L11;
        if (r3 != null) goto L8;
    L10:
        r1 = false;
        goto L12
    L8:
        if (r3.startsWith(DEFAULT_AVATER_PREFIX) == false) goto L10;
        goto L10
    }

    private String getEncryptEntityId(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L7;
        return DEFAULT_AVATER_PREFIX;
    L7:
        if (this.mMd5NameCache.contains(r3) == true) goto L9;
        String r0 = Util.md5BytesToHex(MessageDigest.getInstance("MD5").digest(r3.getBytes()));     // Catch: NoSuchAlgorithmException -> L12
        this.mMd5NameCache.put(r3, r0);     // Catch: NoSuchAlgorithmException -> L12
        return r0;
    L12:
        e = move-exception;
        e.printStackTrace();
        return DEFAULT_AVATER_PREFIX;
    L9:
        return (String) this.mMd5NameCache.get(r3);
    }

    private String generateSuffix(Context r2, AvatarImage r3) {
        float r4 = INVOKEVIRTUAL_com_ss_android_lark_image_impl_avatar_AvatarImageNameManager_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r2.getResources()).density;
        int r5 = UIHelper.px2dp(Math.max(r3.getWidth(), r3.getHeight()));
        int[] r6 = this.mSuffixSizeConfig[getDensityIndex(r4)];
        if (r5 > r6[0]) goto L7;
        return SMALL_SIZE_SUFFIX;
    L7:
        if (r5 > r6[1]) goto L11;
        return MID_SIZE_SUFFIX;
    L11:
        return BIG_SIZE_SUFFIX;
    }

    public String generateFileName(Context r3, AvatarImage r4) {
        return generatePrefix(r4) + generateSuffix(r3, r4);
    }
}
