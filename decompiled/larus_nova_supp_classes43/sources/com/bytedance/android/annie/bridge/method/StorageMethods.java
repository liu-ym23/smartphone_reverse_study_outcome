package com.bytedance.android.annie.bridge.method;

import android.content.SharedPreferences;
import com.bytedance.android.annie.bridge.method.abs.GetStorageItemResultModel;
import com.bytedance.android.annie.bridge.method.abs.RemoveStorageItemResultModel;
import com.bytedance.android.annie.bridge.method.abs.SetStorageItemResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.Gson;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class StorageMethods {
    public static final /* synthetic */ int a = 0;

    @XBridgeMethod(biz = "webcast_sdk", name = "getStorageItem")
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0094\u0002¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/StorageMethods$GetStorageItemMethod;", "Le7/i;", "Le7/i0;", "Lcom/bytedance/android/annie/bridge/method/abs/GetStorageItemResultModel;", "params", "Lcom/bytedance/ies/web/jsbridge2/CallContext;", "context", "", "invoke", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final class GetStorageItemMethod extends e7.i<e7.i0, GetStorageItemResultModel> {
        public GetStorageItemMethod() {
        }

        public void invoke(e7.i0 r10, CallContext r11) {
            Intrinsics.checkNotNullParameter(r10, "params");
            Intrinsics.checkNotNullParameter(r11, "context");
            GetStorageItemResultModel r0 = new GetStorageItemResultModel();
            String r1 = r10.b();
            String r12 = r10.b();
            if (r12 != null) goto L5;
        L8:
            boolean r13 = true;
        L9:
            if (r13 == false) goto L12;
            finishWithFailure();
            return;
        L12:
            String r14 = r10.a();
            if (r14 != null) goto L15;
            int r15 = StorageMethods.a;
            r14 = "js_kv_methods_20191113";
        L15:
            int r16 = StorageMethods.a;
            SharedPreferences r17 = r11.getContext().getSharedPreferences(r14, 0);
            r0.a(GetStorageItemResultModel.Code.Success);
            Object r18 = null;
            String r19 = r17.getString(r1, null);
            if (r19 == null) goto L28;
            Gson r20 = new Gson();
            StorageValue r21 = (StorageValue) GsonProtectorUtils.fromJson(r20, r19, StorageValue.class);
            String r22 = r21.getValue();
            StorageDataType r23 = StorageDataType.valueOf(r21.getType());
            switch(a.a[r23.ordinal()]) {
                case 1: goto L25;
                case 2: goto L24;
                case 3: goto L23;
                case 4: goto L22;
                case 5: goto L21;
                case 6: goto L20;
                default: goto L26;
            };
        L20:
            r18 = GsonProtectorUtils.fromJson(r20, r22, Map.class);
            goto L26
        L21:
            r18 = GsonProtectorUtils.fromJson(r20, r22, List.class);
            goto L26
        L22:
            r18 = r22;
            goto L26
        L23:
            r18 = Double.valueOf(CastDoubleProtector.parseDouble(r22));
            goto L26
        L24:
            r18 = Integer.valueOf(CastIntegerProtector.parseInt(r22));
            goto L26
        L25:
            r18 = Boolean.valueOf(Boolean.parseBoolean(r22));
        L26:
            if (r18 == null) goto L28;
            r0.b(r18);
        L28:
            r0.c("SUCCESS");
            finishWithResult(r0);
            return;
        L5:
            if (StringsKt.isBlank(r12) == true) goto L8;
            r13 = false;
            goto L9
        }

        public /* bridge */ /* synthetic */ void invoke(Object r1, CallContext r10) {
            invoke((e7.i0) r1, r10);
        }
    }

    @XBridgeMethod(biz = "webcast_sdk", name = "removeStorageItem")
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0094\u0002¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/StorageMethods$RemoveStorageItemMethod;", "Le7/t;", "Le7/r0;", "Lcom/bytedance/android/annie/bridge/method/abs/RemoveStorageItemResultModel;", "params", "Lcom/bytedance/ies/web/jsbridge2/CallContext;", "context", "", "invoke", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final class RemoveStorageItemMethod extends e7.t<e7.r0, RemoveStorageItemResultModel> {
        public RemoveStorageItemMethod() {
        }

        public void invoke(e7.r0 r10, CallContext r11) {
            Intrinsics.checkNotNullParameter(r10, "params");
            Intrinsics.checkNotNullParameter(r11, "context");
            String r0 = r10.b();
            if (r0 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == false) goto L12;
            finishWithFailure();
            return;
        L12:
            String r12 = r10.b();
            String r13 = r10.a();
            if (r13 != null) goto L15;
            int r14 = StorageMethods.a;
            r13 = "js_kv_methods_20191113";
        L15:
            RemoveStorageItemResultModel r15 = new RemoveStorageItemResultModel();
            r15.a(RemoveStorageItemResultModel.Code.Success);
            r15.b("SUCCESS");
            int r16 = StorageMethods.a;
            if (r11.getContext().getSharedPreferences(r13, 0).edit().remove(r12).commit() == false) goto L18;
            finishWithResult(r15);
            return;
        L18:
            finishWithFailure();
            return;
        L5:
            if (StringsKt.isBlank(r0) == true) goto L8;
            r1 = false;
            goto L9
        }

        public /* bridge */ /* synthetic */ void invoke(Object r1, CallContext r10) {
            invoke((e7.r0) r1, r10);
        }
    }

    @XBridgeMethod(biz = "webcast_sdk", name = "setStorageItem")
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0094\u0002¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/StorageMethods$SetStorageItemMethod;", "Le7/a0;", "Le7/w0;", "Lcom/bytedance/android/annie/bridge/method/abs/SetStorageItemResultModel;", "params", "Lcom/bytedance/ies/web/jsbridge2/CallContext;", "context", "", "invoke", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final class SetStorageItemMethod extends e7.a0<e7.w0, SetStorageItemResultModel> {
        public SetStorageItemMethod() {
        }

        public void invoke(e7.w0 r10, CallContext r11) {
            Intrinsics.checkNotNullParameter(r10, "params");
            Intrinsics.checkNotNullParameter(r11, "context");
            String r0 = r10.c();
            if (r0 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == false) goto L12;
            finishWithFailure();
            return;
        L12:
            String r12 = r10.a();
            if (r12 != null) goto L15;
            int r13 = StorageMethods.a;
            r12 = "js_kv_methods_20191113";
        L15:
            SetStorageItemResultModel r14 = new SetStorageItemResultModel();
            r14.a(SetStorageItemResultModel.Code.Success);
            r14.b("SUCCESS");
            Object r15 = r10.b();
            if (r15 == null) goto L51;
            int r16 = StorageMethods.a;
            Gson r17 = new Gson();
            Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L39
            if ((r15 instanceof Boolean) == false) goto L22;
            String r19 = r17.toJson(new StorageValue(StorageDataType.Boolean.name(), r15.toString()));     // Catch: Throwable -> L39
        L37:
            Object r20 = Result.constructor-impl(r19);     // Catch: Throwable -> L39
        L42:
            if (Result.isFailure-impl(r20) == false) goto L44;
            r20 = null;
        L44:
            String r21 = (String) r20;
            if (r21 == null) goto L51;
            int r22 = StorageMethods.a;
            if (r11.getContext().getSharedPreferences(r12, 0).edit().putString(r10.c(), r21).commit() == false) goto L49;
            finishWithResult(r14);
            return;
        L49:
            finishWithFailure();
            return;
        L22:
            if ((r15 instanceof Integer) == false) goto L25;
            r19 = r17.toJson(new StorageValue(StorageDataType.Int.name(), r15.toString()));     // Catch: Throwable -> L39
            goto L37
        L25:
            if ((r15 instanceof Double) == false) goto L28;
            r19 = r17.toJson(new StorageValue(StorageDataType.Number.name(), r15.toString()));     // Catch: Throwable -> L39
            goto L37
        L28:
            if ((r15 instanceof String) == false) goto L31;
            r19 = r17.toJson(new StorageValue(StorageDataType.String.name(), r15.toString()));     // Catch: Throwable -> L39
            goto L37
        L31:
            if ((r15 instanceof List) == false) goto L34;
            r19 = r17.toJson(new StorageValue(StorageDataType.List.name(), r17.toJson(r15)));     // Catch: Throwable -> L39
            goto L37
        L34:
            if ((r15 instanceof Map) == false) goto L36;
            r19 = r17.toJson(new StorageValue(StorageDataType.Map.name(), r17.toJson(r15)));     // Catch: Throwable -> L39
            goto L37
        L36:
            r19 = "";
        L39:
            th = move-exception;
            Result.Companion r23 = Result.Companion;
            r20 = Result.constructor-impl(ResultKt.createFailure(th));
        L51:
            finishWithFailure();
            return;
        L5:
            if (StringsKt.isBlank(r0) == true) goto L8;
            r1 = false;
            goto L9
        }

        public /* bridge */ /* synthetic */ void invoke(Object r1, CallContext r10) {
            invoke((e7.w0) r1, r10);
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[StorageDataType.values().length];
            r0[StorageDataType.Boolean.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[StorageDataType.Int.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[StorageDataType.Number.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[StorageDataType.String.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[StorageDataType.List.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[StorageDataType.Map.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    static {
    }

    public StorageMethods() {
    }
}
