package com.larus.bot.impl.feature.edit.feature.speakervoice;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.bean.AudioUserConfig;
import com.larus.bmhome.auth.c1;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.im.bean.bot.SpeakerVoice;
import cv8.a;
import cv8.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import p68.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b0\u0005J\"\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\rH\u0002¨\u0006\u000e"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/speakervoice/SpeakerVoiceItemViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "getTtsSpeakerGroups", "Landroidx/lifecycle/LiveData;", "Ljava/util/ArrayList;", "Lcom/larus/audio/bean/TtsSpeakerGroup;", "Lkotlin/collections/ArrayList;", "getLanguageGroup", "language", "", "ttsSpeakerGroups", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpeakerVoiceItemViewModel extends ViewModel {
    public static /* synthetic */ ArrayList Mo(SpeakerVoiceItemViewModel r0, AudioUserConfig r1) {
        return getTtsSpeakerGroups$lambda$1(r0, r1);
    }

    public static /* synthetic */ ArrayList yo(SpeakerVoiceItemViewModel r0, c1 r1) {
        return getTtsSpeakerGroups$lambda$3(r0, r1);
    }

    public final LiveData<ArrayList<h>> getTtsSpeakerGroups() {
        if (FeatureKitDelegate.b.w0().b() == false) goto L6;
        return Transformations.distinctUntilChanged(Transformations.map(AudioServiceDelegate.a.p(), new a(this)));
    L6:
        return Transformations.distinctUntilChanged(Transformations.map(AuthModelDelegate.b.j(), new b(this)));
    }

    public SpeakerVoiceItemViewModel() {
    }

    private final h getLanguageGroup(String r4, List<h> r5) {
        Iterator<T> r6 = r5.iterator();
        h r0 = null;
    L4:
        if (r6.hasNext() == false) goto L8;
        h r1 = (h) r6.next();
        if (Intrinsics.areEqual(r1.a, r4) == false) goto L4;
        r0 = r1;
        goto L4
    L8:
        return r0;
    }

    private static final ArrayList getTtsSpeakerGroups$lambda$1(SpeakerVoiceItemViewModel r5, AudioUserConfig r6) {
        Intrinsics.checkNotNullParameter(r6, "it");
        List r7 = r6.getNewVoiceList();
        if (r7 != null) goto L5;
        r7 = CollectionsKt.emptyList();
    L5:
        ArrayList r0 = new ArrayList();
        Iterator r8 = r7.iterator();
    L7:
        if (r8.hasNext() == false) goto L15;
        SpeakerVoice r1 = (SpeakerVoice) r8.next();
        h r2 = r5.getLanguageGroup(r1.getLanguage(), r0);
        if (r2 != null) goto L14;
        String r3 = r1.getLanguage();
        if (r3 != null) goto L13;
        r3 = "";
    L13:
        r2 = new h(r3, new ArrayList());
        r0.add(r2);
    L14:
        r2.b.add(r1);
        goto L7
    L15:
        return r0;
    }

    private static final ArrayList getTtsSpeakerGroups$lambda$3(SpeakerVoiceItemViewModel r5, c1 r6) {
        Intrinsics.checkNotNullParameter(r6, "it");
        com.larus.bmhome.auth.b r7 = (com.larus.bmhome.auth.b) r6.d;
        if (r7 == null) goto L5;
        List r8 = r7.p();
    L6:
        if (r8 != null) goto L8;
        r8 = CollectionsKt.emptyList();
    L8:
        ArrayList r0 = new ArrayList();
        Iterator r9 = r8.iterator();
    L10:
        if (r9.hasNext() == false) goto L18;
        SpeakerVoice r1 = (SpeakerVoice) r9.next();
        h r2 = r5.getLanguageGroup(r1.getLanguage(), r0);
        if (r2 != null) goto L17;
        String r3 = r1.getLanguage();
        if (r3 != null) goto L16;
        r3 = "";
    L16:
        r2 = new h(r3, new ArrayList());
        r0.add(r2);
    L17:
        r2.b.add(r1);
        goto L10
    L18:
        return r0;
    L5:
        r8 = null;
        goto L6
    }
}
