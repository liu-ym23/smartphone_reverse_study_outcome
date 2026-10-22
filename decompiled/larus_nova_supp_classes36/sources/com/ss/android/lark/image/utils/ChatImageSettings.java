package com.ss.android.lark.image.utils;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\bÇ\u0002\u0018\u00002\u00020\u0001:\nABCDEFGHIJB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\r\u0010\tR!\u0010\u000f\u001a\u00020\u00108FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u000b\u0012\u0004\b\u0011\u0010\u0003\u001a\u0004\b\u0012\u0010\u0013R!\u0010\u0015\u001a\u00020\u00168FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u000b\u0012\u0004\b\u0017\u0010\u0003\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001c\u0010\tR!\u0010\u001e\u001a\u00020\u001f8FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b#\u0010\u000b\u0012\u0004\b \u0010\u0003\u001a\u0004\b!\u0010\"R!\u0010$\u001a\u00020%8FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b)\u0010\u000b\u0012\u0004\b&\u0010\u0003\u001a\u0004\b'\u0010(R!\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u000b\u001a\u0004\b-\u0010.R!\u00100\u001a\b\u0012\u0004\u0012\u00020,0+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u000b\u001a\u0004\b1\u0010.Ru\u00103\u001aV\u0012\u0004\u0012\u000205\u0012 \u0012\u001e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020504j\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u000205`604j*\u0012\u0004\u0012\u000205\u0012 \u0012\u001e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020504j\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u000205`6`68FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b:\u0010\u000b\u0012\u0004\b7\u0010\u0003\u001a\u0004\b8\u00109R!\u0010;\u001a\u00020<8FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b@\u0010\u000b\u0012\u0004\b=\u0010\u0003\u001a\u0004\b>\u0010?¨\u0006K"}, d2 = {"Lcom/ss/android/lark/image/utils/ChatImageSettings;", "", "<init>", "()V", "TAG", "", "chatImageJson", "Lorg/json/JSONObject;", "getChatImageJson", "()Lorg/json/JSONObject;", "chatImageJson$delegate", "Lkotlin/Lazy;", "messageImageLoadSetting", "getMessageImageLoadSetting", "messageImageLoadSetting$delegate", "messageImageCache", "Lcom/ss/android/lark/image/utils/ChatImageSettings$MessageImageCache;", "getMessageImageCache$annotations", "getMessageImageCache", "()Lcom/ss/android/lark/image/utils/ChatImageSettings$MessageImageCache;", "messageImageCache$delegate", "messageImageRemote", "Lcom/ss/android/lark/image/utils/ChatImageSettings$MessageImageRemote;", "getMessageImageRemote$annotations", "getMessageImageRemote", "()Lcom/ss/android/lark/image/utils/ChatImageSettings$MessageImageRemote;", "messageImageRemote$delegate", "largeImageLoadSetting", "getLargeImageLoadSetting", "largeImageLoadSetting$delegate", "largeImageCache", "Lcom/ss/android/lark/image/utils/ChatImageSettings$LargeImageCache;", "getLargeImageCache$annotations", "getLargeImageCache", "()Lcom/ss/android/lark/image/utils/ChatImageSettings$LargeImageCache;", "largeImageCache$delegate", "largeImageRemote", "Lcom/ss/android/lark/image/utils/ChatImageSettings$LargeImageRemote;", "getLargeImageRemote$annotations", "getLargeImageRemote", "()Lcom/ss/android/lark/image/utils/ChatImageSettings$LargeImageRemote;", "largeImageRemote$delegate", "imageLoadDownSampleDefaultConfigs", "", "Lcom/ss/android/lark/image/utils/ChatImageSettings$DownSampleConfig;", "getImageLoadDownSampleDefaultConfigs", "()Ljava/util/List;", "imageLoadDownSampleDefaultConfigs$delegate", "imageLoadDownSampleConfigs", "getImageLoadDownSampleConfigs", "imageLoadDownSampleConfigs$delegate", "imageLoadDownSampleDictionary", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getImageLoadDownSampleDictionary$annotations", "getImageLoadDownSampleDictionary", "()Ljava/util/HashMap;", "imageLoadDownSampleDictionary$delegate", "glideImageCache", "Lcom/ss/android/lark/image/utils/ChatImageSettings$GlideImageCache;", "getGlideImageCache$annotations", "getGlideImageCache", "()Lcom/ss/android/lark/image/utils/ChatImageSettings$GlideImageCache;", "glideImageCache$delegate", "ChatImageSetting", "MessageImageCache", "MessageImageRemote", "MessageImageRemoteTarget", "LargeImageCache", "LargeImageRemote", "LargeImageRemoteTarget", "LargeImageRemoteFirstThumb", "DownSampleConfig", "GlideImageCache", "image_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ChatImageSettings {
    public static final ChatImageSettings INSTANCE = null;
    private static final String TAG = "ChatImageSettings";
    private static final Lazy chatImageJson$delegate = null;
    private static final Lazy glideImageCache$delegate = null;
    private static final Lazy imageLoadDownSampleConfigs$delegate = null;
    private static final Lazy imageLoadDownSampleDefaultConfigs$delegate = null;
    private static final Lazy imageLoadDownSampleDictionary$delegate = null;
    private static final Lazy largeImageCache$delegate = null;
    private static final Lazy largeImageLoadSetting$delegate = null;
    private static final Lazy largeImageRemote$delegate = null;
    private static final Lazy messageImageCache$delegate = null;
    private static final Lazy messageImageLoadSetting$delegate = null;
    private static final Lazy messageImageRemote$delegate = null;

    @AppConfig(key = "chat_image_settings")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/image/utils/ChatImageSettings$ChatImageSetting;", "", "<init>", "()V", "image_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class ChatImageSetting {
        public ChatImageSetting() {
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B5\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tR.\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/image/utils/ChatImageSettings$DownSampleConfig;", "", "fromTypes", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "diskPercentage", "memoryPercentage", "<init>", "(Ljava/util/ArrayList;II)V", "getFromTypes", "()Ljava/util/ArrayList;", "setFromTypes", "(Ljava/util/ArrayList;)V", "getDiskPercentage", "()I", "setDiskPercentage", "(I)V", "getMemoryPercentage", "setMemoryPercentage", "image_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class DownSampleConfig {

        @SerializedName("disk_percentage")
        private int diskPercentage;

        @SerializedName("from_types")
        private ArrayList<Integer> fromTypes;

        @SerializedName("memory_percentage")
        private int memoryPercentage;

        public DownSampleConfig() {
            this(null, 0, 0, 7, null);
        }

        public final int getDiskPercentage() {
            return this.diskPercentage;
        }

        public final ArrayList<Integer> getFromTypes() {
            return this.fromTypes;
        }

        public final int getMemoryPercentage() {
            return this.memoryPercentage;
        }

        public final void setDiskPercentage(int r1) {
            this.diskPercentage = r1;
        }

        public final void setFromTypes(ArrayList<Integer> r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.fromTypes = r2;
        }

        public final void setMemoryPercentage(int r1) {
            this.memoryPercentage = r1;
        }

        public DownSampleConfig(ArrayList<Integer> r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "fromTypes");
            this.fromTypes = r2;
            this.diskPercentage = r3;
            this.memoryPercentage = r4;
        }

        public /* synthetic */ DownSampleConfig(ArrayList r2, int r3, int r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 1) == 0) goto L6;
            r2 = CollectionsKt.arrayListOf(new Integer[]{5});
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = 50;
        L9:
            if ((r5 & 4) == 0) goto L11;
            r4 = 10;
        L11:
            this(r2, r3, r4);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/image/utils/ChatImageSettings$GlideImageCache;", "", "noCacheOnLowDiskSpace", "", "noCacheEncrypt", "noCacheOnDiskCacheException", "noCachePreload", "minDiskSpace", "<init>", "(IIIII)V", "getNoCacheOnLowDiskSpace", "()I", "setNoCacheOnLowDiskSpace", "(I)V", "getNoCacheEncrypt", "setNoCacheEncrypt", "getNoCacheOnDiskCacheException", "setNoCacheOnDiskCacheException", "getNoCachePreload", "setNoCachePreload", "getMinDiskSpace", "setMinDiskSpace", "image_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class GlideImageCache {

        @SerializedName("min_disk_space")
        private int minDiskSpace;

        @SerializedName("no_cache_encrypt")
        private int noCacheEncrypt;

        @SerializedName("no_cache_disk_cache_exception")
        private int noCacheOnDiskCacheException;

        @SerializedName("no_cache_low_disk_space")
        private int noCacheOnLowDiskSpace;

        @SerializedName("no_cache_preload")
        private int noCachePreload;

        public GlideImageCache() {
            this(0, 0, 0, 0, 0, 31, null);
        }

        public final int getMinDiskSpace() {
            return this.minDiskSpace;
        }

        public final int getNoCacheEncrypt() {
            return this.noCacheEncrypt;
        }

        public final int getNoCacheOnDiskCacheException() {
            return this.noCacheOnDiskCacheException;
        }

        public final int getNoCacheOnLowDiskSpace() {
            return this.noCacheOnLowDiskSpace;
        }

        public final int getNoCachePreload() {
            return this.noCachePreload;
        }

        public final void setMinDiskSpace(int r1) {
            this.minDiskSpace = r1;
        }

        public final void setNoCacheEncrypt(int r1) {
            this.noCacheEncrypt = r1;
        }

        public final void setNoCacheOnDiskCacheException(int r1) {
            this.noCacheOnDiskCacheException = r1;
        }

        public final void setNoCacheOnLowDiskSpace(int r1) {
            this.noCacheOnLowDiskSpace = r1;
        }

        public final void setNoCachePreload(int r1) {
            this.noCachePreload = r1;
        }

        public GlideImageCache(int r1, int r2, int r3, int r4, int r5) {
            this.noCacheOnLowDiskSpace = r1;
            this.noCacheEncrypt = r2;
            this.noCacheOnDiskCacheException = r3;
            this.noCachePreload = r4;
            this.minDiskSpace = r5;
        }

        public /* synthetic */ GlideImageCache(int r4, int r5, int r6, int r7, int r8, int r9, DefaultConstructorMarker r10) {
            int r0 = 1;
            if ((r9 & 1) == 0) goto L5;
            int r11 = 1;
        L7:
            if ((r9 & 2) == 0) goto L9;
            int r1 = 1;
        L11:
            if ((r9 & 4) == 0) goto L13;
            int r2 = 1;
        L15:
            if ((r9 & 8) != 0) goto L19;
            r0 = r7;
        L19:
            if ((r9 & 16) == 0) goto L21;
            int r12 = 100;
        L22:
            this(r11, r1, r2, r0, r12);
            return;
        L21:
            r12 = r8;
            goto L22
        L13:
            r2 = r6;
            goto L15
        L9:
            r1 = r5;
            goto L11
        L5:
            r11 = r4;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/image/utils/ChatImageSettings$LargeImageCache;", "", "enable", "", "<init>", "(I)V", "getEnable", "()I", "setEnable", "image_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class LargeImageCache {

        @SerializedName("cache_enable")
        private int enable;

        public LargeImageCache() {
            int r2 = 0;
            this(r2, 1, null);
        }

        public final int getEnable() {
            return this.enable;
        }

        public LargeImageCache(int r1) {
            this.enable = r1;
        }

        public final void setEnable(int r1) {
            this.enable = r1;
        }

        public /* synthetic */ LargeImageCache(int r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = 1;
        L5:
            this(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/image/utils/ChatImageSettings$LargeImageRemote;", "", "target", "Lcom/ss/android/lark/image/utils/ChatImageSettings$LargeImageRemoteTarget;", "firstThumb", "Lcom/ss/android/lark/image/utils/ChatImageSettings$LargeImageRemoteFirstThumb;", "<init>", "(Lcom/ss/android/lark/image/utils/ChatImageSettings$LargeImageRemoteTarget;Lcom/ss/android/lark/image/utils/ChatImageSettings$LargeImageRemoteFirstThumb;)V", "getTarget", "()Lcom/ss/android/lark/image/utils/ChatImageSettings$LargeImageRemoteTarget;", "setTarget", "(Lcom/ss/android/lark/image/utils/ChatImageSettings$LargeImageRemoteTarget;)V", "getFirstThumb", "()Lcom/ss/android/lark/image/utils/ChatImageSettings$LargeImageRemoteFirstThumb;", "setFirstThumb", "(Lcom/ss/android/lark/image/utils/ChatImageSettings$LargeImageRemoteFirstThumb;)V", "image_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class LargeImageRemote {

        @SerializedName("first_load_thumb")
        private LargeImageRemoteFirstThumb firstThumb;

        @SerializedName("target")
        private LargeImageRemoteTarget target;

        /* JADX WARN: Multi-variable type inference failed */
        public LargeImageRemote() {
            Object[] r0 = 0 == true ? 1 : 0;
            this(null, r0, 3, 0 == true ? 1 : 0);
        }

        public final LargeImageRemoteFirstThumb getFirstThumb() {
            return this.firstThumb;
        }

        public final LargeImageRemoteTarget getTarget() {
            return this.target;
        }

        public final void setFirstThumb(LargeImageRemoteFirstThumb r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.firstThumb = r2;
        }

        public final void setTarget(LargeImageRemoteTarget r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.target = r2;
        }

        public LargeImageRemote(LargeImageRemoteTarget r2, LargeImageRemoteFirstThumb r3) {
            Intrinsics.checkNotNullParameter(r2, "target");
            Intrinsics.checkNotNullParameter(r3, "firstThumb");
            this.target = r2;
            this.firstThumb = r3;
        }

        public /* synthetic */ LargeImageRemote(LargeImageRemoteTarget r3, LargeImageRemoteFirstThumb r4, int r5, DefaultConstructorMarker r6) {
            int r0 = 3;
            String r1 = null;
            if ((r5 & 1) == 0) goto L6;
            r3 = new LargeImageRemoteTarget(0, r1, r0, r1);
        L6:
            if ((r5 & 2) == 0) goto L8;
            float r7 = 0.0f;
            r4 = new LargeImageRemoteFirstThumb(r7, r7, r0, r1);
        L8:
            this(r3, r4);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/image/utils/ChatImageSettings$LargeImageRemoteFirstThumb;", "", "autoOriginMax", "", "autoOriginWeakMax", "<init>", "(FF)V", "getAutoOriginMax", "()F", "setAutoOriginMax", "(F)V", "getAutoOriginWeakMax", "setAutoOriginWeakMax", "image_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class LargeImageRemoteFirstThumb {

        @SerializedName("origin_common_min")
        private float autoOriginMax;

        @SerializedName("origin_weak_net_min")
        private float autoOriginWeakMax;

        public LargeImageRemoteFirstThumb() {
            float r2 = 0.0f;
            this(r2, r2, 3, null);
        }

        public final float getAutoOriginMax() {
            return this.autoOriginMax;
        }

        public final float getAutoOriginWeakMax() {
            return this.autoOriginWeakMax;
        }

        public final void setAutoOriginMax(float r1) {
            this.autoOriginMax = r1;
        }

        public final void setAutoOriginWeakMax(float r1) {
            this.autoOriginWeakMax = r1;
        }

        public LargeImageRemoteFirstThumb(float r1, float r2) {
            this.autoOriginMax = r1;
            this.autoOriginWeakMax = r2;
        }

        public /* synthetic */ LargeImageRemoteFirstThumb(float r1, float r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = 4.5f;
        L6:
            if ((r3 & 2) == 0) goto L8;
            r2 = 1.5f;
        L8:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/image/utils/ChatImageSettings$LargeImageRemoteTarget;", "", "autoOriginMax", "", "defaultTarget", "", "<init>", "(ILjava/lang/String;)V", "getAutoOriginMax", "()I", "setAutoOriginMax", "(I)V", "getDefaultTarget", "()Ljava/lang/String;", "setDefaultTarget", "(Ljava/lang/String;)V", "image_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class LargeImageRemoteTarget {

        @SerializedName("remote_auto_origin_max")
        private int autoOriginMax;

        @SerializedName("remote_default_target")
        private String defaultTarget;

        public LargeImageRemoteTarget() {
            String r0 = null;
            int r2 = 0;
            this(r2, r0, 3, r0);
        }

        public final int getAutoOriginMax() {
            return this.autoOriginMax;
        }

        public final String getDefaultTarget() {
            return this.defaultTarget;
        }

        public final void setAutoOriginMax(int r1) {
            this.autoOriginMax = r1;
        }

        public final void setDefaultTarget(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.defaultTarget = r2;
        }

        public LargeImageRemoteTarget(int r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "defaultTarget");
            this.autoOriginMax = r2;
            this.defaultTarget = r3;
        }

        public /* synthetic */ LargeImageRemoteTarget(int r1, String r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = 500;
        L6:
            if ((r3 & 2) == 0) goto L8;
            r2 = "middle";
        L8:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/image/utils/ChatImageSettings$MessageImageCache;", "", "enable", "", "originMax", "<init>", "(II)V", "getEnable", "()I", "setEnable", "(I)V", "getOriginMax", "setOriginMax", "image_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class MessageImageCache {

        @SerializedName("cache_enable")
        private int enable;

        @SerializedName("cache_load_origin_max")
        private int originMax;

        public MessageImageCache() {
            int r2 = 0;
            this(r2, r2, 3, null);
        }

        public final int getEnable() {
            return this.enable;
        }

        public final int getOriginMax() {
            return this.originMax;
        }

        public final void setEnable(int r1) {
            this.enable = r1;
        }

        public final void setOriginMax(int r1) {
            this.originMax = r1;
        }

        public MessageImageCache(int r1, int r2) {
            this.enable = r1;
            this.originMax = r2;
        }

        public /* synthetic */ MessageImageCache(int r1, int r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = 1;
        L6:
            if ((r3 & 2) == 0) goto L8;
            r2 = 25;
        L8:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/image/utils/ChatImageSettings$MessageImageRemote;", "", "target", "Lcom/ss/android/lark/image/utils/ChatImageSettings$MessageImageRemoteTarget;", "<init>", "(Lcom/ss/android/lark/image/utils/ChatImageSettings$MessageImageRemoteTarget;)V", "getTarget", "()Lcom/ss/android/lark/image/utils/ChatImageSettings$MessageImageRemoteTarget;", "setTarget", "image_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class MessageImageRemote {

        @SerializedName("target")
        private MessageImageRemoteTarget target;

        public MessageImageRemote() {
            MessageImageRemoteTarget r0 = null;
            this(r0, 1, r0);
        }

        public final MessageImageRemoteTarget getTarget() {
            return this.target;
        }

        public MessageImageRemote(MessageImageRemoteTarget r2) {
            Intrinsics.checkNotNullParameter(r2, "target");
            this.target = r2;
        }

        public final void setTarget(MessageImageRemoteTarget r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.target = r2;
        }

        public /* synthetic */ MessageImageRemote(MessageImageRemoteTarget r2, int r3, DefaultConstructorMarker r4) {
            int r5 = 1;
            if ((r3 & 1) == 0) goto L5;
            r2 = new MessageImageRemoteTarget(0, r5, null);
        L5:
            this(r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/image/utils/ChatImageSettings$MessageImageRemoteTarget;", "", "thumbWidthMax", "", "<init>", "(I)V", "getThumbWidthMax", "()I", "setThumbWidthMax", "image_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class MessageImageRemoteTarget {

        @SerializedName("remote_auto_thumb_screen_width_max")
        private int thumbWidthMax;

        public MessageImageRemoteTarget() {
            int r2 = 0;
            this(r2, 1, null);
        }

        public final int getThumbWidthMax() {
            return this.thumbWidthMax;
        }

        public MessageImageRemoteTarget(int r1) {
            this.thumbWidthMax = r1;
        }

        public final void setThumbWidthMax(int r1) {
            this.thumbWidthMax = r1;
        }

        public /* synthetic */ MessageImageRemoteTarget(int r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = 830;
        L5:
            this(r1);
        }
    }

    private ChatImageSettings() {
    }

    @JvmStatic
    public static /* synthetic */ void getGlideImageCache$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getImageLoadDownSampleDictionary$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getLargeImageCache$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getLargeImageRemote$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getMessageImageCache$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getMessageImageRemote$annotations() {
    }

    static {
        INSTANCE = new ChatImageSettings();
        chatImageJson$delegate = LazyKt.lazy(ChatImageSettings$chatImageJson$2.INSTANCE);
        messageImageLoadSetting$delegate = LazyKt.lazy(ChatImageSettings$messageImageLoadSetting$2.INSTANCE);
        messageImageCache$delegate = LazyKt.lazy(ChatImageSettings$messageImageCache$2.INSTANCE);
        messageImageRemote$delegate = LazyKt.lazy(ChatImageSettings$messageImageRemote$2.INSTANCE);
        largeImageLoadSetting$delegate = LazyKt.lazy(ChatImageSettings$largeImageLoadSetting$2.INSTANCE);
        largeImageCache$delegate = LazyKt.lazy(ChatImageSettings$largeImageCache$2.INSTANCE);
        largeImageRemote$delegate = LazyKt.lazy(ChatImageSettings$largeImageRemote$2.INSTANCE);
        imageLoadDownSampleDefaultConfigs$delegate = LazyKt.lazy(ChatImageSettings$imageLoadDownSampleDefaultConfigs$2.INSTANCE);
        imageLoadDownSampleConfigs$delegate = LazyKt.lazy(ChatImageSettings$imageLoadDownSampleConfigs$2.INSTANCE);
        imageLoadDownSampleDictionary$delegate = LazyKt.lazy(ChatImageSettings$imageLoadDownSampleDictionary$2.INSTANCE);
        glideImageCache$delegate = LazyKt.lazy(ChatImageSettings$glideImageCache$2.INSTANCE);
    }

    private final JSONObject getChatImageJson() {
        return (JSONObject) chatImageJson$delegate.getValue();
    }

    public static final GlideImageCache getGlideImageCache() {
        return (GlideImageCache) glideImageCache$delegate.getValue();
    }

    private final List<DownSampleConfig> getImageLoadDownSampleConfigs() {
        return (List) imageLoadDownSampleConfigs$delegate.getValue();
    }

    private final List<DownSampleConfig> getImageLoadDownSampleDefaultConfigs() {
        return (List) imageLoadDownSampleDefaultConfigs$delegate.getValue();
    }

    public static final HashMap<Integer, HashMap<Integer, Integer>> getImageLoadDownSampleDictionary() {
        return (HashMap) imageLoadDownSampleDictionary$delegate.getValue();
    }

    public static final LargeImageCache getLargeImageCache() {
        return (LargeImageCache) largeImageCache$delegate.getValue();
    }

    private final JSONObject getLargeImageLoadSetting() {
        return (JSONObject) largeImageLoadSetting$delegate.getValue();
    }

    public static final LargeImageRemote getLargeImageRemote() {
        return (LargeImageRemote) largeImageRemote$delegate.getValue();
    }

    public static final MessageImageCache getMessageImageCache() {
        return (MessageImageCache) messageImageCache$delegate.getValue();
    }

    private final JSONObject getMessageImageLoadSetting() {
        return (JSONObject) messageImageLoadSetting$delegate.getValue();
    }

    public static final MessageImageRemote getMessageImageRemote() {
        return (MessageImageRemote) messageImageRemote$delegate.getValue();
    }

    public static final /* synthetic */ JSONObject access$getChatImageJson(ChatImageSettings r0) {
        return r0.getChatImageJson();
    }

    public static final /* synthetic */ List access$getImageLoadDownSampleConfigs(ChatImageSettings r0) {
        return r0.getImageLoadDownSampleConfigs();
    }

    public static final /* synthetic */ List access$getImageLoadDownSampleDefaultConfigs(ChatImageSettings r0) {
        return r0.getImageLoadDownSampleDefaultConfigs();
    }

    public static final /* synthetic */ JSONObject access$getLargeImageLoadSetting(ChatImageSettings r0) {
        return r0.getLargeImageLoadSetting();
    }

    public static final /* synthetic */ JSONObject access$getMessageImageLoadSetting(ChatImageSettings r0) {
        return r0.getMessageImageLoadSetting();
    }
}
