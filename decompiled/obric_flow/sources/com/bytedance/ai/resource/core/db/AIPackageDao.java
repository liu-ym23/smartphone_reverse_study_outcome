package com.bytedance.ai.resource.core.db;

import ai.j0;
import android.text.TextUtils;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.resource.core.AIPackageConfig;
import com.bytedance.ai.resource.core.AIPackageDeployment;
import com.bytedance.ai.utils.c;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.h0;
import t0.d;

/* JADX INFO: loaded from: classes2.dex */
@Dao
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u001d\n\u0002\u0010\u0011\n\u0002\b\u0016\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0097@¢\u0006\u0002\u0010\fJ(\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0097@¢\u0006\u0002\u0010\fJ0\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0082@¢\u0006\u0002\u0010\u0013J0\u0010\u0014\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0080@¢\u0006\u0004\b\u0017\u0010\u0018J6\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u001a2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0080@¢\u0006\u0004\b\u001b\u0010\u0018J\u0016\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\u0097@¢\u0006\u0002\u0010\u001eJ\u0016\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u000eH\u0097@¢\u0006\u0002\u0010!J\u0016\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010$J\u0016\u0010%\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\u001eJ\u0016\u0010&\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\u001eJ\u001c\u0010'\u001a\u00020\u00152\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u001aH§@¢\u0006\u0002\u0010(J\u001e\u0010)\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H§@¢\u0006\u0002\u0010*J\u0016\u0010+\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u0005H§@¢\u0006\u0002\u0010,J&\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001a2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H§@¢\u0006\u0002\u0010*J.\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001a2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0005H§@¢\u0006\u0002\u0010/J0\u0010-\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH§@¢\u0006\u0002\u00100J\u001e\u00101\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001a2\u0006\u0010\t\u001a\u00020\u0005H§@¢\u0006\u0002\u0010,J\u0016\u00102\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001aH§@¢\u0006\u0002\u00103J\u0016\u00104\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001aH§@¢\u0006\u0002\u00103J\u0016\u00105\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001aH§@¢\u0006\u0002\u00103J\"\u00106\u001a\u00020\u00152\u0012\u00107\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000708\"\u00020\u0007H§@¢\u0006\u0002\u00109J\u001e\u0010:\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H§@¢\u0006\u0002\u0010*J\u0016\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001aH§@¢\u0006\u0002\u00103J&\u00105\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001a2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH§@¢\u0006\u0002\u0010<J\u001e\u00104\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001a2\u0006\u0010\t\u001a\u00020\u0005H§@¢\u0006\u0002\u0010,J\u0016\u0010=\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u000eH§@¢\u0006\u0002\u0010!J\u0016\u0010>\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u000eH§@¢\u0006\u0002\u0010!J\u001c\u0010?\u001a\u00020\u00152\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001aH§@¢\u0006\u0002\u0010(J\u001e\u0010A\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H§@¢\u0006\u0002\u0010*J\u0016\u0010B\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u0005H§@¢\u0006\u0002\u0010,J&\u0010C\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001a2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H§@¢\u0006\u0002\u0010*J.\u0010C\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001a2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0005H§@¢\u0006\u0002\u0010/J0\u0010C\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH§@¢\u0006\u0002\u00100J\u001e\u0010D\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001a2\u0006\u0010\t\u001a\u00020\u0005H§@¢\u0006\u0002\u0010,J\u0016\u0010E\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001aH§@¢\u0006\u0002\u00103J\u0016\u0010F\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001aH§@¢\u0006\u0002\u00103J\u0016\u0010G\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001aH§@¢\u0006\u0002\u00103J\u001e\u0010H\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001a2\u0006\u0010I\u001a\u00020\u0005H§@¢\u0006\u0002\u0010,J\"\u0010J\u001a\u00020\u00152\u0012\u0010@\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e08\"\u00020\u000eH§@¢\u0006\u0002\u0010KJ\u001e\u0010L\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H§@¢\u0006\u0002\u0010*J\u0016\u0010M\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001aH§@¢\u0006\u0002\u00103J&\u0010G\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001a2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH§@¢\u0006\u0002\u0010<J\u001e\u0010F\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001a2\u0006\u0010\t\u001a\u00020\u0005H§@¢\u0006\u0002\u0010,R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lcom/bytedance/ai/resource/core/db/AIPackageDao;", "", "<init>", "()V", "TAG", "", "queryOrActiveWidget", "Lcom/bytedance/ai/model/objects/Widget;", Constant.APPID, "packageName", "versionCode", "", "(Ljava/lang/String;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryOrActiveApplet", "Lcom/bytedance/ai/model/objects/Applet;", "queryOrActiveAIPackage", "Lcom/bytedance/ai/model/objects/AIPackage;", "aiPackageType", "Lcom/bytedance/ai/model/objects/AIPackage$AIPackageType;", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ai/model/objects/AIPackage$AIPackageType;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanOutdatedFile", "", "digest", "cleanOutdatedFile$ai_sdk_release", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "renameOutdatedFile", "", "renameOutdatedFile$ai_sdk_release", "insertInactiveWidget", "widget", "(Lcom/bytedance/ai/model/objects/Widget;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertInactiveApplet", "applet", "(Lcom/bytedance/ai/model/objects/Applet;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertInactivePackage", "finalPackage", "(Lcom/bytedance/ai/model/objects/AIPackage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertWidget", "deleteWidget", "deleteWidgets", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteWidgetById", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteWidgetByPackageName", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryWidgetById", "installStatus", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryInstalledWidgetsByPackageName", "queryAllWidgets", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryInactiveWidgets", "queryInstalledWidgets", "updateWidget", "widgets", "", "([Lcom/bytedance/ai/model/objects/Widget;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markWidgetToDelete", "queryWidgetsToDelete", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertApplet", "deleteApplet", "deleteApplets", "applets", "deleteAppletById", "deleteAppletByPackageName", "queryAppletById", "queryInstalledAppletsByPackageName", "queryAllApplets", "queryInactiveApplets", "queryInstalledApplets", "queryAppletByBotId", "botId", "updateApplet", "([Lcom/bytedance/ai/model/objects/Applet;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markAppletToDelete", "queryAppletsToDelete", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAIPackageDao.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AIPackageDao.kt\ncom/bytedance/ai/resource/core/db/AIPackageDao\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,361:1\n295#2,2:362\n295#2,2:364\n774#2:366\n865#2,2:367\n774#2:369\n865#2,2:370\n774#2:372\n865#2,2:373\n295#2,2:375\n*S KotlinDebug\n*F\n+ 1 AIPackageDao.kt\ncom/bytedance/ai/resource/core/db/AIPackageDao\n*L\n50#1:362,2\n52#1:364,2\n55#1:366\n55#1:367,2\n57#1:369\n57#1:370,2\n80#1:372\n80#1:373,2\n163#1:375,2\n*E\n"})
public abstract class AIPackageDao {
    private final String TAG;

    /* JADX INFO: renamed from: com.bytedance.ai.resource.core.db.AIPackageDao$insertInactivePackage$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.resource.core.db.AIPackageDao", f = "AIPackageDao.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4}, l = {224, 226, 232, 234, 240, 246, 248}, m = "insertInactivePackage", n = {"this", "finalPackage", "packageType", "this", "finalPackage", "packageType", "this", "finalPackage", "packageType", "duplicatesPackages", "this", "finalPackage", "packageType", "duplicatesPackages", "this", "finalPackage", "packageType"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AIPackageDao this$0;

        public AnonymousClass1(AIPackageDao r5, Continuation<? super AnonymousClass1> r10) {
            this.this$0 = r5;
            super(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            this.result = r5;
            this.label |= Integer.MIN_VALUE;
            return AIPackageDao.access$insertInactivePackage(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ai.resource.core.db.AIPackageDao$queryOrActiveAIPackage$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.resource.core.db.AIPackageDao", f = "AIPackageDao.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5}, l = {44, 46, 73, 75, 83, 85}, m = "queryOrActiveAIPackage", n = {"this", "aiPackageType", "versionCode", "this", "aiPackageType", "versionCode", "this", "aiPackageType", "installPkg", "inactivePkg", "finalPkg", "tempId", "finalId", "this", "aiPackageType", "installPkg", "inactivePkg", "finalPkg", "tempId", "finalId", "this", "installPkg", "inactivePkg", "finalPkg", "finalId", "this", "installPkg", "inactivePkg", "finalPkg", "finalId"}, s = {"L$0", "L$1", "J$0", "L$0", "L$1", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "J$1", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "J$1", "L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "L$2", "L$3", "J$0"})
    public static final class C01701 extends ContinuationImpl {
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AIPackageDao this$0;

        public C01701(AIPackageDao r5, Continuation<? super C01701> r10) {
            this.this$0 = r5;
            super(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return AIPackageDao.access$queryOrActiveAIPackage(this.this$0, null, null, null, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ai.resource.core.db.AIPackageDao$queryOrActiveAIPackage$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.resource.core.db.AIPackageDao$queryOrActiveAIPackage$4", f = "AIPackageDao.kt", i = {}, l = {97, 108}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AIPackage $finalPkg;
        final /* synthetic */ List<AIPackage> $inactivePkg;
        final /* synthetic */ AIPackage $installPkg;
        Object L$0;
        int label;
        final /* synthetic */ AIPackageDao this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass4(AIPackage r5, AIPackage r10, List<? extends AIPackage> r11, AIPackageDao r12, Continuation<? super AnonymousClass4> r13) {
            this.$installPkg = r5;
            this.$finalPkg = r10;
            this.$inactivePkg = r11;
            this.this$0 = r12;
            super(2, r13);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass4(this.$installPkg, this.$finalPkg, this.$inactivePkg, this.this$0, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            return invoke2(r5, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r12) {
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r10 = this.label;
            if (r10 == 0) goto L10;
            if (r10 == 1) goto L9;
            if (r10 != 2) goto L8;
            Iterator<AIPackage> r11 = (Iterator) this.L$0;
            ResultKt.throwOnFailure(r12);
        L23:
            if (r11.hasNext() == false) goto L33;
            AIPackage r13 = r11.next();
            if (Intrinsics.areEqual(this.$finalPkg, r13) == true) goto L23;
            if (Intrinsics.areEqual(r13.f2267n, this.$finalPkg.f2267n) == true) goto L23;
            AIPackageDao r14 = this.this$0;
            String r15 = r13.c();
            String r16 = r13.f2267n;
            this.L$0 = r11;
            this.label = 2;
            if (r14.cleanOutdatedFile$ai_sdk_release(r13.f2260c, r15, r13.f2259b, r16, this) != r5) goto L23;
        L31:
            return r5;
        L33:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            AIPackage r17 = (AIPackage) this.L$0;
            ResultKt.throwOnFailure(r12);
        L21:
            r11 = this.$inactivePkg.iterator();
            goto L23
        L10:
            ResultKt.throwOnFailure(r12);
            AIPackage r18 = this.$installPkg;
            if (r18 == null) goto L13;
            String r19 = r18.f2267n;
        L15:
            if (Intrinsics.areEqual(r19, this.$finalPkg.f2267n) == true) goto L21;
            AIPackage r110 = this.$installPkg;
            if (r110 == null) goto L21;
            AIPackageDao r20 = this.this$0;
            String r21 = r110.c();
            String r22 = r110.f2267n;
            this.L$0 = r110;
            this.label = 1;
            if (r20.cleanOutdatedFile$ai_sdk_release(r110.f2260c, r21, r110.f2259b, r22, this) != r5) goto L21;
        L13:
            r19 = null;
            goto L15
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
            return ((AnonymousClass4) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public AIPackageDao() {
        this.TAG = "AIPackageDao";
    }

    public static final /* synthetic */ Object access$insertInactivePackage(AIPackageDao r5, AIPackage r10, Continuation r11) {
        return r5.insertInactivePackage(r10, r11);
    }

    public static final /* synthetic */ Object access$queryOrActiveAIPackage(AIPackageDao r5, String r10, String r11, AIPackage.AIPackageType r12, long r13, Continuation r14) {
        return r5.queryOrActiveAIPackage(r10, r11, r12, r13, r14);
    }

    @Transaction
    public static /* synthetic */ Object insertInactiveApplet$suspendImpl(AIPackageDao r5, Applet r10, Continuation<? super Unit> r11) {
        Object r12 = r5.insertInactivePackage(r10, r11);
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r12;
    L6:
        return Unit.INSTANCE;
    }

    private final Object insertInactivePackage(AIPackage r12, Continuation<? super Unit> r13) {
        if ((r13 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r5 = (AnonymousClass1) r13;
        int r10 = r5.label;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r10 - Integer.MIN_VALUE;
    L8:
        Object r14 = r5.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r5.label) {
            case 0: goto L19;
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L16;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            default: goto L11;
        };
    L12:
        ResultKt.throwOnFailure(r14);
    L70:
        return Unit.INSTANCE;
    L13:
        ResultKt.throwOnFailure(r14);
    L65:
        return Unit.INSTANCE;
    L14:
        Iterator<? extends Widget> r15 = (Iterator) r5.L$3;
        AIPackage.AIPackageType r16 = (AIPackage.AIPackageType) r5.L$2;
        AIPackage r17 = (AIPackage) r5.L$1;
        AIPackageDao r18 = (AIPackageDao) r5.L$0;
        ResultKt.throwOnFailure(r14);
    L15:
        AIPackage r19 = r17;
        AIPackageDao r20 = r18;
    L52:
        if (r15.hasNext() == false) goto L58;
        Widget r21 = r15.next();
        if (Intrinsics.areEqual(r21.f2267n, r19.f2267n) == true) goto L52;
        String r22 = r21.c();
        String r23 = r21.f2267n;
        r5.L$0 = r20;
        r5.L$1 = r19;
        r5.L$2 = r16;
        r5.L$3 = r15;
        r5.label = 5;
        if (r20.cleanOutdatedFile$ai_sdk_release(r21.f2260c, r22, r21.f2259b, r23, r5) != r11) goto L52;
    L68:
        return r11;
    L58:
        AIPackage.AIPackageType r24 = r16;
        AIPackageDao r110 = r20;
    L60:
        if (r24 != AIPackage.AIPackageType.f2279a) goto L66;
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type com.bytedance.ai.model.objects.Applet");
        r5.L$0 = null;
        r5.L$1 = null;
        r5.L$2 = null;
        r5.L$3 = null;
        r5.label = 6;
        if (r110.insertApplet((Applet) r19, r5) != r11) goto L65;
    L66:
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type com.bytedance.ai.model.objects.Widget");
        r5.L$0 = null;
        r5.L$1 = null;
        r5.L$2 = null;
        r5.L$3 = null;
        r5.label = 7;
        if (r110.insertWidget((Widget) r19, r5) != r11) goto L70;
    L16:
        List<? extends Widget> r111 = (List) r5.L$3;
        r16 = (AIPackage.AIPackageType) r5.L$2;
        r17 = (AIPackage) r5.L$1;
        r18 = (AIPackageDao) r5.L$0;
        ResultKt.throwOnFailure(r14);
    L50:
        r15 = r111.iterator();
        goto L15
    L17:
        AIPackage.AIPackageType r112 = (AIPackage.AIPackageType) r5.L$2;
        r12 = (AIPackage) r5.L$1;
        AIPackageDao r25 = (AIPackageDao) r5.L$0;
        ResultKt.throwOnFailure(r14);
        AIPackage.AIPackageType r113 = r112;
        AIPackageDao this = r25;
        Object r26 = r14;
    L36:
        List<? extends Widget> r27 = (List) r26;
    L32:
        AIPackage r114 = r12;
        r110 = this;
        r111 = r27;
        r24 = r113;
        r19 = r114;
        if (r111 == null) goto L60;
        if (r111.isEmpty() == true) goto L60;
        if (r24 != AIPackage.AIPackageType.f2279a) goto L46;
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type kotlin.collections.List<com.bytedance.ai.model.objects.Applet>");
        r5.L$0 = r110;
        r5.L$1 = r19;
        r5.L$2 = r24;
        r5.L$3 = r111;
        r5.label = 3;
        if (r110.deleteApplets(r111, r5) == r11) goto L68;
    L49:
        r18 = r110;
        r16 = r24;
        r17 = r19;
        goto L50
    L46:
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type kotlin.collections.List<com.bytedance.ai.model.objects.Widget>");
        r5.L$0 = r110;
        r5.L$1 = r19;
        r5.L$2 = r24;
        r5.L$3 = r111;
        r5.label = 4;
        if (r110.deleteWidgets(r111, r5) != r11) goto L49;
    L18:
        AIPackage.AIPackageType r115 = (AIPackage.AIPackageType) r5.L$2;
        r12 = (AIPackage) r5.L$1;
        AIPackageDao r28 = (AIPackageDao) r5.L$0;
        ResultKt.throwOnFailure(r14);
        r113 = r115;
        this = r28;
        Object r29 = r14;
    L31:
        r27 = (List) r29;
        goto L32
    L19:
        ResultKt.throwOnFailure(r14);
        if (Intrinsics.areEqual(r12.f2274v, "inactive") == true) goto L26;
        String r116 = this.TAG;
        String r117 = "insert inactive package failed! package status isn't inactive, unique id: " + r12.f();
        Intrinsics.checkNotNullParameter(r116, "tag");
        d r118 = c.f2846a;
        if (r118 == null) goto L25;
        r118.e(r116, r117);
    L25:
        return Unit.INSTANCE;
    L26:
        r113 = r12.e();
        AIPackage.AIPackageType r30 = AIPackage.AIPackageType.f2279a;
        String r31 = r12.f2259b;
        if (r113 != r30) goto L33;
        String r32 = r12.c();
        r5.L$0 = this;
        r5.L$1 = r12;
        r5.L$2 = r113;
        r5.label = 1;
        r29 = queryAppletById(r32, r31, "inactive", r5);
        if (r29 != r11) goto L31;
    L33:
        String r33 = r12.c();
        r5.L$0 = this;
        r5.L$1 = r12;
        r5.L$2 = r113;
        r5.label = 2;
        r26 = queryWidgetById(r33, r31, "inactive", r5);
        if (r26 != r11) goto L36;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r5 = new AnonymousClass1(this, r13);
        goto L8
    }

    @Transaction
    public static /* synthetic */ Object insertInactiveWidget$suspendImpl(AIPackageDao r5, Widget r10, Continuation<? super Unit> r11) {
        Object r12 = r5.insertInactivePackage(r10, r11);
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r12;
    L6:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.bytedance.ai.resource.core.db.AIPackageDao, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r23v1, types: [com.bytedance.ai.resource.core.db.AIPackageDao] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v6, types: [com.bytedance.ai.resource.core.db.AIPackageDao, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r9v4, types: [com.bytedance.ai.model.objects.Widget[]] */
    /* JADX WARN: Type inference failed for: r9v8, types: [com.bytedance.ai.model.objects.Applet[]] */
    private final Object queryOrActiveAIPackage(String r20, String r21, AIPackage.AIPackageType r22, long r23, Continuation<? super AIPackage> r25) {
        AIPackageDao r5 = this;
        long r10 = r23;
        if ((r25 instanceof C01701) == false) goto L7;
        C01701 r11 = (C01701) r25;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ArrayList r15 = null;
        switch(r11.label) {
            case 0: goto L16;
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L12;
            default: goto L11;
        };
    L12:
        long r16 = r11.J$0;
        List r17 = (List) r11.L$4;
        AIPackage r18 = (AIPackage) r11.L$3;
        List r19 = (List) r11.L$2;
        AIPackage r24 = (AIPackage) r11.L$1;
        AIPackageDao r26 = (AIPackageDao) r11.L$0;
        ResultKt.throwOnFailure(r13);
        List r110 = r19;
        AIPackage r27 = r24;
        ?? r28 = r26;
    L125:
        r18.f2266m = r16;
        BuildersKt.launch$default(h0.a(t2.b.f22089a), null, null, new AnonymousClass4(r27, r18, r110, r28, null), 3, null);
        return r18;
    L13:
        r16 = r11.J$1;
        long r29 = r11.J$0;
        AIPackage r30 = (AIPackage) r11.L$4;
        List r31 = (List) r11.L$3;
        r27 = (AIPackage) r11.L$2;
        AIPackage.AIPackageType r111 = (AIPackage.AIPackageType) r11.L$1;
        AIPackageDao r112 = (AIPackageDao) r11.L$0;
        ResultKt.throwOnFailure(r13);
        r18 = r30;
        long r32 = r29;
        r110 = r31;
        ?? r33 = r112;
    L109:
        r18.f2266m = r32;
        ArrayList r34 = new ArrayList();
        Iterator r35 = r110.iterator();
    L111:
        if (r35.hasNext() == false) goto L115;
        Object r36 = r35.next();
        if (((AIPackage) r36).f2266m == r16) goto L111;
        r34.add(r36);
        goto L111
    L115:
        r28 = r33;
        if (r34.isEmpty() == true) goto L125;
        if (r111 != AIPackage.AIPackageType.f2279a) goto L122;
        r11.L$0 = r33;
        r11.L$1 = r27;
        r11.L$2 = r110;
        r11.L$3 = r18;
        r11.L$4 = r34;
        r11.J$0 = r16;
        r11.label = 5;
        Object r37 = r33.deleteApplets(r34, r11);
        r28 = r33;
        if (r37 != r14) goto L125;
    L124:
        return r14;
    L122:
        r11.L$0 = r33;
        r11.L$1 = r27;
        r11.L$2 = r110;
        r11.L$3 = r18;
        r11.L$4 = r34;
        r11.J$0 = r16;
        r11.label = 6;
        Object r38 = r33.deleteWidgets(r34, r11);
        r28 = r33;
        if (r38 != r14) goto L125;
    L14:
        long r39 = r11.J$0;
        AIPackage.AIPackageType r40 = (AIPackage.AIPackageType) r11.L$1;
        AIPackageDao r41 = (AIPackageDao) r11.L$0;
        ResultKt.throwOnFailure(r13);
        r10 = r39;
        AIPackageDao r42 = r41;
    L30:
        List r43 = (List) r13;
        ?? r44 = r42;
    L32:
        if (r10 != 0) goto L49;
        if (r43 == null) goto L62;
        Iterator r113 = r43.iterator();
    L36:
        if (r113.hasNext() == false) goto L47;
        Object r114 = r113.next();
        AIPackage r115 = (AIPackage) r114;
        if (Intrinsics.areEqual(r115.f2274v, "installed") == true) goto L41;
        if (Intrinsics.areEqual(r115.f2274v, "") == false) goto L36;
    L41:
        Integer r116 = r115.f2275w;
        if (r116 == null) goto L36;
        if (r116.intValue() != 0) goto L36;
    L48:
        AIPackage r117 = (AIPackage) r114;
    L64:
        if (r10 != 0) goto L78;
        if (r43 == null) goto L87;
        ArrayList r45 = new ArrayList();
        Iterator r46 = r43.iterator();
    L68:
        if (r46.hasNext() == false) goto L77;
        Object r47 = r46.next();
        AIPackage r48 = (AIPackage) r47;
        if (Intrinsics.areEqual(r48.f2274v, "inactive") == false) goto L68;
        Integer r49 = r48.f2275w;
        if (r49 == null) goto L68;
        if (r49.intValue() != 0) goto L68;
        r45.add(r47);
    L77:
        r15 = r45;
    L87:
        if (r15 != null) goto L89;
    L127:
        return r117;
    L89:
        if (r15.isEmpty() == true) goto L127;
        AIPackage r50 = (AIPackage) CollectionsKt.first(r15);
        r32 = r50.f2266m;
        if (r117 == null) goto L94;
        long r51 = r117.f2266m;
    L95:
        String r118 = r44.TAG;
        StringBuilder r119 = new StringBuilder("find inactive package: ");
        r119.append(r50.f2259b);
        r119.append(", appId: ");
        r119.append(r50.c());
        r119.append(", version code: ");
        ArrayList r120 = r15;
        String r121 = j0.o(r119, r50.f2260c, " ===> update as installed package");
        Intrinsics.checkNotNullParameter(r118, "tag");
        d r122 = c.f2846a;
        if (r122 == null) goto L98;
        r122.d(r118, r121);
    L98:
        if (r117 == null) goto L100;
        r50.f2266m = r117.f2266m;
    L100:
        Intrinsics.checkNotNullParameter("installed", "<set-?>");
        r50.f2274v = "installed";
        if (r40 != AIPackage.AIPackageType.f2279a) goto L105;
        Intrinsics.checkNotNull(r50, "null cannot be cast to non-null type com.bytedance.ai.model.objects.Applet");
        ?? r52 = {r50};
        r11.L$0 = r44;
        r11.L$1 = r40;
        r11.L$2 = r117;
        r110 = r120;
        r11.L$3 = r110;
        r11.L$4 = r50;
        r11.J$0 = r32;
        r11.J$1 = r51;
        r11.label = 3;
        if (r44.updateApplet(r52, r11) == r14) goto L124;
    L108:
        r111 = r40;
        r27 = r117;
        r18 = r50;
        long r123 = r51;
        r33 = r44;
        r16 = r123;
        goto L109
    L105:
        r110 = r120;
        Intrinsics.checkNotNull(r50, "null cannot be cast to non-null type com.bytedance.ai.model.objects.Widget");
        ?? r53 = {r50};
        r11.L$0 = r44;
        r11.L$1 = r40;
        r11.L$2 = r117;
        r11.L$3 = r110;
        r11.L$4 = r50;
        r11.J$0 = r32;
        r11.J$1 = r51;
        r11.label = 4;
        if (r44.updateWidget(r53, r11) != r14) goto L108;
    L94:
        r51 = r32;
        goto L95
    L78:
        if (r43 == null) goto L87;
        r45 = new ArrayList();
        Iterator r54 = r43.iterator();
    L81:
        if (r54.hasNext() == false) goto L77;
        Object r124 = r54.next();
        AIPackage r125 = (AIPackage) r124;
        if (Intrinsics.areEqual(r125.f2274v, "inactive") == false) goto L81;
        if (r125.f2260c != r10) goto L81;
        r45.add(r124);
        goto L81
    L47:
        r114 = null;
    L62:
        r117 = null;
        goto L64
    L49:
        if (r43 == null) goto L62;
        Iterator r126 = r43.iterator();
    L52:
        if (r126.hasNext() == false) goto L60;
        Object r127 = r126.next();
        AIPackage r128 = (AIPackage) r127;
        if (Intrinsics.areEqual(r128.f2274v, "installed") == true) goto L58;
        if (Intrinsics.areEqual(r128.f2274v, "") == false) goto L52;
    L58:
        if (r128.f2260c != r10) goto L52;
    L61:
        r117 = (AIPackage) r127;
        goto L64
    L60:
        r127 = null;
        goto L61
    L15:
        long r55 = r11.J$0;
        r40 = (AIPackage.AIPackageType) r11.L$1;
        AIPackageDao r56 = (AIPackageDao) r11.L$0;
        ResultKt.throwOnFailure(r13);
        r10 = r55;
        AIPackageDao r57 = r56;
    L25:
        r43 = (List) r13;
        r44 = r57;
        goto L32
    L16:
        ResultKt.throwOnFailure(r13);
        if (r22 != AIPackage.AIPackageType.f2281c) goto L20;
        return null;
    L20:
        if (r22 != AIPackage.AIPackageType.f2279a) goto L26;
        r11.L$0 = r5;
        r11.L$1 = r22;
        r11.J$0 = r10;
        r11.label = 1;
        r13 = r5.queryAppletById(r20, r21, r11);
        if (r13 == r14) goto L124;
        r40 = r22;
        r57 = r5;
        goto L25
    L26:
        r11.L$0 = r5;
        r11.L$1 = r22;
        r11.J$0 = r10;
        r11.label = 2;
        r13 = r5.queryWidgetById(r20, r21, r11);
        if (r13 == r14) goto L124;
        r40 = r22;
        r42 = r5;
        goto L30
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r11 = new C01701(r5, r25);
        goto L8
    }

    @Transaction
    public static /* synthetic */ Object queryOrActiveApplet$suspendImpl(AIPackageDao r10, String r11, String r12, long r13, Continuation<? super Applet> r14) {
        Object r15 = r10.queryOrActiveAIPackage(r11, r12, AIPackage.AIPackageType.f2279a, r13, r14);
        if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r15;
    L6:
        return (Applet) r15;
    }

    @Transaction
    public static /* synthetic */ Object queryOrActiveWidget$suspendImpl(AIPackageDao r10, String r11, String r12, long r13, Continuation<? super Widget> r14) {
        Object r15 = r10.queryOrActiveAIPackage(r11, r12, AIPackage.AIPackageType.f2280b, r13, r14);
        if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r15;
    L6:
        return (Widget) r15;
    }

    public final Object cleanOutdatedFile$ai_sdk_release(long r33, String r35, String r36, String r37, Continuation<? super Unit> r38) {
        long r12 = r33;
        if ((r38 instanceof AIPackageDao$cleanOutdatedFile$1) == false) goto L8;
        AIPackageDao$cleanOutdatedFile$1 r5 = (AIPackageDao$cleanOutdatedFile$1) r38;
        int r10 = r5.label;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L8;
        r5.label = r10 - Integer.MIN_VALUE;
    L7:
        AIPackageDao$cleanOutdatedFile$1 r15 = r5;
        Object r11 = r15.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r15.label;
        boolean r16 = false;
        if (r14 == 0) goto L17;
        if (r14 == 1) goto L16;
        if (r14 != 2) goto L15;
        long r17 = r15.J$0;
        AIPackageDeployment.AIPackageDeploymentItem r18 = (AIPackageDeployment.AIPackageDeploymentItem) r15.L$4;
        String r19 = (String) r15.L$3;
        String r110 = (String) r15.L$2;
        String r111 = (String) r15.L$1;
        AIPackageDao r112 = (AIPackageDao) r15.L$0;
        ResultKt.throwOnFailure(r11);
        String r20 = ", appId: ";
        String r21 = ", version code: ";
        String r22 = ", packageName: ";
        String r23 = ", digest: ";
        String r24 = "tag";
        String r113 = "<this>";
    L31:
        Collection r25 = (Collection) r11;
        if (r25 != null) goto L34;
    L37:
        boolean r26 = c.i(AIPackageConfig.a(r18));
        String r27 = r112.TAG;
        StringBuilder r28 = new StringBuilder("cleaning base zip. result: ");
        r28.append(r26);
        String r29 = r20;
        r28.append(r29);
        r28.append(r111);
        String r30 = r22;
        r28.append(r30);
        r28.append(r110);
        String r31 = r21;
        r28.append(r31);
        r28.append(r17);
        String r32 = r23;
        r28.append(r32);
        r28.append(r19);
        String r34 = r28.toString();
        String r114 = r24;
        Intrinsics.checkNotNullParameter(r27, r114);
        d r115 = c.f2846a;
        if (r115 == null) goto L40;
        r115.d(r27, r34);
    L40:
        Intrinsics.checkNotNullParameter(r18, "deploymentInfo");
        StringBuilder r39 = new StringBuilder();
        r39.append(AIPackageConfig.f2571a);
        r39.append('/');
        jm.c.f(r18, r39, "/base_");
        r39.append(r18.getVersionCode());
        String r40 = r39.toString();
        String r41 = r113;
        Intrinsics.checkNotNullParameter(r40, r41);
        if (TextUtils.isEmpty(r40) == true) goto L46;
        File r116 = new File(r40);
        if (r116.exists() == false) goto L46;
        boolean r42 = FilesKt.deleteRecursively(r116);
    L47:
        String r117 = r112.TAG;
        AIPackageDeployment.AIPackageDeploymentItem r310 = r18;
        String r43 = "cleaning base dir. result: " + r42 + r29 + r111 + r30 + r110 + r31 + r17 + r32 + r19;
        Intrinsics.checkNotNullParameter(r117, r114);
        d r44 = c.f2846a;
        if (r44 == null) goto L50;
        r44.d(r117, r43);
    L50:
        r18 = r310;
        String r118 = r111;
        long r311 = r17;
        String r45 = r110;
        AIPackageDao r46 = r112;
        r12 = r311;
    L51:
        boolean r47 = c.i(AIPackageConfig.c(r18));
        String r119 = r46.TAG;
        AIPackageDao r120 = r46;
        String r48 = "cleaning package zip, result: " + r47 + r29 + r118 + r30 + r45 + r31 + r12 + r32 + r19;
        Intrinsics.checkNotNullParameter(r119, r114);
        d r49 = c.f2846a;
        if (r49 == null) goto L54;
        r49.d(r119, r48);
    L54:
        String r50 = AIPackageConfig.b(r18);
        Intrinsics.checkNotNullParameter(r50, r41);
        if (TextUtils.isEmpty(r50) == true) goto L60;
        File r51 = new File(r50);
        if (r51.exists() == false) goto L60;
        r16 = FilesKt.deleteRecursively(r51);
    L60:
        String r52 = r120.TAG;
        String r53 = "cleaning package dir, result: " + r16 + r29 + r118 + r30 + r45 + r31 + r12 + r32 + r19;
        Intrinsics.checkNotNullParameter(r52, r114);
        d r54 = c.f2846a;
        if (r54 == null) goto L64;
        r54.d(r52, r53);
    L64:
        return Unit.INSTANCE;
    L46:
        r42 = false;
        goto L47
    L34:
        if (r25.isEmpty() == true) goto L37;
        r310 = r18;
        r29 = r20;
        r31 = r21;
        r30 = r22;
        r32 = r23;
        r114 = r24;
        r41 = r113;
        goto L50
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r12 = r15.J$0;
        r18 = (AIPackageDeployment.AIPackageDeploymentItem) r15.L$4;
        r19 = (String) r15.L$3;
        r45 = (String) r15.L$2;
        r118 = (String) r15.L$1;
        r46 = (AIPackageDao) r15.L$0;
        ResultKt.throwOnFailure(r11);
        Object r55 = r13;
    L21:
        Collection r56 = (Collection) r11;
        if (r56 != null) goto L24;
    L27:
        r15.L$0 = r46;
        r15.L$1 = r118;
        r15.L$2 = r45;
        r15.L$3 = r19;
        r15.L$4 = r18;
        r15.J$0 = r12;
        r15.label = 2;
        r11 = r46.queryInstalledWidgets(r45, r12, r15);
        if (r11 != r55) goto L30;
    L29:
        return r55;
    L30:
        r110 = r45;
        r112 = r46;
        r17 = r12;
        r111 = r118;
        goto L31
    L24:
        if (r56.isEmpty() == true) goto L27;
        r29 = ", appId: ";
        r31 = ", version code: ";
        r30 = ", packageName: ";
        r32 = ", digest: ";
        r114 = "tag";
        r41 = "<this>";
        goto L51
    L17:
        ResultKt.throwOnFailure(r11);
        AIPackageDeployment.AIPackageDeploymentItem r57 = new AIPackageDeployment.AIPackageDeploymentItem(r35, r36, r33, null, r37, null, false, 104, null);
        r15.L$0 = this;
        r15.L$1 = r35;
        r15.L$2 = r36;
        r19 = r37;
        r15.L$3 = r19;
        r15.L$4 = r57;
        r15.J$0 = r12;
        r15.label = 1;
        Object r58 = queryInstalledApplets(r36, r12, r15);
        r55 = r13;
        if (r58 == r55) goto L29;
        r46 = this;
        r18 = r57;
        r45 = r36;
        r118 = r35;
        r11 = r58;
    L8:
        r5 = new AIPackageDao$cleanOutdatedFile$1(this, r38);
        goto L7
    }

    @Delete
    public abstract Object deleteApplet(Applet r5, Continuation<? super Unit> r10);

    @Query("DELETE FROM ai_applet_info WHERE applet_id = :appId AND package_name = :packageName")
    public abstract Object deleteAppletById(String r5, String r10, Continuation<? super Unit> r11);

    @Query("DELETE FROM ai_applet_info WHERE package_name = :packageName")
    public abstract Object deleteAppletByPackageName(String r5, Continuation<? super Unit> r10);

    @Delete
    public abstract Object deleteApplets(List<Applet> r5, Continuation<? super Unit> r10);

    @Delete
    public abstract Object deleteWidget(Widget r5, Continuation<? super Unit> r10);

    @Query("DELETE FROM ai_widget_info WHERE widget_id = :appId AND package_name = :packageName")
    public abstract Object deleteWidgetById(String r5, String r10, Continuation<? super Unit> r11);

    @Query("DELETE FROM ai_widget_info WHERE package_name = :packageName")
    public abstract Object deleteWidgetByPackageName(String r5, Continuation<? super Unit> r10);

    @Delete
    public abstract Object deleteWidgets(List<? extends Widget> r5, Continuation<? super Unit> r10);

    @Insert
    public abstract Object insertApplet(Applet r5, Continuation<? super Unit> r10);

    @Transaction
    public Object insertInactiveApplet(Applet r5, Continuation<? super Unit> r10) {
        return insertInactiveApplet$suspendImpl(this, r5, r10);
    }

    @Transaction
    public Object insertInactiveWidget(Widget r5, Continuation<? super Unit> r10) {
        return insertInactiveWidget$suspendImpl(this, r5, r10);
    }

    @Insert
    public abstract Object insertWidget(Widget r5, Continuation<? super Unit> r10);

    @Query("UPDATE ai_applet_info SET ready_for_deleting = 1 WHERE applet_id = :appId AND package_name = :packageName")
    public abstract Object markAppletToDelete(String r5, String r10, Continuation<? super Unit> r11);

    @Query("UPDATE ai_widget_info SET ready_for_deleting = 1 WHERE widget_id = :appId AND package_name = :packageName")
    public abstract Object markWidgetToDelete(String r5, String r10, Continuation<? super Unit> r11);

    @Query("SELECT * FROM ai_applet_info")
    public abstract Object queryAllApplets(Continuation<? super List<Applet>> r5);

    @Query("SELECT * FROM ai_widget_info")
    public abstract Object queryAllWidgets(Continuation<? super List<? extends Widget>> r5);

    @Query("SELECT * FROM ai_applet_info WHERE status = 'installed' AND bot_id = :botId")
    public abstract Object queryAppletByBotId(String r5, Continuation<? super List<Applet>> r10);

    @Query("SELECT * FROM ai_applet_info WHERE applet_id = :appId AND package_name = :packageName AND status = :installStatus AND version_code = :versionCode")
    public abstract Object queryAppletById(String r5, String r10, String r11, long r12, Continuation<? super Applet> r13);

    @Query("SELECT * FROM ai_applet_info WHERE applet_id = :appId AND package_name = :packageName AND status = :installStatus ORDER BY ut DESC")
    public abstract Object queryAppletById(String r5, String r10, String r11, Continuation<? super List<Applet>> r12);

    @Query("SELECT * FROM ai_applet_info WHERE applet_id = :appId AND package_name = :packageName ORDER BY ut DESC")
    public abstract Object queryAppletById(String r5, String r10, Continuation<? super List<Applet>> r11);

    @Query("SELECT * FROM ai_applet_info WHERE ready_for_deleting = 1")
    public abstract Object queryAppletsToDelete(Continuation<? super List<Applet>> r5);

    @Query("SELECT * FROM ai_applet_info WHERE package_name = :packageName AND status = 'inactive' AND ready_for_deleting = 0")
    public abstract Object queryInactiveApplets(String r5, Continuation<? super List<Applet>> r10);

    @Query("SELECT * FROM ai_applet_info WHERE status = 'inactive'")
    public abstract Object queryInactiveApplets(Continuation<? super List<Applet>> r5);

    @Query("SELECT * FROM ai_widget_info WHERE package_name = :packageName AND status = 'inactive' AND ready_for_deleting = 0")
    public abstract Object queryInactiveWidgets(String r5, Continuation<? super List<? extends Widget>> r10);

    @Query("SELECT * FROM ai_widget_info WHERE status = 'inactive'")
    public abstract Object queryInactiveWidgets(Continuation<? super List<? extends Widget>> r5);

    @Query("SELECT * FROM ai_applet_info WHERE package_name = :packageName AND status = 'installed' AND ready_for_deleting = 0 AND version_code = :versionCode")
    public abstract Object queryInstalledApplets(String r5, long r10, Continuation<? super List<Applet>> r11);

    @Query("SELECT * FROM ai_applet_info WHERE status = 'installed' AND ready_for_deleting = 0")
    public abstract Object queryInstalledApplets(Continuation<? super List<Applet>> r5);

    @Query("SELECT * FROM ai_applet_info WHERE package_name = :packageName AND status = 'installed' AND ready_for_deleting = 0")
    public abstract Object queryInstalledAppletsByPackageName(String r5, Continuation<? super List<Applet>> r10);

    @Query("SELECT * FROM ai_widget_info WHERE package_name = :packageName AND status = 'installed' AND ready_for_deleting = 0 AND version_code = :versionCode")
    public abstract Object queryInstalledWidgets(String r5, long r10, Continuation<? super List<? extends Widget>> r11);

    @Query("SELECT * FROM ai_widget_info WHERE status = 'installed' AND ready_for_deleting = 0")
    public abstract Object queryInstalledWidgets(Continuation<? super List<? extends Widget>> r5);

    @Query("SELECT * FROM ai_widget_info WHERE package_name = :packageName AND status = 'installed' AND ready_for_deleting = 0")
    public abstract Object queryInstalledWidgetsByPackageName(String r5, Continuation<? super List<? extends Widget>> r10);

    @Transaction
    public Object queryOrActiveApplet(String r5, String r10, long r11, Continuation<? super Applet> r12) {
        return queryOrActiveApplet$suspendImpl(this, r5, r10, r11, r12);
    }

    @Transaction
    public Object queryOrActiveWidget(String r5, String r10, long r11, Continuation<? super Widget> r12) {
        return queryOrActiveWidget$suspendImpl(this, r5, r10, r11, r12);
    }

    @Query("SELECT * FROM ai_widget_info WHERE widget_id = :appId AND package_name = :packageName AND status = :installStatus AND version_code = :versionCode")
    public abstract Object queryWidgetById(String r5, String r10, String r11, long r12, Continuation<? super Widget> r13);

    @Query("SELECT * FROM ai_widget_info WHERE widget_id = :appId AND package_name = :packageName AND status = :installStatus ORDER BY ut DESC")
    public abstract Object queryWidgetById(String r5, String r10, String r11, Continuation<? super List<? extends Widget>> r12);

    @Query("SELECT * FROM ai_widget_info WHERE widget_id = :appId AND package_name = :packageName ORDER BY ut DESC")
    public abstract Object queryWidgetById(String r5, String r10, Continuation<? super List<? extends Widget>> r11);

    @Query("SELECT * FROM ai_widget_info WHERE ready_for_deleting = 1")
    public abstract Object queryWidgetsToDelete(Continuation<? super List<? extends Widget>> r5);

    public final Object renameOutdatedFile$ai_sdk_release(long r29, String r31, String r32, String r33, Continuation<? super List<String>> r34) {
        String r14 = r32;
        if ((r34 instanceof AIPackageDao$renameOutdatedFile$1) == false) goto L8;
        AIPackageDao$renameOutdatedFile$1 r5 = (AIPackageDao$renameOutdatedFile$1) r34;
        int r10 = r5.label;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L8;
        r5.label = r10 - Integer.MIN_VALUE;
    L7:
        AIPackageDao$renameOutdatedFile$1 r15 = r5;
        Object r11 = r15.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r15.label;
        if (r13 == 0) goto L17;
        if (r13 == 1) goto L16;
        if (r13 != 2) goto L15;
        long r16 = r15.J$0;
        List r17 = (List) r15.L$4;
        AIPackageDeployment.AIPackageDeploymentItem r18 = (AIPackageDeployment.AIPackageDeploymentItem) r15.L$3;
        String r19 = (String) r15.L$2;
        String r20 = (String) r15.L$1;
        AIPackageDao r21 = (AIPackageDao) r15.L$0;
        ResultKt.throwOnFailure(r11);
        AIPackageDao r110 = r21;
    L34:
        List r22 = (List) r11;
        Object r111 = null;
        if (r22 == null) goto L43;
        Iterator r112 = r22.iterator();
    L38:
        if (r112.hasNext() == false) goto L42;
        Object r113 = r112.next();
        if (Intrinsics.areEqual(((Widget) r113).F, r20) == false) goto L38;
        r111 = r113;
    L42:
        r111 = (Widget) r111;
    L43:
        if (r111 == null) goto L49;
        String r23 = r110.TAG;
        StringBuilder r24 = new StringBuilder();
        r24.append(r19);
        r24.append(r7);
        r24.append(r20);
        r24.append(": ");
        String r25 = j0.o(r24, r16, ": the same version is installed again. skip removing files");
        Intrinsics.checkNotNullParameter(r23, "tag");
        d r26 = c.f2846a;
        if (r26 == null) goto L47;
        r26.w(r23, r25);
    L47:
        return r17;
    L49:
        if (r22 != null) goto L51;
    L52:
        String r27 = AIPackageConfig.a(r18);
        Intrinsics.checkNotNullParameter(r18, "deploymentInfo");
        StringBuilder r28 = new StringBuilder();
        r28.append(AIPackageConfig.f2571a);
        r28.append('/');
        jm.c.f(r18, r28, "/base_");
        r28.append(r18.getVersionCode());
        r28.append("_delete.zip");
        String r30 = r28.toString();
        if (c.j(r27, r30) == false) goto L58;
        String r35 = r110.TAG;
        String r114 = androidx.room.jarjarred.org.antlr.runtime.a.r("add ", r30, " into the delete list", r35, r6);
        d r115 = c.f2846a;
        if (r115 == null) goto L57;
        r115.d(r35, r114);
    L57:
        r17.add(r30);
    L58:
        Intrinsics.checkNotNullParameter(r18, "deploymentInfo");
        String r36 = AIPackageConfig.f2571a + '/' + r18.getPackageName() + "/base_" + r18.getVersionCode();
        Intrinsics.checkNotNullParameter(r18, "deploymentInfo");
        String r37 = AIPackageConfig.f2571a + '/' + r18.getPackageName() + "/base_" + r18.getVersionCode() + "_delete";
        if (c.j(r36, r37) == false) goto L64;
        String r38 = r110.TAG;
        String r39 = androidx.room.jarjarred.org.antlr.runtime.a.r("add ", r37, " into the delete list", r38, r6);
        d r116 = c.f2846a;
        if (r116 == null) goto L63;
        r116.d(r38, r39);
    L63:
        r17.add(r37);
    L64:
        String r40 = AIPackageConfig.c(r18);
        Intrinsics.checkNotNullParameter(r18, "deploymentInfo");
        String r41 = AIPackageConfig.c(r18) + "_delete";
        if (c.j(r40, r41) == false) goto L70;
        String r42 = r110.TAG;
        String r43 = androidx.room.jarjarred.org.antlr.runtime.a.r("add ", r41, " into the delete list", r42, r6);
        d r117 = c.f2846a;
        if (r117 == null) goto L69;
        r117.d(r42, r43);
    L69:
        r17.add(r41);
    L70:
        String r44 = AIPackageConfig.b(r18);
        Intrinsics.checkNotNullParameter(r18, "deploymentInfo");
        String r45 = AIPackageConfig.b(r18) + "_delete";
        if (c.j(r44, r45) == false) goto L76;
        String r46 = r110.TAG;
        String r47 = androidx.room.jarjarred.org.antlr.runtime.a.r("add ", r45, " into the delete list", r46, r6);
        d r48 = c.f2846a;
        if (r48 == null) goto L75;
        r48.d(r46, r47);
    L75:
        r17.add(r45);
    L76:
        return r17;
    L51:
        if (r22.isEmpty() == false) goto L64;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r16 = r15.J$0;
        r17 = (List) r15.L$4;
        r18 = (AIPackageDeployment.AIPackageDeploymentItem) r15.L$3;
        String r49 = (String) r15.L$2;
        r20 = (String) r15.L$1;
        r110 = (AIPackageDao) r15.L$0;
        ResultKt.throwOnFailure(r11);
        r14 = r49;
        Object r50 = r12;
    L21:
        List r51 = (List) r11;
        if (r51 == null) goto L30;
        if (r51.isEmpty() == true) goto L30;
        String r52 = r110.TAG;
        StringBuilder r53 = new StringBuilder();
        r53.append(r14);
        r53.append(": ");
        r53.append(r20);
        r53.append(": ");
        String r54 = j0.o(r53, r16, ": the same version is installed again. skip removing files");
        Intrinsics.checkNotNullParameter(r52, "tag");
        d r55 = c.f2846a;
        if (r55 == null) goto L29;
        r55.w(r52, r54);
    L29:
        return r17;
    L30:
        r15.L$0 = r110;
        r15.L$1 = r20;
        r15.L$2 = r14;
        r15.L$3 = r18;
        r15.L$4 = r17;
        r15.J$0 = r16;
        r15.label = 2;
        r11 = r110.queryInstalledWidgets(r14, r16, r15);
        if (r11 != r50) goto L33;
    L32:
        return r50;
    L33:
        r19 = r14;
        goto L34
    L17:
        ResultKt.throwOnFailure(r11);
        AIPackageDeployment.AIPackageDeploymentItem r56 = new AIPackageDeployment.AIPackageDeploymentItem(r31, r32, r29, null, r33, null, false, 104, null);
        ArrayList r57 = new ArrayList();
        r15.L$0 = this;
        r15.L$1 = r31;
        r15.L$2 = r14;
        r15.L$3 = r56;
        r15.L$4 = r57;
        r15.J$0 = r29;
        r15.label = 1;
        Object r58 = queryInstalledApplets(r14, r29, r15);
        r50 = r12;
        if (r58 == r50) goto L32;
        r20 = r31;
        r110 = this;
        r17 = r57;
        r11 = r58;
        r18 = r56;
        r16 = r29;
    L8:
        r5 = new AIPackageDao$renameOutdatedFile$1(this, r34);
        goto L7
    }

    @Update
    public abstract Object updateApplet(Applet[] r5, Continuation<? super Unit> r10);

    @Update
    public abstract Object updateWidget(Widget[] r5, Continuation<? super Unit> r10);
}
