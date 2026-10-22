package com.ss.android.lark.newemoji.impl;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.DataSource;
import com.ss.android.lark.image.api.DiskCacheStrategy;
import com.ss.android.lark.image.api.SimpleTarget;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.newemoji.loader.EmojiImageResource;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.y0;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import qsb.h;
import rkb.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@UserScope
public final class EmojiMapManager2 extends c0c.c implements rsb.a {
    public final ConcurrentHashMap<String, qsb.a> b;
    public final ConcurrentHashMap<String, qsb.a> c;
    public final ConcurrentHashMap<String, String> d;
    public final ExecutorService e;
    public final ConcurrentHashMap<String, CopyOnWriteArrayList<WeakReference<IGetDataCallback<Boolean>>>> f;
    public final ConcurrentHashMap<String, CopyOnWriteArrayList<WeakReference<IGetDataCallback<Boolean>>>> g;
    public final int h;
    public int i;
    public final Lazy j;
    public rsb.a.InterfaceC0324a k;

    public static final class a {
    }

    public static final class b implements g<Object, Object> {
        public final /* synthetic */ long a;
        public final /* synthetic */ String b;

        public b(long r1, String r3) {
            this.a = r1;
            this.b = r3;
        }

        @Override // rkb.g
        public final boolean onLoadFailed(Exception r9, Object r10, Target<Object> r11, boolean r12) {
            long r5 = SystemClock.elapsedRealtime() - this.a;
            int r13 = qsb.c.a;
            String r3 = this.b;
            if (r9 == null) goto L5;
            String r14 = r9.getMessage();
        L6:
            String r4 = r14;
            Intrinsics.checkNotNullParameter(r3, "imageKey");
            CoreThreadPool.getDefault().getCachedThreadPool().execute(new h(r3, r4, r5, -1));
            return false;
        L5:
            r14 = null;
            goto L6
        }

        @Override // rkb.g
        public final boolean onResourceReady(Object r7, Object r8, Target<Object> r9, DataSource r10, boolean r11) {
            long r3 = SystemClock.elapsedRealtime() - this.a;
            int r12 = qsb.c.a;
            String r1 = this.b;
            Intrinsics.checkNotNullParameter(r1, "imageKey");
            CoreThreadPool.getDefault().getCachedThreadPool().execute(new h(r1, null, r3, 0));
            return false;
        }
    }

    public static final class c extends SimpleTarget<Bitmap> {
        public final /* synthetic */ qsb.a a;
        public final /* synthetic */ String b;
        public final /* synthetic */ EmojiMapManager2 c;

        @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
        public final void onLoadFailed(Drawable r5) {
            super.onLoadFailed(r5);
            Log.i("EmojiMapManager2", "loadBitmapFromNet failed, emojiKey: " + this.a.a + ", imageKey: " + this.b);
            EmojiMapManager2 r6 = this.c;
            r6.e.execute(new com.ss.android.lark.newemoji.impl.b(r6, this.a.a, false));
        }

        @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
        public final void onResourceReady(Object r5) {
            Bitmap r6 = (Bitmap) r5;
            StringBuilder r1 = new StringBuilder("loadBitmapFromNet success, emojiKey: ");
            r1.append(this.a.a);
            r1.append(", imageKey: ");
            r1.append(this.b);
            r1.append(", resource valid: ");
            if (r6 == null) goto L5;
            boolean r3 = true;
        L6:
            r1.append(r3);
            Log.i("EmojiMapManager2", r1.toString());
            if (r6 == null) goto L16;
            EmojiMapManager2 r0 = this.c;
            qsb.a r2 = this.a;
            monitor-enter(this);
            r2.e = r6;     // Catch: Throwable -> L13
            Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L13
            monitor-exit(this);
            String r8 = r2.a;
            r0.e.execute(new com.ss.android.lark.newemoji.impl.b(r0, r8, true));
            return;
        L13:
            th = move-exception;
            throw th;
        L16:
            return;
        L5:
            r3 = false;
            goto L6
        }

        public c(qsb.a r1, String r2, EmojiMapManager2 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
    }

    @Override // rsb.a
    public final int U9() {
        monitor-enter(this);
        int r0 = this.i;     // Catch: Throwable -> L6
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // rsb.a
    public final void f3() {
        Log.i("EmojiMapManager2", "resetMap");
        monitor-enter(this);
        this.d.clear();     // Catch: Throwable -> L8
        this.b.clear();     // Catch: Throwable -> L8
        this.c.clear();     // Catch: Throwable -> L8
        this.f.clear();     // Catch: Throwable -> L8
        this.g.clear();     // Catch: Throwable -> L8
        this.i = this.h;     // Catch: Throwable -> L8
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(this);
        u();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void u() {
        n(this, 2131888639, "Lark_Emoji_Smile_0", "SMILE", "emoji_smile.png", 2131235195, false, "微笑", null, 128);
        n(this, 2131888530, "Lark_Emoji_Drool_0", "DROOL", "emoji_drool.png", 2131235035, false, "爱慕", null, 128);
        n(this, 2131888624, "Lark_Emoji_Scowl_0", "SCOWL", "emoji_scowl.png", 2131235173, false, "惊呆", null, 128);
        n(this, 2131888579, "Lark_Emoji_haughty_0", "HAUGHTY", "emoji_irritated_v2.png", 2131235106, false, "酷拽", null, 128);
        n(this, 2131888600, "Lark_Emoji_NosePick_0", "NOSEPICK", "emoji_nosepick.png", 2131235141, false, "抠鼻", null, 128);
        n(this, 2131888645, "Lark_Emoji_Sob_0", "SOB", "emoji_sob.png", 2131235200, false, "流泪", null, 128);
        n(this, 2131888490, "Lark_Emoji_Angry_0", "ANGRY", "emoji_angry.png", 2131234978, false, "发怒", null, 128);
        n(this, 2131888566, "Lark_Emoji_Grin_0", "BLUSH", "emoji_grin.png", 2131235088, false, "呲牙", null, 128);
        n(this, 2131888636, "Lark_Emoji_Sleep_0", "SLEEP", "emoji_sleep.png", 2131235191, false, "鼾睡", null, 128);
        n(this, 2131888630, "Lark_Emoji_Shy_0", "SHY", "emoji_shy.png", 2131235184, false, "害羞", null, 128);
        n(this, 2131888682, "Lark_Emoji_Wink_0", "WINK", "emoji_wink.png", 2131235253, false, "可爱", null, 128);
        n(this, 2131888527, "Lark_Emoji_Dizzy_0", "DIZZY", "emoji_dizzy.png", 2131235031, false, "晕", null, 128);
        n(this, 2131888668, "Lark_Emoji_Toasted_0", "TOASTED", "emoji_toasted.png", 2131235238, false, "衰", null, 128);
        n(this, 2131888633, "Lark_Emoji_Silent_0", "SILENT", "emoji_silent.png", 2131235187, false, "闭嘴", null, 128);
        n(this, 2131888638, "Lark_Emoji_Smart_0", "SMART", "emoji_smart.png", 2131235194, false, "机智", null, 128);
        n(this, 2131888492, "Lark_Emoji_Attention_0", "ATTENTION", "emoji_attention.png", 2131234985, true, "来看我", null, 128);
        n(this, 2131888683, "Lark_Emoji_Witty_0", "WITTY", "emoji_witty.png", 2131235254, false, "灵光一闪", null, 128);
        n(this, 2131888689, "Lark_Emoji_Yeah_0", "YEAH", "emoji_yeah.png", 2131235260, false, "耶", null, 128);
        n(this, 2131888542, "Lark_Emoji_Facepalm_0", "FACEPALM", "emoji_facepalm.png", 2131235047, false, "捂脸", null, 128);
        n(this, 2131888635, "Lark_Emoji_Slap_0", "SLAP", "emoji_slap.png", 2131235190, false, "打脸", null, 128);
        n(this, 2131888584, "Lark_Emoji_Laugh_0", "LAUGH", "emoji_laugh.png", 2131235110, false, "大笑", null, 128);
        n(this, 2131888688, "Lark_Emoji_Yawn_0", "YAWN", "emoji_yawn.png", 2131235259, false, "哈欠", null, 128);
        n(this, 2131888627, "Lark_Emoji_Shocked_0", "SHOCKED", "emoji_shocked.png", 2131235181, false, "震惊", null, 128);
        n(this, 2131888590, "Lark_Emoji_Love_0", "LOVE", "emoji_love.png", 2131235121, false, "送心", null, 128);
        n(this, 2131888531, "Lark_Emoji_Drowsy_0", "DROWSY", "emoji_drowsy.png", 2131235036, false, "困", null, 128);
        n(this, 2131888680, "Lark_Emoji_What_0", "WHAT", "emoji_what.png", 2131235251, false, "what", null, 128);
        n(this, 2131888522, "Lark_Emoji_Cry_0", "CRY", "emoji_cry.png", 2131235023, false, "泣不成声", null, 128);
        n(this, 2131888514, "Lark_Emoji_Clap_0", "CLAP", "emoji_clap.png", 2131235009, false, "小鼓掌", null, 128);
        n(this, 2131888628, "Lark_Emoji_ShowOff_0", "SHOWOFF", "emoji_showoff.png", 2131235182, false, "酷", null, 128);
        n(this, 2131888513, "Lark_Emoji_Chuckle_0", "CHUCKLE", "emoji_chuckle.png", 2131235008, false, "偷笑", null, 128);
        n(this, 2131888609, "Lark_Emoji_Petrified_0", "PETRIFIED", "emoji_petrified.png", 2131235152, false, "石化", null, 128);
        n(this, 2131888665, "Lark_Emoji_Thinking_0", "THINKING", "emoji_thinking.png", 2131235225, false, "思考", null, 128);
        n(this, 2131888648, "Lark_Emoji_SpitBlood_0", "SPITBLOOD", "emoji_spitblood.png", 2131235204, false, "吐血", null, 128);
        n(this, 2131888681, "Lark_Emoji_Whimper_0", "WHIMPER", "emoji_whimper.png", 2131235252, false, "可怜", null, 128);
        n(this, 2131888626, "Lark_Emoji_Shhh_0", "SHHH", "emoji_shhh.png", 2131235180, false, "嘘", null, 128);
        n(this, 2131888642, "Lark_Emoji_Smug_0", "SMUG", "emoji_smug.png", 2131235198, false, "撇嘴", null, 128);
        n(this, 2131888540, "Lark_Emoji_Errr_0", "ERROR", "emoji_errr.png", 2131235045, false, "黑线", null, 128);
        n(this, 2131888587, "Lark_Emoji_Lol_0", "LOL", "emoji_lol.png", 2131235118, false, "笑哭", null, 128);
        n(this, 2131888631, "Lark_Emoji_Sick_0", "SICK", "emoji_sick.png", 2131235185, false, "雾霾", null, 128);
        n(this, 2131888640, "Lark_Emoji_Smirk_0", "SMIRK", "emoji_smirk.png", 2131235196, false, "奸笑", null, 128);
        n(this, 2131888614, "Lark_Emoji_Proud_0", "PROUD", "emoji_proud.png", 2131235158, false, "得意", null, 128);
        n(this, 2131888670, "Lark_Emoji_Trick_0", "TRICK", "emoji_trick.png", 2131235240, false, "憨笑", null, 128);
        n(this, 2131888520, "Lark_Emoji_Crazy_0", "CRAZY", "emoji_crazy.png", 2131235021, false, "抓狂", null, 128);
        n(this, 2131888659, "Lark_Emoji_Tears_0", "TEARS", "emoji_tears.png", 2131235214, false, "泪奔", null, 128);
        n(this, 2131888582, "Lark_Emoji_Kiss_0", "KISS", "emoji_kiss.png", 2131235109, false, "吻", null, 128);
        n(this, 2131888661, "Lark_Emoji_Terror_0", "TERROR", "emoji_terror.png", 2131235216, false, "恐惧", null, 128);
        n(this, 2131888580, "Lark_Emoji_Joyful_0", "JOYFUL", "emoji_joyful.png", 2131235107, false, "笑", null, 128);
        n(this, 2131888504, "Lark_Emoji_Blubber_0", "BLUBBER", "emoji_blubber.png", 2131234999, false, "快哭了", null, 128);
        n(this, 2131888577, "Lark_Emoji_Husky_0", "HUSKY", "emoji_husky.png", 2131235103, false, "翻白眼", null, 128);
        n(this, 2131888549, "Lark_Emoji_FollowMe_0", "FOLLOWME", "emoji_followme.png", 2131235070, true, "互粉", null, 128);
        n(this, 2131888667, "MediumLightThumbsup", "MediumLightThumbsup", "emoji_mediumlightthumbsup_v2.png", 2131235237, false, "", null, 128);
        n(this, 2131888667, "LightThumbsup", "LightThumbsup", "emoji_lightthumbsup_v2.png", 2131235234, false, "", null, 128);
        m(2131888667, "Lark_Emoji_Thumbsup_0", "THUMBSUP", "emoji_thumbsup_v2.png", 2131235232, false, "赞", new String[]{"MediumLightThumbsup", "LightThumbsup", "THUMBSUP", "MediumThumbsup", "MediumDarkThumbsup", "DarkThumbsup"});
        n(this, 2131888667, "MediumThumbsup", "MediumThumbsup", "emoji_mediumthumbsup_v2.png", 2131235235, false, "", null, 128);
        n(this, 2131888667, "MediumDarkThumbsup", "MediumDarkThumbsup", "emoji_mediumdarkthumbsup_v2.png", 2131235236, false, "", null, 128);
        n(this, 2131888667, "DarkThumbsup", "DarkThumbsup", "emoji_darkthumbsup_v2.png", 2131235233, false, "", null, 128);
        n(this, 2131888491, "MediumLightApplaud", "MediumLightApplaud", "emoji_mediumlightapplaud_v2.png", 2131234984, false, "", null, 128);
        n(this, 2131888491, "LightApplaud", "LightApplaud", "emoji_lightapplaud_v2.png", 2131234981, false, "", null, 128);
        m(2131888491, "Lark_Emoji_Applaud_0", "APPLAUSE", "emoji_applaud_v2.png", 2131234979, false, "鼓掌", new String[]{"MediumLightApplaud", "LightApplaud", "APPLAUSE", "MediumApplaud", "MediumDarkApplaud", "DarkApplaud"});
        n(this, 2131888491, "MediumApplaud", "MediumApplaud", "emoji_mediumapplaud_v2.png", 2131234982, false, "", null, 128);
        n(this, 2131888491, "MediumDarkApplaud", "MediumDarkApplaud", "emoji_mediumdarkapplaud_v2.png", 2131234983, false, "", null, 128);
        n(this, 2131888491, "DarkApplaud", "DarkApplaud", "emoji_darkapplaud_v2.png", 2131234980, false, "", null, 128);
        n(this, 2131888662, "MediumLightThanks", "MediumLightThanks", "emoji_mediumlightthanks_v2.png", 2131235222, false, "", null, 128);
        n(this, 2131888662, "LightThanks", "LightThanks", "emoji_lightthanks_v2.png", 2131235219, false, "", null, 128);
        m(2131888662, "Lark_Emoji_Thanks_0", "THANKS", "emoji_thanks_v2.png", 2131235217, false, "谢谢", new String[]{"MediumLightThanks", "LightThanks", "THANKS", "MediumThanks", "MediumDarkThanks", "DarkThanks"});
        n(this, 2131888662, "MediumThanks", "MediumThanks", "emoji_mediumthanks_v2.png", 2131235220, false, "", null, 128);
        n(this, 2131888662, "MediumDarkThanks", "MediumDarkThanks", "emoji_mediumdarkthanks_v2.png", 2131235221, false, "", null, 128);
        n(this, 2131888662, "DarkThanks", "DarkThanks", "emoji_darkthanks_v2.png", 2131235218, false, "", null, 128);
        n(this, 2131888543, "MediumLightFightOn", "MediumLightFightOn", "emoji_mediumlightfighton_v2.png", 2131235054, false, "", null, 128);
        n(this, 2131888543, "LightFightOn", "LightFightOn", "emoji_lightfighton_v2.png", 2131235051, false, "", null, 128);
        m(2131888543, "Lark_Emoji_Fighting_0", "MUSCLE", "emoji_fighton_v2.png", 2131235049, false, "加油", new String[]{"MediumLightFightOn", "LightFightOn", "MUSCLE", "MediumFightOn", "MediumDarkFightOn", "DarkFightOn"});
        n(this, 2131888543, "MediumFightOn", "MediumFightOn", "emoji_mediumfighton_v2.png", 2131235052, false, "", null, 128);
        n(this, 2131888543, "MediumDarkFightOn", "MediumDarkFightOn", "emoji_mediumdarkfighton_v2.png", 2131235053, false, "", null, 128);
        n(this, 2131888543, "DarkFightOn", "DarkFightOn", "emoji_darkfighton_v2.png", 2131235050, false, "", null, 128);
        n(this, 2131888570, "Lark_Emoji_Heart_0", "HEART", "emoji_heart.png", 2131235092, false, "爱心", null, 128);
        n(this, 2131888586, "Lark_Emoji_Lips_0", "LIPS", "emoji_lips_v1.png", 2131235117, false, "kiss", null, 128);
        n(this, 2131888526, "Lark_Emoji_Detergent_0", "DETERGENT", "emoji_detergent.png", 2131235030, true, "去污粉", null, 128);
        n(this, 2131888493, "Lark_Emoji_Awesome_0", "AWESOME", "emoji_awesome.png", 2131234986, true, "666", null, 128);
        n(this, 2131888621, "Lark_Emoji_Rose_0", "ROSE", "emoji_rose.png", 2131235165, false, "玫瑰", null, 128);
        n(this, 2131888523, "Lark_Emoji_Cucumber_0", "CUCUMBER", "emoji_cucumber_v3.png", 2131235024, false, "胡瓜", null, 128);
        n(this, 2131888500, "Lark_Emoji_Beer_0", "BEER", "emoji_beer.png", 2131234993, false, "啤酒", null, 128);
        n(this, 2131888539, "Lark_Emoji_Enough_0", "ENOUGH", "emoji_enough.png", 2131235044, false, "我想静静", null, 128);
        n(this, 2131888685, "Lark_Emoji_Wronged_0", "WRONGED", "emoji_wronged.png", 2131235256, false, "委屈", null, 128);
        n(this, 2131888572, "Lark_Emoji_Obsessed_0", "OBSESSED", "emoji_hearts_v2.png", 2131235094, false, "舔屏", null, 128);
        n(this, 2131888588, "Lark_Emoji_LookDown_0", "LOOKDOWN", "emoji_lookdown.png", 2131235119, false, "鄙视", null, 128);
        n(this, 2131888641, "Lark_Emoji_Smooch_0", "SMOOCH", "emoji_smooch.png", 2131235197, false, "飞吻", null, 128);
        n(this, 2131888677, "Lark_Emoji_Wave_0", "WAVE", "emoji_wave.png", 2131235248, false, "再见", null, 128);
        n(this, 2131888529, "Lark_Emoji_DonnotGo_0", "DONNOTGO", "emoji_donnotgo.png", 2131235034, false, "紫薇别走", null, 128);
        n(this, 2131888569, "Lark_Emoji_Headset_0", "HEADSET", "emoji_headset_v3.png", 2131235091, false, "听歌", null, 128);
        n(this, 2131888575, "Lark_Emoji_Hug_0", "HUG", "emoji_hug.png", 2131235101, false, "求抱抱", null, 128);
        n(this, 2131888534, "Lark_Emoji_DullStare_0", "DULLSTARE", "emoji_dullstare.png", 2131235039, false, "周冬雨的凝视", null, 128);
        n(this, 2131888578, "Lark_Emoji_InnocentSmile_0", "INNOCENTSMILE", "emoji_innocentsmile.png", 2131235105, false, "马思纯的微笑", null, 128);
        n(this, 2131888669, "Lark_Emoji_Tongue_0", "TONGUE", "emoji_tongue.png", 2131235239, false, "吐舌", null, 128);
        n(this, 2131888533, "Lark_Emoji_Dull_0", "DULL", "emoji_dull.png", 2131235038, false, "呆无辜", null, 128);
        n(this, 2131888563, "Lark_Emoji_Glance_0", "GLANCE", "emoji_glance.png", 2131235083, false, "看", null, 128);
        n(this, 2131888637, "Lark_Emoji_Slight_0", "SLIGHT", "emoji_slight.png", 2131235192, false, "白眼", null, 128);
        n(this, 2131888499, "Lark_Emoji_Bear_0", "BEAR", "emoji_bear.png", 2131234991, false, "熊吉", null, 128);
        n(this, 2131888634, "Lark_Emoji_Skull_0", "SKULL", "emoji_skull.png", 2131235189, false, "骷髅", null, 128);
        n(this, 2131888503, "Lark_Emoji_BlackFace_0", "BLACKFACE", "emoji_blackface.png", 2131234998, false, "黑脸", null, 128);
        n(this, 2131888535, "Lark_Emoji_Eating_0", "EATING", "emoji_eating.png", 2131235040, false, "吃瓜群众", null, 128);
        n(this, 2131888657, "Lark_Emoji_Sweat_0", "SWEAT", "emoji_sweat.png", 2131235213, false, "汗", null, 128);
        n(this, 2131888519, "Lark_Emoji_Comfort_0", "COMFORT", "emoji_comfort.png", 2131235020, false, "摸头", null, 128);
        n(this, 2131888551, "Lark_Emoji_Frown_0", "FROWN", "emoji_frown.png", 2131235072, false, "皱眉", null, 128);
        n(this, 2131888647, "Lark_Emoji_Speechless_0", "SPEECHLESS", "emoji_speechless.png", 2131235203, false, "擦汗", null, 128);
        n(this, 2131888505, "Lark_Emoji_Blush_0", "XBLUSH", "emoji_blush.png", 2131235000, false, "红脸", null, 128);
        n(this, 2131888538, "Lark_Emoji_Embarrassed_0", "EMBARRASSED", "emoji_embarrassed.png", 2131235043, false, "尬笑", null, 128);
        n(this, 2131888660, "Lark_Emoji_Tease_0", "TEASE", "emoji_tease.png", 2131235215, false, "做鬼脸", null, 128);
        n(this, 2131888613, "Lark_Emoji_Praise_0", "PRAISE", "emoji_praise.png", 2131235156, false, "强", null, 128);
        n(this, 2131888502, "Lark_Emoji_BigKiss_0", "BIGKISS", "emoji_bigkiss.png", 2131234997, false, "如花", null, 128);
        n(this, 2131888615, "Lark_Emoji_Puke_0", "PUKE", "emoji_puke.png", 2131235159, false, "吐", null, 128);
        n(this, 2131888684, "Lark_Emoji_Wow_0", "WOW", "emoji_wow.png", 2131235255, false, "惊喜", null, 128);
        n(this, 2131888567, "Lark_Emoji_Hammer_0", "HAMMER", "emoji_hammer_v1.png", 2131235089, false, "敲打", null, 128);
        n(this, 2131888656, "Lark_Emoji_Strive_0", "STRIVE", "emoji_strive.png", 2131235212, false, "奋斗", null, 128);
        n(this, 2131888618, "Lark_Emoji_RainbowPuke_0", "RAINBOWPUKE", "emoji_rainbowpuke_v2.png", 2131235162, false, "吐彩虹", null, 128);
        n(this, 2131888676, "Lark_Emoji_Wail_0", "WAIL", "emoji_wail.png", 2131235247, false, "大哭", null, 128);
        n(this, 2131888544, "MediumLightFingerHeart", "MediumLightFingerHeart", "emoji_mediumlightfingerheart_v2.png", 2131235060, false, "", null, 128);
        n(this, 2131888544, "LightFingerHeart", "LightFingerHeart", "emoji_lightfingerheart_v2.png", 2131235057, false, "", null, 128);
        m(2131888544, "Lark_Emoji_FingerHeart_0", "FINGERHEART", "emoji_fingerheart_v2.png", 2131235055, false, "比心", new String[]{"MediumLightFingerHeart", "LightFingerHeart", "FINGERHEART", "MediumFingerHeart", "MediumDarkFingerHeart", "DarkFingerHeart"});
        n(this, 2131888544, "MediumFingerHeart", "MediumFingerHeart", "emoji_mediumfingerheart_v2.png", 2131235058, false, "", null, 128);
        n(this, 2131888544, "MediumDarkFingerHeart", "MediumDarkFingerHeart", "emoji_mediumdarkfingerheart_v2.png", 2131235059, false, "", null, 128);
        n(this, 2131888544, "DarkFingerHeart", "DarkFingerHeart", "emoji_darkfingerheart_v2.png", 2131235056, false, "", null, 128);
        n(this, 2131888548, "MediumLightFistBump", "MediumLightFistBump", "emoji_mediumlightfistbump_v2.png", 2131235069, false, "", null, 128);
        n(this, 2131888548, "LightFistBump", "LightFistBump", "emoji_lightfistbump_v2.png", 2131235066, false, "", null, 128);
        m(2131888548, "Lark_Emoji_FistBump_0", "FISTBUMP", "emoji_fistbump_v2.png", 2131235064, false, "碰拳", new String[]{"MediumLightFistBump", "LightFistBump", "FISTBUMP", "MediumFistBump", "MediumDarkFistBump", "DarkFistBump"});
        n(this, 2131888548, "MediumFistBump", "MediumFistBump", "emoji_mediumfistbump_v2.png", 2131235067, false, "", null, 128);
        n(this, 2131888548, "MediumDarkFistBump", "MediumDarkFistBump", "emoji_mediumdarkfistbump_v2.png", 2131235068, false, "", null, 128);
        n(this, 2131888548, "DarkFistBump", "DarkFistBump", "emoji_darkfistbump_v2.png", 2131235065, false, "", null, 128);
        n(this, 2131888573, "MediumLightHighFive", "MediumLightHighFive", "emoji_mediumlighthighfive_v2.png", 2131235100, false, "", null, 128);
        n(this, 2131888573, "LightHighFive", "LightHighFive", "emoji_lighthighfive_v2.png", 2131235097, false, "", null, 128);
        m(2131888573, "Lark_Emoji_HighFive_0", "HIGHFIVE", "emoji_highfive_v2.png", 2131235095, false, "击掌", new String[]{"MediumLightHighFive", "LightHighFive", "HIGHFIVE", "MediumHighFive", "MediumDarkHighFive", "DarkHighFive"});
        n(this, 2131888573, "MediumHighFive", "MediumHighFive", "emoji_mediumhighfive_v2.png", 2131235098, false, "", null, 128);
        n(this, 2131888573, "MediumDarkHighFive", "MediumDarkHighFive", "emoji_mediumdarkhighfive_v2.png", 2131235099, false, "", null, 128);
        n(this, 2131888573, "DarkHighFive", "DarkHighFive", "emoji_darkhighfive_v2.png", 2131235096, false, "", null, 128);
        n(this, 2131888674, "MediumLightClick", "MediumLightClick", "emoji_mediumlightclick_v2.png", 2131235015, false, "", null, 128);
        n(this, 2131888674, "LightClick", "LightClick", "emoji_lightclick_v2.png", 2131235012, false, "", null, 128);
        m(2131888674, "Lark_Emoji_UpperLeft_0", "UPPERLEFT", "emoji_click_v2.png", 2131235016, false, "左上", new String[]{"MediumLightClick", "LightClick", "UPPERLEFT", "MediumClick", "MediumDarkClick", "DarkClick"});
        n(this, 2131888674, "MediumClick", "MediumClick", "emoji_mediumclick_v2.png", 2131235013, false, "", null, 128);
        n(this, 2131888674, "MediumDarkClick", "MediumDarkClick", "emoji_mediumdarkclick_v2.png", 2131235014, false, "", null, 128);
        n(this, 2131888674, "DarkClick", "DarkClick", "emoji_darkclick_v2.png", 2131235011, false, "", null, 128);
        n(this, 2131888625, "MediumLightShake", "MediumLightShake", "emoji_mediumlightshake_v2.png", 2131235179, false, "", null, 128);
        n(this, 2131888625, "LightShake", "LightShake", "emoji_lightshake_v2.png", 2131235176, false, "", null, 128);
        m(2131888625, "Lark_Emoji_Shake_0", "SHAKE", "emoji_shake_v2.png", 2131235174, false, "握手", new String[]{"MediumLightShake", "LightShake", "SHAKE", "MediumShake", "MediumDarkShake", "DarkShake"});
        n(this, 2131888625, "MediumShake", "MediumShake", "emoji_mediumshake_v2.png", 2131235177, false, "", null, 128);
        n(this, 2131888625, "MediumDarkShake", "MediumDarkShake", "emoji_mediumdarkshake_v2.png", 2131235178, false, "", null, 128);
        n(this, 2131888625, "DarkShake", "DarkShake", "emoji_darkshake_v2.png", 2131235175, false, "", null, 128);
        n(this, 2131888622, "MediumLightSalute", "MediumLightSalute", "emoji_mediumlightsalute_v2.png", 2131235171, false, "", null, 128);
        n(this, 2131888622, "LightSalute", "LightSalute", "emoji_lightsalute_v2.png", 2131235168, false, "", null, 128);
        m(2131888622, "Salute", "SALUTE", "emoji_salute_v2.png", 2131235166, false, "抱拳", new String[]{"MediumLightSalute", "LightSalute", "SALUTE", "MediumSalute", "MediumDarkSalute", "DarkSalute"});
        n(this, 2131888622, "MediumSalute", "MediumSalute", "emoji_mediumsalute_v2.png", 2131235169, false, "", null, 128);
        n(this, 2131888622, "MediumDarkSalute", "MediumDarkSalute", "emoji_mediumdarksalute_v2.png", 2131235170, false, "", null, 128);
        n(this, 2131888622, "DarkSalute", "DarkSalute", "emoji_darksalute_v2.png", 2131235167, false, "", null, 128);
        n(this, 2131888528, "Done", "DONE", "emoji_done.png", 2131235033, false, "完成", null, 128);
        n(this, 2131888537, "Lark_Emoji_18x_0", "18X", "emoji_eighteen.png", 2131235042, false, "18禁", null, 128);
        n(this, 2131888515, "Lark_Emoji_Cleaver_0", "CLEAVER", "emoji_cleaver_v3.png", 2131235010, false, "刀", null, 128);
        n(this, 2131888611, "+1", "JIAYI", "emoji_plusone.png", 2131235154, false, "+1", null, 128);
        n(this, 2131888679, "Lark_Emoji_WellDone_0", "WELLDONE", "emoji_welldone.png", 2131235250, true, "V5", null, 128);
        n(this, 2131888565, "Lark_Emoji_GoodJob_0", "GOODJOB", "emoji_goodjob.png", 2131235086, true, "给力", null, 128);
        n(this, 2131888571, "Lark_Emoji_HeartBroken_0", "HEARTBROKEN", "emoji_heartbroken.png", 2131235093, false, "伤心", null, 128);
        n(this, 2131888612, "Lark_Emoji_Poop_0", "POOP", "emoji_poop.png", 2131235155, false, "屎", null, 128);
        n(this, 2131888562, "Lark_Emoji_Gift_0", "GIFT", "emoji_gift_v3.png", 2131235082, false, "礼物", null, 128);
        n(this, 2131888509, "Lark_Emoji_Cake_0", "CAKE", "emoji_cake_v2.png", 2131235004, false, "蛋糕", null, 128);
        n(this, 2131888606, "Lark_Emoji_Party_0", "PARTY", "emoji_party.png", 2131235149, false, "撒花", null, 128);
        n(this, 2131888541, "Lark_Emoji_EyesClosed_0", "EYESCLOSED", "emoji_eyesclosed.png", 2131235046, false, "不看", null, 128);
        n(this, 2131888506, "Lark_Emoji_Bomb_0", "BOMB", "emoji_bomb.png", 2131235001, false, "炸弹", null, 128);
        n(this, 2131888547, "Fireworks", "FIREWORKS", "emoji_fireworks_v2.png", 2131235063, false, "", null, 128);
        n(this, 2131888508, "Bull", "BULL", "emoji_bull.png", 2131235003, false, "", null, 128);
        n(this, 2131888510, "Calf", "CALF", "emoji_calf.png", 2131235005, false, "", null, 128);
        n(this, 2131888511, "Candiedhaws", "CANDIEDHAWS", "emoji_candiedhaws.png", 2131235006, false, "", null, 128);
        n(this, 2131888619, "Redpacket", "REDPACKET", "emoji_redpacket_v2.png", 2131235163, false, "", null, 128);
        n(this, 2131888591, "Luck", "LUCK", "emoji_luck.png", 2131235122, false, "", null, 128);
        n(this, 2131888546, "Firecracker", "FIRECRACKER", "emoji_firecracker_v3.png", 2131235062, false, "", null, 128);
        n(this, 2131888536, "EatingFood", "EatingFood", "emoji_eatingfood_v2.png", 2131235041, false, null, null, 128);
        n(this, 2131888673, "Typing", "Typing", "emoji_typing.png", 2131235245, false, null, null, 128);
        n(this, 2131888585, "Lemon", "Lemon", "emoji_lemon_v2.png", 2131235111, false, null, null, 128);
        n(this, 2131888583, "LGTM", "LGTM", "emoji_lgtm_v3.png", 2131235112, false, null, null, 128);
        n(this, 2131888666, "MediumLightThumbsDown", "MediumLightThumbsDown", "emoji_mediumlightthumbsdown_v2.png", 2131235231, false, null, null, 128);
        n(this, 2131888666, "LightThumbsDown", "LightThumbsDown", "emoji_lightthumbsdown_v2.png", 2131235228, false, null, null, 128);
        m(2131888666, "ThumbsDown", "ThumbsDown", "emoji_thumbsdown_v2.png", 2131235226, false, null, new String[]{"MediumLightThumbsDown", "LightThumbsDown", "ThumbsDown", "MediumThumbsDown", "MediumDarkThumbsDown", "DarkThumbsDown"});
        n(this, 2131888666, "MediumThumbsDown", "MediumThumbsDown", "emoji_mediumthumbsdown_v2.png", 2131235229, false, null, null, 128);
        n(this, 2131888666, "MediumDarkThumbsDown", "MediumDarkThumbsDown", "emoji_mediumdarkthumbsdown_v2.png", 2131235230, false, null, null, 128);
        n(this, 2131888666, "DarkThumbsDown", "DarkThumbsDown", "emoji_darkthumbsdown_v2.png", 2131235227, false, null, null, 128);
        n(this, 2131888532, "Drumstick", "Drumstick", "emoji_drumstick.png", 2131235037, false, null, null, 128);
        n(this, 2131888608, "Pepper", "Pepper", "emoji_pepper.png", 2131235151, false, null, null, 128);
        n(this, 2131888507, "BubbleTea", "BubbleTea", "emoji_bubbletea.png", 2131235002, false, null, null, 128);
        n(this, 2131888517, "Coffee", "Coffee", "emoji_coffee_v2.png", 2131235018, false, null, null, 128);
        n(this, 2131888690, "Yes", "Yes", "emoji_yes_v2.png", 2131235261, false, null, null, 128);
        n(this, 2131888599, "No", "No", "emoji_no_v3.png", 2131235140, false, null, null, 128);
        n(this, 2131888602, "OKR", "OKR", "emoji_okr.png", 2131235145, false, null, null, 128);
        n(this, 2131888512, "CheckMark", "CheckMark", "emoji_checkmark.png", 2131235007, false, null, null, 128);
        n(this, 2131888521, "CrossMark", "CrossMark", "emoji_crossmark.png", 2131235022, false, null, null, 128);
        n(this, 2131888593, "MinusOne", "MinusOne", "emoji_minusone_v4.png", 2131235134, false, null, null, 128);
        n(this, 2131888576, "Hundred", "Hundred", "emoji_hundred.png", 2131235102, false, null, null, 128);
        n(this, 2131888610, "Pin", "Pin", "emoji_pin.png", 2131235153, false, null, null, 128);
        n(this, 2131888489, "Alarm", "Alarm", "emoji_alarm.png", 2131234977, false, null, null, 128);
        n(this, 2131888589, "Loudspeaker", "Loudspeaker", "emoji_loudspeaker.png", 2131235120, false, null, null, 128);
        n(this, 2131888671, "Trophy", "Trophy", "emoji_trophy.png", 2131235241, false, null, null, 128);
        n(this, 2131888545, "Fire", "Fire", "emoji_fire.png", 2131235061, false, null, null, 128);
        n(this, 2131888598, "Music", "Music", "emoji_music_v2.png", 2131235139, false, null, null, 128);
        n(this, 2131888495, "Basketball", "Basketball", "emoji_basketball_v3.png", 2131234989, false, null, null, 128);
        n(this, 2131888646, "Soccer", "Soccer", "emoji_soccer_v3.png", 2131235201, false, null, null, 128);
        n(this, 2131888553, "GeneralBusinessTrip", "GeneralBusinessTrip", "emoji_generalbusinesstrip_v2.png", 2131235074, false, null, null, 128);
        n(this, 2131888554, "GeneralDoNotDisturb", "GeneralDoNotDisturb", "emoji_generaldonotdisturb_v3.png", 2131235075, false, null, null, 128);
        n(this, 2131888555, "GeneralInMeetingBusy", "GeneralInMeetingBusy", "emoji_generalInmeetingbusy_v2.png", 2131235076, false, null, null, 128);
        n(this, 2131888556, "GeneralMoonRest", "GeneralMoonRest", "emoji_generalmoonrest_v2.png", 2131235077, false, null, null, 128);
        n(this, 2131888557, "GeneralSun", "GeneralSun", "emoji_generalsun.png", 2131235078, false, null, null, 128);
        n(this, 2131888558, "GeneralTravellingCar", "GeneralTravellingCar", "emoji_generaltravellingcar.png", 2131235079, false, null, null, 128);
        n(this, 2131888560, "GeneralWorkFromHome", "GeneralWorkFromHome", "emoji_generalworkfromhome.png", 2131235080, false, null, null, 128);
        n(this, 2131888654, "Status_PrivateMessage", "Status_PrivateMessage", "emoji_status_privatemessage.png", 2131235205, false, null, null, 128);
        n(this, 2131888649, "StatusBus", "StatusBus", "emoji_statusbus.png", 2131235206, false, null, null, 128);
        n(this, 2131888650, "StatusEnjoyLife", "StatusEnjoyLife", "emoji_statusenjoylife.png", 2131235207, false, null, null, 128);
        n(this, 2131888651, "StatusFlashOfInspiration", "StatusFlashOfInspiration", "emoji_statusflashofinspiration.png", 2131235208, false, null, null, 128);
        n(this, 2131888652, "StatusInFlight", "StatusInFlight", "emoji_statusinflight.png", 2131235209, false, null, null, 128);
        n(this, 2131888653, "StatusReading", "StatusReading", "emoji_statusreading.png", 2131235210, false, null, null, 128);
        n(this, 2131888496, "Ambitious", "Ambitious", UIHelper.getString(2131888695), 2131234994, false, null, null, 128);
        n(this, 2131888496, "Patient", "Patient", UIHelper.getString(2131888695), 2131234994, false, null, null, 128);
        n(this, 2131888524, "CustomerSuccess", "CustomerSuccess", UIHelper.getString(2131888696), 2131235025, false, null, null, 128);
        n(this, 2131888617, "PursueUltimate", "PursueUltimate", UIHelper.getString(2131888697), 2131235161, false, null, null, 128);
        n(this, 2131888497, "Responsible", "Responsible", UIHelper.getString(2131888698), 2131234995, false, null, null, 128);
        n(this, 2131888497, "Reliable", "Reliable", UIHelper.getString(2131888698), 2131234995, false, null, null, 128);
        n(this, 2131888644, "Snowman", "Snowman", "emoji_snowman.png", 2131235199, false, null, null, 128);
        n(this, 2131888686, "XmasHat", "XmasHat", "emoji_xmashat.png", 2131235257, false, null, null, 128);
        n(this, 2131888687, "XmasTree", "XmasTree", "emoji_xmastree.png", 2131235258, false, null, null, 128);
        n(this, 2131888605, "OneSecond", "OneSecond", "emoji_onesecond.png", 2131235146, false, null, null, 128);
        n(this, 2131888632, "Sigh", "Sigh", "emoji_sigh.png", 2131235186, false, null, null, 128);
        n(this, 2131888604, "OnIt", "OnIt", "emoji_onit_v1.png", 2131235147, false, null, null, 128);
        n(this, 2131888483, "2022", "2022", "emoji_twentytwentytwo.png", 2131235244, false, null, null, 128);
        n(this, 2131888620, "RoarForYou", "RoarForYou", "emoji_roarforyou.png", 2131235164, false, null, null, 192);
        n(this, 2131888655, "StickyRiceBalls", "StickyRiceBalls", "emoji_stickyriceballs.png", 2131235211, false, null, null, 192);
        n(this, 2131888592, "MeMeMe", "MeMeMe", "emoji_mememe.png", 2131235133, false, null, null, 192);
        n(this, 2131888603, "MediumlightOKHand", "MediumlightOKHand", "emoji_mediumlightokhand.png", 2131235127, false, null, null, 192);
        n(this, 2131888603, "LightOKHand", "LightOKHand", "emoji_lightokhand.png", 2131235113, false, null, null, 192);
        n(this, 2131888603, "OKHand", "OKHand", "emoji_okhand.png", 2131235144, false, null, new String[]{"MediumlightOKHand", "LightOKHand", "OKHand", "MediumOKHand", "MediumdarkOKHand", "DarkOKHand"}, 64);
        n(this, 2131888603, "MediumOKHand", "MediumOKHand", "emoji_mediumokhand.png", 2131235130, false, null, null, 192);
        n(this, 2131888603, "MediumdarkOKHand", "MediumdarkOKHand", "emoji_mediumdarkokhand.png", 2131235124, false, null, null, 192);
        n(this, 2131888603, "DarkOKHand", "DarkOKHand", "emoji_darkokhand.png", 2131235026, false, null, null, 192);
        n(this, 2131888691, "YouAreTheBest", "YouAreTheBest", "emoji_youarethebest.png", 2131235262, false, null, new String[]{"MediumlightYouAreTheBest", "LightYouAreTheBest", "YouAreTheBest", "MediumYouAreTheBest", "MediumdarkYouAreTheBest", "DarkYouAreTheBest"}, 64);
        n(this, 2131888691, "MediumlightYouAreTheBest", "MediumlightYouAreTheBest", "emoji_mediumlightyouarethebest_v1.png", 2131235129, false, null, null, 192);
        n(this, 2131888691, "LightYouAreTheBest", "LightYouAreTheBest", "emoji_lightyouarethebest_v1.png", 2131235115, false, null, null, 192);
        n(this, 2131888691, "MediumYouAreTheBest", "MediumYouAreTheBest", "emoji_mediumyouarethebest_v1.png", 2131235132, false, null, null, 192);
        n(this, 2131888691, "MediumdarkYouAreTheBest", "MediumdarkYouAreTheBest", "emoji_mediumdarkyouarethebest_v1.png", 2131235126, false, null, null, 192);
        n(this, 2131888691, "DarkYouAreTheBest", "DarkYouAreTheBest", "emoji_darkyouarethebest_v1.png", 2131235028, false, null, null, 192);
        n(this, 2131888559, "GeneralVacation", "GeneralVacation", "emoji_onleavestatus.png", 2131235148, false, null, null, 192);
        n(this, 2131888596, "Mooncake", "Mooncake", "emoji_mooncake_v2.png", 2131235136, false, null, null, 192);
        n(this, 2131888595, "MoonRabbit", "MoonRabbit", "emoji_moonrabbit_v2.png", 2131235137, false, null, null, 192);
        n(this, 2131888607, "Partying", "Partying", "emoji_partying_v1.png", 2131235150, false, null, null, 192);
        n(this, 2131888564, "GoGoGo", "GoGoGo", "emoji_gogogo_v4.png", 2131235084, false, null, null, 192);
        n(this, 2131888658, "TV", "TV", "emoji_tv_v1.png", 2131235242, false, null, null, 192);
        n(this, 2131888597, "Movie", "Movie", "emoji_movie_v1.png", 2131235138, false, null, null, 192);
        n(this, 2131888616, "Pumpkin", "Pumpkin", "emoji_pumpkin_v1.png", 2131235160, false, null, null, 192);
        n(this, 2131888484, "2023", "2023", "emoji_2023_v4.png", 2131234971, false, null, null, 192);
        n(this, 2131888581, "JubilantRabbit", "JubilantRabbit", "emoji_jubilantrabbit_v1.png", 2131235108, false, null, null, 192);
        n(this, 2131888675, "VRHeadset", "VRHeadset", "emoji_vrheadset_v1.png", 2131235246, false, null, null, 192);
        n(this, 2131888552, "FullMoonFace", "FullMoonFace", "emoji_fullmoonface_v1.png", 2131235073, false, null, null, 192);
        n(this, 2131888518, "ColdSweat", "ColdSweat", "emoji_coldsweat_v1.png", 2131235019, false, null, null, 192);
        n(this, 2131888525, "Delighted", "Delighted", "emoji_delighted_v1.png", 2131235029, false, null, null, 192);
        n(this, 2131888498, "BeamingFace", "BeamingFace", "emoji_beamingface_v1.png", 2131234990, false, null, null, 192);
        n(this, 2131888663, "ThanksFace", "ThanksFace", "emoji_thanksface_v1.png", 2131235223, false, null, null, 192);
        n(this, 2131888623, "SaluteFace", "SaluteFace", "emoji_saluteface_v1.png", 2131235172, false, null, null, 192);
        n(this, 2131888629, "Shrug", "Shrug", "emoji_shrug_v1.png", 2131235183, false, null, null, 192);
        n(this, 2131888516, "ClownFace", "ClownFace", "emoji_clownface_v1.png", 2131235017, false, null, null, 192);
        n(this, 2131888678, "MediumlightWavingHand", "MediumlightWavingHand", "emoji_mediumlightwavinghand_v1.png", 2131235128, false, null, null, 192);
        n(this, 2131888678, "LightWavingHand", "LightWavingHand", "emoji_lightwavinghand_v1.png", 2131235114, false, null, null, 192);
        n(this, 2131888678, "WavingHand", "WavingHand", "emoji_wavinghand_v1.png", 2131235249, false, null, new String[]{"MediumlightWavingHand", "LightWavingHand", "WavingHand", "MediumWavingHand", "MediumdarkWavingHand", "DarkWavingHand"}, 64);
        n(this, 2131888678, "MediumWavingHand", "MediumWavingHand", "emoji_mediumwavinghand_v1.png", 2131235131, false, null, null, 192);
        n(this, 2131888678, "MediumdarkWavingHand", "MediumdarkWavingHand", "emoji_mediumdarkwavinghand_v1.png", 2131235125, false, null, null, 192);
        n(this, 2131888678, "DarkWavingHand", "DarkWavingHand", "emoji_darkwavinghand_v1.png", 2131235027, false, null, null, 192);
        n(this, 2131888485, "2024", "2024", "emoji_2024_v1.png", 2131234972, false, null, null, 192);
        n(this, 2131888568, "HappyDragon", "HappyDragon", "emoji_happydragon_v3.png", 2131235090, false, null, null, 192);
        n(this, 2131888486, "2025", "2025", "emoji_2025_v1.png", 2131234973, false, null, null, 192);
        n(this, 2131888643, "SiSiASYouWish", "SiSiASYouWish", "emoji_sisiasyouwish_v1.png", 2131235188, false, null, null, 192);
        n(this, 2131888487, "2026", "2026", "emoji_2026_v1.png", 2131234974, false, null, null, 192);
        n(this, 2131888574, "BeAtTheForefront", "BeAtTheForefront", "emoji_beattheforefront_v1.png", 2131234992, false, null, null, 192);
        n(this, 2131888664, "ThanksHoldingBoard", "ThanksHoldingBoard", "emoji_thanksholdingboard_v1.png", 2131235224, false, null, null, 192);
        Locale r0 = com.ss.android.lark.language.service.impl.a.o().getLanguageSetting();
        Log.i("EmojiMapManager2", "setDefaultData, local: " + wsb.c.a(r0));
        if (Intrinsics.areEqual(r0.getLanguage(), Locale.CHINESE.getLanguage()) == true) goto L5;
        n(this, 2131888594, "Lark_Emoji_Money_0", "MONEY", "emoji_dollar.png", 2131235032, false, "钱", null, 128);
        n(this, 2131888601, "Lark_Emoji_OK_0", "OK", "emoji_ok_v2.png", 2131235143, false, "OK", null, 128);
        n(this, 2131888501, "Lark_Emoji_Betrayed_0", "BETRAYED", "emoji_mad.png", 2131235123, false, "绿帽子", null, 128);
        n(this, 2131888494, "Awesomen", "AWESOMEN", "emoji_socool_v2.png", 2131235202, false, "", null, 128);
        n(this, 2131888672, "2021", "2021", "emoji_balloon_v2.png", 2131234988, false, "", null, 128);
        n(this, 2131888550, "Fortune", "FORTUNE", "emoji_gold.png", 2131235085, false, "", null, 128);
        n(this, 2131888561, "Get", "Get", "emoji_gotit_v1.png", 2131235087, false, null, null, 128);
        n(this, 2131888488, "AINailedIt", "AINailedIt", "emoji_ai_nailed_it_zh.png", 2131234975, false, null, null, 128);
        return;
    L5:
        n(this, 2131888594, "Lark_Emoji_Money_0", "MONEY", "emoji_money.png", 2131235135, false, "钱", null, 128);
        n(this, 2131888601, "Lark_Emoji_OK_0", "OK", "emoji_ok_v2.png", 2131235143, false, "OK", null, 128);
        n(this, 2131888501, "Lark_Emoji_Betrayed_0", "BETRAYED", "emoji_betrayed.png", 2131234996, false, "绿帽子", null, 128);
        n(this, 2131888494, "Awesomen", "AWESOMEN", "emoji_awesomen_v2.png", 2131234987, false, "", null, 128);
        n(this, 2131888672, "2021", "2021", "emoji_twentytwentyone_v2.png", 2131235243, false, "", null, 128);
        n(this, 2131888550, "Fortune", "FORTUNE", "emoji_fortune.png", 2131235071, false, "", null, 128);
        n(this, 2131888561, "Get", "Get", "emoji_get_v3.png", 2131235081, false, null, null, 128);
        n(this, 2131888488, "AINailedIt", "AINailedIt", "emoji_ai_nailed_it_en.png", 2131234976, false, null, null, 128);
    }

    @Override // rsb.a
    public final ConcurrentHashMap<String, qsb.a> Q1() {
        return this.c;
    }

    @Override // rsb.a
    public final ConcurrentHashMap<String, String> h2() {
        return this.d;
    }

    @Inject
    public EmojiMapManager2(m r2) {
        Intrinsics.checkNotNullParameter(r2, "passport");
        super(r2);
        this.b = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
        this.d = new ConcurrentHashMap();
        this.e = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("EmojiMapManager2"));
        this.f = new ConcurrentHashMap();
        this.g = new ConcurrentHashMap();
        this.h = Target.SIZE_ORIGINAL;
        this.i = Target.SIZE_ORIGINAL;
        this.j = LazyKt.lazy(EmojiMapManager2$emojiLoadExecutor$2.INSTANCE);
        Log.i("EmojiMapManager2", "init");
        u();
    }

    @Override // rsb.a
    public final qsb.a Yd(String r2) {
        Intrinsics.checkNotNullParameter(r2, "reactionKey");
        return this.c.get(r2);
    }

    @Override // rsb.a
    public final qsb.a b0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "emojiKey");
        return this.b.get(r2);
    }

    @Override // rsb.a
    public final void c9(rsb.a.InterfaceC0324a r1) {
        this.k = r1;
    }

    @Override // rsb.a
    public final String df(String r4) {
        Intrinsics.checkNotNullParameter(r4, TabAppInfo.IMAGE_JSON_KEY);
        if (i7(r4) == true) goto L5;
        qsb.a r0 = p(r4);
        if (r0 == null) goto L9;
        String r1 = r0.c;
    L10:
        if (r1 != null) goto L12;
    L15:
        boolean r2 = true;
    L16:
        if (r2 == false) goto L18;
        Log.i("EmojiMapManager2", "getReactionOrEmojiText, emoji text is null, key = ".concat(r4));
    L18:
        if (r0 == null) goto L24;
        String r3 = r0.c;
        if (r3 != null) goto L23;
        return r4;
    L23:
        return r3;
    L24:
        return r4;
    L12:
        if (r1.length() == 0) goto L15;
        r2 = false;
        goto L16
    L9:
        r1 = null;
        goto L10
    L5:
        return UIHelper.getString(2131891158);
    }

    @Override // rsb.a
    public final boolean i7(String r2) {
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        qsb.a r3 = p(r2);
        if (r3 != null) goto L7;
        return false;
    L7:
        return r3.h;
    }

    @Override // rsb.a
    /* JADX INFO: renamed from: if, reason: not valid java name */
    public final boolean mo1505if(String r2) {
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        qsb.a r3 = p(r2);
        if (r3 != null) goto L7;
        return false;
    L7:
        return !TextUtils.isEmpty(r3.d);
    }

    @Override // rsb.a
    public final boolean l4(String r2) {
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        qsb.a r3 = p(r2);
        if (r3 != null) goto L6;
        return false;
    L6:
        if (r3.b() == null) goto L9;
        return true;
    L9:
        return false;
    }

    public final qsb.a p(String r2) {
        qsb.a r0 = b0(r2);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return Yd(r2);
    }

    public final void s(String r5) {
        Intrinsics.checkNotNullParameter(r5, TabAppInfo.IMAGE_JSON_KEY);
        if (i7(r5) == false) goto L7;
        Log.w("EmojiMapManager2", "requestBitmap, key is delete");
        return;
    L7:
        if (TextUtils.isEmpty(r5) == false) goto L10;
        Log.e("EmojiMapManager2", "requestBitmap, key is null");
        return;
    L10:
        qsb.a r0 = p(r5);
        if (r0 != null) goto L20;
        Log.i("EmojiMapManager2", "requestBitmap, key = " + r5 + ", emoji entity is null, get emojis from net.");
        List<String> r6 = CollectionsKt.listOf(r5);
        if (this.k != null) goto L15;
        Log.w("EmojiMapManager2", "getEntityFromNet, emojiDataFetcher is null");
    L15:
        rsb.a.InterfaceC0324a r1 = this.k;
        if (r1 == null) goto L23;
        r1.k0(this.i, r6);
        return;
    L23:
        return;
    L20:
        if (r0.b() != null) goto L24;
        Log.i("EmojiMapManager2", "requestBitmap, key = " + r5 + ", emoji bitmap is null, load bitmap.");
        r(r0.d, r0);
        return;
    }

    @Override // rsb.a
    @Deprecated(message = "replace with [requestBitmap(String)]", replaceWith = @ReplaceWith(expression = "requestBitmap(key)", imports = {}))
    public final void sb(String r2) {
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        s(r2);
    }

    @Override // rsb.a
    public final String ub(String r3) {
        Intrinsics.checkNotNullParameter(r3, TabAppInfo.IMAGE_JSON_KEY);
        if (i7(r3) == false) goto L5;
        return null;
    L5:
        qsb.a r4 = p(r3);
        if (r4 != null) goto L8;
        return null;
    L8:
        return r4.d;
    }

    @Override // rsb.a
    public final Bitmap v1(String r6) {
        Intrinsics.checkNotNullParameter(r6, TabAppInfo.IMAGE_JSON_KEY);
        if (i7(r6) == false) goto L5;
        return null;
    L5:
        qsb.a r1 = p(r6);
        if (r1 != null) goto L10;
        Statistics.sendEvent("emoji_show_fallback", new JSONObject().put("version", this.i).put(TabAppInfo.IMAGE_JSON_KEY, r6));
        return null;
    L10:
        return r1.b();
    }

    @Override // rsb.a
    @Deprecated(message = "replace with [getReactionOrEmojiBitmap]", replaceWith = @ReplaceWith(expression = "getReactionOrEmojiBitmap(key)", imports = {}))
    public final Bitmap Hb(String r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, TabAppInfo.IMAGE_JSON_KEY);
        return v1(r1);
    }

    @Override // rsb.a
    @Deprecated(message = "replace with [getReactionOrEmojiText]", replaceWith = @ReplaceWith(expression = "getReactionOrEmojiText(key)", imports = {}))
    public final String K9(String r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, TabAppInfo.IMAGE_JSON_KEY);
        return df(r1);
    }

    @Override // rsb.a
    public final void V8(Set<? extends qsb.a> r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "set");
        Log.i("EmojiMapManager2", "updateMap, version = " + r6 + ", change count = " + r5.size());
        if (CollectionUtils.isEmpty(r5) == false) goto L5;
        return;
    L5:
        monitor-enter(this);
        this.i = r6;     // Catch: Throwable -> L29
        Iterator<T> r7 = r5.iterator();     // Catch: Throwable -> L29
    L8:
        if (r7.hasNext() == false) goto L19;
        qsb.a r0 = (qsb.a) r7.next();     // Catch: Throwable -> L29
        qsb.a r1 = this.b.get(r0.a);     // Catch: Throwable -> L29
        if (r1 == null) goto L12;
        String r2 = r1.c;     // Catch: Throwable -> L29
    L13:
        this.b.put(r0.a, r0);     // Catch: Throwable -> L29
        this.c.put(r0.b, r0);     // Catch: Throwable -> L29
        if (r2 == null) goto L18;
        if (y0.a(r0.c, r2) == true) goto L18;
        this.d.remove(r2);     // Catch: Throwable -> L29
    L18:
        this.d.put(r0.c, r0.a);     // Catch: Throwable -> L29
        goto L8
    L12:
        r2 = null;
        goto L13
    L19:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L29
        monitor-exit(this);
        Iterator<T> r9 = r5.iterator();
    L23:
        if (r9.hasNext() == false) goto L27;
        qsb.a r10 = (qsb.a) r9.next();
        if (r10.b() != null) goto L23;
        r(r10.d, r10);
        goto L23
    L27:
        this.e.execute(new com.ss.android.lark.newemoji.impl.a(this));
        return;
    L29:
        th = move-exception;
        throw th;
    }

    public final void r(String r5, qsb.a r6) {
        Log.i("EmojiMapManager2", "loadBitmapFromNet, start load bitmap of " + r6.a + " from net, " + r5);
        ImageLoader.with(UIHelper.getContext()).load(new EmojiImageResource(r5)).diskCacheStrategy(DiskCacheStrategy.RESULT).sourceExecutor((GlideExecutor) this.j.getValue()).asBitmap().listener(new b(SystemClock.elapsedRealtime(), r5)).into(new c(r6, r5, this));
    }

    @Override // rsb.a
    public final void ge(String r5, boolean r6, IGetDataCallback<Boolean> r7, IGetDataCallback<Boolean> r8) {
        Intrinsics.checkNotNullParameter(r5, TabAppInfo.IMAGE_JSON_KEY);
        if (i7(r5) == false) goto L10;
        Log.w("EmojiMapManager2", "requestBitmapWithCallback, key is delete");
        if (r7 == null) goto L7;
        r7.onError(new ErrorResult("key is delete"));
    L7:
        if (r8 == null) goto L52;
        r8.onError(new ErrorResult("key is delete"));
        return;
    L52:
        return;
    L10:
        boolean r1 = false;
        if (r5.length() != 0) goto L13;
        boolean r9 = true;
    L14:
        if (r9 == true) goto L16;
        qsb.a r10 = p(r5);
        if (r10 != null) goto L24;
    L36:
        if (r7 != null) goto L38;
    L43:
        if (r8 != null) goto L45;
    L50:
        s(r5);
        return;
    L45:
        if (this.g.get(r5) != null) goto L47;
        this.g.put(r5, new CopyOnWriteArrayList());
    L47:
        Log.i("EmojiMapManager2", "requestBitmapWithCallback, add image resources callback of ".concat(r5));
        CopyOnWriteArrayList<WeakReference<IGetDataCallback<Boolean>>> r11 = this.g.get(r5);
        if (r11 == null) goto L50;
        r11.add(new WeakReference(r8));
        goto L50
    L38:
        if (this.f.get(r5) != null) goto L40;
        this.f.put(r5, new CopyOnWriteArrayList());
    L40:
        Log.i("EmojiMapManager2", "requestBitmapWithCallback, add emoji entity callback of ".concat(r5));
        CopyOnWriteArrayList<WeakReference<IGetDataCallback<Boolean>>> r12 = this.f.get(r5);
        if (r12 == null) goto L43;
        r12.add(new WeakReference(r7));
        goto L43
    L24:
        if (r10.d.length() <= 0) goto L26;
        r1 = true;
    L26:
        if (r1 == false) goto L28;
    L29:
        if (r7 == null) goto L32;
        r7.onSuccess(Boolean.TRUE);
    L32:
        if (r10.b() == null) goto L43;
        if (r8 == null) goto L54;
        r8.onSuccess(Boolean.TRUE);
        return;
    L54:
        return;
    L28:
        if (r10.b() == null) goto L36;
    L16:
        if (r7 == null) goto L18;
        r7.onError(new ErrorResult("key is null"));
    L18:
        if (r8 == null) goto L53;
        r8.onError(new ErrorResult("key is null"));
        return;
    L53:
        return;
    L13:
        r9 = false;
        goto L14
    }

    public final void m(int r13, String r14, String r15, String r16, int r17, boolean r18, String r19, String[] r20) {
        String r10 = UIHelper.getString(r13);
        qsb.a r11 = new qsb.a(r14, r15, r10, r16, r17, Boolean.valueOf(r18));
        if (r20 == null) goto L5;
        List r1 = ArraysKt.toList(r20);
        r11.f.clear();
        r11.f.addAll(r1);
    L5:
        this.b.put(r14, r11);
        this.c.put(r15, r11);
        this.d.put(r10, r14);
        boolean r2 = false;
        if (r19 != null) goto L8;
    L13:
        if (r2 == false) goto L16;
        this.b.put(r19, r11);
        return;
    L16:
        return;
    L8:
        if (r19.length() <= 0) goto L10;
        boolean r3 = true;
    L11:
        if (r3 != true) goto L13;
        r2 = true;
        goto L13
    L10:
        r3 = false;
        goto L11
    }

    public static /* synthetic */ void n(EmojiMapManager2 r12, int r13, String r14, String r15, String r16, int r17, boolean r18, String r19, String[] r20, int r21) {
        if ((r21 & 64) == 0) goto L5;
        String r10 = null;
    L7:
        if ((r21 & 128) == 0) goto L9;
        String[] r11 = null;
    L10:
        r12.m(r13, r14, r15, r16, r17, r18, r10, r11);
        return;
    L9:
        r11 = r20;
        goto L10
    L5:
        r10 = r19;
        goto L7
    }
}
