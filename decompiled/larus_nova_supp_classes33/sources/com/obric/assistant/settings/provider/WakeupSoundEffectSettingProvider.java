package com.obric.assistant.settings.provider;

import android.content.Context;
import android.os.Build;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.ObricWakeupSoundConfig;
import com.obric.assistant.ObricWakeupSoundOption;
import com.obric.assistant.settings.spi.IObricSettingProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\rH\u0002¨\u0006\u0011"}, d2 = {"Lcom/obric/assistant/settings/provider/WakeupSoundEffectSettingProvider;", "Lcom/obric/assistant/settings/spi/IObricSettingProvider;", "<init>", "()V", "getSettingGroups", "", "Lcom/obric/assistant/settings/spi/ObricSettingGroup;", "host", "Lcom/obric/assistant/settings/spi/IObricSettingHost;", "getSettingItems", "Lcom/obric/assistant/settings/spi/ObricSettingItem;", "(Lcom/obric/assistant/settings/spi/IObricSettingHost;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isWakeupSoundSupportedDevice", "", "isPacificProduct", "hasValidWakeupSoundConfig", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WakeupSoundEffectSettingProvider implements IObricSettingProvider {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    public WakeupSoundEffectSettingProvider() {
    }

    public static boolean c() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(Boolean.valueOf(Intrinsics.areEqual(t9a.b.a().d(), "pacific")));     // Catch: Throwable -> L4
    L6:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L9;
        FLogger.a.w("WakeupSoundEffectSettingProvider", "isPacificProduct failed: " + r2.getMessage(), r2);
    L9:
        Boolean r3 = Boolean.FALSE;
        if (Result.isFailure-impl(r1) == false) goto L13;
        r1 = r3;
    L13:
        if (((Boolean) r1).booleanValue() == false) goto L15;
        return true;
    L15:
        if (com.obric.assistant.t1.a.H() == 1) goto L22;
        return false;
    L22:
        return true;
    L4:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    @Override // com.obric.assistant.settings.spi.IObricSettingProvider
    public final List<com.obric.assistant.settings.spi.c> a(com.obric.assistant.settings.spi.b r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        if (r2.getHostContext() != null) goto L7;
        return CollectionsKt.emptyList();
    L7:
        if (Build.VERSION.SDK_INT >= 23) goto L11;
        return CollectionsKt.emptyList();
    L11:
        if (ega.a.a() == true) goto L15;
        return CollectionsKt.emptyList();
    L15:
        if (c() == true) goto L19;
        return CollectionsKt.emptyList();
    L19:
        return CollectionsKt.listOf(new com.obric.assistant.settings.spi.c("group_voice"));
    }

    @Override // com.obric.assistant.settings.spi.IObricSettingProvider
    public final Object b(com.obric.assistant.settings.spi.b r20, Continuation<? super List<? extends com.obric.assistant.settings.spi.e>> r21) {
        Context r0 = r20.getHostContext();
        if (r0 != null) goto L7;
        return CollectionsKt.emptyList();
    L7:
        if (Build.VERSION.SDK_INT >= 23) goto L11;
        return CollectionsKt.emptyList();
    L11:
        if (ega.a.a() == true) goto L15;
        return CollectionsKt.emptyList();
    L15:
        if (c() == false) goto L17;
        com.obric.assistant.t1 r1 = com.obric.assistant.t1.a;
        if (r1.b() == false) goto L21;
        ObricWakeupSoundConfig r2 = r1.x1();
        boolean r3 = false;
        if (r2.getEnable() == true) goto L25;
        FLogger.a.d("WakeupSoundEffectSettingProvider", "hide wakeup sound setting, config disabled or unavailable");
    L65:
        if (r3 == true) goto L69;
        return CollectionsKt.emptyList();
    L69:
        return CollectionsKt.listOf(new com.obric.assistant.settings.spi.a("group_voice", "wakeup_sound_effect", r0.getString(2131912594), 94, new f2(), null, new g2(), new WakeupSoundEffectSettingProvider$getSettingItems$4(null), null, false, null, null, 7968));
    L25:
        List r4 = r2.getOptions();
        if (r4 == null) goto L59;
        List r5 = CollectionsKt.filterNotNull(r4);
        if (r5 == null) goto L59;
        ArrayList r6 = new ArrayList();
        Iterator r7 = r5.iterator();
    L31:
        if (r7.hasNext() == false) goto L52;
        Object r8 = r7.next();
        ObricWakeupSoundOption r9 = (ObricWakeupSoundOption) r8;
        String r10 = r9.getId();
        boolean r11 = true;
        if (r10 != null) goto L35;
    L38:
        boolean r12 = true;
    L39:
        if (r12 == true) goto L49;
        String r13 = r9.getType();
        if (r13 != null) goto L43;
    L46:
        boolean r14 = true;
    L47:
        if (r14 == true) goto L49;
    L50:
        if (r11 == false) goto L31;
        r6.add(r8);
        goto L31
    L43:
        if (StringsKt.isBlank(r13) == true) goto L46;
        r14 = false;
    L49:
        r11 = false;
        goto L50
    L35:
        if (StringsKt.isBlank(r10) == true) goto L38;
        r12 = false;
        goto L39
    L52:
        ArrayList r15 = new ArrayList();
        Iterator r16 = r6.iterator();
    L54:
        if (r16.hasNext() == false) goto L58;
        String r17 = ((ObricWakeupSoundOption) r16.next()).getId();
        if (r17 == null) goto L54;
        r15.add(r17);
        goto L54
    L58:
        Set r18 = CollectionsKt.toSet(r15);
    L60:
        if (r18 != null) goto L62;
        r18 = SetsKt.emptySet();
    L62:
        r3 = r18.containsAll(CollectionsKt.listOf(new String[]{"classic", "smart", "doubao_same_voice"}));
        if (r3 == true) goto L65;
        FLogger.a.d("WakeupSoundEffectSettingProvider", "hide wakeup sound setting, required options missing, optionIds=" + r18);
    L59:
        r18 = null;
        goto L60
    L21:
        return CollectionsKt.emptyList();
    L17:
        return CollectionsKt.emptyList();
    }
}
