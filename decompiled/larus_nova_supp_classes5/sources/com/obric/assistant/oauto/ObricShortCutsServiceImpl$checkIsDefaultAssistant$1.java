package com.obric.assistant.oauto;

import android.content.ComponentName;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.os.Build;
import com.google.gson.Gson;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.IObricAvailableManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.oauto.ObricShortCutsServiceImpl$checkIsDefaultAssistant$1", f = "ObricShortCutsServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ObricShortCutsServiceImpl$checkIsDefaultAssistant$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ObricShortCutsServiceImpl this$0;

    public ObricShortCutsServiceImpl$checkIsDefaultAssistant$1(ObricShortCutsServiceImpl r1, Continuation<? super ObricShortCutsServiceImpl$checkIsDefaultAssistant$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricShortCutsServiceImpl$checkIsDefaultAssistant$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L135;
        ResultKt.throwOnFailure(r17);
        IObricAvailableManager r0 = (IObricAvailableManager) ServiceManager.get().getService(IObricAvailableManager.class);
        if (r0 != null) goto L7;
    L9:
        boolean r4 = false;
    L10:
        List<String> r1 = ObricShortCutsServiceImpl.a;
        boolean r2 = ObricShortCutsServiceImpl.a.a().getBoolean("key_is_default_assistant", false);
        FLogger.a.d("ObricShortCutsServiceImpl", "checkIsDefaultAssistant -> isDefaultAssistant = " + r4 + ",cacheIsDefaultAssistant=" + r2);
        if (r2 != r4) goto L15;
        return Unit.INSTANCE;
    L15:
        if (r4 == false) goto L71;
        this.this$0.getClass();
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L26
        PackageManager r13 = AppHost.a.getApplication().getPackageManager();     // Catch: Throwable -> L26
        Iterator<T> r14 = ObricShortCutsServiceImpl.a.iterator();     // Catch: Throwable -> L26
    L19:
        if (r14.hasNext() == false) goto L24;
        String r15 = (String) r14.next();     // Catch: Throwable -> L26
        List<String> r16 = ObricShortCutsServiceImpl.a;     // Catch: Throwable -> L26
        String r3 = ObricShortCutsServiceImpl.a.a().getString(r15, "default");     // Catch: Throwable -> L26
        FLogger.a.d("ObricShortCutsServiceImpl", "enableAllActivityAliases: " + r15 + ", sp_state=" + r3);     // Catch: Throwable -> L26
        if (Intrinsics.areEqual(r3, "disable") == false) goto L19;
        r13.setComponentEnabledSetting(new ComponentName(AppHost.a.getApplication(), r15), 1, 1);     // Catch: Throwable -> L26
        SharedPreferences.Editor r5 = ObricShortCutsServiceImpl.a.a().edit();     // Catch: Throwable -> L26
        r5.remove(r15);     // Catch: Throwable -> L26
        r5.apply();     // Catch: Throwable -> L26
        goto L19
    L24:
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L26
    L28:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L31;
        FLogger.a.e("ObricShortCutsServiceImpl", "enableAllActivityAliases fail: " + r7);
    L31:
        this.this$0.getClass();
    L66:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        Object r9 = Result.constructor-impl(ResultKt.createFailure(th));
    L68:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L132;
        FLogger.a.e("ObricShortCutsServiceImpl", "enableAllPinnedShortcuts fail: " + r10);
    L132:
        List<String> r11 = ObricShortCutsServiceImpl.a;
        SharedPreferences.Editor r18 = ObricShortCutsServiceImpl.a.a().edit();
        r18.putBoolean("key_is_default_assistant", r4);
        r18.apply();
        return Unit.INSTANCE;
    L33:
        if (Build.VERSION.SDK_INT < 25) goto L64;
        List<String> r19 = ObricShortCutsServiceImpl.a;
        List r20 = (List) new Gson().fromJson(ObricShortCutsServiceImpl.a.a().getString("key_disable_pinned_shortcuts", "[]"), new h().getType());     // Catch: Throwable -> L66
        ShortcutManager r21 = (ShortcutManager) AppHost.a.getApplication().getSystemService(ShortcutManager.class);     // Catch: Throwable -> L66
        if (r21 == null) goto L64;
        List<ShortcutInfo> r22 = r21.getPinnedShortcuts();     // Catch: Throwable -> L66
        Intrinsics.checkNotNull(r22);     // Catch: Throwable -> L66
        if ((!r22.isEmpty()) == false) goto L40;
        List<ShortcutInfo> r23 = r22;
    L41:
        if (r23 == null) goto L64;
        ArrayList r24 = new ArrayList();     // Catch: Throwable -> L66
        Iterator<T> r25 = r23.iterator();     // Catch: Throwable -> L66
    L44:
        if (r25.hasNext() == false) goto L48;
        Object r26 = r25.next();     // Catch: Throwable -> L66
        if ((!((ShortcutInfo) r26).isEnabled()) == false) goto L44;
        r24.add(r26);     // Catch: Throwable -> L66
        goto L44
    L48:
        ArrayList r27 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r24, 10));     // Catch: Throwable -> L66
        Iterator r28 = r24.iterator();     // Catch: Throwable -> L66
    L50:
        if (r28.hasNext() == false) goto L52;
        r27.add(((ShortcutInfo) r28.next()).getId());     // Catch: Throwable -> L66
        goto L50
    L52:
        ArrayList r29 = new ArrayList();     // Catch: Throwable -> L66
        Iterator r30 = r27.iterator();     // Catch: Throwable -> L66
    L54:
        if (r30.hasNext() == false) goto L63;
        Object r31 = r30.next();     // Catch: Throwable -> L66
        String r110 = (String) r31;     // Catch: Throwable -> L66
        if (r20 != null) goto L58;
    L60:
        boolean r111 = false;
    L61:
        if (r111 == false) goto L54;
        r29.add(r31);     // Catch: Throwable -> L66
        goto L54
    L58:
        if (r20.contains(r110) != true) goto L60;
        r111 = true;
        goto L61
    L63:
        FLogger.a.d("ObricShortCutsServiceImpl", "enableAllPinnedShortcuts enable " + r29.size() + " pinned shortcuts");     // Catch: Throwable -> L66
        r21.enableShortcuts(r29);     // Catch: Throwable -> L66
        SharedPreferences.Editor r32 = ObricShortCutsServiceImpl.a.a().edit();     // Catch: Throwable -> L66
        r32.remove("key_disable_pinned_shortcuts");     // Catch: Throwable -> L66
        r32.apply();     // Catch: Throwable -> L66
        goto L64
    L40:
        r23 = null;
    L64:
        r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L66
    L26:
        th = move-exception;
        Result.Companion r33 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    L71:
        this.this$0.getClass();
        Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L81
        PackageManager r35 = AppHost.a.getApplication().getPackageManager();     // Catch: Throwable -> L81
        Iterator<T> r36 = ObricShortCutsServiceImpl.a.iterator();     // Catch: Throwable -> L81
    L74:
        if (r36.hasNext() == false) goto L79;
        String r37 = (String) r36.next();     // Catch: Throwable -> L81
        AppHost.Companion r112 = AppHost.a;     // Catch: Throwable -> L81
        int r113 = r35.getComponentEnabledSetting(new ComponentName(r112.getApplication(), r37));     // Catch: Throwable -> L81
        FLogger.a.d("ObricShortCutsServiceImpl", "disableAllActivityAliases: " + r37 + ", state=" + r113);     // Catch: Throwable -> L81
        if (r113 != 1) goto L74;
        r35.setComponentEnabledSetting(new ComponentName(r112.getApplication(), r37), 2, 1);     // Catch: Throwable -> L81
        List<String> r38 = ObricShortCutsServiceImpl.a;     // Catch: Throwable -> L81
        SharedPreferences.Editor r39 = ObricShortCutsServiceImpl.a.a().edit();     // Catch: Throwable -> L81
        r39.putString(r37, "disable");     // Catch: Throwable -> L81
        r39.apply();     // Catch: Throwable -> L81
        goto L74
    L79:
        Object r40 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L81
    L83:
        Throwable r41 = Result.exceptionOrNull-impl(r40);
        if (r41 == null) goto L86;
        FLogger.a.e("ObricShortCutsServiceImpl", "disableAllActivityAliases fail: " + r41);
    L86:
        this.this$0.getClass();
    L109:
        th = move-exception;
        Result.Companion r42 = Result.Companion;
        Object r43 = Result.constructor-impl(ResultKt.createFailure(th));
    L111:
        Throwable r44 = Result.exceptionOrNull-impl(r43);
        if (r44 == null) goto L114;
        FLogger.a.e("ObricShortCutsServiceImpl", "disableAllPinnedShortcuts fail: " + r44);
    L114:
        this.this$0.getClass();
    L127:
        th = move-exception;
        Result.Companion r45 = Result.Companion;
        Object r46 = Result.constructor-impl(ResultKt.createFailure(th));
    L129:
        Throwable r47 = Result.exceptionOrNull-impl(r46);
        if (r47 == null) goto L132;
        FLogger.a.e("ObricShortCutsServiceImpl", "removeAllDynamicShortcuts fail: " + r47);
        goto L132
    L116:
        if (Build.VERSION.SDK_INT < 25) goto L125;
        ShortcutManager r48 = (ShortcutManager) AppHost.a.getApplication().getSystemService(ShortcutManager.class);     // Catch: Throwable -> L127
        if (r48 == null) goto L125;
        List<ShortcutInfo> r49 = r48.getDynamicShortcuts();     // Catch: Throwable -> L127
        Intrinsics.checkNotNull(r49);     // Catch: Throwable -> L127
        if ((true ^ r49.isEmpty()) == false) goto L122;
        List<ShortcutInfo> r50 = r49;
    L123:
        if (r50 == null) goto L125;
        FLogger.a.d("ObricShortCutsServiceImpl", "removeAllDynamicShortcuts remove " + r50.size() + " dynamic shortcuts");     // Catch: Throwable -> L127
        r48.removeAllDynamicShortcuts();     // Catch: Throwable -> L127
        goto L125
    L122:
        r50 = null;
    L125:
        r46 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L127
        goto L129
    L88:
        if (Build.VERSION.SDK_INT < 25) goto L107;
        ShortcutManager r51 = (ShortcutManager) AppHost.a.getApplication().getSystemService(ShortcutManager.class);     // Catch: Throwable -> L109
        if (r51 == null) goto L107;
        List<ShortcutInfo> r52 = r51.getPinnedShortcuts();     // Catch: Throwable -> L109
        Intrinsics.checkNotNull(r52);     // Catch: Throwable -> L109
        if ((!r52.isEmpty()) == true) goto L95;
        r52 = null;
    L95:
        if (r52 == null) goto L107;
        ArrayList r53 = new ArrayList();     // Catch: Throwable -> L109
        Iterator<T> r54 = r52.iterator();     // Catch: Throwable -> L109
    L98:
        if (r54.hasNext() == false) goto L102;
        Object r55 = r54.next();     // Catch: Throwable -> L109
        if (((ShortcutInfo) r55).isEnabled() == false) goto L98;
        r53.add(r55);     // Catch: Throwable -> L109
        goto L98
    L102:
        ArrayList r56 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r53, 10));     // Catch: Throwable -> L109
        Iterator r57 = r53.iterator();     // Catch: Throwable -> L109
    L104:
        if (r57.hasNext() == false) goto L106;
        r56.add(((ShortcutInfo) r57.next()).getId());     // Catch: Throwable -> L109
        goto L104
    L106:
        List<String> r58 = ObricShortCutsServiceImpl.a;     // Catch: Throwable -> L109
        SharedPreferences.Editor r59 = ObricShortCutsServiceImpl.a.a().edit();     // Catch: Throwable -> L109
        r59.putString("key_disable_pinned_shortcuts", new Gson().toJson(r56));     // Catch: Throwable -> L109
        r59.apply();     // Catch: Throwable -> L109
        FLogger.a.d("ObricShortCutsServiceImpl", "disableAllPinnedShortcuts disable " + r56.size() + " pinned shortcuts");     // Catch: Throwable -> L109
        r51.disableShortcuts(r56, AppHost.a.getApplication().getString(2131912607));     // Catch: Throwable -> L109
    L107:
        r43 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L109
    L81:
        th = move-exception;
        Result.Companion r60 = Result.Companion;
        r40 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L83
    L7:
        if (r0.a() != true) goto L9;
        r4 = true;
        goto L10
    L135:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
