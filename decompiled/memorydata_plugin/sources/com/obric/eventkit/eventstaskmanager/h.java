package com.obric.eventkit.eventstaskmanager;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public interface h extends IInterface {

    public static abstract class a extends Binder implements h {

        /* JADX INFO: renamed from: com.obric.eventkit.eventstaskmanager.h$a$a, reason: collision with other inner class name */
        public static class C0392a implements h {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static h f8030a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f8031b;

            public C0392a(IBinder r3) {
                this.f8031b = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public int a(long[] r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L12
                r0.writeLongArray(r5);     // Catch: Throwable -> L12
                if (this.f8031b.transact(35, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                int r4 = r1.readInt();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.k() == null) goto L10;
                r4 = a.k().a(r5);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public ConditionTask a(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L15
                r0.writeString(r5);     // Catch: Throwable -> L15
                if (this.f8031b.transact(31, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L14;
                ConditionTask r4 = (ConditionTask) ZeusTransformUtils.preCheckCast(ConditionTask.CREATOR.createFromParcel(r1), ConditionTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L8
            L6:
                if (a.k() == null) goto L10;
                r4 = a.k().a(r5);     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public ConditionTaskResult a(String r15, List<ConditionTaskAction> r16, String r17, ConditionGroup r18, PeriodicPolicy r19, TriggerControlPolicy r20, int r21, Map r22) {
                List<ConditionTaskAction> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.memorydata.plugin");
                Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r22, Map.class, "com.obric.memorydata.plugin");
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L25
                r10.writeString(r15);     // Catch: Throwable -> L25
                r10.writeTypedList(r3);     // Catch: Throwable -> L25
                r10.writeString(r17);     // Catch: Throwable -> L25
                if (r18 == null) goto L6;
                r10.writeInt(1);     // Catch: Throwable -> L25
                r18.writeToParcel(r10, 0);     // Catch: Throwable -> L25
            L7:
                if (r19 == null) goto L9;
                r10.writeInt(1);     // Catch: Throwable -> L25
                r19.writeToParcel(r10, 0);     // Catch: Throwable -> L25
            L10:
                if (r20 == null) goto L12;
                r10.writeInt(1);     // Catch: Throwable -> L25
                r20.writeToParcel(r10, 0);     // Catch: Throwable -> L25
            L13:
                r10.writeInt(r21);     // Catch: Throwable -> L25
                r10.writeMap(r9);     // Catch: Throwable -> L25
                if (this.f8031b.transact(32, r10, r11, 0) == false) goto L16;
            L20:
                r11.readException();     // Catch: Throwable -> L25
                if (r11.readInt() == 0) goto L24;
                ConditionTaskResult r0 = (ConditionTaskResult) ZeusTransformUtils.preCheckCast(ConditionTaskResult.CREATOR.createFromParcel(r11), ConditionTaskResult.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
            L18:
                r11.recycle();
                r10.recycle();
                return r0;
            L24:
                r0 = null;
                goto L18
            L16:
                if (a.k() == null) goto L20;
                r0 = a.k().a(r15, r3, r17, r18, r19, r20, r21, r9);     // Catch: Throwable -> L25
                goto L18
            L12:
                r10.writeInt(0);     // Catch: Throwable -> L25
                goto L13
            L9:
                r10.writeInt(0);     // Catch: Throwable -> L25
                goto L10
            L6:
                r10.writeInt(0);     // Catch: Throwable -> L25
            L25:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public ConditionTaskResult a(List<ConditionTaskAction> r10, String r11, ConditionGroup r12, PeriodicPolicy r13, TriggerControlPolicy r14, Map r15) {
                List<ConditionTaskAction> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
                Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r15, Map.class, "com.obric.memorydata.plugin");
                Parcel r16 = Parcel.obtain();
                Parcel r17 = Parcel.obtain();
                r16.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L25
                r16.writeTypedList(r3);     // Catch: Throwable -> L25
                r16.writeString(r11);     // Catch: Throwable -> L25
                if (r12 == null) goto L6;
                r16.writeInt(1);     // Catch: Throwable -> L25
                r12.writeToParcel(r16, 0);     // Catch: Throwable -> L25
            L7:
                if (r13 == null) goto L9;
                r16.writeInt(1);     // Catch: Throwable -> L25
                r13.writeToParcel(r16, 0);     // Catch: Throwable -> L25
            L10:
                if (r14 == null) goto L12;
                r16.writeInt(1);     // Catch: Throwable -> L25
                r14.writeToParcel(r16, 0);     // Catch: Throwable -> L25
            L13:
                r16.writeMap(r8);     // Catch: Throwable -> L25
                if (this.f8031b.transact(29, r16, r17, 0) == false) goto L16;
            L20:
                r17.readException();     // Catch: Throwable -> L25
                if (r17.readInt() == 0) goto L24;
                ConditionTaskResult r9 = (ConditionTaskResult) ZeusTransformUtils.preCheckCast(ConditionTaskResult.CREATOR.createFromParcel(r17), ConditionTaskResult.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
            L18:
                r17.recycle();
                r16.recycle();
                return r9;
            L24:
                r9 = null;
                goto L18
            L16:
                if (a.k() == null) goto L20;
                r9 = a.k().a(r3, r11, r12, r13, r14, r8);     // Catch: Throwable -> L25
                goto L18
            L12:
                r16.writeInt(0);     // Catch: Throwable -> L25
                goto L13
            L9:
                r16.writeInt(0);     // Catch: Throwable -> L25
                goto L10
            L6:
                r16.writeInt(0);     // Catch: Throwable -> L25
            L25:
                th = move-exception;
                r17.recycle();
                r16.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public ConditionTaskResult a(String[] r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L15
                r0.writeStringArray(r5);     // Catch: Throwable -> L15
                if (this.f8031b.transact(30, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L14;
                ConditionTaskResult r4 = (ConditionTaskResult) ZeusTransformUtils.preCheckCast(ConditionTaskResult.CREATOR.createFromParcel(r1), ConditionTaskResult.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L8
            L6:
                if (a.k() == null) goto L10;
                r4 = a.k().a(r5);     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public EventTaskExecutionDetailRecord a(EventTaskExecutionDetailRecord r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L19
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L19
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L19
            L8:
                if (this.f8031b.transact(69, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L19
                if (r1.readInt() == 0) goto L18;
                EventTaskExecutionDetailRecord r4 = (EventTaskExecutionDetailRecord) ZeusTransformUtils.preCheckCast(EventTaskExecutionDetailRecord.CREATOR.createFromParcel(r1), EventTaskExecutionDetailRecord.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
            L12:
                r1.recycle();
                r0.recycle();
                return r4;
            L18:
                r4 = null;
                goto L12
            L10:
                if (a.k() == null) goto L14;
                r4 = a.k().a(r5);     // Catch: Throwable -> L19
                goto L12
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L19
            L19:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public EventTaskExecutionRecord a(long r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L15
                r0.writeLong(r5);     // Catch: Throwable -> L15
                if (this.f8031b.transact(60, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L14;
                EventTaskExecutionRecord r4 = (EventTaskExecutionRecord) ZeusTransformUtils.preCheckCast(EventTaskExecutionRecord.CREATOR.createFromParcel(r1), EventTaskExecutionRecord.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L8
            L6:
                if (a.k() == null) goto L10;
                r4 = a.k().a(r5);     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public EventTaskExecutionRecord a(EventTaskExecutionRecord r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L19
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L19
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L19
            L8:
                if (this.f8031b.transact(61, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L19
                if (r1.readInt() == 0) goto L18;
                EventTaskExecutionRecord r4 = (EventTaskExecutionRecord) ZeusTransformUtils.preCheckCast(EventTaskExecutionRecord.CREATOR.createFromParcel(r1), EventTaskExecutionRecord.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
            L12:
                r1.recycle();
                r0.recycle();
                return r4;
            L18:
                r4 = null;
                goto L12
            L10:
                if (a.k() == null) goto L14;
                r4 = a.k().a(r5);     // Catch: Throwable -> L19
                goto L12
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L19
            L19:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public EventTaskResult a(EventTaskSpec r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L19
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L19
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L19
            L8:
                if (this.f8031b.transact(43, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L19
                if (r1.readInt() == 0) goto L18;
                EventTaskResult r4 = (EventTaskResult) ZeusTransformUtils.preCheckCast(EventTaskResult.CREATOR.createFromParcel(r1), EventTaskResult.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
            L12:
                r1.recycle();
                r0.recycle();
                return r4;
            L18:
                r4 = null;
                goto L12
            L10:
                if (a.k() == null) goto L14;
                r4 = a.k().a(r5);     // Catch: Throwable -> L19
                goto L12
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L19
            L19:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public EventTaskResult a(String r5, EventTaskSpec r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L19
                r0.writeString(r5);     // Catch: Throwable -> L19
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L19
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L19
            L8:
                if (this.f8031b.transact(45, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L19
                if (r1.readInt() == 0) goto L18;
                EventTaskResult r4 = (EventTaskResult) ZeusTransformUtils.preCheckCast(EventTaskResult.CREATOR.createFromParcel(r1), EventTaskResult.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
            L12:
                r1.recycle();
                r0.recycle();
                return r4;
            L18:
                r4 = null;
                goto L12
            L10:
                if (a.k() == null) goto L14;
                r4 = a.k().a(r5, r6);     // Catch: Throwable -> L19
                goto L12
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L19
            L19:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public TimerTask a(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L15
                r0.writeInt(r5);     // Catch: Throwable -> L15
                if (this.f8031b.transact(6, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L14;
                TimerTask r4 = TimerTask.CREATOR.a(r1);     // Catch: Throwable -> L15
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L8
            L6:
                if (a.k() == null) goto L10;
                r4 = a.k().a(r5);     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public TimerTaskResult a(int r5, long[] r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L15
                r0.writeInt(r5);     // Catch: Throwable -> L15
                r0.writeLongArray(r6);     // Catch: Throwable -> L15
                if (this.f8031b.transact(4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L14;
                TimerTaskResult r4 = TimerTaskResult.CREATOR.a(r1);     // Catch: Throwable -> L15
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L8
            L6:
                if (a.k() == null) goto L10;
                r4 = a.k().a(r5, r6);     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public TimerTaskResult a(TimerTask r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L19
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L19
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L19
            L8:
                if (this.f8031b.transact(1, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L19
                if (r1.readInt() == 0) goto L18;
                TimerTaskResult r4 = TimerTaskResult.CREATOR.a(r1);     // Catch: Throwable -> L19
            L12:
                r1.recycle();
                r0.recycle();
                return r4;
            L18:
                r4 = null;
                goto L12
            L10:
                if (a.k() == null) goto L14;
                r4 = a.k().a(r5);     // Catch: Throwable -> L19
                goto L12
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L19
            L19:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public TimerTaskResult a(Map r5) {
                Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L15
                r0.writeMap(r6);     // Catch: Throwable -> L15
                if (this.f8031b.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L14;
                TimerTaskResult r4 = TimerTaskResult.CREATOR.a(r1);     // Catch: Throwable -> L15
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L8
            L6:
                if (a.k() == null) goto L10;
                r4 = a.k().a(r6);     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public TimerTaskResult a(int[] r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L15
                r0.writeIntArray(r5);     // Catch: Throwable -> L15
                if (this.f8031b.transact(2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L14;
                TimerTaskResult r4 = TimerTaskResult.CREATOR.a(r1);     // Catch: Throwable -> L15
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L8
            L6:
                if (a.k() == null) goto L10;
                r4 = a.k().a(r5);     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public List<TimerTask> a() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L12
                if (this.f8031b.transact(9, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<TimerTask> r4 = r1.createTypedArrayList(TimerTask.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.k() == null) goto L10;
                r4 = a.k().a();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public List<EventTaskExecutionRecord> a(int r5, int r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L12
                r0.writeInt(r5);     // Catch: Throwable -> L12
                r0.writeInt(r6);     // Catch: Throwable -> L12
                if (this.f8031b.transact(58, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<EventTaskExecutionRecord> r4 = r1.createTypedArrayList(EventTaskExecutionRecord.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.k() == null) goto L10;
                r4 = a.k().a(r5, r6);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public List<EventTask> a(int r5, int r6, int r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L12
                r0.writeInt(r5);     // Catch: Throwable -> L12
                r0.writeInt(r6);     // Catch: Throwable -> L12
                r0.writeInt(r7);     // Catch: Throwable -> L12
                if (this.f8031b.transact(48, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<EventTask> r4 = r1.createTypedArrayList(EventTask.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.k() == null) goto L10;
                r4 = a.k().a(r5, r6, r7);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public List<TimerTaskRecord> a(long r5, long r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L12
                r0.writeLong(r5);     // Catch: Throwable -> L12
                r0.writeLong(r7);     // Catch: Throwable -> L12
                if (this.f8031b.transact(11, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<TimerTaskRecord> r4 = r1.createTypedArrayList(TimerTaskRecord.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.k() == null) goto L10;
                r4 = a.k().a(r5, r7);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public List<TimerTaskRecord> a(long r9, long r11, int r13) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L12
                r0.writeLong(r9);     // Catch: Throwable -> L12
                r0.writeLong(r11);     // Catch: Throwable -> L12
                r0.writeInt(r13);     // Catch: Throwable -> L12
                if (this.f8031b.transact(10, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<TimerTaskRecord> r8 = r1.createTypedArrayList(TimerTaskRecord.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r8;
            L6:
                if (a.k() == null) goto L10;
                r8 = a.k().a(r9, r11, r13);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public List<ConditionTaskRecord> a(long r9, long r11, String r13) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L12
                r0.writeLong(r9);     // Catch: Throwable -> L12
                r0.writeLong(r11);     // Catch: Throwable -> L12
                r0.writeString(r13);     // Catch: Throwable -> L12
                if (this.f8031b.transact(33, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<ConditionTaskRecord> r8 = r1.createTypedArrayList(ConditionTaskRecord.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r8;
            L6:
                if (a.k() == null) goto L10;
                r8 = a.k().a(r9, r11, r13);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public List<EventTaskExecutionRecord> a(String r5, int r6, int r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                r0.writeInt(r6);     // Catch: Throwable -> L12
                r0.writeInt(r7);     // Catch: Throwable -> L12
                if (this.f8031b.transact(59, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<EventTaskExecutionRecord> r4 = r1.createTypedArrayList(EventTaskExecutionRecord.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.k() == null) goto L10;
                r4 = a.k().a(r5, r6, r7);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public List<EventTaskExecutionRecord> a(List<EventTaskExecutionRecord> r5) {
                List<EventTaskExecutionRecord> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L12
                r0.writeTypedList(r6);     // Catch: Throwable -> L12
                if (this.f8031b.transact(57, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<EventTaskExecutionRecord> r4 = r1.createTypedArrayList(EventTaskExecutionRecord.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.k() == null) goto L10;
                r4 = a.k().a(r6);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public void a(StateInfo r5, boolean r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L16
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L7:
                r0.writeInt(r6 ? 1 : 0);     // Catch: Throwable -> L16
                if (this.f8031b.transact(16, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L16
            L12:
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (a.k() == null) goto L14;
                a.k().a(r5, r6);     // Catch: Throwable -> L16
                goto L12
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public void a(b r5) {
                b r6 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.f8031b.transact(19, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L16
            L12:
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (a.k() == null) goto L14;
                a.k().a(r6);     // Catch: Throwable -> L16
                goto L12
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public void a(c r5) {
                c r6 = (c) ZeusTransformUtils.wrapperContextForParams(r5, c.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.f8031b.transact(27, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (a.k() == null) goto L14;
                a.k().a(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public void a(d r5) {
                d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.f8031b.transact(25, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (a.k() == null) goto L14;
                a.k().a(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public void a(f r5) {
                f r6 = (f) ZeusTransformUtils.wrapperContextForParams(r5, f.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.f8031b.transact(39, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (a.k() == null) goto L14;
                a.k().a(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public void a(g r5) {
                g r6 = (g) ZeusTransformUtils.wrapperContextForParams(r5, g.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.f8031b.transact(41, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (a.k() == null) goto L14;
                a.k().a(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public void a(i r5) {
                i r6 = (i) ZeusTransformUtils.wrapperContextForParams(r5, i.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.f8031b.transact(14, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (a.k() == null) goto L14;
                a.k().a(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public void a(String r5, String r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                r0.writeString(r6);     // Catch: Throwable -> L12
                if (this.f8031b.transact(50, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (a.k() == null) goto L10;
                a.k().a(r5, r6);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public void a(String r5, String r6, Map r7) {
                Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                r0.writeString(r6);     // Catch: Throwable -> L12
                r0.writeMap(r8);     // Catch: Throwable -> L12
                if (this.f8031b.transact(20, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (a.k() == null) goto L10;
                a.k().a(r5, r6, r8);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public void a(String r8, List<ConditionTaskAction> r9, TaskKnowledge r10, int r11, String r12) {
                List<ConditionTaskAction> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
                Parcel r13 = Parcel.obtain();
                Parcel r6 = Parcel.obtain();
                r13.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L16
                r13.writeString(r8);     // Catch: Throwable -> L16
                r13.writeTypedList(r2);     // Catch: Throwable -> L16
                if (r10 == null) goto L6;
                r13.writeInt(1);     // Catch: Throwable -> L16
                r10.writeToParcel(r13, 0);     // Catch: Throwable -> L16
            L7:
                r13.writeInt(r11);     // Catch: Throwable -> L16
                r13.writeString(r12);     // Catch: Throwable -> L16
                if (this.f8031b.transact(52, r13, r6, 0) == false) goto L10;
            L14:
                r6.readException();     // Catch: Throwable -> L16
            L12:
                r6.recycle();
                r13.recycle();
                return;
            L10:
                if (a.k() == null) goto L14;
                a.k().a(r8, r2, r10, r11, r12);     // Catch: Throwable -> L16
                goto L12
            L6:
                r13.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r6.recycle();
                r13.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public void a(boolean r5, StateInfo r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L16
                r0.writeInt(r5 ? 1 : 0);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (this.f8031b.transact(18, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L16
            L12:
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (a.k() == null) goto L14;
                a.k().a(r5, r6);     // Catch: Throwable -> L16
                goto L12
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public boolean a(AppEvent r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L20
                boolean r2 = true;
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L8:
                if (this.f8031b.transact(23, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L20
                if (r1.readInt() != 0) goto L18;
                r2 = false;
            L18:
                r1.recycle();
                r0.recycle();
                return r2;
            L10:
                if (a.k() == null) goto L14;
                boolean r5 = a.k().a(r6);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return r5;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f8031b;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public int b() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L12
                if (this.f8031b.transact(13, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                int r4 = r1.readInt();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.k() == null) goto L10;
                r4 = a.k().b();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public int b(int r5, long[] r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L12
                r0.writeInt(r5);     // Catch: Throwable -> L12
                r0.writeLongArray(r6);     // Catch: Throwable -> L12
                if (this.f8031b.transact(55, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                int r4 = r1.readInt();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.k() == null) goto L10;
                r4 = a.k().b(r5, r6);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public int b(List<EventTaskExecutionRecord> r5) {
                List<EventTaskExecutionRecord> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L12
                r0.writeTypedList(r6);     // Catch: Throwable -> L12
                if (this.f8031b.transact(62, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                int r4 = r1.readInt();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.k() == null) goto L10;
                r4 = a.k().b(r6);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public int b(int[] r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L12
                r0.writeIntArray(r5);     // Catch: Throwable -> L12
                if (this.f8031b.transact(12, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                int r4 = r1.readInt();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.k() == null) goto L10;
                r4 = a.k().b(r5);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public int b(long[] r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L12
                r0.writeLongArray(r5);     // Catch: Throwable -> L12
                if (this.f8031b.transact(63, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                int r4 = r1.readInt();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.k() == null) goto L10;
                r4 = a.k().b(r5);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public long b(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L12
                r0.writeInt(r5);     // Catch: Throwable -> L12
                if (this.f8031b.transact(7, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                long r4 = r1.readLong();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.k() == null) goto L10;
                r4 = a.k().b(r5);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public EventTask b(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L15
                r0.writeString(r5);     // Catch: Throwable -> L15
                if (this.f8031b.transact(38, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L14;
                EventTask r4 = (EventTask) ZeusTransformUtils.preCheckCast(EventTask.CREATOR.createFromParcel(r1), EventTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L8
            L6:
                if (a.k() == null) goto L10;
                r4 = a.k().b(r5);     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public EventTaskExecutionDetailRecord b(long r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L15
                r0.writeLong(r5);     // Catch: Throwable -> L15
                if (this.f8031b.transact(68, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L14;
                EventTaskExecutionDetailRecord r4 = (EventTaskExecutionDetailRecord) ZeusTransformUtils.preCheckCast(EventTaskExecutionDetailRecord.CREATOR.createFromParcel(r1), EventTaskExecutionDetailRecord.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L8
            L6:
                if (a.k() == null) goto L10;
                r4 = a.k().b(r5);     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public EventTaskResult b(String[] r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L15
                r0.writeStringArray(r5);     // Catch: Throwable -> L15
                if (this.f8031b.transact(44, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L14;
                EventTaskResult r4 = (EventTaskResult) ZeusTransformUtils.preCheckCast(EventTaskResult.CREATOR.createFromParcel(r1), EventTaskResult.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L8
            L6:
                if (a.k() == null) goto L10;
                r4 = a.k().b(r5);     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public TimerTaskResult b(TimerTask r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L19
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L19
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L19
            L8:
                if (this.f8031b.transact(5, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L19
                if (r1.readInt() == 0) goto L18;
                TimerTaskResult r4 = TimerTaskResult.CREATOR.a(r1);     // Catch: Throwable -> L19
            L12:
                r1.recycle();
                r0.recycle();
                return r4;
            L18:
                r4 = null;
                goto L12
            L10:
                if (a.k() == null) goto L14;
                r4 = a.k().b(r5);     // Catch: Throwable -> L19
                goto L12
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L19
            L19:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public List<EventTaskExecutionDetailRecord> b(int r5, int r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L12
                r0.writeInt(r5);     // Catch: Throwable -> L12
                r0.writeInt(r6);     // Catch: Throwable -> L12
                if (this.f8031b.transact(66, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<EventTaskExecutionDetailRecord> r4 = r1.createTypedArrayList(EventTaskExecutionDetailRecord.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.k() == null) goto L10;
                r4 = a.k().b(r5, r6);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public List<ConditionTaskRecord> b(long r5, long r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L12
                r0.writeLong(r5);     // Catch: Throwable -> L12
                r0.writeLong(r7);     // Catch: Throwable -> L12
                if (this.f8031b.transact(34, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<ConditionTaskRecord> r4 = r1.createTypedArrayList(ConditionTaskRecord.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.k() == null) goto L10;
                r4 = a.k().b(r5, r7);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public List<EventTaskRecord> b(long r9, long r11, int r13) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L12
                r0.writeLong(r9);     // Catch: Throwable -> L12
                r0.writeLong(r11);     // Catch: Throwable -> L12
                r0.writeInt(r13);     // Catch: Throwable -> L12
                if (this.f8031b.transact(54, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<EventTaskRecord> r8 = r1.createTypedArrayList(EventTaskRecord.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r8;
            L6:
                if (a.k() == null) goto L10;
                r8 = a.k().b(r9, r11, r13);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public List<EventTaskRecord> b(long r9, long r11, String r13) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L12
                r0.writeLong(r9);     // Catch: Throwable -> L12
                r0.writeLong(r11);     // Catch: Throwable -> L12
                r0.writeString(r13);     // Catch: Throwable -> L12
                if (this.f8031b.transact(53, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<EventTaskRecord> r8 = r1.createTypedArrayList(EventTaskRecord.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r8;
            L6:
                if (a.k() == null) goto L10;
                r8 = a.k().b(r9, r11, r13);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public List<EventTaskExecutionDetailRecord> b(String r5, int r6, int r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                r0.writeInt(r6);     // Catch: Throwable -> L12
                r0.writeInt(r7);     // Catch: Throwable -> L12
                if (this.f8031b.transact(67, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<EventTaskExecutionDetailRecord> r4 = r1.createTypedArrayList(EventTaskExecutionDetailRecord.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.k() == null) goto L10;
                r4 = a.k().b(r5, r6, r7);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public List<TimerTask> b(Map r5) {
                Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L12
                r0.writeMap(r6);     // Catch: Throwable -> L12
                if (this.f8031b.transact(8, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<TimerTask> r4 = r1.createTypedArrayList(TimerTask.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.k() == null) goto L10;
                r4 = a.k().b(r6);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public void b(c r5) {
                c r6 = (c) ZeusTransformUtils.wrapperContextForParams(r5, c.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.f8031b.transact(28, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (a.k() == null) goto L14;
                a.k().b(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public void b(d r5) {
                d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.f8031b.transact(26, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (a.k() == null) goto L14;
                a.k().b(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public void b(f r5) {
                f r6 = (f) ZeusTransformUtils.wrapperContextForParams(r5, f.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.f8031b.transact(40, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (a.k() == null) goto L14;
                a.k().b(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public void b(g r5) {
                g r6 = (g) ZeusTransformUtils.wrapperContextForParams(r5, g.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.f8031b.transact(42, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (a.k() == null) goto L14;
                a.k().b(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public void b(i r5) {
                i r6 = (i) ZeusTransformUtils.wrapperContextForParams(r5, i.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.f8031b.transact(15, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (a.k() == null) goto L14;
                a.k().b(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public boolean b(AppEvent r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L20
                boolean r2 = true;
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L8:
                if (this.f8031b.transact(24, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L20
                if (r1.readInt() != 0) goto L18;
                r2 = false;
            L18:
                r1.recycle();
                r0.recycle();
                return r2;
            L10:
                if (a.k() == null) goto L14;
                boolean r5 = a.k().b(r6);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return r5;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public int c(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L12
                r0.writeInt(r5);     // Catch: Throwable -> L12
                if (this.f8031b.transact(56, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                int r4 = r1.readInt();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.k() == null) goto L10;
                r4 = a.k().c(r5);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public int c(long[] r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L12
                r0.writeLongArray(r5);     // Catch: Throwable -> L12
                if (this.f8031b.transact(71, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                int r4 = r1.readInt();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.k() == null) goto L10;
                r4 = a.k().c(r5);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public List<EventTaskExecutionDetailRecord> c(List<EventTaskExecutionDetailRecord> r5) {
                List<EventTaskExecutionDetailRecord> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L12
                r0.writeTypedList(r6);     // Catch: Throwable -> L12
                if (this.f8031b.transact(65, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<EventTaskExecutionDetailRecord> r4 = r1.createTypedArrayList(EventTaskExecutionDetailRecord.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.k() == null) goto L10;
                r4 = a.k().c(r6);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public void c() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L12
                if (this.f8031b.transact(17, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (a.k() == null) goto L10;
                a.k().c();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public void c(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                if (this.f8031b.transact(51, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (a.k() == null) goto L10;
                a.k().c(r5);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public boolean c(AppEvent r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L20
                boolean r2 = true;
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L8:
                if (this.f8031b.transact(73, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L20
                if (r1.readInt() != 0) goto L18;
                r2 = false;
            L18:
                r1.recycle();
                r0.recycle();
                return r2;
            L10:
                if (a.k() == null) goto L14;
                boolean r5 = a.k().c(r6);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return r5;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public int d() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L12
                if (this.f8031b.transact(21, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                int r4 = r1.readInt();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.k() == null) goto L10;
                r4 = a.k().d();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public int d(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                if (this.f8031b.transact(64, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                int r4 = r1.readInt();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.k() == null) goto L10;
                r4 = a.k().d(r5);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public int d(List<EventTaskExecutionDetailRecord> r5) {
                List<EventTaskExecutionDetailRecord> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L12
                r0.writeTypedList(r6);     // Catch: Throwable -> L12
                if (this.f8031b.transact(70, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                int r4 = r1.readInt();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.k() == null) goto L10;
                r4 = a.k().d(r6);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public int e() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L12
                if (this.f8031b.transact(22, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                int r4 = r1.readInt();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.k() == null) goto L10;
                r4 = a.k().e();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public int e(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                if (this.f8031b.transact(72, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                int r4 = r1.readInt();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.k() == null) goto L10;
                r4 = a.k().e(r5);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public int f() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L12
                if (this.f8031b.transact(36, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                int r4 = r1.readInt();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.k() == null) goto L10;
                r4 = a.k().f();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public List<EventTask> g() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L12
                if (this.f8031b.transact(37, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<EventTask> r4 = r1.createTypedArrayList(EventTask.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.k() == null) goto L10;
                r4 = a.k().g();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public List<EventTask> h() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L12
                if (this.f8031b.transact(46, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<EventTask> r4 = r1.createTypedArrayList(EventTask.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.k() == null) goto L10;
                r4 = a.k().h();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public List<EventTask> i() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L12
                if (this.f8031b.transact(47, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<EventTask> r4 = r1.createTypedArrayList(EventTask.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.k() == null) goto L10;
                r4 = a.k().i();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.h
            public List<ShortcutTask> j() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L12
                if (this.f8031b.transact(49, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<ShortcutTask> r4 = r1.createTypedArrayList(ShortcutTask.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (a.k() == null) goto L10;
                r4 = a.k().j();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public static h a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, h.class) == false) goto L13;
            return (h) ZeusTransformUtils.preCheckCast(r0, h.class, "com.obric.memorydata.plugin");
        L13:
            return new C0392a(r4);
        }

        public static h k() {
            return C0392a.f8030a;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r16, Parcel r17, Parcel r18, int r19) {
            if (r16 == 1598968902) goto L274;
            TimerTask r5 = null;
            AppEvent r6 = null;
            EventTaskExecutionDetailRecord r7 = null;
            EventTaskExecutionRecord r8 = null;
            EventTaskSpec r9 = null;
            EventTaskSpec r10 = null;
            TriggerControlPolicy r11 = null;
            AppEvent r12 = null;
            AppEvent r13 = null;
            StateInfo r14 = null;
            StateInfo r15 = null;
            TimerTask r20 = null;
            boolean r110 = false;
            switch(r16) {
                case 1: goto L266;
                case 2: goto L261;
                case 3: goto L256;
                case 4: goto L251;
                case 5: goto L243;
                case 6: goto L238;
                case 7: goto L236;
                case 8: goto L234;
                case 9: goto L232;
                case 10: goto L230;
                case 11: goto L228;
                case 12: goto L226;
                case 13: goto L224;
                case 14: goto L222;
                case 15: goto L220;
                case 16: goto L212;
                case 17: goto L210;
                case 18: goto L202;
                case 19: goto L200;
                case 20: goto L198;
                case 21: goto L196;
                case 22: goto L194;
                case 23: goto L189;
                case 24: goto L184;
                case 25: goto L182;
                case 26: goto L180;
                case 27: goto L178;
                case 28: goto L176;
                case 29: goto L160;
                case 30: goto L155;
                case 31: goto L150;
                case 32: goto L133;
                case 33: goto L131;
                case 34: goto L129;
                case 35: goto L127;
                case 36: goto L125;
                case 37: goto L123;
                case 38: goto L118;
                case 39: goto L116;
                case 40: goto L114;
                case 41: goto L112;
                case 42: goto L110;
                case 43: goto L102;
                case 44: goto L97;
                case 45: goto L89;
                case 46: goto L87;
                case 47: goto L85;
                case 48: goto L83;
                case 49: goto L81;
                case 50: goto L79;
                case 51: goto L77;
                case 52: goto L71;
                case 53: goto L69;
                case 54: goto L67;
                case 55: goto L65;
                case 56: goto L63;
                case 57: goto L61;
                case 58: goto L59;
                case 59: goto L57;
                case 60: goto L52;
                case 61: goto L44;
                case 62: goto L42;
                case 63: goto L40;
                case 64: goto L38;
                case 65: goto L36;
                case 66: goto L34;
                case 67: goto L32;
                case 68: goto L27;
                case 69: goto L19;
                case 70: goto L17;
                case 71: goto L15;
                case 72: goto L13;
                case 73: goto L8;
                default: goto L7;
            };
        L8:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            if (r17.readInt() == 0) goto L11;
            r6 = AppEvent.CREATOR.createFromParcel(r17);
        L11:
            boolean r0 = c(r6);
            r18.writeNoException();
            r18.writeInt(r0 ? 1 : 0);
            return true;
        L13:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            int r1 = e(r17.readString());
            r18.writeNoException();
            r18.writeInt(r1);
            return true;
        L15:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            int r2 = c(r17.createLongArray());
            r18.writeNoException();
            r18.writeInt(r2);
            return true;
        L17:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            int r3 = d(r17.createTypedArrayList(EventTaskExecutionDetailRecord.CREATOR));
            r18.writeNoException();
            r18.writeInt(r3);
            return true;
        L19:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            if (r17.readInt() == 0) goto L22;
            r7 = (EventTaskExecutionDetailRecord) ZeusTransformUtils.preCheckCast(EventTaskExecutionDetailRecord.CREATOR.createFromParcel(r17), EventTaskExecutionDetailRecord.class, "com.obric.memorydata.plugin");
        L22:
            EventTaskExecutionDetailRecord r4 = a(r7);
            r18.writeNoException();
            if (r4 == null) goto L25;
            r18.writeInt(1);
            r4.writeToParcel(r18, 1);
        L26:
            return true;
        L25:
            r18.writeInt(0);
            goto L26
        L27:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            EventTaskExecutionDetailRecord r21 = b(r17.readLong());
            r18.writeNoException();
            if (r21 == null) goto L30;
            r18.writeInt(1);
            r21.writeToParcel(r18, 1);
        L31:
            return true;
        L30:
            r18.writeInt(0);
            goto L31
        L32:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            List<EventTaskExecutionDetailRecord> r22 = b(r17.readString(), r17.readInt(), r17.readInt());
            r18.writeNoException();
            r18.writeTypedList(r22);
            return true;
        L34:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            List<EventTaskExecutionDetailRecord> r23 = b(r17.readInt(), r17.readInt());
            r18.writeNoException();
            r18.writeTypedList(r23);
            return true;
        L36:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            List<EventTaskExecutionDetailRecord> r24 = c(r17.createTypedArrayList(EventTaskExecutionDetailRecord.CREATOR));
            r18.writeNoException();
            r18.writeTypedList(r24);
            return true;
        L38:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            int r25 = d(r17.readString());
            r18.writeNoException();
            r18.writeInt(r25);
            return true;
        L40:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            int r26 = b(r17.createLongArray());
            r18.writeNoException();
            r18.writeInt(r26);
            return true;
        L42:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            int r27 = b(r17.createTypedArrayList(EventTaskExecutionRecord.CREATOR));
            r18.writeNoException();
            r18.writeInt(r27);
            return true;
        L44:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            if (r17.readInt() == 0) goto L47;
            r8 = (EventTaskExecutionRecord) ZeusTransformUtils.preCheckCast(EventTaskExecutionRecord.CREATOR.createFromParcel(r17), EventTaskExecutionRecord.class, "com.obric.memorydata.plugin");
        L47:
            EventTaskExecutionRecord r28 = a(r8);
            r18.writeNoException();
            if (r28 == null) goto L50;
            r18.writeInt(1);
            r28.writeToParcel(r18, 1);
        L51:
            return true;
        L50:
            r18.writeInt(0);
            goto L51
        L52:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            EventTaskExecutionRecord r29 = a(r17.readLong());
            r18.writeNoException();
            if (r29 == null) goto L55;
            r18.writeInt(1);
            r29.writeToParcel(r18, 1);
        L56:
            return true;
        L55:
            r18.writeInt(0);
            goto L56
        L57:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            List<EventTaskExecutionRecord> r30 = a(r17.readString(), r17.readInt(), r17.readInt());
            r18.writeNoException();
            r18.writeTypedList(r30);
            return true;
        L59:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            List<EventTaskExecutionRecord> r31 = a(r17.readInt(), r17.readInt());
            r18.writeNoException();
            r18.writeTypedList(r31);
            return true;
        L61:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            List<EventTaskExecutionRecord> r32 = a(r17.createTypedArrayList(EventTaskExecutionRecord.CREATOR));
            r18.writeNoException();
            r18.writeTypedList(r32);
            return true;
        L63:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            int r33 = c(r17.readInt());
            r18.writeNoException();
            r18.writeInt(r33);
            return true;
        L65:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            int r34 = b(r17.readInt(), r17.createLongArray());
            r18.writeNoException();
            r18.writeInt(r34);
            return true;
        L67:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            List<EventTaskRecord> r35 = b(r17.readLong(), r17.readLong(), r17.readInt());
            r18.writeNoException();
            r18.writeTypedList(r35);
            return true;
        L69:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            List<EventTaskRecord> r36 = b(r17.readLong(), r17.readLong(), r17.readString());
            r18.writeNoException();
            r18.writeTypedList(r36);
            return true;
        L71:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            String r37 = r17.readString();
            ArrayList r38 = r17.createTypedArrayList(ConditionTaskAction.CREATOR);
            if (r17.readInt() == 0) goto L74;
            TaskKnowledge r39 = (TaskKnowledge) ZeusTransformUtils.preCheckCast(TaskKnowledge.CREATOR.createFromParcel(r17), TaskKnowledge.class, "com.obric.memorydata.plugin");
        L75:
            a(r37, r38, r39, r17.readInt(), r17.readString());
            r18.writeNoException();
            return true;
        L74:
            r39 = null;
            goto L75
        L77:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            c(r17.readString());
            r18.writeNoException();
            return true;
        L79:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            a(r17.readString(), r17.readString());
            r18.writeNoException();
            return true;
        L81:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            List<ShortcutTask> r40 = j();
            r18.writeNoException();
            r18.writeTypedList(r40);
            return true;
        L83:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            List<EventTask> r41 = a(r17.readInt(), r17.readInt(), r17.readInt());
            r18.writeNoException();
            r18.writeTypedList(r41);
            return true;
        L85:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            List<EventTask> r42 = i();
            r18.writeNoException();
            r18.writeTypedList(r42);
            return true;
        L87:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            List<EventTask> r43 = h();
            r18.writeNoException();
            r18.writeTypedList(r43);
            return true;
        L89:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            String r44 = r17.readString();
            if (r17.readInt() == 0) goto L92;
            r9 = (EventTaskSpec) ZeusTransformUtils.preCheckCast(EventTaskSpec.CREATOR.createFromParcel(r17), EventTaskSpec.class, "com.obric.memorydata.plugin");
        L92:
            EventTaskResult r45 = a(r44, r9);
            r18.writeNoException();
            if (r45 == null) goto L95;
            r18.writeInt(1);
            r45.writeToParcel(r18, 1);
        L96:
            return true;
        L95:
            r18.writeInt(0);
            goto L96
        L97:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            EventTaskResult r46 = b(r17.createStringArray());
            r18.writeNoException();
            if (r46 == null) goto L100;
            r18.writeInt(1);
            r46.writeToParcel(r18, 1);
        L101:
            return true;
        L100:
            r18.writeInt(0);
            goto L101
        L102:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            if (r17.readInt() == 0) goto L105;
            r10 = (EventTaskSpec) ZeusTransformUtils.preCheckCast(EventTaskSpec.CREATOR.createFromParcel(r17), EventTaskSpec.class, "com.obric.memorydata.plugin");
        L105:
            EventTaskResult r47 = a(r10);
            r18.writeNoException();
            if (r47 == null) goto L108;
            r18.writeInt(1);
            r47.writeToParcel(r18, 1);
        L109:
            return true;
        L108:
            r18.writeInt(0);
            goto L109
        L110:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            b(g.a.a(r17.readStrongBinder()));
            return true;
        L112:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            a(g.a.a(r17.readStrongBinder()));
            return true;
        L114:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            b(f.a.a(r17.readStrongBinder()));
            return true;
        L116:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            a(f.a.a(r17.readStrongBinder()));
            return true;
        L118:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            EventTask r48 = b(r17.readString());
            r18.writeNoException();
            if (r48 == null) goto L121;
            r18.writeInt(1);
            r48.writeToParcel(r18, 1);
        L122:
            return true;
        L121:
            r18.writeInt(0);
            goto L122
        L123:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            List<EventTask> r49 = g();
            r18.writeNoException();
            r18.writeTypedList(r49);
            return true;
        L125:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            int r50 = f();
            r18.writeNoException();
            r18.writeInt(r50);
            return true;
        L127:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            int r51 = a(r17.createLongArray());
            r18.writeNoException();
            r18.writeInt(r51);
            return true;
        L129:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            List<ConditionTaskRecord> r52 = b(r17.readLong(), r17.readLong());
            r18.writeNoException();
            r18.writeTypedList(r52);
            return true;
        L131:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            List<ConditionTaskRecord> r53 = a(r17.readLong(), r17.readLong(), r17.readString());
            r18.writeNoException();
            r18.writeTypedList(r53);
            return true;
        L133:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            String r54 = r17.readString();
            ArrayList r55 = r17.createTypedArrayList(ConditionTaskAction.CREATOR);
            String r56 = r17.readString();
            if (r17.readInt() == 0) goto L136;
            ConditionGroup r57 = (ConditionGroup) ZeusTransformUtils.preCheckCast(ConditionGroup.CREATOR.createFromParcel(r17), ConditionGroup.class, "com.obric.memorydata.plugin");
        L138:
            if (r17.readInt() == 0) goto L140;
            PeriodicPolicy r58 = (PeriodicPolicy) ZeusTransformUtils.preCheckCast(PeriodicPolicy.CREATOR.createFromParcel(r17), PeriodicPolicy.class, "com.obric.memorydata.plugin");
        L142:
            if (r17.readInt() == 0) goto L144;
            TriggerControlPolicy r111 = (TriggerControlPolicy) ZeusTransformUtils.preCheckCast(TriggerControlPolicy.CREATOR.createFromParcel(r17), TriggerControlPolicy.class, "com.obric.memorydata.plugin");
        L145:
            ConditionTaskResult r59 = a(r54, r55, r56, r57, r58, r111, r17.readInt(), r17.readHashMap(getClass().getClassLoader()));
            r18.writeNoException();
            if (r59 == null) goto L148;
            r18.writeInt(1);
            r59.writeToParcel(r18, 1);
        L149:
            return true;
        L148:
            r18.writeInt(0);
            goto L149
        L144:
            r111 = null;
            goto L145
        L140:
            r58 = null;
            goto L142
        L136:
            r57 = null;
            goto L138
        L150:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            ConditionTask r60 = a(r17.readString());
            r18.writeNoException();
            if (r60 == null) goto L153;
            r18.writeInt(1);
            r60.writeToParcel(r18, 1);
        L154:
            return true;
        L153:
            r18.writeInt(0);
            goto L154
        L155:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            ConditionTaskResult r61 = a(r17.createStringArray());
            r18.writeNoException();
            if (r61 == null) goto L158;
            r18.writeInt(1);
            r61.writeToParcel(r18, 1);
        L159:
            return true;
        L158:
            r18.writeInt(0);
            goto L159
        L160:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            ArrayList r62 = r17.createTypedArrayList(ConditionTaskAction.CREATOR);
            String r63 = r17.readString();
            if (r17.readInt() == 0) goto L163;
            ConditionGroup r64 = (ConditionGroup) ZeusTransformUtils.preCheckCast(ConditionGroup.CREATOR.createFromParcel(r17), ConditionGroup.class, "com.obric.memorydata.plugin");
        L165:
            if (r17.readInt() == 0) goto L167;
            PeriodicPolicy r65 = (PeriodicPolicy) ZeusTransformUtils.preCheckCast(PeriodicPolicy.CREATOR.createFromParcel(r17), PeriodicPolicy.class, "com.obric.memorydata.plugin");
        L169:
            if (r17.readInt() == 0) goto L171;
            r11 = (TriggerControlPolicy) ZeusTransformUtils.preCheckCast(TriggerControlPolicy.CREATOR.createFromParcel(r17), TriggerControlPolicy.class, "com.obric.memorydata.plugin");
        L171:
            ConditionTaskResult r66 = a(r62, r63, r64, r65, r11, r17.readHashMap(getClass().getClassLoader()));
            r18.writeNoException();
            if (r66 == null) goto L174;
            r18.writeInt(1);
            r66.writeToParcel(r18, 1);
        L175:
            return true;
        L174:
            r18.writeInt(0);
            goto L175
        L167:
            r65 = null;
            goto L169
        L163:
            r64 = null;
            goto L165
        L176:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            b(c.a.a(r17.readStrongBinder()));
            return true;
        L178:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            a(c.a.a(r17.readStrongBinder()));
            return true;
        L180:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            b(d.a.a(r17.readStrongBinder()));
            return true;
        L182:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            a(d.a.a(r17.readStrongBinder()));
            return true;
        L184:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            if (r17.readInt() == 0) goto L187;
            r12 = AppEvent.CREATOR.createFromParcel(r17);
        L187:
            boolean r67 = b(r12);
            r18.writeNoException();
            r18.writeInt(r67 ? 1 : 0);
            return true;
        L189:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            if (r17.readInt() == 0) goto L192;
            r13 = AppEvent.CREATOR.createFromParcel(r17);
        L192:
            boolean r68 = a(r13);
            r18.writeNoException();
            r18.writeInt(r68 ? 1 : 0);
            return true;
        L194:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            int r69 = e();
            r18.writeNoException();
            r18.writeInt(r69);
            return true;
        L196:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            int r70 = d();
            r18.writeNoException();
            r18.writeInt(r70);
            return true;
        L198:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            a(r17.readString(), r17.readString(), r17.readHashMap(getClass().getClassLoader()));
            r18.writeNoException();
            return true;
        L200:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            a(b.a.a(r17.readStrongBinder()));
            r18.writeNoException();
            return true;
        L202:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            if (r17.readInt() == 0) goto L206;
            r110 = true;
        L206:
            if (r17.readInt() == 0) goto L208;
            r14 = StateInfo.CREATOR.a(r17);
        L208:
            a(r110, r14);
            r18.writeNoException();
            return true;
        L210:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            c();
            r18.writeNoException();
            return true;
        L212:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            if (r17.readInt() == 0) goto L216;
            r15 = StateInfo.CREATOR.a(r17);
        L216:
            if (r17.readInt() == 0) goto L218;
            r110 = true;
        L218:
            a(r15, r110);
            r18.writeNoException();
            return true;
        L220:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            b(i.a.a(r17.readStrongBinder()));
            return true;
        L222:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            a(i.a.a(r17.readStrongBinder()));
            return true;
        L224:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            int r71 = b();
            r18.writeNoException();
            r18.writeInt(r71);
            return true;
        L226:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            int r72 = b(r17.createIntArray());
            r18.writeNoException();
            r18.writeInt(r72);
            return true;
        L228:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            List<TimerTaskRecord> r73 = a(r17.readLong(), r17.readLong());
            r18.writeNoException();
            r18.writeTypedList(r73);
            return true;
        L230:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            List<TimerTaskRecord> r74 = a(r17.readLong(), r17.readLong(), r17.readInt());
            r18.writeNoException();
            r18.writeTypedList(r74);
            return true;
        L232:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            List<TimerTask> r75 = a();
            r18.writeNoException();
            r18.writeTypedList(r75);
            return true;
        L234:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            List<TimerTask> r76 = b(r17.readHashMap(getClass().getClassLoader()));
            r18.writeNoException();
            r18.writeTypedList(r76);
            return true;
        L236:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            long r77 = b(r17.readInt());
            r18.writeNoException();
            r18.writeLong(r77);
            return true;
        L238:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            TimerTask r78 = a(r17.readInt());
            r18.writeNoException();
            if (r78 == null) goto L241;
            r18.writeInt(1);
            r78.writeToParcel(r18, 1);
        L242:
            return true;
        L241:
            r18.writeInt(0);
            goto L242
        L243:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            if (r17.readInt() == 0) goto L246;
            r20 = TimerTask.CREATOR.a(r17);
        L246:
            TimerTaskResult r79 = b(r20);
            r18.writeNoException();
            if (r79 == null) goto L249;
            r18.writeInt(1);
            r79.writeToParcel(r18, 1);
        L250:
            return true;
        L249:
            r18.writeInt(0);
            goto L250
        L251:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            TimerTaskResult r80 = a(r17.readInt(), r17.createLongArray());
            r18.writeNoException();
            if (r80 == null) goto L254;
            r18.writeInt(1);
            r80.writeToParcel(r18, 1);
        L255:
            return true;
        L254:
            r18.writeInt(0);
            goto L255
        L256:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            TimerTaskResult r81 = a(r17.readHashMap(getClass().getClassLoader()));
            r18.writeNoException();
            if (r81 == null) goto L259;
            r18.writeInt(1);
            r81.writeToParcel(r18, 1);
        L260:
            return true;
        L259:
            r18.writeInt(0);
            goto L260
        L261:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            TimerTaskResult r82 = a(r17.createIntArray());
            r18.writeNoException();
            if (r82 == null) goto L264;
            r18.writeInt(1);
            r82.writeToParcel(r18, 1);
        L265:
            return true;
        L264:
            r18.writeInt(0);
            goto L265
        L266:
            r17.enforceInterface("com.obric.eventkit.eventstaskmanager.ITaskManager");
            if (r17.readInt() == 0) goto L269;
            r5 = TimerTask.CREATOR.a(r17);
        L269:
            TimerTaskResult r83 = a(r5);
            r18.writeNoException();
            if (r83 == null) goto L272;
            r18.writeInt(1);
            r83.writeToParcel(r18, 1);
        L273:
            return true;
        L272:
            r18.writeInt(0);
            goto L273
        L7:
            return super.onTransact(r16, r17, r18, r19);
        L274:
            r18.writeString("com.obric.eventkit.eventstaskmanager.ITaskManager");
            return true;
        }
    }

    int a(long[] r1);

    ConditionTask a(String r1);

    ConditionTaskResult a(String r1, List<ConditionTaskAction> r2, String r3, ConditionGroup r4, PeriodicPolicy r5, TriggerControlPolicy r6, int r7, Map r8);

    ConditionTaskResult a(List<ConditionTaskAction> r1, String r2, ConditionGroup r3, PeriodicPolicy r4, TriggerControlPolicy r5, Map r6);

    ConditionTaskResult a(String[] r1);

    EventTaskExecutionDetailRecord a(EventTaskExecutionDetailRecord r1);

    EventTaskExecutionRecord a(long r1);

    EventTaskExecutionRecord a(EventTaskExecutionRecord r1);

    EventTaskResult a(EventTaskSpec r1);

    EventTaskResult a(String r1, EventTaskSpec r2);

    TimerTask a(int r1);

    TimerTaskResult a(int r1, long[] r2);

    TimerTaskResult a(TimerTask r1);

    TimerTaskResult a(Map r1);

    TimerTaskResult a(int[] r1);

    List<TimerTask> a();

    List<EventTaskExecutionRecord> a(int r1, int r2);

    List<EventTask> a(int r1, int r2, int r3);

    List<TimerTaskRecord> a(long r1, long r3);

    List<TimerTaskRecord> a(long r1, long r3, int r5);

    List<ConditionTaskRecord> a(long r1, long r3, String r5);

    List<EventTaskExecutionRecord> a(String r1, int r2, int r3);

    List<EventTaskExecutionRecord> a(List<EventTaskExecutionRecord> r1);

    void a(StateInfo r1, boolean r2);

    void a(b r1);

    void a(c r1);

    void a(d r1);

    void a(f r1);

    void a(g r1);

    void a(i r1);

    void a(String r1, String r2);

    void a(String r1, String r2, Map r3);

    void a(String r1, List<ConditionTaskAction> r2, TaskKnowledge r3, int r4, String r5);

    void a(boolean r1, StateInfo r2);

    boolean a(AppEvent r1);

    int b();

    int b(int r1, long[] r2);

    int b(List<EventTaskExecutionRecord> r1);

    int b(int[] r1);

    int b(long[] r1);

    long b(int r1);

    EventTask b(String r1);

    EventTaskExecutionDetailRecord b(long r1);

    EventTaskResult b(String[] r1);

    TimerTaskResult b(TimerTask r1);

    List<EventTaskExecutionDetailRecord> b(int r1, int r2);

    List<ConditionTaskRecord> b(long r1, long r3);

    List<EventTaskRecord> b(long r1, long r3, int r5);

    List<EventTaskRecord> b(long r1, long r3, String r5);

    List<EventTaskExecutionDetailRecord> b(String r1, int r2, int r3);

    List<TimerTask> b(Map r1);

    void b(c r1);

    void b(d r1);

    void b(f r1);

    void b(g r1);

    void b(i r1);

    boolean b(AppEvent r1);

    int c(int r1);

    int c(long[] r1);

    List<EventTaskExecutionDetailRecord> c(List<EventTaskExecutionDetailRecord> r1);

    void c();

    void c(String r1);

    boolean c(AppEvent r1);

    int d();

    int d(String r1);

    int d(List<EventTaskExecutionDetailRecord> r1);

    int e();

    int e(String r1);

    int f();

    List<EventTask> g();

    List<EventTask> h();

    List<EventTask> i();

    List<ShortcutTask> j();
}
